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

import org.acaro.graffiti.processing.Vertex;
import org.apache.hadoop.io.Text;

public class HasEdge 
extends Condition {

	private String edge;
	
	public HasEdge() { }
	
	public HasEdge(String e) {
		this.edge     = e;
	}
	
	public String toString() {
		return "hasEdge(" + edge + ")";
	}

	@Override
	public void readFields(DataInput input) 
	throws IOException {
	
	    edge = input.readUTF();
	}

	@Override
	public void write(DataOutput output) 
	throws IOException {
	
	    output.writeInt(Condition.TYPE.HASEDGE.ordinal());
	    output.writeUTF(edge);
	}

    @Override
    public boolean evaluate(Vertex vertex) {
        
    	if (edge.equals(LocationStep.ANY) && vertex.getNumOutEdges() > 0) {
    		return true;
    	}
    	
        Set<Text> values = vertex.getEdgesByLabel(new Text(edge));
        if (values == null || values.size() <= 0) {
            return false;
        }
        
        return true;
    }
}
