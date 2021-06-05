package codeanalyzer;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.Test;

/**
 *  This is a test class for the Noc class.
 * 
 * @author Konstantina Saketou
 */
public class NocTest {
    private final static String TYPE_REGEX = "regex";
	private final static String TYPE_STRCOMP = "strcomp";
	private final static String TEST_CLASS = "src/test/resources/TestClass.java";
	private String SOURCE_LOC = "local";

    @Test
	public void testCalculateRegex() throws IOException {
		Noc noc = new Noc();
		assertEquals(3, noc.calculate(TEST_CLASS, TYPE_REGEX, SOURCE_LOC));
	}
	
	@Test
	public void testCalculateStrComp() throws IOException {
		Noc noc = new Noc();
		assertEquals(3, noc.calculate(TEST_CLASS, TYPE_STRCOMP, SOURCE_LOC));
	}

	@Test
	public void testCalculateInvalid() throws IOException {
		Noc noc = new Noc();
		assertEquals(-1, noc.calculate(TEST_CLASS, "wrong", SOURCE_LOC));
	}
}
