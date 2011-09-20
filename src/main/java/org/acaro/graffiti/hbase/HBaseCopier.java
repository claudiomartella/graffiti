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
