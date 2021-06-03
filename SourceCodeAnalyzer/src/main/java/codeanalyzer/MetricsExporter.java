package codeanalyzer;

import java.util.Map;

/**
 * This interface contains a method for exporting (writing) the 
 * supported metrics to a given output. The output can be CSV or JSON files.
 * 
 * @author Konstantina Saketou
 */

public interface MetricsExporter{

	void writeFile(Map<String, Integer> metrics, String filepath);
}
