package math;

import java.util.ArrayList;
import java.util.List;

import io.FileIO;

/**
 * This class contains a method for collecting integer prime numbers
 * into an array. It uses methods from the classes FileIO and MyMath.
 * 
 * @author Konstantina Saketou
 *
 */
public class ArrayOperations {
	/**
	 * This method iterates an array of numbers, and returns 
	 * a new array that contains only its prime numbers. It uses the classes FileIO and MyMath
	 * to identify integer numbers from a file and collect the prime ones.
	 * 
	 * @param fileIo object of FileIO class
	 * @param filepath the absolute path of the resource file
	 * @param myMath object of MyMath class
	 * @return an array containing only integer prime numbers
	 */
	public int[] findPrimesInFile(FileIO fileIo, String filepath, MyMath myMath) {
		
		List<Integer> numList = new ArrayList<>();
		
		int [] numbers = fileIo.readFile(filepath);
		for (int i=0;i< numbers.length; i++) {
			if (myMath.isPrime(numbers[i])) {
				numList.add(numbers[i]);
			}
		}
		
		return numList.stream().mapToInt(i -> i).toArray();

	}
}
