package org.acaro.graffiti.query;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class Filter extends Condition {
	private FUNCTION function;
	private String argument;
	
	public Filter() { }
	
	public Filter(String f, String a) {
		this.function = parseFunction(f);
		this.argument = a;
	}
	
	public String toString() {
		return function.name() + "(" + argument + ")";
	}

	@Override
	public void readFields(DataInput input) throws IOException {
		function = FUNCTION.values()[input.readInt()];
		argument = input.readUTF();
	}

	@Override
	public void write(DataOutput output) throws IOException {
		output.writeInt(Condition.TYPE.FILTER.ordinal());
		output.writeInt(function.ordinal());
		output.writeUTF(argument);
	}
}
