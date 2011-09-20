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
