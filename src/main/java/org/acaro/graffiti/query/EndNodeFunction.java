package org.acaro.graffiti.query;

public class EndNodeFunction {
	public enum FUNCTION { MIN, MAX, COUNT, AVG, SUM, DISTANCE };
	private FUNCTION func;
	private String argument;
	
	public EndNodeFunction(String f) {
		func = parseFunction(f);
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
}
