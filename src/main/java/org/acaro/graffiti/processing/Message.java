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

import org.acaro.graffiti.query.Query;
import org.apache.hadoop.io.Writable;

public class Message 
implements Writable {

    private Query query;
    private ResultSet results;

    public Message(Query query, ResultSet results) {
        this.query   = query;
        this.results = results;
    }

    public Message(Message other) {
        this.query   = new Query(other.getQuery());
        this.results = new ResultSet(other.getResults());
    }

    public Query getQuery() {
        return this.query;
    }

    public ResultSet getResults() {
        return this.results;
    }

    @Override
    public void readFields(DataInput input) 
    throws IOException {

        this.query   = new Query();
        this.results = new ResultSet();
        this.query.readFields(input);
        this.results.readFields(input);
    }

    @Override
    public void write(DataOutput output) 
    throws IOException {

        this.query.write(output);
        this.results.write(output);
    }
}
