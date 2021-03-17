package com.juanjo.ocp.io;

import java.io.*;

public class ByteStreamsEx {
	
	public void copyFile(File src, File dest) throws IOException {
		try(var in = new FileInputStream(src);
				var out = new FileOutputStream(dest)) {
			int b;
			int counter = 0;
			while((b = in.read()) != -1) {
				out.write(b);
				counter++;
			}
			System.out.println("copyFile() counter: " + counter);
		}
	}
	
	public void copyFileWithBuffer(File src, File dest) throws IOException{
		try(var in = new BufferedInputStream(
						new FileInputStream(src));
				var out = new BufferedOutputStream(
						new FileOutputStream(dest))) {
			var buffer = new byte[1024];
			int lengthRead;
			int counter = 0;
			while((lengthRead = in.read(buffer)) > 0) {
				out.write(buffer, 0, lengthRead);
				out.flush();
			}
			System.out.println("copyFileWithBuffer() counter: " + counter);
		}
	}
	
}
