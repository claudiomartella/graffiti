package org.acaro.graffiti.query;

public class EndNodeFunction {
	public enum FUNCTION { MIN, MAX, COUNT, AVG, SUM, DISTANCE };
	private FUNCTION func;
	private String f;
	private String argument;
	
	public EndNodeFunction(String f) {
		this.func = parseFunction(f);
		this.f    = f;
	}
	
	public EndNodeFunction(String func, String argument) {
		this(func);
		this.argument = argument;
	}
	
	private FUNCTION parseFunction(String func) {
		if (func.equals("MIN("))
			return FUNCTION.MIN;
		else if (func.equals("MAX("))
			return FUNCTION.MAX;
		else if (func.equals("COUNT("))
			return FUNCTION.COUNT;
		else if (func.equals("AVG("))
			return FUNCTION.AVG;
		else if (func.equals("SUM("))
			return FUNCTION.SUM;
		else if (func.equals("DISTANCE("))
			return FUNCTION.DISTANCE;
		else
			throw new ParseError("Unknown EndNodeFunction " + func);
	}
	
	public String toString() {
		StringBuffer string = new StringBuffer(". ");
		
		string.append(this.f);
		if (argument != null)
			string.append(argument);
		
		string.append(")");
		
		return string.toString();
	}
}
