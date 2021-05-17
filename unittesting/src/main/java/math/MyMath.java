package math;

/**
 * This class contains a function for the calculation of the factorial of
 * an integer input number.
 * 
 * @author Konstantina Saketou
 */
public class MyMath {
	
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
	
	/**
	 * This function gets an integer input value and checks
	 * if it is prime or not.
	 * 
	 * @param n an integer input
	 * @return true if input is prime or false if not
	 */
	public boolean isPrime(int n) {
		 
		if (n < 2)
	        throw new IllegalArgumentException("Input number must be greater or equal to 2.");
	 
	    else if (n == 2)
	         return true;
	 
	    else if (n % 2 == 0)
	         return false;
	 
	    for (int i = 3; i <= Math.sqrt(n); i += 2){
	         if (n % i == 0)
	             return false;
	     }
	   return true;
	}
}