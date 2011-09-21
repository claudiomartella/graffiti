/*  Copyright 2011 Claudio Martella
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
*/

package org.acaro.graffiti.processing;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeSet;

import org.acaro.graffiti.query.Condition;
import org.acaro.graffiti.query.LocationStep;
import org.acaro.graffiti.query.Query;
import org.acaro.graffiti.query.QueryParser;
import org.apache.giraph.graph.BspUtils;
import org.apache.giraph.graph.GiraphJob;
import org.apache.giraph.graph.MutableVertex;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.util.Tool;
import org.apache.log4j.Logger;

/*
 * XXX: can maybe save some clone()s. If we firstElement() instead of pop() before we evaluate
 * we can basically share the same object UNTIL we modify it. And we modify it ONLY if we are
 * a matching vertex, before we forward it. So all the non-matching vertices share the same object.
 */
public class GraffitiVertex 
    extends MutableVertex<Text, Query, Text, GraffitiMessage> 
    implements Tool {
	
	public static final String SOURCE_VX = "source_vertex";
	public static final String QUERY = "query";
    private static final Logger LOG = Logger.getLogger(GraffitiVertex.class);
	/*
	 * It contains all the outgoing edges. Each entry in the hashmap represents an outgoing label.
	 * Each element of the contained TreeSet are vertices on the other end of an edge with
	 * that label.
	 */
    private final Map<Text, Set<Text>> labelledOutEdgeMap = new HashMap<Text, Set<Text>>();
    private final List<GraffitiMessage> msgList = new ArrayList<GraffitiMessage>();
	private Configuration conf;
    private Text vertexId = null;
    private Query query;
    private boolean halt = false;
    private int numOutEdges; 

	@Override
	public void compute(Iterator<GraffitiMessage> messages) throws IOException {
		
		if (getSuperstep() == 0 && isSource()) {
            processMessage(new GraffitiMessage(this.query.clone(), new ResultSet()));
		} else {
			while (messages.hasNext()) {
				processMessage(messages.next());
			}
		}
		
		voteToHalt();
	}

	private void processMessage(GraffitiMessage message) {
		
		Query query = message.getQuery();
	    LocationStep l = query.getLocationSteps().pop();
		
		// 1- check all the conditions
		for (Condition c: l.getConditions()) {
			if (c.evaluate(this) == false) {
				return;
			}
		}
		
		// 2- check if we have to repeat this locationStep
		int rp = l.getRepeat();
		if (rp > 0) {
			l.setRepeat(--rp);
			query.getLocationSteps().push(l);
		}

		// 3- forward the query through the right edge(s)
		if (l.getEdge().equals("*")) {
		    for (Text label: getEdgesLabels()) {
		        forwardMsgThroughLabel(label, message.clone());
		    }
		} else {
		    forwardMsgThroughLabel(new Text(l.getEdge()), message);
		}		
	}

	private void forwardMsgThroughLabel(Text label, GraffitiMessage message) {
	    
	    message.getResults().push(getVertexId());
	    message.getResults().push(label);
	    
	    Set<Text> edges = labelledOutEdgeMap.get(label);
	    if (edges != null) {
	        for (Text v: edges) {
	            sendMsg(v, message.clone());
	        }
	    }
	}
	
	private boolean isSource() {
	    String source = getContext().getConfiguration().get(SOURCE_VX);

	    return source.equals("*") || source.equals(getVertexId());
	}
	
	public Set<Text> getEdgesByLabel(Text label) {
		return labelledOutEdgeMap.get(label);
	}
	
	public Set<Text> getEdgesLabels() {
		return labelledOutEdgeMap.keySet();
	}
	
	@Override
	public void readFields(DataInput in) throws IOException {
        
		vertexId = BspUtils.<Text>createVertexIndex(getContext().getConfiguration());
        vertexId.readFields(in);

        int edgeMapSize = in.readInt();
        for (int i = 0; i < edgeMapSize; i++) {
        	Text label = new Text();
        	label.readFields(in);
        	int verticesSize = in.readInt();
        	for (int j = 0; j < verticesSize; j++) {
        		Text vID = new Text();
        		vID.readFields(in);
        		addEdge(vID, label);
        	}
        }
        
        int msgListSize = in.readInt();
        for (int i = 0; i < msgListSize; i++) {
            GraffitiMessage msg = BspUtils.<GraffitiMessage>createMessageValue(
                                                getContext().getConfiguration());
            msg.readFields(in);
            msgList.add(msg);
        }
        
        halt = in.readBoolean();
	}

	@Override
	public void write(DataOutput out) throws IOException {
       
		vertexId.write(out);

        out.writeInt(labelledOutEdgeMap.size());
        for (Entry<Text, Set<Text>> label: labelledOutEdgeMap.entrySet()) {
        	label.getKey().write(out);
        	out.writeInt(label.getValue().size());
        	for (Text dest: label.getValue()) {
        		dest.write(out);
        	}
        }
        
        out.writeInt(msgList.size());
        for (GraffitiMessage msg : msgList) {
            msg.write(out);
        }
        
        out.writeBoolean(halt);
	}

	@Override
	public boolean addEdge(Text vID, Text label) {

		Set<Text> set = labelledOutEdgeMap.get(label);
		if (set == null) {
			set = new TreeSet<Text>();
			labelledOutEdgeMap.put(label, set);
		}
		
		boolean ret = set.add(vID);
		if (ret == true) {
			numOutEdges++;
		}
		
		return ret;
	}

	@Override
	public Text removeEdge(Text vID) {
		throw new UnsupportedOperationException("removeEdge should not be called");
	}

	@Override
	public void setVertexId(Text vID) {
		this.vertexId = vID;
	}

	@Override
	public Text getEdgeValue(Text vID) {
		throw new UnsupportedOperationException("getEdgeValue should not be called");
	}

	@Override
	public List<GraffitiMessage> getMsgList() {
		return this.msgList;
	}

	@Override
	public int getNumOutEdges() {
		return this.numOutEdges;
	}

	@Override
	public Text getVertexId() {
		return this.vertexId;
	}

	@Override
	public Query getVertexValue() {
		return this.query;
	}

	@Override
	public boolean hasEdge(Text vID) {
		throw new UnsupportedOperationException("hasEdge should not be called");
	}

	@Override
	public boolean isHalted() {
		return this.halt;
	}

	@Override
	public Iterator<Text> iterator() {
		throw new UnsupportedOperationException("iterator should not be called");
	}
	
	@Override
	public void postApplication() {
		// Don't need this
	}

	@Override
	public void postSuperstep() {
		// Don't need this
	}

	@Override
	public void preApplication() throws InstantiationException,
			IllegalAccessException {
		// Don't need this
	}

	@Override
	public void preSuperstep() {
		// Don't need this	
	}

	@Override
	public void sendMsgToAllEdges(GraffitiMessage m) {
		for (Set<Text> labelSet: labelledOutEdgeMap.values()) {
			for (Text v: labelSet) {
				sendMsg(v, m);
			}
		}
	}

	@Override
	public void setVertexValue(Query value) {
	    this.query = value;
	}

	@Override
	public void voteToHalt() {
		this.halt = true;
	}
	
	/*
	 * This is all Tool stuff
	 */
	@Override
	public Configuration getConf() {
		return this.conf;
	}

	@Override
	public void setConf(Configuration conf) {
		this.conf = conf;
	}

	@Override
	public int run(String[] args) throws Exception {
	    if (args.length != 2) {
	        throw new IllegalArgumentException(
	            "run: Must have 2 arguments <input path> <query>");
	    }
	    
	    Query q = new QueryParser(args[1]).parse();
	    
	    GiraphJob job = new GiraphJob(getConf(), getClass().getName());
	    job.setVertexClass(getClass());
	    job.setVertexInputFormatClass(GraffitiVertexInputFormat.class);
	    FileInputFormat.addInputPath(job, new Path(args[0]));
	    job.getConfiguration().set(GraffitiVertex.SOURCE_VX, q.getStartNode());
	    job.getConfiguration().set(GraffitiVertex.QUERY, args[1]);
	    
	    //job.setWorkerConfiguration(Integer.parseInt(argArray[3]), Integer.parseInt(argArray[3]), 100.0f);
	    if (job.run(true) == true) {
	        return 0;
	    } else {
	        return -1;
	    }
	}
}
