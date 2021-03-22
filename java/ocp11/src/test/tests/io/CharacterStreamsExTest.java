package tests.io;

import com.juanjo.ocp.io.CharacterStreamsEx;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.Instant;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class CharacterStreamsExTest {
	
	private CharacterStreamsEx obj;
	
	@BeforeAll
	private void setUp() {
		obj = new CharacterStreamsEx();
	}
	
	@Test
	public void copyTextFileTest() throws IOException {
		File srcFile = new File("src/main/resources/beautiful_day.txt");
		File destFile = new File("src/test/resources/beatutiful_day_copy.txt");
		Instant start = Instant.now();
		obj.copyTextFile(srcFile, destFile);
		Instant finish = Instant.now();
		long timeElapsed = Duration.between(start, finish).toMillis();
		System.out.println("copyTextFile() Time elapsed: " + timeElapsed + " Milliseconds");
	}
	
	@Test
	public void copyTextFileWithBuffer() throws IOException{
		File srcFile = new File("src/main/resources/beautiful_day.txt");
		File destFile = new File("src/test/resources/beatutiful_day_copy_buffer.txt");
		Instant start = Instant.now();
		obj.copyTextFileWithBuffer(srcFile, destFile);
		Instant finish = Instant.now();
		long timeElapsed = Duration.between(start, finish).toMillis();
		System.out.println("copyTextFileWithBuffer() Time elapsed: " + timeElapsed + " Milliseconds");
	}
	
}
