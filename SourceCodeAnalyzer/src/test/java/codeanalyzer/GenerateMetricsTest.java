package codeanalyzer;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 *  This is a test class for the GenerateMetrics class.
 * 
 * @author Konstantina Saketou
 */
public class GenerateMetricsTest {
    
    private final PrintStream standardOut = System.out;
	private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @Test
    public void testGenerateFileCsv(){
        GenerateMetrics csv = new GenerateMetrics(new CsvExporter());
        Map<String, Integer> metrics = new HashMap<>();
		metrics.put("loc",30);
		metrics.put("nom",5);
		metrics.put("noc",2);
        csv.generateFile(metrics, "target/output2");

    }

	@Before
	public void setUp() {
		System.setOut(new PrintStream(outputStreamCaptor));
	}

	@Test
	public void testGenerateFileNull() {
        GenerateMetrics empty = new GenerateMetrics(new NullExporter());
        empty.generateFile(null, null);
	
		assertEquals("Operation failed. Unknown file type.", outputStreamCaptor.toString()
		  .trim());
	}

	@After
	public void tearDown() {
		System.setOut(standardOut);
	}
}
