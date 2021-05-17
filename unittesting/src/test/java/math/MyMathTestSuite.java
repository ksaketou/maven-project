package math;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * This is a Test Suite created to group the MyMathTest and 
 * MyMathParameterizedTest classes. With the execution of this class 
 * the test cases of the included test classes are being executed as well.
 * 
 * @author Konstantina Saketou
 *
 */
@RunWith(Suite.class)
@SuiteClasses({ MyMathParameterizedTest.class, MyMathTest.class })
public class MyMathTestSuite {
	
	/*
	 * This class remains empty. It is just used
	 * to hold the above annotations.
	 */
}
