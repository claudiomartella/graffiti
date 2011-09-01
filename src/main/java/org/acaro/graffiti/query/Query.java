package org.acaro.graffiti.query;

import java.util.List;

import com.google.common.base.Joiner;

public class Query {
	private List<LocationStep> locationSteps;
	private EndNodeFunction enf;
	private String startNode;
	
	public Query(String startNode, List<LocationStep> locationSteps) {
		setStartNode(startNode);
		setLocationSteps(locationSteps);
	}

	public Query(String startNode, List<LocationStep> locationSteps, EndNodeFunction func) {
		this(startNode, locationSteps);
		setEndNodeFunction(func);
	}

	public void setStartNode(String label) {
		this.startNode = label;
	}
	
	public String getStartNode() {
		return this.startNode;
	}
	
	public void setLocationSteps(List<LocationStep> locationSteps) {
		this.locationSteps = locationSteps;
	}
	
	public List<LocationStep> getLocationSteps() {
		return this.locationSteps;
	}
	
	public void setEndNodeFunction(EndNodeFunction enf) {
		this.enf = enf;
	}
	
	public EndNodeFunction getEndNodeFunction() {
		return this.enf;
	}
	
	public String toString() {
		String string = startNode + " :: " + Joiner.on(" > ").skipNulls().join(locationSteps);
		if (enf != null)
			string = string + enf;
		
		return string;
	}
}
