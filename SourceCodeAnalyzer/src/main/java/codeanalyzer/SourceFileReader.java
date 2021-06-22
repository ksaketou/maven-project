package codeanalyzer;

import java.io.IOException;
import java.util.List;

/**
 * This interface contains a method for reading a file given its path.
 * 
 * @author Konstantina Saketou
 */

public interface SourceFileReader{

	List<String> readFile (String filepath) throws IOException;
	

}
