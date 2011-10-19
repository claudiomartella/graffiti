package org.acaro.graffiti.processing;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.hadoop.mapreduce.TaskAttemptID;
import org.apache.hadoop.mapreduce.Mapper.Context;
import org.apache.log4j.Logger;

/**
 * This class is thread-safe as it encapsulates ConcurrentHashMap. It's also a thread-safe
 * singleton (Bill Pugh's tech). Different workers access Emitters and multiple workers
 * can potentially run in parallel.
 * 
 * @author hammer
 *
 */
public class Emitters {
    
    private Map<TaskAttemptID,Emitter> emitters = new ConcurrentHashMap<TaskAttemptID, Emitter>();
    private static final Logger LOG = Logger.getLogger(Emitters.class);
    
    private Emitters() { }
    
    private static class SingletonHolder { 
        public static final Emitters instance = new Emitters();
    }
    
    public static Emitters getInstance() {
        return SingletonHolder.instance;
    }
    
    @SuppressWarnings("rawtypes")
    public void registerEmitter(Context context) throws IOException {
        if (emitters.put(context.getTaskAttemptID(), new Emitter(context)) != null) {
            LOG.error("registering an Emitter for an already registered TaskAttempt");
        }
    }
    
    @SuppressWarnings("rawtypes")
    public Emitter removeEmitter(Context context) {
        Emitter old = emitters.remove(context.getTaskAttemptID()); 
        
        if (old == null) {
            LOG.warn("removing a non-registered Emitter");
        }
        
        return old;
    }
    
    @SuppressWarnings("rawtypes")
    public Emitter getEmitter(Context context) {
        return emitters.get(context.getTaskAttemptID());
    }
}
