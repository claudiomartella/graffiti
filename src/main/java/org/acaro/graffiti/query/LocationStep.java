package org.acaro.graffiti.query;

import java.util.ArrayList;

import com.google.common.base.Joiner;

public class LocationStep {
	private ArrayList<Condition> conditions = new ArrayList<Condition>();
	private String edge;
	private int repeat = -1;
	private boolean isSP = false;
	
	public void setEdge(String edge) {
		this.edge = edge;
	}

	public void addCondition(Condition condition) {
		conditions.add(condition);
	}

	public void setRepeat(Integer repeat) {
		this.repeat = repeat;
	}

	public void setSP(boolean value) {
		this.isSP = value;
	}
	
	public String toString() {
		String string;
		
		if (edge != null)
			string = edge;
		else
			string = "<no edge>";
		
		string += Joiner.on(" | ").skipNulls().join(conditions);
		
		if (repeat != -1) {
			string += " (";
			if (isSP)
				string += "*";
			string += ")";
		}
		
		return string;
	}
}
