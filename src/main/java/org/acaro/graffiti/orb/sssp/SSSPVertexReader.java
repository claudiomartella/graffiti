package org.acaro.graffiti.orb.sssp;

import java.util.ArrayList;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.goldenorb.Edge;
import org.goldenorb.io.input.VertexBuilder;


public class SSSPVertexReader extends VertexBuilder<SSSPVertex, LongWritable, Text> {

	@Override
	protected SSSPVertex buildVertex(LongWritable key, Text value) {

		String[] values = value.toString().split("\t");
		ArrayList<Edge<IntWritable>> edges = new ArrayList<Edge<IntWritable>>();

		for (int i = 1; i < values.length; i++) {
			Edge<IntWritable> edge = new Edge<IntWritable>(values[i], new IntWritable(0));
			edges.add(edge);
		}
		
		SSSPVertex vertex = new SSSPVertex(values[0], new IntWritable(Integer.MAX_VALUE) , edges);
		
		return vertex;
	}
}
