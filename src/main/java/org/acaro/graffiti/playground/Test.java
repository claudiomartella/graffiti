package org.acaro.graffiti.playground;

import org.acaro.graffiti.query.Query;
import org.acaro.graffiti.query.QueryParser;
import org.antlr.runtime.RecognitionException;

public class Test {

	public static void main(String[] args) throws RecognitionException {

		Query q = new QueryParser("bla :: age [MAX(10)][MIN(3)] > knows [ country = PREFIX('DE')]").parse();
		
		System.out.println(q.toString());
	}
}
