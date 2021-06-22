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
 * the readFile method to read a file and return its content into a list.
 * Current functionality supports two types of file sources: local and web.
 * 
 * @author Konstantina Saketou
 */
public class ReadFileIntoList implements SourceFileReader{

	private String type;
	public ReadFileIntoList(String _type) {
		this.type = _type;
	}

	/**
	 * This method reads a given file which is located locally or
	 * on the web and returns it into a list.
	 */
	@Override
	public List<String> readFile (String filepath) throws IOException{
		// read a locally stored file
		if (type.contentEquals("local")) {
			List<String> lines = new ArrayList<>();
			File file = new File(filepath);
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line = null;
			while ((line = reader.readLine()) != null) {
				lines.add(line);
			}
			reader.close();
			return lines;
		// read a file stored in the web
		} else if (type.contentEquals("web")) {
			List<String> lines = new ArrayList<>();
	        URL url = new URL(filepath);
	        BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
	        String line = null;
	        while ((line = reader.readLine()) != null) {
	        	lines.add(line);
	        }
	        reader.close();
			return lines;
		} else {
			return null;
		}
    }
}
