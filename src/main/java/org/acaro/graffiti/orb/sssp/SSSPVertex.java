package org.acaro.graffiti.orb.sssp;

import java.util.Collection;
import java.util.List;

import org.apache.hadoop.io.IntWritable;
import org.goldenorb.Edge;
import org.goldenorb.Vertex;
import org.goldenorb.types.message.IntMessage;

public class SSSPVertex extends Vertex<IntWritable, IntWritable, IntMessage> {
	private boolean isSource = false;
	
	public SSSPVertex() {
		super(IntWritable.class, IntWritable.class, IntMessage.class);
	}

	public SSSPVertex(String vertexID, IntWritable value, List<Edge<IntWritable>> edges) {
		super(vertexID, value, edges);
		String sourceVertex = this.getOci().getOrbProperty("sssp.sourceVertex");
		isSource = sourceVertex.equals(vertexID);
	}
	
	@Override
	public void compute(Collection<IntMessage> messages) {
	
		int minDist = isSource ? 0 : Integer.MAX_VALUE;
		for (IntMessage message: messages) 
			minDist = Math.min(minDist, ((IntWritable) message.getMessageValue()).get());
		
		if (minDist < this.getValue().get()) {
			this.getValue().set(minDist);
			
			for (Edge<IntWritable> edge: this.getEdges())
				sendMessage(new IntMessage(edge.getDestinationVertex(), new IntWritable(minDist + 1)));
		}
		
		this.voteToHalt();
	}	
}
