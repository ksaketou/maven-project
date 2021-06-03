package codeanalyzer;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

/**
* This class implements the MetricsExporter interface to 
* export the supported metrics into a csv file.
* 
* @author Konstantina Saketou
*/
public class CsvExporter implements MetricsExporter{

	/**
	 * This method exports the result of the calculated metrics
	 * into a csv file.
	 */
    @Override
    public void writeFile(Map<String, Integer> metrics, String filepath) {
        File outputFile = new File(filepath + ".csv");
		StringBuilder metricsNames = new StringBuilder();
		StringBuilder metricsValues = new StringBuilder();
		
		for (Map.Entry<String, Integer> entry : metrics.entrySet()) {
			metricsNames.append(entry.getKey() + ",");
			metricsValues.append(entry.getValue()+",");
		}
		
		try {
			FileWriter writer = new FileWriter(outputFile);
			writer.append(metricsNames + "\n");
			writer.append(metricsValues + "\n");
			writer.close();
			System.out.println("Metrics saved in " + outputFile.getAbsolutePath());
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

}