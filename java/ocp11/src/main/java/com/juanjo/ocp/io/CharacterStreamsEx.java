package com.juanjo.ocp.io;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

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

}
