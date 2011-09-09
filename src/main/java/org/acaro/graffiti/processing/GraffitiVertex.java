package org.acaro.graffiti.processing;

import java.io.IOException;
import java.util.Iterator;

import org.acaro.graffiti.query.Query;
import org.acaro.graffiti.query.QueryParser;
import org.antlr.runtime.RecognitionException;
import org.apache.giraph.graph.GiraphJob;
import org.apache.giraph.graph.Vertex;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.util.Tool;

public class GraffitiVertex extends Vertex<Text, IntWritable, Text, Query> implements Tool {
	
	private static final String SOURCE_VX = "source_vertex";
	private static final String QUERY = "query";
	private Configuration conf;
	
	@Override
	public void compute(Iterator<Query> messages) throws IOException {
		
		if (getSuperstep() == 0 && isSource()) {
			String query = getQuery();

			try {

				processQuery(new QueryParser(query).parse());

			} catch (RecognitionException e) {
				System.err.println("impossible to parse: " + query);
				e.printStackTrace();
			}
		} else {
			
			while (messages.hasNext())
				processQuery(messages.next());
		
		}
		
		voteToHalt();
	}

	private void processQuery(Query query) {
		
	}

	private boolean isSource() {
	    String source = getContext().getConfiguration().get(SOURCE_VX);

	    return source.equals("*") || source.equals(getVertexId());
	}
	
	private String getQuery() {
		return getContext().getConfiguration().get(QUERY);
	}

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
