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
import java.util.Stack;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.Writable;

public class ResultSet 
    implements Writable, Cloneable {

    private Stack<Text> results = new Stack<Text>();    

    public ResultSet() { }
    
    protected ResultSet(Stack<Text> results) {
        this.results = results;
    }

    public Text pop() {
        return results.pop();
    }
    
    public Text push(Text item) {
        return results.push(item);
    }
    
    @SuppressWarnings("unchecked")
    @Override
    public ResultSet clone() {
        return new ResultSet((Stack<Text>) results.clone());
    }
    
    @Override
    public void readFields(DataInput input) throws IOException {
        int n = input.readInt();
        for (int i = 0; i < n; i++) {
            Text t = new Text();
            t.readFields(input);
            results.add(t);
        }
    }

    @Override
    public void write(DataOutput output) throws IOException {
        output.writeInt(results.size());
        for (Text result: results) {
            result.write(output);
        }
    }
}
