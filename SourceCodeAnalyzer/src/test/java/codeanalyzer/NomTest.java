package codeanalyzer;

import java.io.IOException;
import org.junit.Test;


import static org.junit.Assert.*;
/**
 *  This is a test class for the Nom clas.
 * 
 * @author Konstantina Saketou
 */
public class NomTest {
	private final static String TYPE_REGEX = "regex";
	private final static String TYPE_STRCOMP = "strcomp";
	private final static String TEST_CLASS = "src/test/resources/TestClass.java";
	private String SOURCE_LOC = "local";
	
	@Test
	public void testCalculateRegex() throws IOException {
		Nom nom = new Nom();
		assertEquals(3, nom.calculate(TEST_CLASS, TYPE_REGEX, SOURCE_LOC));
	}
	
	@Test
	public void testCalculateStrComp() throws IOException {
		Nom nom = new Nom();
		assertEquals(3, nom.calculate(TEST_CLASS, TYPE_STRCOMP, SOURCE_LOC));
	}
	

	
}
