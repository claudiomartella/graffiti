package org.acaro.graffiti.hbase;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class HBaseCopier {
	private static final String USAGE = "usage: HBaseLoader <file to load>";

	private static void loadFile(final String file, HBaseManager manager) throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader(file));
		
		String line;
		while ((line = reader.readLine()) != null) {
			String[] tokens = line.split(" ", 3);
			
			manager.addTriple(
					tokens[0], 
					tokens[1], 
					tokens[2].substring(0, tokens[2].length()-1)); // remove '.' in the end			
		}

		reader.close();
	}
		
	public static void main(String[] args) throws IOException {
				
		if (args.length != 1) {
			System.err.println(USAGE);
			System.exit(-1);
		}
		
		HBaseManager manager = new HBaseManager();
		loadFile(args[0], manager);
		manager.close();
	}
}
