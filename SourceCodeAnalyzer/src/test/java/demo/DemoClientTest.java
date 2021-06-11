package demo;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * This is a test class for the DemoClient class.
 * 
 * @author Konstantina Saketou
 */
public class DemoClientTest {
    private final PrintStream standardOut = System.out;
	private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @Test
    public void testMainArgsCorrect() throws IOException {
        String filepath = "src/test/resources/TestClass.java";
		String sourceCodeAnalyzerType = "regex";
		String sourceFileLocation = "local";
		String outputFilePath = "target/output_metrics";
		String outputFileType = "csv";

        String args[] = {filepath, sourceCodeAnalyzerType, sourceFileLocation,
            outputFilePath, outputFileType};

        DemoClient.main(args);
        boolean exists = false;
        File f = new File(outputFilePath);
        if(new File("target/output_metrics.csv").exists()) { 
            exists = true;
        }
        assertEquals(true, exists);
    }

    @Before
	public void setUp() {
		System.setOut(new PrintStream(outputStreamCaptor));
	}

    @Test
    public void testMainLessArgs() throws IOException {
        String args[] = {"csv"};
        DemoClient.main(args);
        assertEquals("Incorrect number of arguments.", outputStreamCaptor.toString()
		  .trim());
    }   

	@After
	public void tearDown() {
		System.setOut(standardOut);
	}
}
