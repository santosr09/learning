package com.juanjo.ocp.nio2;

import java.io.File;
import java.net.URI;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Nio2Example {
	
	public void obtainingPath() {
		Path path1 = Path.of("resources/nio2");
		Path path2 = Path.of("/home/juanjo/dev/github/learning/java/ocp11/src/main/resources/nio2/subfolderB/FileB.txt");
		Path path3 = Path.of("subfolderA", "fileA.txt");
		System.out.println("Using java.nio.file.Path");
		System.out.println(path1);
		System.out.println(path2);
		System.out.println(path3);
		
		Path path4 = Paths.get("resources/nio2");
		Path path5 = Paths.get("/home/juanjo/dev/github/learning/java/ocp11/src/main/resources/nio2/subfolderB/FileB.txt");
		Path path6 = Paths.get("subfolderA", "fileA.txt");
		System.out.println("Using java.nio.file.Paths (LEGACY)");
		System.out.println(path4);
		System.out.println(path5);
		System.out.println(path6);
	}
	
	public void pathFromURI(URI uri) {
			Path pathB = Path.of(uri);
			Path pathC = Paths.get(uri);
			URI uriB = pathC.toUri();
			
			System.out.println("pathB: " + pathB);
			System.out.println("pathC: " + pathC);
			System.out.println("uri: " + uri);
	}
	
	public void pathFromFileSystem(String pathString) {
		Path path1 = FileSystems.getDefault().getPath(pathString);
		//Remote FileSystem:
		//FileSystem fileSystem = FileSystems.getFileSystem(new URI("http://www.selikoff.net"));
		//Path path = fileSystem.getPath("duck.txt");
	}
	
	public void pathFromFile(File file) {
		Path pathA = file.toPath();
		File backToFile = pathA.toFile();
	}
	
	public void viewingPath(Path path) {
		System.out.println("The Path Name is: " + path);
		for(int i=0; i<path.getNameCount(); i++) {
			System.out.println("   Element " + i + " is: " + path.getName(i));
		}
	}
	
	public void accessingPathElements(Path path) {
		System.out.println("Filename is: " + path.getFileName());
		System.out.println("   Root is: " + path.getRoot());
		Path currentParent = path;
		while((currentParent = currentParent.getParent()) != null) {
			System.out.println("   Current parent is: " + currentParent);
		}
	}
	
	public void checkingPathType(Path path) {
		System.out.println("Path1 is Absolute? " + path.isAbsolute());
		System.out.println("Absolute Path1: " + path.toAbsolutePath());
	}
	
	public void joiningPathResolve(Path pathA, Path pathB) {
		System.out.println(pathA.resolve(pathB));
	}
	
}
