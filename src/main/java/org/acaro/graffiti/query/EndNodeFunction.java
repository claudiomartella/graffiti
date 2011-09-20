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

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import org.apache.hadoop.io.Writable;

public class EndNodeFunction implements Writable {
	public enum FUNCTION { MIN, MAX, COUNT, AVG, SUM, DISTANCE };
	private FUNCTION function;
	private String argument;
	
	public EndNodeFunction() { }
	
	public EndNodeFunction(String f) {
		this.function = parseFunction(f);
	}
	
	public EndNodeFunction(String func, String argument) {
		this(func);
		this.argument = argument;
	}
	
	private FUNCTION parseFunction(String func) {
		if (func.equals("MIN("))
			return FUNCTION.MIN;
		else if (func.equals("MAX("))
			return FUNCTION.MAX;
		else if (func.equals("COUNT("))
			return FUNCTION.COUNT;
		else if (func.equals("AVG("))
			return FUNCTION.AVG;
		else if (func.equals("SUM("))
			return FUNCTION.SUM;
		else if (func.equals("DISTANCE("))
			return FUNCTION.DISTANCE;
		else
			throw new ParseError("Unknown EndNodeFunction " + func);
	}
	
	public String toString() {
		StringBuffer string = new StringBuffer(". ");
		
		string.append(this.function.name());
		string.append("(");
		if (argument != null)
			string.append(argument);
		
		string.append(")");
		
		return string.toString();
	}

	@Override
	public void readFields(DataInput input) throws IOException {
		function = FUNCTION.values()[input.readInt()];
		if (function == FUNCTION.DISTANCE)
			argument = input.readUTF();
	}

	@Override
	public void write(DataOutput output) throws IOException {
		output.writeInt(function.ordinal());
		if (argument != null)
			output.writeUTF(argument);
	}
}
