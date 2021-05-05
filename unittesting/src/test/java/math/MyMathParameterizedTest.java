package math;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

/**
 * This is a parameterized test class for the MyMath class.
 * It tests the calculation of the factorial of the values 0, 1, 2 and 12.
 * 
 * @author Konstantina Saketou
 *
 */
@RunWith (Parameterized.class)
public class MyMathParameterizedTest {

	private int n; //input value
	private int resultExpected; //expected output
	
	public MyMathParameterizedTest(int n, int result) 
    {
        this.n = n;
        this.resultExpected = result;
    }

	@Parameterized.Parameters
	public static Collection<Object[]>factorialNumbers() { // dataset of inputs and results
		return Arrays.asList(new Object[][] {
	         { 0, 1},
	         { 1, 1 },
	         { 2, 2 },
	         { 12, 479001600 }
	      });
	   }
	
	@Test
	public void testFactorial() {
		System.out.println("Calculating factorial of "+ n +".");
		MyMath math = new MyMath();
		assert resultExpected == math.factorial(n);
	}
	
}
