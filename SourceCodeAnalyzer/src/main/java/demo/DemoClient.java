package demo;

import java.io.IOException;

import codeanalyzer.ExecuteMetrics;

/**
 * This class uses the codeanalyzer package in order to read a file,
 * calculate some metrics and export them into a csv file.
 * 
 * @author Konstantina Saketou
 */
public class DemoClient {
	public static void main(String[] args) throws IOException {
		String filepath = "src/main/resources/TestClass.java";
		String sourceCodeAnalyzerType = "regex";
		String sourceFileLocation = "local";
		String outputFilePath = "output_metrics";
		String outputFileType = "csv";

		if(args.length == 5) {
			filepath = args[0];
			sourceCodeAnalyzerType = args[1];
			sourceFileLocation = args[2];
			outputFilePath = args[3];
			outputFileType = args[4];
		} else if (args.length != 0) {
			System.out.println("Incorrect number of arguments.");
			System.exit(1);
		}

		ExecuteMetrics exec = new ExecuteMetrics();
		exec.getMetrics(outputFileType, filepath, sourceCodeAnalyzerType, outputFilePath, sourceFileLocation);
	}

}
