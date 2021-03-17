package tests.io;

import com.juanjo.ocp.io.ByteStreamsEx;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.time.Instant;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ByteStreamsExTest {
	
	private ByteStreamsEx obj;
	
	@BeforeAll
	private void setUp() {
		obj = new ByteStreamsEx();
	}
	
	@Test
	public void copyFileTest() throws IOException {
		File srcFile = new File("src/main/resources/java.png");
		File destFile = new File("src/test/resources/java_copy.png");
		destFile.delete();
		Instant start = Instant.now();
		obj.copyFile(srcFile, destFile);
		Instant finish = Instant.now();
		long timeElapsed = Duration.between(start, finish).toMillis();
		System.out.println("copyFile() Time elapsed: " + timeElapsed + " Milliseconds");
		Assertions.assertEquals(destFile.length(), srcFile.length());
	}
	
	@Test
	public void copyFileTestNotFound() throws IOException {
		File srcFile = new File("src/main/resources/java_unknown.png");
		File destFile = new File("src/test/resources/java_copy.png");
		Assertions.assertThrows(FileNotFoundException.class, () -> obj.copyFile(srcFile, destFile));
	}
	
	@Test
	public void copyFileWithBufferTest() throws IOException {
		File srcFile = new File("src/main/resources/java.png");
		File destFile = new File("src/test/resources/java_buffer_copy.png");
		destFile.delete();
		Instant start = Instant.now();
		obj.copyFileWithBuffer(srcFile, destFile);
		Instant finish = Instant.now();
		long timeElapsed = Duration.between(start, finish).toMillis();
		System.out.println("copyFileWithBuffer() Time elapsed: " + timeElapsed + " Milliseconds");
		Assertions.assertEquals(destFile.length(), srcFile.length());
	}
	
}
