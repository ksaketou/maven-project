package math;

public class MyMath {
/**
 * This class contains a function for the calculation of the factorial of
 * an integer input number.
 * 
 * @author Konstantina Saketou
 */
	
	/**
	 * This function gets an integer input value and calculates its factorial.
	 * 
	 * @param n the integer number of which we calculate its factorial 
	 * @return the factorial of input integer
	 */
	public int factorial(int n) {
		if (n<0 || n>12) {
			throw new IllegalArgumentException("This value is not accepted.");
		} else {
			int f =1;
			for (int i=1;i <= n; i++) {
				f *= i;
			}
			return f;
		}
	}
}