package codeanalyzer;

import java.io.IOException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * This class implements the SourceCodeAnalyzer interface and uses
 * the calculate method to calculate the nom metric (= number of methods)
 * 
 * @author Konstantina Saketou
 */
public class Nom implements SourceCodeAnalyzer{
/**
 * This method calculates the total number of methods of a file.
 * The current functionality supports two types of source code analysis,
 * namely regex (with the use of regular expressions) and 
 * strcomp (with the use of string comparison). 
 */
    @Override
    public int calculate(String filepath, String analyzerType, String sourceLocation) throws IOException {
        if(analyzerType.equals("regex")) {
			ReadFileIntoString str = new ReadFileIntoString(sourceLocation);
			String sourceCode = str.readFile(filepath).get(0);
			Pattern pattern = Pattern.compile(".*(public |protected |private |static )?[\\w\\<\\>\\[\\]]+\\s+(\\w+) *\\([^\\)]*\\) *(\\{?|[^;]).*"); 
	        Matcher methodSignatures = pattern.matcher(sourceCode);

	        int methodCounter = 0;
	        while (methodSignatures.find()) {
	        	methodCounter++;
	        }
			return methodCounter;
		} else if (analyzerType.equals("strcomp")) {
			ReadFileIntoList list = new ReadFileIntoList(sourceLocation);
			List<String> sourceCodeList = list.readFile(filepath);
			int methodCounter = 0;
			for (String line : sourceCodeList) {
				line = line.stripLeading().stripTrailing(); //clear all leading and trailing white spaces
				if ( ((line.contains("public") || line.contains("private") || line.contains("protected"))
						|| line.contains("void") || line.contains("int") || line.contains("String"))
					&& line.contains("(") && line.contains(")") && line.contains("{") )
					methodCounter++;
			}
			return methodCounter; 
		}
		return -1;
    }

}