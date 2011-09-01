package org.acaro.graffiti.query;

public class Subquery extends Condition {
	private FUNCTION function;
	private String argument;
	private String edge;
	private String f;
	
	public Subquery(String e, String f, String a) {
		this.function = parseFunction(f);
		this.argument = a;
		this.edge     = e;
		this.f        = f;
	}
	
	public String toString() {
		return edge + "=" + this.f + argument + ")";
	}
}
