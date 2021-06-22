package codeanalyzer;

import java.io.IOException;

/**
 * This interface contains one method which was created to analyze 
 * the contents of a Java source code file and calculate several metrics. 
 * The current functionality supports two types of source code analysis,
 * namely regex (with the use of regular expressions) and 
 * strcomp (with the use of string comparison). 
 *
 * @author Konstantina Saketou
 */

public interface SourceCodeAnalyzer {

	int calculate(String filepath, String fileReaderType, String sourceLocation) throws IOException;
}
