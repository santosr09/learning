package com.juanjo.ocp.nio2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.util.List;

public class IOStreamsExample {
	
	public void bufferedReaderEx(Path path) throws IOException {
		//var path = Path.of("src/main/resources/nio2/subfolderA/fileA.txt");
		//System.out.println("path.toRealPath(LinkOption.NOFOLLOW_LINKS) " + path.toRealPath(LinkOption.NOFOLLOW_LINKS));
		try (var reader = Files.newBufferedReader(path)) {
			String currentLine = null;
			while((currentLine = reader.readLine()) != null)
				System.out.println(currentLine);
		}
		
	}
	
	public void bufferedWriterEx(List<String> characters, Path path) throws IOException {
		try (var writer = Files.newBufferedWriter(path)) {
			for(var line : characters) {
				writer.write(line);
				writer.newLine();
			}
		}
	}
	
}
