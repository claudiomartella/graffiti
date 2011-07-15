package org.acaro.graffiti.orb.pr;

import org.apache.hadoop.io.Text;
import org.goldenorb.io.output.OrbContext;
import org.goldenorb.io.output.VertexWriter;

public class PRVertexWriter extends VertexWriter<PRVertex, Text, Text> {

	@Override
	public OrbContext<Text, Text> vertexWrite(PRVertex vertex) {
		
		OrbContext<Text, Text> orbContext = new OrbContext<Text, Text>();
		
		orbContext.write(new Text(vertex.getVertexID()), new Text(Double.toString(vertex.getValue().get())));
		
		return orbContext;
	}
}
