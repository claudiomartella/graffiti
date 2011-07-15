package org.acaro.graffiti.hbase;

import java.io.BufferedWriter;

import org.openrdf.model.Statement;
import org.openrdf.rio.RDFHandler;
import org.openrdf.rio.RDFHandlerException;

public class TripleHandler implements RDFHandler {
	private HBaseManager manager;
	private long total = 0;
	
	public TripleHandler(HBaseManager manager) {
		this.manager = manager;
	}
	
	public void handleComment(String arg0) throws RDFHandlerException { }

	public void handleNamespace(String arg0, String arg1)
			throws RDFHandlerException { }

	public void handleStatement(Statement arg0) {

		try {
			// avoid self-cycles
			if (arg0.getSubject().stringValue().equals(arg0.getObject().stringValue()))
				return;
			
			if (total++ % 1000 == 0)
				System.out.println("1000 triples inserted");
			
			manager.addTriple(arg0.getSubject(), arg0.getPredicate(), arg0.getObject());
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Subject: " + arg0.getSubject().toString() +
					" Predicate: " + arg0.getPredicate().toString() +
					" Object: " + arg0.getObject().toString());
		}
	}

	public void startRDF() throws RDFHandlerException { }
	
	public void endRDF() throws RDFHandlerException { }
}
