package codeanalyzer;

import static org.mockito.Mockito.doCallRealMethod;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

/**
 *  This is a test class for the JsonExporter class.
 * 
 * @author Konstantina Saketou
 */
public class JsonExporterTest {
    
    @Test
	public void testWriteJson() {
		JsonExporter json = mock(JsonExporter.class);
		// create an empty metrics content
		Map<String, Integer> metrics = new HashMap<>();
		String outputFilepath = "whatever-path";
		
		//this is a demo of how a mocked object can call a real method (partial mocking)
		doCallRealMethod().when(json).writeFile(metrics, outputFilepath);
		json.writeFile(metrics, outputFilepath);
		//just verify that the method was executed/called
		verify(json).writeFile(metrics, outputFilepath);
    }
}
