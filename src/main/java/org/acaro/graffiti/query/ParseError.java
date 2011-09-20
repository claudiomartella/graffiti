package org.acaro.graffiti.query;

public class ParseError extends RuntimeException {

    private static final long serialVersionUID = -6429954396241543227L;

    public ParseError(String string) {
		super(string);
	}
}
