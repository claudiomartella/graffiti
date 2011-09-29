package org.acaro.graffiti;

import org.acaro.graffiti.processing.Vertex;
import org.apache.hadoop.util.ToolRunner;

public class Graffiti {

    public static void main(String[] args) throws Exception {
        System.exit(ToolRunner.run(new Vertex(), args));
    }
}
