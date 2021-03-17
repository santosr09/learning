package tests.exceptions;

import com.juanjo.ocp.exceptions.ExcepTestA;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ExceptionTestA {
	
	private ExcepTestA obj;
	
	@BeforeAll
	public void setUp() {
		obj = new ExcepTestA();
	}
	
	@Test
	public void ExcepTestA_ArithmethicExc() {
		Assertions.assertThrows(ArithmeticException.class, () -> obj.divide(0,0));
	}
	
	@Test
	public void ExcepTestA() {
		try{
			obj.divide(0, 0);
			System.out.println("This line should not be printed");
		}catch (ArithmeticException ex) {
			System.out.println("Exception was caugth: " + ex);
		}finally {
			System.out.println("FINALLY: This line should be printed");
		}
	}
	
}
