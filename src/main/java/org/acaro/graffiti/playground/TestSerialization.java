package org.acaro.graffiti.playground;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.acaro.graffiti.query.Query;
import org.acaro.graffiti.query.QueryParser;

public class TestSerialization {
	
	public static void main(String[] args) throws Exception {
		Query q = new QueryParser("bla :: age [MAX(10)][MIN(3)] > loves (*3) > knows [ country = PREFIX('DE')]. DISTANCE('blabla')").parse();
		
		System.out.println(q);
		
		DataOutputStream dos = new DataOutputStream(new FileOutputStream("test-serialization.dat"));
		q.write(dos);
		dos.flush();
		dos.close();
		
		DataInputStream dis = new DataInputStream(new FileInputStream("test-serialization.dat"));
		q = new Query();
		q.readFields(dis);
		
		System.out.println(q);
	}
}
