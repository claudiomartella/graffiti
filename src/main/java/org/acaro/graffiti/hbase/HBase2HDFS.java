package org.acaro.graffiti.hbase;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.NavigableMap;
import java.util.Map.Entry;

import org.acaro.graffiti.processing.GraffitiEmitter;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.client.HTable;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.client.ResultScanner;
import org.apache.hadoop.hbase.client.Scan;
import org.apache.hadoop.hbase.util.Bytes;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.RecordWriter;
import org.apache.log4j.Logger;
import org.codehaus.jackson.JsonEncoding;
import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.JsonGenerator;
import org.json.JSONArray;

public class HBase2HDFS {
	
	private static final Logger LOG = Logger.getLogger(HBase2HDFS.class);
	private static final int SCANNERCACHING = 1000;
	private static final byte[] SPO = Bytes.toBytes("_SPO");
	private HTable htable;
	private JsonFactory f;
	private RecordWriter<byte[], Text> writer;
	
	public HBase2HDFS(String filename) throws IOException {
		Configuration conf = HBaseConfiguration.create();
		htable = new HTable(conf, "DBLP");
		htable.setScannerCaching(SCANNERCACHING);
		
        Configuration hdfsConf = new Configuration();
        FileSystem fs = FileSystem.get(hdfsConf);
        Path outFile = new Path(filename);
        if (fs.exists(outFile)) {
            LOG.error("file " + filename + " already exists.");
            System.exit(-1);
        }

        FSDataOutputStream out = fs.create(outFile);
        f = new JsonFactory();
	}

	private void convert() throws IOException {
		
		Scan scan = new Scan();
		scan.addFamily(Bytes.toBytes("_SPO"));
		
		ResultScanner rs = htable.getScanner(scan);
		
		Result res;
		while ((res = rs.next()) != null) {
			write(res.getRow(), res.getNoVersionMap().get(SPO));
		}
		
		rs.close();
	}
	
	private void write(byte[] row, NavigableMap<byte[], byte[]> columns) throws IOException {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		JsonGenerator json = f.createJsonGenerator(baos);
		
		json.writeStartArray();
		json.writeBinary(row);
		for (Entry<byte[], byte[]> column: columns.entrySet());
		
		json.writeEndArray();
		json.close();
		
		writer.write(null, new Text(baos.toByteArray()));
	}
	
	public static void main(String[] args) throws IOException {
		
		String filename = "sticazzi";
		
		HBase2HDFS converter = new HBase2HDFS(filename);
		converter.convert();
		
	}
}
