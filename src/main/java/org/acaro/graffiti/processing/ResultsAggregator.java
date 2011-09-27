package org.acaro.graffiti.processing;

import java.io.IOException;

import org.apache.giraph.graph.Aggregator;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.log4j.Logger;

public class ResultsAggregator 
    implements Aggregator<ResultSet> {

    private static final Logger LOG = Logger.getLogger(ResultsAggregator.class);
    private static final String FILENAME = "/data/results";
    private static FSDataOutputStream out;
    
    public ResultsAggregator() throws IOException {
        
        Configuration conf = new Configuration();
        FileSystem fs      = FileSystem.get(conf);
        Path outFile       = new Path(FILENAME);
        
        if (fs.exists(outFile)) {
            LOG.error("file " + FILENAME + " already exists.");
            System.exit(-1);
        }

        out = fs.create(outFile);
    }
    
    @Override
    public void aggregate(ResultSet r) {
        try {
            r.write(out);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public ResultSet createAggregatedValue() {
        throw new UnsupportedOperationException("Operation not supported");
    }

    @Override
    public ResultSet getAggregatedValue() {
        throw new UnsupportedOperationException("Operation not supported");
    }

    @Override
    public void setAggregatedValue(ResultSet r) {
        throw new UnsupportedOperationException("Operation not supported");
    }
}
