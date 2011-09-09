package org.acaro.graffiti.processing;

import java.io.IOException;

import org.apache.giraph.graph.VertexReader;
import org.apache.giraph.lib.TextVertexInputFormat;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.InputSplit;
import org.apache.hadoop.mapreduce.TaskAttemptContext;

public class GraffitiVertexInputFormat extends 
	TextVertexInputFormat<Text, IntWritable, Text> {

	@Override
	public VertexReader<Text, IntWritable, Text> createVertexReader(
			InputSplit split, TaskAttemptContext ctx) throws IOException {
		return new GraffitiVertexReader(textInputFormat.createRecordReader(split, ctx));
	}
}
