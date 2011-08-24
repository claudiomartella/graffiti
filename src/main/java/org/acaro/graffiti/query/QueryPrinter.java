package org.acaro.graffiti.query;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.TokenRewriteStream;
import org.antlr.runtime.tree.CommonTree;
import org.antlr.runtime.tree.CommonTreeAdaptor;
import org.antlr.runtime.tree.TreeAdaptor;

import antlr.Token;

public class QueryPrinter {
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
		
		printQuery(ast);
	}
	
	private static void printQuery(CommonTree ast) {
		if (ast.getType() != RDFPathLexer.QUERY) 
			throw new ParseError("query should be first root");
		
		for (Object child: ast.getChildren()) {
			CommonTree treeChild = (CommonTree) child;
			
			switch (treeChild.getType()) {
			
			case RDFPathLexer.STARTNODE:
				
				System.out.print(treeChild.getChild(0).getText() + " :: ");
				
				break;
				
			case RDFPathLexer.LOCATIONSTEP:
				
				printLocationStep(treeChild);
				
				break;
				
			case RDFPathLexer.ENDNODEFUNCTION:
				int num = treeChild.getChildCount();
				
				if (treeChild.getChildCount() != 1)
					System.out.print(". " + treeChild.getChild(0).getText() +
							treeChild.getChild(1).getText() + ")");
				else
					System.out.print(". " + treeChild.getChild(0).getText());
				
				break;
				
			default:
				throw new ParseError("unknown type: "+ treeChild.getType());
			}
		}
	}

	private static void printLocationStep(CommonTree ast) {

		for (Object child: ast.getChildren()) {
			CommonTree treeChild = (CommonTree) child;
			
			switch (treeChild.getType()) {
				
			case RDFPathLexer.EDGE:
				
				System.out.print(" " + treeChild.getChild(0).getText());
				
				break;
				
			case RDFPathLexer.CONDITION:
				
				printCondition(treeChild);
				
				break;

			case RDFPathLexer.REPEAT:
				
				System.out.print("( " + treeChild.getChild(0).getText()+ " )");
				
				break;
				
			case RDFPathLexer.SHORTESTPATH:
				
				System.out.print("(* " + treeChild.getChild(0).getText()+ " )");
				
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
