package org.acaro.graffiti.query;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class Subquery extends Condition {
	private FUNCTION function;
	private String argument;
	private String edge;
	
	public Subquery() { }
	
	public Subquery(String e, String f, String a) {
		this.function = parseFunction(f);
		this.argument = a;
		this.edge     = e;
	}
	
	public String toString() {
		return edge + "=" + function.name() + "(" + argument + ")";
	}

	@Override
	public void readFields(DataInput input) throws IOException {
		edge     = input.readUTF();
		function = FUNCTION.values()[input.readInt()];
		argument = input.readUTF();
	}

	@Override
	public void write(DataOutput output) throws IOException {
		output.writeInt(Condition.TYPE.SUBQUERY.ordinal());
		output.writeUTF(edge);
		output.writeInt(function.ordinal());
		output.writeUTF(argument);
	}
}
