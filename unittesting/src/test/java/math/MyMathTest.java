package math;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
/**
 * @author Konstantina Saketou
 *
 */
public class MyMathTest {

	/**
	 * This is a test class for the class MyMath.
	 * 
	 * @author Konstantina Saketou
	 */
	
	@Test (expected = IllegalArgumentException.class)
	public void testFactorial_thirteen() {
		System.out.println("Attempting to calculate factorial of thirteen.");
		MyMath m = new MyMath();
		m.factorial(13);
	}

	@Test (expected = IllegalArgumentException.class)
	public void testFactorial_minus_one() {
		System.out.println("Attempting to calculate factorial of minus one.");
		MyMath m = new MyMath();
		m.factorial(-1);
	}
	
	@Test
	public void testFactorial_accepted() {
		System.out.println("Attempting to calculate factorial of five.");
		MyMath m = new MyMath();
		assert 120 == m.factorial(5) : "Unable to calculate factorial of five.";
	}
	
	@Test
	public void testIsPrime_true() {
		System.out.println("Checking if the input number is prime.");
		MyMath m = new MyMath();
		assert true == m.isPrime(5);
	}
	
	@Test
	public void testIsPrime_false() {
		System.out.println("Checking if the input number is prime.");
		MyMath m = new MyMath();
		assert false == m.isPrime(6);
	}
	
	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	@Test
	public void testIsPrime_incorrect() {
		MyMath m = new MyMath();
		thrown.expectMessage("Input number must be greater or equal to 2.");
		m.isPrime(-1);
	}
	
	@Test
	public void testIsPrime_incorrect2() {
		MyMath m = new MyMath();
		assert true == m.isPrime(2);
	}
	
	@Test
	public void testIsPrime_incorrect3() {
		MyMath m = new MyMath();
		assert false == m.isPrime(81);
	}

	@Test
	public void testIsPrime_incorrect4() {
		MyMath m = new MyMath();
		assert false == m.isPrime(25);
	}

}
