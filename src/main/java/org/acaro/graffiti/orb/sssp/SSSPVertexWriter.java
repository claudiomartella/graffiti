package org.acaro.graffiti.orb.sssp;

import org.apache.hadoop.io.Text;
import org.goldenorb.io.output.OrbContext;
import org.goldenorb.io.output.VertexWriter;

public class SSSPVertexWriter extends VertexWriter<SSSPVertex, Text, Text> {

	@Override
	public OrbContext<Text, Text> vertexWrite(SSSPVertex vertex) {
		
		OrbContext<Text, Text> orbContext = new OrbContext<Text, Text>();
		
		Text value;
		if (vertex.getValue().get() == Integer.MAX_VALUE)
			value = new Text("UNREACHABLE");
		else
			value = new Text(Integer.toString(vertex.getValue().get()));
		
		orbContext.write(new Text(vertex.getVertexID()), value);
		
		return orbContext;
	}
}
