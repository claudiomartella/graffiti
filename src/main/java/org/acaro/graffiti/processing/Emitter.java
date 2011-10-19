package org.acaro.graffiti.processing;

import java.io.Closeable;
import java.io.DataOutputStream;
import java.io.IOException;

import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Writable;
import org.apache.hadoop.mapreduce.Mapper.Context;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

/**
 *  Emitter is not thread-safe but it should not be a problem as only vertices belonging to 
 *  the same worker share each Emitter and there's only one vertex per worker active at
 *  each moment. So: no concurrency should happen at Emitter level.
 */
public class Emitter implements Closeable {
    
    private static final String FILENAME = "emitter_";
    private DataOutputStream out;
    
    @SuppressWarnings("rawtypes")
    public Emitter(Context context) throws IOException {
        Path outF = new Path(FileOutputFormat.getOutputPath(context), FILENAME+context.getTaskAttemptID().toString());
        FileSystem fs = FileSystem.get(context.getConfiguration());
        out = fs.create(outF);
    }
    
    public void write(Writable o) throws IOException {
        o.write(out);
    }
    
    @Override
    public void close() throws IOException {
        if (out != null) {
            out.flush();
            out.close();
            out = null;
        }
    }
}
