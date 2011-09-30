package org.acaro.graffiti.processing;

import static org.junit.Assert.*;

import java.util.Set;

import org.apache.hadoop.io.Text;
import org.junit.Test;

public class VertexText {

	@Test
	public void should_add_edge_and_get_by_label() {
		Vertex vertex = new Vertex();
		vertex.addEdge(new Text("someId"), new Text("someLabel"));
		Set<Text> edges = vertex.getEdgesByLabel(new Text("someLabel"));
		assertEquals(1, edges.size());
		assertEquals("someId", edges.toArray()[0].toString());
	}
	
}
