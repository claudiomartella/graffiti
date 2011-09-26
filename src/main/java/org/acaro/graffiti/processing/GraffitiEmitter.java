package org.acaro.graffiti.processing;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.log4j.Logger;

public class GraffitiEmitter {

    private static final Logger LOG = Logger.getLogger(GraffitiEmitter.class);
    private static final String FILENAME = "outfile";
    private static FSDataOutputStream out;
    
    private GraffitiEmitter() { 
    
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
        public static final GraffitiEmitter instance = new GraffitiEmitter();
    }

    public static GraffitiEmitter getInstance() {
        return GraffitiEmitterHolder.instance;
    }
    
    public synchronized void emit(ResultSet r) throws IOException {
    	r.write(out);
    }
    
    public synchronized void close() throws IOException {
        if (out != null) {
            out.flush();
            out.close();
            out = null;
        }
    }
}
