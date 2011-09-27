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

import java.io.Closeable;
import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.client.HTable;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.util.Bytes;
import org.openrdf.model.Resource;
import org.openrdf.model.URI;
import org.openrdf.model.Value;

public class HBaseManager implements Closeable {
	private static final long BUFFERSIZE = 65536;
	private static final byte[] SPO_CF = Bytes.toBytes("_SPO");
	private static final byte[] PSO_CF = Bytes.toBytes("_PSO");
	private static final String SEP = "|";
	private HTable htable;

	public HBaseManager() throws IOException {
		Configuration conf = HBaseConfiguration.create();
		htable = new HTable(conf, "DBLP");
		htable.setWriteBufferSize(BUFFERSIZE);
		htable.setAutoFlush(false);
	}
	
	public void close() throws IOException {
		htable.flushCommits();
		htable.close();
	}

	public void addTriple(String subject, String predicate, String object) throws IOException {
		byte[] rowKey, columnName, value = { 0x0 };
		Put p;
		
		rowKey = Bytes.toBytes(subject);
		p = new Put(rowKey);
		columnName = Bytes.toBytes(predicate+SEP+object);
		p.add(SPO_CF, columnName, value);
		
		htable.put(p);
		
		rowKey = Bytes.toBytes(predicate);
		p = new Put(rowKey);
		columnName = Bytes.toBytes(subject+SEP+object);
		p.add(PSO_CF, columnName, value);
		
		htable.put(p);

	}
	
	public void addTriple(Resource subject, URI predicate, Value object) throws IOException {
		addTriple(subject.stringValue(), predicate.stringValue(), object.stringValue());
	}
}
