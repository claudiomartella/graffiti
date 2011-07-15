package org.acaro.graffiti.hbase;

import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

import org.openrdf.rio.ParseErrorListener;
import org.openrdf.rio.RDFHandlerException;
import org.openrdf.rio.RDFParseException;
import org.openrdf.rio.RDFParser;
import org.openrdf.rio.n3.N3ParserFactory;

public class HBaseLoader {
	private static final String USAGE = "usage: HBaseLoader <file to load>";

	private static void loadFile(final String file, HBaseManager manager) throws RDFParseException, RDFHandlerException, FileNotFoundException, IOException {

		RDFParser parser = new N3ParserFactory().getParser();
		TripleHandler handler = new TripleHandler(manager);
		
		parser.setRDFHandler(handler);
		parser.setStopAtFirstError(false);
		parser.setParseErrorListener(new ParseErrorListener() {
			
			public void warning(String msg, int lineNo, int colNo) {
				System.err.println("warning: " + msg);
				System.err.println("file: " + file + " line: " + lineNo + " column: " +colNo);
			}

			public void error(String msg, int lineNo, int colNo) {
				System.err.println("error: " + msg);
				System.err.println("file: " + file + " line: " + lineNo + " column: " +colNo);
			}

			public void fatalError(String msg, int lineNo, int colNo) {
				System.err.println("fatal: " + msg);
				System.err.println("file: " + file + " line: " + lineNo + " column: " +colNo);
			}
			
		});
		parser.parse(new BufferedInputStream(new FileInputStream(new File(file))), "http://localhost/");
	}
		
	public static void main(String[] args) throws IOException, RDFParseException, RDFHandlerException {
				
		if (args.length != 1) {
			System.err.println(USAGE);
			System.exit(-1);
		}
		
		HBaseManager manager = new HBaseManager();
		loadFile(args[0], manager);
		manager.close();
	}
}
