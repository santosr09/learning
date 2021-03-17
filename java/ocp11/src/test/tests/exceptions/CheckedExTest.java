package tests.exceptions;

import com.juanjo.ocp.exceptions.CheckedEx;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.io.IOException;
import java.nio.file.NoSuchFileException;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class CheckedExTest {
	
	private CheckedEx obj;
	
	@BeforeAll
	public void setUp() {
		obj = new CheckedEx();
	}
	
	@Test
	public void ceckedExTest() {
		Assertions.assertThrows(NoSuchFileException.class, () -> CheckedEx.openFile(null));
	}
	
	public void checkedExTestB() {
		try {
			obj.openFile(null);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			System.out.println("Finally...");
		}
	}
	
	@Test
	public void runtimeExTest() {
		Assertions.assertThrows(RuntimeException.class, () -> obj.openFileRuntimeEx());
	}
}
