package org.acaro.graffiti.query;

public class Filter extends Condition {
	private FUNCTION function;
	private String argument;
	
	public Filter(String f, String a) {
		this.function = parseFunction(f);
		this.argument = a;
	}
	
	public String toString() {
		return function + argument + ")";
	}
}
