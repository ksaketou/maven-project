package math;

import org.junit.Test;
/**
 * @author Konstantina Saketou
 *
 */
public class MyMathTest {

	/**
	 * Test method for {
	 * 		@link math.MyMath#factorial(int)
	 * }.
	 */
	
	@Test (expected = IllegalArgumentException.class)
	public void test_Factorial_thirteen() {
		System.out.println("Attempting to calculate factorial of thirteen.");
		MyMath m = new MyMath();
		m.factorial(13);
	}

	@Test (expected = IllegalArgumentException.class)
	public void test_Factorial_minus_one() {
		System.out.println("Attempting to calculate factorial of minus one.");
		MyMath m = new MyMath();
		m.factorial(-1);
	}
	
	@Test
	public void test_Factorial_accepted() {
		System.out.println("Attempting to calculate factorial of five.");
		MyMath m = new MyMath();
		assert 120 == m.factorial(5) : "Unable to calculate factorial of five.";
	}

}
