/*  Copyright 2011 Claudio Martella
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
*/

package org.acaro.graffiti.query;

import java.util.ArrayDeque;
import java.util.Deque;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.tree.CommonTree;

public class QueryParser {

    private String query;
	private Query q;
	private LocationStep current, next;
	
	public QueryParser(String query) {
		this.query = query;
	}
	
	public Query parse() throws RecognitionException {

		if (q == null) {
			ANTLRStringStream is = new ANTLRStringStream(query);
			RDFPathLexer lexer   = new RDFPathLexer(is);
			CommonTokenStream ts = new CommonTokenStream(lexer);
			RDFPathParser parser = new RDFPathParser(ts);
			RDFPathParser.query_return result = parser.query();

			CommonTree ast = (CommonTree) result.getTree();

			q = parseQuery(ast);
		} 
		
		return q;
	}
	
	private Query parseQuery(CommonTree ast) {
		Deque<LocationStep> locationSteps = new ArrayDeque<LocationStep>();
		String startNode     = null;
		EndNodeFunction func = null;
		
		for (Object child: ast.getChildren()) {
			CommonTree treeChild = (CommonTree) child;
			
			switch (treeChild.getType()) {
			
			case RDFPathLexer.STARTNODE:
			{	
				startNode = treeChild.getChild(0).getText();
				break;
			}	
			case RDFPathLexer.LOCATIONSTEP:
			{	
				LocationStep l = parseLocationStep(treeChild);
				locationSteps.add(l);
				break;
			}	
			case RDFPathLexer.ENDNODEFUNCTION:
			{	
				if (treeChild.getChildCount() != 1) {
					func = new EndNodeFunction(treeChild.getChild(0).getText(), 
							treeChild.getChild(1).getText());
				} else {
					func = new EndNodeFunction(treeChild.getChild(0).getText());
				}
				break;
			}	
			default:
				throw new ParseError("unknown type: "+ treeChild.getType());
			}
		}
		
		if (next != null) {
			locationSteps.add(next);
		}
		
		return (func == null) ? new Query(startNode, locationSteps) : 
			new Query(startNode, locationSteps, func);
	}

	private LocationStep parseLocationStep(CommonTree ast) {
		// we might already have a locationStep created by a subquery
		if (next != null) {
			current = next;
			next    = null;
		} else {
			current = new LocationStep();
		}
		
		for (Object child: ast.getChildren()) {
			CommonTree treeChild = (CommonTree) child;
			
			switch (treeChild.getType()) {
				
			case RDFPathLexer.EDGE:
			{	
				String edge = treeChild.getChild(0).getText();
				current.setEdge(edge);
				current.addCondition(new HasEdge(edge));
				break;
			}	
			case RDFPathLexer.CONDITION:
			{	
				CommonTree conditionTree = (CommonTree) treeChild.getChild(0);
				
				switch (conditionTree.getType()) {

				case RDFPathLexer.FILTER:
				{	
					CommonTree filterFunction = (CommonTree) conditionTree.getChild(0);
					String function = filterFunction.getChild(0).getText();
					String argument = filterFunction.getChild(1).getText();
					String edge     = current.getEdge();
					
					current.addCondition(new Subquery(edge, function, argument));
					break;
				}	
				case RDFPathLexer.SUBQUERY:
				{	
					CommonTree filterFunction = (CommonTree) conditionTree.getChild(1);
					String function = filterFunction.getChild(0).getText();
					String argument = filterFunction.getChild(1).getText();
					String edge     = conditionTree.getChild(0).getChild(0).getText();

					// subqueries are actually executed by the next vertex
					if (next == null) {
						next = new LocationStep();
					}
					next.addCondition(new Subquery(edge, function, argument));
					break;
				}	
				default:
					throw new ParseError("unknown condition type: "+ conditionTree.getType());
				}
				break;
			}	
			case RDFPathLexer.REPEAT:
			{	
				Integer repeat = Integer.parseInt(treeChild.getChild(0).getText());
				current.setRepeat(repeat);
				break;
			}	
			case RDFPathLexer.SHORTESTPATH:
			{	
				Integer repeat = Integer.parseInt(treeChild.getChild(0).getText());
				current.setRepeat(repeat);
				current.setSP(true);
				break;
			}	
			default:
				throw new ParseError("unknown type: "+ treeChild.getType());
			}
		}
		
		return current;
	}
}
