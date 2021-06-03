package codeanalyzer;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * This class implements the SourceFileReader interface and uses
 * the readFile method to read a file and return its content into a string.
 * Current functionality supports two types of file sources: local and web.
 * 
 * @author Konstantina Saketou
 */
public class ReadFileIntoString implements SourceFileReader{

	private String type;
    public ReadFileIntoString(String _type) {
		this.type = _type;
	}

	/**
	 * This method reads a given file which is located localy or on
	 * the web and returns it into a string.
	 */
	@Override
	public List<String> readFile(String filepath) throws IOException{
		// read a locally stored file
		List<String> result_str = new ArrayList<>();
		if (type.contentEquals("local")) {
			StringBuilder sb = new StringBuilder();
			File file = new File(filepath);
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line = null;
			while ((line = reader.readLine()) != null) {
				sb.append(line + "\n");
			}
			reader.close();
			result_str.add(0, sb.toString());
			return result_str;
		// read a file stored in the web
		} else if (type.contentEquals("web")) {
			StringBuilder sb = new StringBuilder();
	        URL url = new URL(filepath);
	        BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
	        String line = null;
	        while ((line = reader.readLine()) != null) {
	        	sb.append(line + "\n");
	        }
	        reader.close();
			result_str.add(0, sb.toString());
			return result_str;
		} else {
			return null;
		}
	}
}
