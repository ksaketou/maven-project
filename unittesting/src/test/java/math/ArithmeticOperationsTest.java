package math;


import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * This is a test class for the ArithmeticOperations class.
 * It contains two test cases for the divide method and three test
 * cases for the multiplication method.
 * 
 * @author Konstantina Saketou
 *
 */
public class ArithmeticOperationsTest {

	@Test (expected = ArithmeticException.class)
	public void testDivide_with_zero() { //test division with zero
		System.out.println("Attempting to divide when denominator is zero.");
		ArithmeticOperations obj = new ArithmeticOperations();
		obj.divide(10, 0);
		
	}
	
	@Test
	public void testDivide_normal() {
		System.out.println("Performing accepted division.");
		ArithmeticOperations obj = new ArithmeticOperations();
		assert 10/2 == obj.divide(10, 2) : "Division failed.";
	}

	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	@Test
	public void testMultiply_negative() { //multiplication of negative integers
		ArithmeticOperations obj = new ArithmeticOperations();
		System.out.println("Attempting to perform multiplication with negative integers.");
		thrown.expectMessage("x & y should be >= 0");
		obj.multiply(-5, 2);
	}
	
	@Test
	public void testMultiply_big_numbers() { //multiplication of big integers
		ArithmeticOperations obj = new ArithmeticOperations();
		System.out.println("Attempting to perform multiplication with big numbers.");
		thrown.expectMessage("The product does not fit in an Integer variable");
		obj.multiply(999999999, 87);
	}
	
	@Test
	public void testMultiply_normal() {
		ArithmeticOperations obj = new ArithmeticOperations();
		System.out.println("Attempting to perform multiplication with accepted numbers.");
		assert 2*5 == obj.multiply(5, 2) : "Multiplication failed.";
	}

}
