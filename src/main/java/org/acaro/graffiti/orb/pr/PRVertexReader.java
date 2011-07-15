package org.acaro.graffiti.orb.pr;

import java.util.ArrayList;

import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.goldenorb.Edge;
import org.goldenorb.io.input.VertexBuilder;


public class PRVertexReader extends VertexBuilder<PRVertex, LongWritable, Text> {
	private double initialValue;
	
	public PRVertexReader() {
		initialValue = 1.0/Integer.parseInt(this.getOrbConf().get("pr.numberOfVertices"));
	}
	
	
	@Override
	protected PRVertex buildVertex(LongWritable key, Text value) {

		String[] values = value.toString().split("\t");
		ArrayList<Edge<IntWritable>> edges = new ArrayList<Edge<IntWritable>>();

		for (int i = 1; i < values.length; i++) {
			Edge<IntWritable> edge = new Edge<IntWritable>(values[i], new IntWritable(0));
			edges.add(edge);
		}
		
		PRVertex vertex = new PRVertex(values[0], new DoubleWritable(initialValue) , edges);
		
		return vertex;
	}
}
