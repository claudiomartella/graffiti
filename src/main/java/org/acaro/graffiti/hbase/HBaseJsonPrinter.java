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

package org.acaro.graffiti.hbase;

import java.io.IOException;
import java.io.StringWriter;
import java.util.NavigableMap;
import java.util.Map.Entry;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.client.HTable;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.client.ResultScanner;
import org.apache.hadoop.hbase.client.Scan;
import org.apache.hadoop.hbase.util.Bytes;
import org.apache.log4j.Logger;
import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.JsonGenerator;

public class HBaseJsonPrinter {

    private static final Logger LOG = Logger.getLogger(HBaseJsonPrinter.class);
    private static final int SCANNERCACHING = 1000;
    private static final byte[] SPO = Bytes.toBytes("_SPO");
    private HTable htable;
    private JsonFactory f;

    public HBaseJsonPrinter() 
    throws IOException {

        Configuration conf = HBaseConfiguration.create();
        htable = new HTable(conf, "DBLP");
        htable.setScannerCaching(SCANNERCACHING);
        f   = new JsonFactory();
    }

    private void convert() 
    throws IOException {

        Scan scan = new Scan();
        scan.addFamily(Bytes.toBytes("_SPO"));

        ResultScanner rs = htable.getScanner(scan);

        Result res;
        while ((res = rs.next()) != null) {
            print(res.getRow(), res.getNoVersionMap().get(SPO));
        }

        rs.close();
    }

    private String cleanResource(String resource) {
        String cleaned = resource;

        // this is not an URI
        if (cleaned.startsWith("\"")) {
            int end = resource.indexOf('"', 1);
            cleaned = resource.substring(1, end);
        }

        return cleaned;
    }

    private void print(byte[] row, NavigableMap<byte[], byte[]> columns) 
    throws IOException {

        StringWriter w      = new StringWriter();
        JsonGenerator json  = f.createJsonGenerator(w);

        json.writeStartArray();
        json.writeString(Bytes.toString(row));
        json.writeStartArray();
        for (Entry<byte[], byte[]> column: columns.entrySet()) {
            json.writeStartArray();
            String splits[] = Bytes.toString(column.getKey()).split("\\|");
            json.writeString(splits[0]);
            json.writeString(cleanResource(splits[1]));
            json.writeEndArray();
        }
        json.writeEndArray();
        json.writeEndArray();
        json.close();

        System.out.println(w.toString());
    }

    public static void main(String[] args) 
    throws IOException {

        HBaseJsonPrinter converter = new HBaseJsonPrinter();
        converter.convert();
    }
}