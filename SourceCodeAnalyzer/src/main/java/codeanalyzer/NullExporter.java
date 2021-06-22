package codeanalyzer;

import java.util.Map;

/**
 * This class implements the MetricsExporter interface to 
 * print a warning message in case the user inserts an unknown
 * or incorrect file type.
 * 
 * @author Konstantina Saketou
 */
public class NullExporter implements MetricsExporter{

    /**
     * Prints warning message for invalid input.
     */
    @Override
    public void writeFile(Map<String, Integer> metrics, String filepath) {
        System.out.println("Operation failed. Unknown file type.");
    }

}