package codeanalyzer;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

/**
 *  This is a test class for the CsvExporter class.
 * 
 * @author Konstantina Saketou
 */
public class CsvExporterTest {
    
    @Test
	public void testWriteFile() {
		// create the metrics content
		Map<String, Integer> metrics = new HashMap<>();
		Loc loc = mock(Loc.class);
		Noc noc = mock(Noc.class);
		Nom nom = mock(Nom.class);
		try{
		    when(loc.calculate("src/test/resources/TestClass.java", "regex", "local")).thenReturn(30);
		    when(noc.calculate("src/test/resources/TestClass.java", "regex", "local")).thenReturn(5);
		    when(nom.calculate("src/test/resources/TestClass.java", "regex", "local")).thenReturn(2);
		} catch (IOException e){
			System.out.println("Unable to calculate metrics.");
		}

		
		// generate and write the output file
		String outputFilepath = "target/output_metrics";
		CsvExporter csv = new CsvExporter();
		csv.writeFile(metrics, outputFilepath);
		
		// evaluate that the file exists
		File outputFile = new File(outputFilepath + ".csv");
		Assert.assertTrue(outputFile.exists());
		
		// delete the generated file
		outputFile.delete();
	}


}
