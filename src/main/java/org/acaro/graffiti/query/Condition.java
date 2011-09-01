package org.acaro.graffiti.query;

public abstract class Condition {
	public enum FUNCTION { MIN, MAX, EQUALS, PREFIX, SUFFIX };

	protected FUNCTION parseFunction(String func) {
		if (func.equals("MIN("))
			return FUNCTION.MIN;
		else if (func.equals("MAX("))
			return FUNCTION.MAX;
		else if (func.equals("PREFIX("))
			return FUNCTION.PREFIX;
		else if (func.equals("SUFFIX"))
			return FUNCTION.SUFFIX;
		else if (func.equals("EQUALS"))
			return FUNCTION.EQUALS;
		else
			throw new ParseError("Unknown EndNodeFunction " + func);
	}
}
