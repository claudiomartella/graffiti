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
import java.util.Set;

import org.acaro.graffiti.processing.GraffitiVertex;
import org.apache.hadoop.io.Text;

public class Filter extends Condition {
	
    private FUNCTION function;
	private String argument;
	private String edge;
	
	public Filter() { }
	
	public Filter(String e, String f, String a) {
		this.function = parseFunction(f);
		this.argument = a;
		this.edge     = e;
	}
	
	public String toString() {
		return function.name() + "(" + argument + ")";
	}

	@Override
	public void readFields(DataInput input) throws IOException {
	    edge     = input.readUTF();
	    function = FUNCTION.values()[input.readInt()];
		argument = input.readUTF();
	}

	@Override
	public void write(DataOutput output) throws IOException {
		output.writeInt(Condition.TYPE.FILTER.ordinal());
		output.writeUTF(edge);
		output.writeInt(function.ordinal());
		output.writeUTF(argument);
	}

    @Override
    public boolean evaluate(GraffitiVertex vertex) {
       
        Set<Text> values = vertex.getEdgesByLabel(new Text(edge));
        if (values == null || values.size() != 1) {
            return false;
        }
        
        String value = values.iterator().next().toString();
        
        boolean ret = false;
        switch (function) {
        case MAX:
        {
            try {
                int v = Integer.parseInt(value);
                int a = Integer.parseInt(argument);
                ret = (v > a) ? true : false;
            } catch (NumberFormatException e) { }
            break;
        }
        case MIN:
        {
            try {
                int v = Integer.parseInt(value);
                int a = Integer.parseInt(argument);
                ret = (v < a) ? true : false;
            } catch (NumberFormatException e) { }
            break;
        }
        case EQUALS:
        {
            ret = value.equals(argument);
            break;
        }
        case PREFIX:
        {
            ret = value.startsWith(argument);
            break;
        }
        case SUFFIX:
        {
            ret = value.endsWith(argument);
            break;
        }
        default:
            throw new IllegalStateException("unknown function, should not happen!");
        }
        
        return ret;
    }
}
