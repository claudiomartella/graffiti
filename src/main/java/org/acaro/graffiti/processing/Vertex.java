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

import org.acaro.graffiti.Graffiti;
import org.acaro.graffiti.query.Condition;
import org.acaro.graffiti.query.LocationStep;
import org.acaro.graffiti.query.Query;
import org.acaro.graffiti.query.QueryParser;
import org.apache.giraph.graph.GiraphJob;
import org.apache.giraph.graph.MutableVertex;
import org.apache.giraph.graph.WorkerContext;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper.Context;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;
import org.apache.log4j.Logger;

public class Vertex 
extends MutableVertex<Text, IntWritable, Text, Message> 
implements Tool {

    private static final Logger LOG = Logger.getLogger(Vertex.class);
    private final Map<Text, Set<Text>> labelledOutEdgeMap = new HashMap<Text, Set<Text>>();
    private final List<Message> msgList = new ArrayList<Message>();
    private Configuration conf;
    private Text vertexId = null;
    private boolean halt = false;
    private int numOutEdges; 

    @Override
    public void compute(Iterator<Message> messages) 
    throws IOException {

    	System.out.println(this.toString());
    	
    	while (messages.hasNext()) {
    		processMessage(messages.next());
    	}

        voteToHalt();
    }

	private void processMessage(Message message) 
    throws IOException {

        Query query = message.getQuery();
        
        LOG.debug(getVertexId() + " received query: " + query);
        
        LocationStep l = query.getLocationSteps().firstElement();
        if (checkConditions(l) == false) {
            return;
        }

        Query newQuery = prepareNewQuery(query);

        String label = l.getEdge();
        ResultSet r  = message.getResults();
        if (newQuery.isFinished()) {
            emitResults(label, new ResultSet(r));
        } else {
            forwardMsg(label, new Message(newQuery, new ResultSet(r)));
        }
    }
		
	/*
	 * checks whether all the conditions match (AND)
	 */
    private boolean checkConditions(LocationStep l) {

        for (Condition c: l.getConditions()) {
            if (c.evaluate(this) == false) {
                return false;
            }
        }
        
        return true;
    }

    private Query prepareNewQuery(Query old) {

        Query newQuery = new Query(old);
        LocationStep l = newQuery.getLocationSteps().pop();
        int rp = l.getRepeat();
        if (rp > 0) {
            LocationStep newL = new LocationStep(l);
            newL.setRepeat(--rp);
            newQuery.getLocationSteps().push(newL);
        }

        return newQuery;
    }

    private void emitResults(String label, ResultSet r) 
    throws IOException {

        r.add(getVertexId());
        if (label.equals(LocationStep.EMPTY)) {
            emit(r);
        } else {
            if (label.equals(LocationStep.ANY)) {
                for (Text tLabel: getEdgesLabels()) {
                    emitWithLabel(tLabel, new ResultSet(r));
                }
            } else {
                emitWithLabel(new Text(label), r);
            }
        }
    }

    private void emitWithLabel(Text label, ResultSet r) 
    throws IOException {

        r.add(label);

        Set<Text> edges = labelledOutEdgeMap.get(label);
        if (edges != null) {
            for (Text v: edges) {
                ResultSet rslv = new ResultSet(r);
                rslv.add(v);
                emit(rslv);
            }
        }
    }

    private void emit(ResultSet r) 
    throws IOException {
        
        Emitter emitter = (Emitter) getWorkerContext();
        emitter.emit(r.toString());
    }

    private void forwardMsg(String label, Message message) {

        if (label.equals(LocationStep.ANY)) {
            for (Text tLabel: getEdgesLabels()) {
                // "clone" it because they go through paths with different labels
                forwardMsgThroughLabel(tLabel, new Message(message));
            }
        } else {
            forwardMsgThroughLabel(new Text(label), message);
        }   
    }

    private void forwardMsgThroughLabel(Text label, Message message) {

        message.getResults().add(getVertexId());
        message.getResults().add(label);

        Set<Text> edges = labelledOutEdgeMap.get(label);
        if (edges != null) {
            for (Text v: edges) {
                sendMsg(v, message);
            }
        }
    }

    public Set<Text> getEdgesByLabel(Text label) {
        return labelledOutEdgeMap.get(label);
    }

    public Set<Text> getEdgesLabels() {
        return labelledOutEdgeMap.keySet();
    }

    @Override
    public void readFields(DataInput in) 
    throws IOException {

        vertexId = new Text();
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
            Message msg = new Message();
            msg.readFields(in);
            msgList.add(msg);
        }

        halt = in.readBoolean();
    }

    @Override
    public void write(DataOutput out) 
    throws IOException {

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
        for (Message msg : msgList) {
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
    public List<Message> getMsgList() {
        return this.msgList;
    }
    
    public void setMsgList(List<Message> msgList) {
    	this.msgList.addAll(msgList);
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
    public IntWritable getVertexValue() {
        return new IntWritable(0);
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
    public boolean isHalted(boolean state) {
    	boolean oldState = this.halt;
    	this.halt = state;
    	
    	return oldState;
    }
    
    @Override
    public Iterator<Text> iterator() {
        throw new UnsupportedOperationException("iterator should not be called");
    }

    @Override
    public void sendMsgToAllEdges(Message m) {

        for (Set<Text> labelSet: labelledOutEdgeMap.values()) {
            for (Text v: labelSet) {
                sendMsg(v, m);
            }
        }
    }

    @Override
    public void setVertexValue(IntWritable value) {
    	// just ignore it
    }

    @Override
    public void voteToHalt() {
        this.halt = true;
    }
    
	@Override
	public void initialize(Text vertexId, IntWritable value, Map<Text, Text> edges, List<Message> msgList) {
		// we don't use this
	}
	
	public String toString() {
		StringBuilder builder = new StringBuilder();
		
		builder.append("superstep=" + getSuperstep());
		builder.append(" vertexid=" + getVertexId().toString() + "\n");
		
		for (Entry<Text, Set<Text>> edge: labelledOutEdgeMap.entrySet()) {
			builder.append(edge.getKey().toString() + ":");
			for (Text endpoint: edge.getValue()) {
				builder.append(" " + endpoint.toString());
			}
			builder.append("\n");
		}
		
		builder.append("Messages:\n");
    	for (Message message: msgList) {
    		builder.append(message.toString() + "\n");
    	}
		
		return builder.toString();
	}
	
    @SuppressWarnings("rawtypes")
	public static class Emitter extends WorkerContext {
        
        private static final String FILENAME = "emitter_";
        private FSDataOutputStream out;

        @Override
        public void preApplication() {
            Context context = getContext();
            FileSystem fs;
            
            try {
            	
                fs = FileSystem.get(context.getConfiguration());

                String p = context.getConfiguration().get(Graffiti.OUTPUTDIR);
                if (p == null) {
                    throw new IllegalArgumentException(Graffiti.OUTPUTDIR + " undefined!");
                }
            
                Path path = new Path(p);
                if (!fs.exists(path)) {
                	fs.mkdirs(path); // in case create output dir
                }

                Path outF = new Path(path, FILENAME + context.getTaskAttemptID());
                if (fs.exists(outF)) {
                    throw new IllegalArgumentException(outF + " aready exists");
                }
            
                out = fs.create(outF);
            } catch (IOException e) {
                throw new RuntimeException("can't initialize WorkerContext", e);
            }
        }

        @Override
        public void postApplication() {
            if (out != null) {
                try {
                    out.flush();
                    out.close();
                } catch (IOException e) {
                    throw new RuntimeException("can't finalize WorkerContext", e);
                }
                out = null;
            }
        }

        @Override
        public void preSuperstep() { }

        @Override
        public void postSuperstep() { }
        
        public void emit(String s) {
            try {
                out.writeUTF(s + "\n");
            } catch (IOException e) {
                throw new RuntimeException("can't emit", e);
            }
        }
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
    public int run(String[] args) 
    throws Exception {

        Query q = new QueryParser(args[2]).parse();
        GiraphJob job = new GiraphJob(getConf(), getClass().getName());
        job.setVertexClass(getClass());
        job.setWorkerContextClass(Emitter.class);
        job.setVertexInputFormatClass(GraffitiInputFormat.class);
        FileInputFormat.addInputPath(job, new Path(args[0]));
        job.getConfiguration().set(Graffiti.SOURCE_VX, q.getStartNode());
        job.getConfiguration().set(Graffiti.QUERY, args[2]);
        job.getConfiguration().set(Graffiti.OUTPUTDIR, args[1]);
        job.getConfiguration().setInt(GiraphJob.CHECKPOINT_FREQUENCY, 0);
        //job.getConfiguration().set(GiraphJob.ZOOKEEPER_LIST, "rose.inf.unibz.it:2181");
        job.setWorkerConfiguration(1, 1, 100.0f);

        if (job.run(true)) {
        	return 0;
        } else {
        	return -1;
        }
    }

    public static void main(String[] args) 
    throws Exception {
    	System.exit(ToolRunner.run(new Vertex(), args));
    }    
}
