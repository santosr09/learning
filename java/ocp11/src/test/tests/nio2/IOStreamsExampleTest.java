package tests.nio2;

import com.juanjo.ocp.nio2.IOStreamsExample;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class IOStreamsExampleTest {
	
	private IOStreamsExample obj;
	Path pathA;
	Path pathB;
	ArrayList<String> list;
	
	@BeforeAll
	private void setUp() {
		obj = new IOStreamsExample();
		pathA = Path.of("src/main/resources/nio2/subfolderA/fileA.txt");
		pathB = Path.of("src/main/resources/nio2/subfolderB/fileB.txt");
		list = new ArrayList<String>();list.add("Smokey");list.add("Yogi");
	}
	
	@Test
	public void bufferedReaderExTest() throws IOException {
		obj.bufferedReaderEx(pathA);
	}
	
	@Test
	public void bufferedWriterTest() throws IOException {
		obj.bufferedWriterEx(list, pathB);
	}
	
}
