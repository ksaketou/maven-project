package codeanalyzer;

import java.io.IOException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * This class implements the SourceCodeAnalyzer interface and uses
 * the calculate method to calculate the noc metric (= number of classes)
 * 
 * @author Konstantina Saketou
 */
public class Noc implements SourceCodeAnalyzer{
/**
 * This method calculates the total number of classes of a file.
 * The current functionality supports two types of source code analysis,
 * namely regex (with the use of regular expressions) and 
 * strcomp (with the use of string comparison). 
 */
    @Override
    public int calculate(String filepath, String analyzerType, String sourceLocation) throws IOException {

		if(analyzerType.equals("regex")) {
			ReadFileIntoString str = new ReadFileIntoString(sourceLocation);
			String sourceCode = str.readFile(filepath).get(0);
			Pattern pattern = Pattern.compile(".*\\s*class\\s+.*"); 
	        Matcher classSignatures = pattern.matcher(sourceCode);

	        int classCounter = 0;
	        while (classSignatures.find()) {
	        	classCounter++;
	        }
			return classCounter;
		} else if (analyzerType.equals("strcomp")) {
			ReadFileIntoList list = new ReadFileIntoList(sourceLocation);
			List<String> sourceCodeList = list.readFile(filepath);
			int classCounter = 0;
			for (String line : sourceCodeList) {
				line = line.strip(); //remove leading and trailing white spaces
				if ((line.startsWith("class ") || line.contains(" class ")) && line.contains("{")) {
					classCounter++;
				}
			}
			return classCounter; 
		}
		return -1;
    }


}