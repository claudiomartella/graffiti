package org.acaro.graffiti;

import org.acaro.graffiti.processing.Vertex;
import org.acaro.graffiti.query.LocationStep;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.util.ToolRunner;

public class Graffiti {

    public static final String OUTPUTDIR = "graffiti.outputdir";
    public static final String SOURCE_VX = "graffiti.source_vertex";
    public static final String QUERY     = "graffiti.query";

    public static boolean isSource(String source, Text vertexId) {
        return source.equals(LocationStep.ANY) || source.equals(vertexId.toString());
    }
    
	public static void main(String[] args) throws Exception {
        if (args.length != 3) {
            throw new IllegalArgumentException("Graffiti: Must have 2 arguments <input path> <output path> <query>");
        }
		
        System.exit(ToolRunner.run(new Vertex(), args));
    }
}
