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

package org.acaro.graffiti.processing;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.util.Iterator;
import java.util.Stack;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.Writable;

/*
 * TODO:
 * Can highly optimize by keeping the internal binary representation. After all we only
 * add stuff to this before serializing it back, so no need to deserialize into Stack.
 * At second thought, that's not true as Text is already the binary representation in memory.
 */
public class ResultSet 
implements Writable, Iterable<Text> {

    private Stack<Text> results = new Stack<Text>();    

    public ResultSet() { }
    
    protected ResultSet(Stack<Text> results) {
        this.results = results;
    }

    public ResultSet(ResultSet other) {
        this.results = new Stack<Text>();
        this.results.addAll(other.results);
    }

    public Text add(Text result) {
        return results.push(result);
    }
    
    @Override
    public void readFields(DataInput input) 
    throws IOException {
        
        int n = input.readInt();
        for (int i = 0; i < n; i++) {
            Text t = new Text();
            t.readFields(input);
            results.add(t);
        }
    }

    @Override
    public void write(DataOutput output) 
    throws IOException {
        
        output.writeInt(results.size());
        for (Text result: results) {
            result.write(output);
        }
    }

    @Override
    public Iterator<Text> iterator() {
        return results.iterator();
    }
    
    public String toString() {
    	StringBuilder builder = new StringBuilder();
    	
    	for (Text result: results) {
    		builder.append(result.toString() + " ");
    	}
    	
    	return builder.toString();
    }
}
