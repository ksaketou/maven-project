package codeanalyzer;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.Test;

/**
 *  This is a test class for the Loc class.
 * 
 * @author Konstantina Saketou
 */
public class LocTest {
    private final static String TYPE_REGEX = "regex";
	private final static String TYPE_STRCOMP = "strcomp";
	private final static String TEST_CLASS = "src/test/resources/TestClass.java";
	private String SOURCE_LOC = "local";
    
    @Test
	public void testCalculateRegex() throws IOException {
		Loc loc = new Loc();
		assertEquals(21, loc.calculate(TEST_CLASS, TYPE_REGEX, SOURCE_LOC ));
	}
	
	@Test
	public void testCalculateStrComp() throws IOException {
		Loc loc = new Loc();
		assertEquals(7, loc.calculate(TEST_CLASS, TYPE_STRCOMP, SOURCE_LOC));
	}

	@Test
	public void testCalculateInvalid() throws IOException {
		Loc loc = new Loc();
		assertEquals(-1, loc.calculate(TEST_CLASS, "wrong", SOURCE_LOC));
	}

}
