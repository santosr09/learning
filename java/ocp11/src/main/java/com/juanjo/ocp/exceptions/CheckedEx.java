package com.juanjo.ocp.exceptions;

import java.io.IOException;
import java.nio.file.NoSuchFileException;

public class CheckedEx {
	
	public static void openFile(String fileName) throws IOException {
		if(fileName == null) {
			throw new NoSuchFileException("FileName must be set");
		}
	}
	public static void openFileRuntimeEx() {
		throw new RuntimeException();
	}
	
}
