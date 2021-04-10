package com.juanjo.ocp.nio;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

public class FilesystemsExample {
	
	public static void main(String[] args) throws IOException {
		FileSystem fs = FileSystems.getDefault();
		//fs.getFileStores().forEach(s -> System.out.println(s.type() + " " + s.name()));
		//fs.getRootDirectories().forEach(p-> System.out.println(p));
		System.out.println("separator: " + fs.getSeparator());
		//navigatingFilesystem();
		zipArchiveExample();
	}
	
	private static void zipArchiveExample() throws IOException {
		Path joe = Path.of("src/main/resources/");
		Path zip = Path.of("/joe.zip");
		Files.createFile(zip);
	}
	
	private static void copyMoving() {
		Path source = Path.of("docs");
	}
	
	private static void navigatingFilesystem() throws IOException {
		Path joe = Path.of("/", "users", "joe");
		Path p1 = Path.of("/", "users", "joe", "docs", "some.txt");
		for (int i=0; i<p1.getNameCount(); i++) {
			Path p = p1.getName(i);
		}
		Path p2 = Path.of("./pics/s.txt");
		Files.createSymbolicLink(p2, p1);
		Files.list(joe).forEach(p -> System.out.println(p));
		Files.walk(joe).map(p -> p.toString())
										.filter(s -> s.endsWith("txt"))
										.forEach(p -> System.out.println(p));
		Path p3 = Files.readSymbolicLink(p2);
	}
	
}
