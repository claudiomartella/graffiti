package org.acaro.graffiti.query;

import org.antlr.runtime.RecognitionException;

public class Test {

	public static void main(String[] args) throws RecognitionException {

		Query q = new QueryParser("bla :: ciao").parse();
		
		System.out.println(q.toString());
	}
}
