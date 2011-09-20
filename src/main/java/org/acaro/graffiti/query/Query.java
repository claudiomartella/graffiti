package org.acaro.graffiti.query;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.util.Stack;

import org.apache.hadoop.io.Writable;

import com.google.common.base.Joiner;

public class Query 
    implements Writable, Cloneable {
 
    private Stack<LocationStep> locationSteps;
	private EndNodeFunction enf;
	private String startNode;
	
	public Query() { }
	
	public Query(String startNode, Stack<LocationStep> locationSteps) {
		setStartNode(startNode);
		setLocationSteps(locationSteps);
	}

	public Query(String startNode, Stack<LocationStep> locationSteps, EndNodeFunction func) {
		this(startNode, locationSteps);
		setEndNodeFunction(func);
	}

	public void setStartNode(String label) {
		this.startNode = label;
	}
	
	public String getStartNode() {
		return this.startNode;
	}
	
	public void setLocationSteps(Stack<LocationStep> locationSteps) {
		this.locationSteps = locationSteps;
	}
	
	public Stack<LocationStep> getLocationSteps() {
		return this.locationSteps;
	}
	
	public void setEndNodeFunction(EndNodeFunction enf) {
		this.enf = enf;
	}
	
	public EndNodeFunction getEndNodeFunction() {
		return this.enf;
	}
	
	public String toString() {
		StringBuffer string = new StringBuffer(startNode);
		
		string.append(" :: ");
		string.append(Joiner.on(" > ").skipNulls().join(locationSteps));
		if (enf != null) {
			string.append(enf);
		}
		
		return string.toString();
	}

	@Override
	public void readFields(DataInput input) throws IOException {
		Stack<LocationStep> locationSteps = new Stack<LocationStep>();
		
		int n = input.readInt();
		for (int i = 0; i < n; i++) {
			LocationStep l = new LocationStep();
			l.readFields(input);
			locationSteps.add(l);
		}

		setLocationSteps(locationSteps);
		setStartNode(input.readUTF());
		if (input.readBoolean() == true) {
			EndNodeFunction enf = new EndNodeFunction();
			enf.readFields(input);
			setEndNodeFunction(enf);
		}
	}

	@Override
	public void write(DataOutput output) throws IOException {
		output.writeInt(locationSteps.size());
		for (LocationStep l: getLocationSteps()) {
			l.write(output);
		}
		
		output.writeUTF(getStartNode());
		if (enf != null) {
			output.writeBoolean(true);
			enf.write(output);
		} else { 
			output.writeBoolean(false);
		}
	}

	@SuppressWarnings("unchecked")
    @Override
	public Query clone() {
        Query clonedQuery = (enf == null) 
            ? new Query(startNode, locationSteps) 
            : new Query(startNode, locationSteps, enf);
        
        clonedQuery.locationSteps = (Stack<LocationStep>) locationSteps.clone();
            
        return clonedQuery;
	}
}
