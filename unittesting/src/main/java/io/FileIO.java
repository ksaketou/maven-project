package io;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
* The FileIO provides simple file input/output operations
* that serve as hands-on practice on Unit Testing.
*
* @authors  agkortzis, Konstantina Saketou
* @version 1.0
* @since   2020-04-06 
*/
public class FileIO {
	
	/**
	 * Reads a file that contains numbers line by line 
	 * and returns an array of the integers found in the file.
	 * @param filepath the file that contains the numbers
	 * @return an array of numbers
	 * @exception IllegalArgumentException when the given file does not exist
	 * @exception IllegalArgumentException when the given file is empty
	 * @exception IOException when an IO interruption occurs (not required to be tested)
	 */
	public int[] readFile(String filepath) {
		File file = new File(filepath);
		if (!file.exists()) 
			throw new IllegalArgumentException("Input file does not exist");
		List<Integer> numbersList = new ArrayList<>();
		try {
		    Scanner line = new Scanner(new File(filepath));
	
		    while (line.hasNext()) {  
	
		      if (line.hasNextInt()) {
					numbersList.add(line.nextInt());
		      }
		      
		    }
	
		    // close the scanner
		    line.close();
	
		} catch(Exception e) {
			  throw new RuntimeException("Sorry, something went wrong.");
		}
		  
		if (numbersList.size() == 0) { 
			throw new IllegalArgumentException("Given file is empty");
		}
		
		// Convert a List to an array using 
		return numbersList.stream().mapToInt(i -> i).toArray();
	}
}

