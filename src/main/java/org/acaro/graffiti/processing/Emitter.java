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

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.log4j.Logger;

public class Emitter {

    private static final Logger LOG = Logger.getLogger(Emitter.class);
    private static final String FILENAME = "outfile";
    private static FSDataOutputStream out;
    
    private Emitter() { 
    
        try {

            Configuration conf = new Configuration();
            FileSystem fs = FileSystem.get(conf);
            Path outFile = new Path("out/file");
            if (fs.exists(outFile)) {
                LOG.error("file " + FILENAME + " already exists.");
                System.exit(-1);
            }

            out = fs.create(outFile);
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(-1);
        }
    }
    
    private static class GraffitiEmitterHolder { 
        public static final Emitter instance = new Emitter();
    }

    public static Emitter getInstance() {
        return GraffitiEmitterHolder.instance;
    }
    
    public synchronized void emit(ResultSet r) 
    throws IOException {

        r.write(out);
    }
    
    public synchronized void close() 
    throws IOException {
    
        if (out != null) {
            out.flush();
            out.close();
            out = null;
        }
    }
}
