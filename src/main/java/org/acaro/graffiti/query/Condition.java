package org.acaro.graffiti.query;

import org.apache.hadoop.io.Writable;

public abstract class Condition implements Writable {
	public enum FUNCTION { MIN, MAX, EQUALS, PREFIX, SUFFIX };
	public enum TYPE { SUBQUERY, FILTER };

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
