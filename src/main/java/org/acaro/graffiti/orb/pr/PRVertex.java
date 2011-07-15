package org.acaro.graffiti.orb.pr;

import java.util.Collection;
import java.util.List;

import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.IntWritable;
import org.goldenorb.Edge;
import org.goldenorb.Vertex;
import org.goldenorb.types.message.DoubleMessage;
import org.goldenorb.types.message.IntMessage;

public class PRVertex extends Vertex<DoubleWritable, IntWritable, DoubleMessage> {
	private int numberOfEdges;
	private int numberOfVertices;
	
	public PRVertex() {
		super(DoubleWritable.class, IntWritable.class, DoubleMessage.class);
	}

	public PRVertex(String vertexID, DoubleWritable value, List<Edge<IntWritable>> edges) {
		super(vertexID, value, edges);
		numberOfEdges    = edges.size();
		numberOfVertices = Integer.parseInt(this.getOci().getOrbProperty("pr.numberOfVertices"));
	}
	
	@Override
	public void compute(Collection<DoubleMessage> messages) {
		
		if (this.superStep() >= 1) {
			double sum = 0;
			for (DoubleMessage message: messages)
				sum += ((IntWritable) message.getMessageValue()).get();
			this.getValue().set(0.15 / numberOfVertices + 0.85 * sum);
		}
		
		if (this.superStep() < 30) {
			for (Edge<IntWritable> edge: this.getEdges())
				sendMessage(new DoubleMessage(edge.getDestinationVertex(), new DoubleWritable(this.getValue().get() / numberOfEdges)));
		} else {
			this.voteToHalt();
		}
	}
}
