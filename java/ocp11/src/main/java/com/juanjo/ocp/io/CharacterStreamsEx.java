package com.juanjo.ocp.io;

import java.io.*;

public class CharacterStreamsEx {
	
	public void copyTextFile(File src, File dest) throws IOException {
		try (var reader = new FileReader(src);
				 var writer = new FileWriter(dest)) {
			int b;
			while ((b = reader.read()) != -1) {
				writer.write(b);
			}
		}
	}
	
	public void copyTextFileWithBuffer(File src, File dest) throws IOException {
		try (var reader = new BufferedReader(new FileReader (src));
				 var writer = new BufferedWriter( new FileWriter(dest))) {
			String s;
			while ((s = reader.readLine()) != null) {
				writer.write(s);
				writer.newLine();
			}
		}
	}

}
