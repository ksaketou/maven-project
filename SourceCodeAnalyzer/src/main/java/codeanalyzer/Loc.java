package codeanalyzer;

import java.io.IOException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * This class implements the SourceCodeAnalyzer interface and uses
 * the calculate method to calculate the loc metric (= lines of code)
 * 
 * @author Konstantina Saketou
 */
public class Loc implements SourceCodeAnalyzer{
/**
 * This method calculates the total lines of code of a file.
 * The current functionality supports two types of source code analysis,
 * namely regex (with the use of regular expressions) and 
 * strcomp (with the use of string comparison). 
 */
    @Override
    public int calculate(String filepath, String analyzerType, String sourceLocation) throws IOException{
        if(analyzerType.equals("regex")) {
			ReadFileIntoString str = new ReadFileIntoString(sourceLocation);
			String sourceCode = str.readFile(filepath).get(0);
			Pattern pattern = Pattern.compile("((//.*)|(/\\*.*)|(\\*+.*))");
	        Matcher nonCodeLinesMatcher = pattern.matcher(sourceCode);

	        int nonCodeLinesCounter = 0;
	        while (nonCodeLinesMatcher.find()) {
	        	nonCodeLinesCounter++;
	        }
			
	        int sourceFileLength = sourceCode.split("\n").length;
	        int loc =  sourceFileLength - nonCodeLinesCounter;
	        
			return loc;
		} else if (analyzerType.equals("strcomp")) {
			ReadFileIntoList list = new ReadFileIntoList(sourceLocation);
			List<String> sourceCodeList = list.readFile(filepath);
			int nonCodeLinesCounter = 0;
			for (String line : sourceCodeList) {
				line = line.stripLeading().stripTrailing(); //clear all leading and trailing white spaces
				if (line.startsWith("//") || line.startsWith("/*") || line.startsWith("*") || line.equals("{") || line.equals("}") || line.equals(""))
					nonCodeLinesCounter++;
			}
			int loc = sourceCodeList.size() - nonCodeLinesCounter;
			return loc; 
		}
		return -1;
    }

}