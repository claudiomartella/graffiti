package org.acaro.graffiti.query;

import java.util.ArrayList;
import java.util.List;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.TokenRewriteStream;
import org.antlr.runtime.tree.CommonTree;
import org.antlr.runtime.tree.CommonTreeAdaptor;
import org.antlr.runtime.tree.TreeAdaptor;

import antlr.Token;

public class QueryParser {
	private static final String USAGE = "./QueryParser <query>";

	public static void main(String[] args) throws RecognitionException {

		if (args.length != 1) {
			System.out.println(USAGE);
			System.exit(-1);
		}
		
		ANTLRStringStream is = new ANTLRStringStream(args[0]);
		RDFPathLexer lexer   = new RDFPathLexer(is);
		CommonTokenStream ts = new CommonTokenStream(lexer);
		RDFPathParser parser = new RDFPathParser(ts);
		RDFPathParser.query_return result = parser.query();
		
		CommonTree ast = (CommonTree) result.getTree();
		
		Query q = parseQuery(ast);
	}
	
	private static Query parseQuery(CommonTree ast) {
		if (ast.getType() != RDFPathLexer.QUERY) 
			throw new ParseError("query should be first root");
		
		String startNode     = null;
		EndNodeFunction func = null;
		List<LocationStep> locationSteps = new ArrayList<LocationStep>();
		
		for (Object child: ast.getChildren()) {
			CommonTree treeChild = (CommonTree) child;
			
			switch (treeChild.getType()) {
			
			case RDFPathLexer.STARTNODE:
				
				startNode = treeChild.getChild(0).getText();
				break;
				
			case RDFPathLexer.LOCATIONSTEP:
				
				LocationStep l = parseLocationStep(treeChild);
				locationSteps.add(l);
				break;
				
			case RDFPathLexer.ENDNODEFUNCTION:
				
				if (treeChild.getChildCount() != 1)
					func = new EndNodeFunction(treeChild.getChild(0).getText(), 
							treeChild.getChild(1).getText());
				else
					func = new EndNodeFunction(treeChild.getChild(0).getText());
				break;
				
			default:
				throw new ParseError("unknown type: "+ treeChild.getType());
			}
		}
		
		return (func == null) ? new Query(startNode, locationSteps) : 
			new Query(startNode, locationSteps, func);
	}

	private static LocationStep parseLocationStep(CommonTree ast) {

		String edge = null;
		List<Condition> conditions = new ArrayList<Condition>();
		Integer repeat = null;
		boolean sp;
		
		for (Object child: ast.getChildren()) {
			CommonTree treeChild = (CommonTree) child;
			
			switch (treeChild.getType()) {
				
			case RDFPathLexer.EDGE:
				
				edge = treeChild.getChild(0).getText();
				break;
				
			case RDFPathLexer.CONDITION:
				
				Condition c = parseCondition(treeChild);
				conditions.add(c);
				break;

			case RDFPathLexer.REPEAT:
				
				repeat = Integer.parseInt(treeChild.getChild(0).getText());
				break;
				
			case RDFPathLexer.SHORTESTPATH:
				
				repeat = Integer.parseInt(treeChild.getChild(0).getText());
				sp     = true;
				break;
				
			default:
				throw new ParseError("unknown type: "+ treeChild.getType());
			}
		}
		
		
		
	}

	private static void printCondition(CommonTree ast) {

		for (Object child: ast.getChildren()) {
			CommonTree treeChild = (CommonTree) child;

			switch (treeChild.getType()) {

			case RDFPathLexer.FILTER:
			{	
				CommonTree filterFunction = (CommonTree) treeChild.getChild(0);
				String function = filterFunction.getChild(0).getText();
				String argument = filterFunction.getChild(1).getText();

				System.out.print("[ " + function + argument + ") ]");

				break;
			}
			case RDFPathLexer.SUBQUERY:
			{
				String edge     = treeChild.getChild(0).getChild(0).getText();
				CommonTree filterFunction = (CommonTree) treeChild.getChild(1);
				String function = filterFunction.getChild(0).getText();
				String argument = filterFunction.getChild(1).getText();

				System.out.print("[ " + edge + " = " + function + argument + ") ]");

				break;
			}	
			default:
				throw new ParseError("unknown type: "+ treeChild.getType());
			}
		}
	}
}
