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

    public ResultsAggregator() 
    throws IOException {

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
