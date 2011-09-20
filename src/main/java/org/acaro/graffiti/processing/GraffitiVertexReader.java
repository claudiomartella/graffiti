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

import java.io.IOException;

import org.apache.giraph.graph.MutableVertex;
import org.apache.giraph.lib.TextVertexInputFormat.TextVertexReader;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.RecordReader;
import org.json.JSONArray;
import org.json.JSONException;

public class GraffitiVertexReader 
    extends TextVertexReader<Text, NullWritable, Text> {

	public GraffitiVertexReader(RecordReader<LongWritable, Text> arg) {
		super(arg);
	}

	@Override
	public boolean next(MutableVertex<Text, NullWritable, Text, ?> vertex)
		throws IOException, InterruptedException {
		
		if (!getRecordReader().nextKeyValue())
            return false;
		
		Text line = getRecordReader().getCurrentValue();
		
		try {
            JSONArray jsonVertex = new JSONArray(line.toString());
            vertex.setVertexId(new Text(jsonVertex.getString(0)));
            vertex.setVertexValue(NullWritable.get());
            
            JSONArray jsonEdgeArray = jsonVertex.getJSONArray(2);
            for (int i = 0; i < jsonEdgeArray.length(); ++i) {
                JSONArray jsonEdge = jsonEdgeArray.getJSONArray(i);
                vertex.addEdge(new Text(jsonEdge.getString(0)), 
                			   new Text(jsonEdge.getString(1)));
            }
        } catch (JSONException e) {
            throw new IllegalArgumentException(
                "next: Couldn't get vertex from line " + line, e);
        }
		
		return true;
	}
}
