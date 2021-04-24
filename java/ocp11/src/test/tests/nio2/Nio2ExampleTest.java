package tests.nio2;

import com.juanjo.ocp.nio2.Nio2Example;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertThrows;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class Nio2ExampleTest {
	
	private Nio2Example obj;
	private URI uriExc;
	private URI uriOk;
	String pathStringA;
	String pathStringB;
	String pathStringC;
	
	@BeforeAll
	private void setUp() {
		obj = new Nio2Example();
		try {
			uriExc = new URI("file://icecream.txt");
			uriOk = new URI("file:///home/juanjo/dev/github/learning/java/ocp11/src/main/resources/nio2/subfolderA/fileA.txt");
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		pathStringA = "nio2/subfolderA/fileA.txt";
		pathStringB = "c:\\zooinfo\\November\\employees.txt";
		pathStringC = "src/main/resources/nio2/subfolderB/FileB.txt";
		
	}
	
	@Test
	public void joiningPathResolveTest() {
		obj.joiningPathResolve(Path.of(uriOk), Path.of(pathStringC));
	}
	
	@Test
	public void checkingPathTypeTest() {
		obj.checkingPathType(Path.of(uriOk));
	}
	
	@Test
	public void accessingPathElementsTest() {
		obj.accessingPathElements(Path.of(uriOk));
	}
	
	@Test
	public void viewingPathTest() {
		obj.viewingPath(Path.of(uriOk));
	}
	
	@Test
	public void  obtainingPathTest() {
		obj.obtainingPath();
	}
	
	@Test
	public void pathFromURITest() {
		assertThrows(IllegalArgumentException.class, () -> obj.pathFromURI(uriExc));
		obj.pathFromURI(uriOk);
	}
	
	@Test
	public void pathFromFileSystem() {
		obj.pathFromFileSystem(pathStringA);
		obj.pathFromFileSystem(pathStringB);
		obj.pathFromFileSystem(pathStringC);
	}
	
}
