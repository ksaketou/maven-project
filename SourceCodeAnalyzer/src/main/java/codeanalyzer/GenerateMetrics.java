package codeanalyzer;

import java.util.Map;

/**
 * This is the context class which implements the 
 * MetricsExporter interface functionality.
 * 
 * @author Konstantina Saketou
 */
public class GenerateMetrics {
    private MetricsExporter MetricsExporter;
 
    public GenerateMetrics(MetricsExporter MetricsExporter){
       this.MetricsExporter = MetricsExporter;
    }
 
    public void generateFile(Map<String, Integer> metrics, String filepath){
    
		MetricsExporter.writeFile(metrics, filepath);

    }

}
