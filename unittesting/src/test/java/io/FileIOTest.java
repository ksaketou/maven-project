package io;

import java.io.File;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class FileIOTest {
	/**
	 * This is a test class for the class FileIO.
	 * 
	 * @author Konstantina Saketou
	 */

	@Test
	public void testReadFile_normal() {
		
		String path = "src/test/resources/testFile1.txt";
		File file = new File(path);
		FileIO f = new FileIO();
		System.out.println("Reading File...");
		assert (f.readFile(file.getAbsolutePath())).getClass().isArray() == true;
		
	}
	
	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	@Test
	public void testReadFile_incorrect1() {
		String path = "src/test/resources/testFileEmpty.txt";
		File file = new File(path);
		FileIO f = new FileIO();
		thrown.expectMessage("Given file is empty");
		f.readFile(file.getAbsolutePath());
		
	}
	
	@Test
	public void testReadFile_incorrect2() {
		
		String file = "src/test/java/resources/testFileGhost.txt";
		FileIO f = new FileIO();
		thrown.expectMessage("Input file does not exist");
		f.readFile(file);
		
	}

	public void testReadFileContainsInvalidEntries() {
		String path = "src/test/resources/testFileDouble.txt";
		File file = new File(path);
		FileIO f = new FileIO();
		assert (f.readFile(file.getAbsolutePath())).getClass().isArray() == true;
	}
	

	

}

