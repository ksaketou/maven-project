package codeanalyzer;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 *  This is a test class for the ExecuteMetrics class.
 * 
 * @author Konstantina Saketou
 */
public class ExecuteMetricsTest {

	private final static String INPUT_PATH = "src/test/resources/TestClass.java";
	private final static String ANALYZER_TYPE = "regex";
	private final static String OUTPUT_PATH = "target/output";
	private final static String SOURCE_LOC = "local";
	private final PrintStream standardOut = System.out;
	private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

	@Test
	public void testGetMetricsCsv(){
		Noc noc = mock(Noc.class);
		Nom nom = mock(Nom.class);
		Loc loc = mock(Loc.class);
		ExecuteMetrics em = new ExecuteMetrics();

		try{
			when(noc.calculate(INPUT_PATH, ANALYZER_TYPE, SOURCE_LOC)).thenReturn(3);
			when(nom.calculate(INPUT_PATH, ANALYZER_TYPE, SOURCE_LOC)).thenReturn(3);
			when(loc.calculate(INPUT_PATH, ANALYZER_TYPE, SOURCE_LOC)).thenReturn(21);
		} catch (IOException e){
			e.printStackTrace();
		}

		em.getMetrics("csv", INPUT_PATH, ANALYZER_TYPE, OUTPUT_PATH, SOURCE_LOC);
	}

	@Before
	public void setUp() {
		System.setOut(new PrintStream(outputStreamCaptor));
	}

	@Test
	public void testGetMetricsNull(){
		Noc noc = mock(Noc.class);
		Nom nom = mock(Nom.class);
		Loc loc = mock(Loc.class);
		ExecuteMetrics em = new ExecuteMetrics();

		try{
			when(noc.calculate(INPUT_PATH, ANALYZER_TYPE, SOURCE_LOC)).thenReturn(3);
			when(nom.calculate(INPUT_PATH, ANALYZER_TYPE, SOURCE_LOC)).thenReturn(3);
			when(loc.calculate(INPUT_PATH, ANALYZER_TYPE, SOURCE_LOC)).thenReturn(21);
		} catch (IOException e){
			e.printStackTrace();
		}

		em.getMetrics("null", INPUT_PATH, ANALYZER_TYPE, OUTPUT_PATH, SOURCE_LOC);

		assertEquals("Operation failed. Unknown file type.", outputStreamCaptor.toString()
		.trim());
	}

	@After
	public void tearDown() {
		System.setOut(standardOut);
	}

}
