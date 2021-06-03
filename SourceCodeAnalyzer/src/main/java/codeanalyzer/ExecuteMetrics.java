package codeanalyzer;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * This class uses the context class and strategies created based on
 * the MetricsExporter interface. It generates and returns the output file
 * containing the calculated metrics.
 * 
 * @author Konstantina Saketou
 */
public class ExecuteMetrics {    

	/**
	 * This method returns the calculated metrics into the requested format.
	 * It uses the MetricsExporter strategy and context objects to
 	 * implement every supported functionality of the different exporters.

	 * @param exp_type output file type [csv|json]
	 * @param inputFilepath location of input file
	 * @param analyzerType the analyzer type [regex|strcomp]
	 * @param outputPath destination of the output file
	 * @param sourceLocation location of input file [web|local]
	 */
    public void getMetrics(String exp_type, String inputFilepath, String analyzerType, 
	String outputPath, String sourceLocation){


		Loc loc = new Loc();
		Nom nom = new Nom();
		Noc noc = new Noc();

		try{
			Map<String, Integer> metrics = new HashMap<>();
			metrics.put("loc", loc.calculate(inputFilepath, analyzerType, sourceLocation));
			metrics.put("nom",nom.calculate(inputFilepath, analyzerType, sourceLocation));
			metrics.put("noc",noc.calculate(inputFilepath, analyzerType, sourceLocation));

			if (exp_type.equals("csv")){
                GenerateMetrics gm = new GenerateMetrics(new CsvExporter());
                gm.generateFile(metrics, outputPath);
			} else if (exp_type.equals("json")){
                GenerateMetrics gm = new GenerateMetrics(new JsonExporter());
                gm.generateFile(metrics, outputPath);
			} else {
                GenerateMetrics gm = new GenerateMetrics(new NullExporter());
                gm.generateFile(metrics, outputPath);
			}
		} catch (IOException e){
			e.printStackTrace();
		}
    }
}
