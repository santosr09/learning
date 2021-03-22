package tests.io.serializing;

import com.juanjo.ocp.io.serializing.Chimpanzee;
import com.juanjo.ocp.io.serializing.SerializingUtility;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class SerializingUtilityTest {
	
	private SerializingUtility obj;
	
	@BeforeAll
	public void setUp() {
		obj = new SerializingUtility();
	}
	
	@Test
	public void seralizeChimpanceTest() throws IOException, ClassNotFoundException {
		var chimpancees = new ArrayList<Chimpanzee>();
		chimpancees.add( new Chimpanzee("Ham", 2, 'A'));
		chimpancees.add( new Chimpanzee( "Enos", 4 , 'B'));
		File dataFile = new File("src/test/resources/chimpanzee.data");
		obj.saveToFile(chimpancees, dataFile);
		var chimpanzeesFromDisk = obj.readFromFile(dataFile);
		System.out.println(chimpanzeesFromDisk);
	}
	
}
