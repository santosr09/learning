package com.juanjo.ocp.nio;

import java.nio.file.FileSystem;
import java.nio.file.FileSystems;

public class FilesystemsExample {
	
	public static void main(String[] args) {
		FileSystem fs = FileSystems.getDefault();
		fs.getFileStores().forEach(s -> System.out.println(s.type() + " " + s.name()));
		fs.getRootDirectories().forEach(p-> System.out.println(p));
		System.out.println("separator: " + fs.getSeparator());
	}
}
