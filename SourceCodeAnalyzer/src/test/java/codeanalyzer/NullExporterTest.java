package codeanalyzer;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 *  This is a test class for the NullExporter class.
 * 
 * @author Konstantina Saketou
 */
public class NullExporterTest {

	private final PrintStream standardOut = System.out;
	private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

	@Before
	public void setUp() {
		System.setOut(new PrintStream(outputStreamCaptor));
	}

	@Test
	public void testWriteFile() {
		NullExporter none = new NullExporter();
		none.writeFile(null, null);
	
		assertEquals("Operation failed. Unknown file type.", outputStreamCaptor.toString()
		  .trim());
	}

	@After
	public void tearDown() {
		System.setOut(standardOut);
	}

}
