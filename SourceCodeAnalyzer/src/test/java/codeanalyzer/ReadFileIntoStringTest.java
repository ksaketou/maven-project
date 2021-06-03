package codeanalyzer;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.List;

import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *  This is a test class for the ReadFileIntoString class.
 * 
 * @author Konstantina Saketou
 */
public class ReadFileIntoStringTest {

	ReadFileIntoString readStr = null;
    private static List<String> expectedList;
	private static String expectedString;
	private final static String TYPE_WEB = "web";
	private final static String TYPE_LOCAL = "local";
	private final static String TEST_CLASS_LOCAL = "src/test/resources/TestClass.java";
	private final static String TEST_CLASS_WEB ="https://drive.google.com/uc?export=download&id=1z51FZXqPyun4oeB7ERFlOgfcoDfLLLhg";

	@BeforeClass
	public static void setUp() throws IOException {
		expectedList = Files.readAllLines(new File(TEST_CLASS_LOCAL).toPath(), Charset.defaultCharset());
		expectedString = String.join("\n", expectedList) + "\n"; // transforms a list into a String (with 'new line' as delimiter) 
	}

	@Test
	public void testReadFileLocal() throws IOException {
		//read a locally stored file into a String
		readStr = new ReadFileIntoString(TYPE_LOCAL);
		String actuals = readStr.readFile(TEST_CLASS_LOCAL).get(0);
				
		assertEquals(expectedString, actuals);
	}

	@Test
	public void testReadFileWeb() throws IOException {
		//read a file stored in the web into a String
		readStr = new ReadFileIntoString(TYPE_WEB);
		String actuals = readStr.readFile(TEST_CLASS_WEB).get(0);
				
		assertEquals(expectedString, actuals);
	}

	@Test
	public void testReadFileNull() throws IOException {
		//give a none existing type to cause a null String return
		readStr = new ReadFileIntoString("non-existing-type");
		List<String> actualString = readStr.readFile("any-filepath");
		
		assertNull(actualString);
	}
}
