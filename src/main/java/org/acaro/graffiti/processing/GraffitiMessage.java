package org.acaro.graffiti.processing;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import org.acaro.graffiti.query.Query;
import org.apache.hadoop.io.Writable;

public class GraffitiMessage 
    implements Writable, Cloneable {

    private Query query;
    private ResultSet results;

    public GraffitiMessage(Query query, ResultSet results) {
        this.query   = query;
        this.results = results;
    }
    
    public Query getQuery() {
        return this.query;
    }
    
    public ResultSet getResults() {
        return this.results;
    }

    @Override
    public GraffitiMessage clone() {
        return new GraffitiMessage(this.query.clone(), this.results.clone());
    }
    
    @Override
    public void readFields(DataInput input) throws IOException {
        this.query = new Query();
        this.query.readFields(input);
        this.results = new ResultSet();
        this.results.readFields(input);
    }

    @Override
    public void write(DataOutput output) throws IOException {
        this.query.write(output);
        this.results.write(output);
    }
}
