package org.acaro.graffiti.mapreduce;

import java.io.IOException;
import java.util.Date;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.compress.GzipCodec;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;
import org.mortbay.log.Log;

public class GraffitiSp2bDatasetWriter {

	private static final String PREFIX = "<http://localhost/bnodes/";

	public static String fromBNode(String bnode) {
		String name = bnode.substring("_:".length());
		
		return PREFIX + name + ">";
	}
	
	public static String fromLiteral(String literal) {
		int end = literal.indexOf('\"', 1);
		
		return literal.substring(1, end);
	}
	
	public static class MyMapper extends Mapper<LongWritable, Text, Text, Edge> {
	
		@Override
		public void map(LongWritable key, Text value, Context context) 
		throws IOException, InterruptedException {

			String line = value.toString();
			String[] elements = line.split(" ");
			if (elements.length != 3) {
				Log.warn("Unsplittable line, ignoring: " + line);
				return;
			}

			String vertex   = elements[0];
			String edge     = elements[1];
			String endpoint = elements[2].substring(0, elements[2].length()-1);
			
			if (vertex.startsWith("_:")) {
				vertex = fromBNode(vertex);
			}
			if (!vertex.startsWith("<")) {
				return;
			}
			if (endpoint.startsWith("_:")) {
				endpoint = fromBNode(endpoint);
			} else if (endpoint.startsWith("\"")) {
				endpoint = fromLiteral(endpoint);
			}
			context.write(new Text(vertex), new Edge(edge, endpoint));
			
			if (!endpoint.startsWith("<")) {
				return;
			}
			context.write(new Text(endpoint), new Edge("i_" + edge, vertex));
		}
	}
	
	public static class MyReducer extends Reducer<Text, Edge, NullWritable, Text> {

		@Override
		public void reduce(Text vertex, Iterable<Edge> edges, Context context) 
		throws IOException, InterruptedException {
			
			StringBuilder builder = new StringBuilder();
			
			builder.append("[ \"")
			       .append(vertex.toString())
			       .append("\", [ ");
			
			boolean first = true;
			for (Edge edge: edges) {

				String label = edge.getLabel();
				String endP  = edge.getEndpoint();
				
				if (!first) {
					builder.append(", ");
				} else {
					first = false;
				}
				builder.append("[ \"")
					   .append(label)
					   .append("\", \"")
					   .append(endP)
					   .append("\" ")
				       .append("]");
			}
			
			builder.append(" ] ]");
			
			context.write(NullWritable.get(), new Text(builder.toString()));
		}
	}
	
	public static void main(String[] args) 
	throws IOException, InterruptedException, ClassNotFoundException {
	
		if (args.length != 2)
			printUsage();
		
        Configuration conf = new Configuration();

        // Add resources
        conf.addResource("hdfs-default.xml");
        conf.addResource("hdfs-site.xml");
        conf.addResource("mapred-default.xml");
        conf.addResource("mapred-site.xml");
        
        Job job = new Job(conf);
        job.setJobName("GraffitiDatasetWriter");
        
        job.setMapOutputKeyClass(Text.class);
        job.setMapOutputValueClass(Edge.class);

        job.setOutputKeyClass(NullWritable.class);
        job.setOutputValueClass(Text.class);

        job.setMapperClass(MyMapper.class);
        job.setReducerClass(MyReducer.class);

        job.setNumReduceTasks(1);
        
        // Set the input format class
        job.setInputFormatClass(TextInputFormat.class);
        // Set the output format class
        job.setOutputFormatClass(TextOutputFormat.class);
        // Set the input path
        TextInputFormat.setInputPaths(job, args[0]);
        // Set the output path
        TextOutputFormat.setOutputPath(job, new Path(args[1]));
        //TextOutputFormat.setCompressOutput(job, true);
        //TextOutputFormat.setOutputCompressorClass(job, GzipCodec.class);

        /* Set the minimum and maximum split sizes
         * This parameter helps to specify the number of map tasks.
         * For each input split, there will be a separate map task.
         * Here each split is of size 32 MB
         */
        //TextInputFormat.setMinInputSplitSize(job, 32 * MEGABYTES);
        //TextInputFormat.setMaxInputSplitSize(job, 16 * 1024*1024);

        // Set the jar file to run
        job.setJarByClass(GraffitiSp2bDatasetWriter.class);

        // Submit the job
        Date startTime = new Date();
        System.out.println("Job started: " + startTime);
        int exitCode = job.waitForCompletion(true) ? 0 : 1;

        if (exitCode == 0) {
        	Date end_time = new Date();
        	System.out.println("Job ended: " + end_time);
        	System.out.println("The job took " + (end_time.getTime() - startTime.getTime()) / 1000 + " seconds.");
        } else {
        	System.out.println("Job Failed!!!");
        }
	}

	private static void printUsage() {
		System.out.println("GraffitiDatasetWriter <input path> <output path>");
		System.exit(-1);
	}
}