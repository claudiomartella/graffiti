package org.acaro.graffiti.orb.sssp;

import org.acaro.graffiti.orb.pr.PRVertexWriter;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;
import org.goldenorb.OrbRunner;
import org.goldenorb.conf.OrbConfiguration;
import org.goldenorb.types.message.IntMessage;

public class SSSPJob extends OrbRunner {
	private static final String USAGE = "usage: SSSPJob <sourceVertexID>";

	private void startJob(String sourceVertex) {
		
		OrbConfiguration orbConf = new OrbConfiguration(true);
	    orbConf.setFileInputFormatClass(TextInputFormat.class);
	    orbConf.setFileOutputFormatClass(TextOutputFormat.class);
	    orbConf.setVertexClass(SSSPVertex.class);
	    orbConf.setMessageClass(IntMessage.class);
	    orbConf.setVertexInputFormatClass(SSSPVertexReader.class);
	    orbConf.setVertexOutputFormatClass(PRVertexWriter.class);
	    orbConf.setNumberOfMessageHandlers(10);
	    orbConf.setNumberOfVertexThreads(10);
	    orbConf.setNumberOfPartitionsPerMachine(3);
	    orbConf.setOrbRequestedPartitions(9);
	    orbConf.setFileInputPath("/path/to/input/data/");
	    orbConf.setFileOutputPath("/path/to/output/data/");
	    orbConf.setOrbClassPaths("/path/to/your/jar");
	    orbConf.set("sssp.sourceVertex", sourceVertex);
	    runJob(orbConf);
	}
	
	public static void main(String[] args) {
		
		if (args.length != 1) {
			System.out.println(USAGE);
			System.exit(-1);
		}
		
		SSSPJob job = new SSSPJob();
		job.startJob(args[0]);
	}
}
