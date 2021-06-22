package codeanalyzer;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertNull;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

/**
 *  This is a test class for the ReadFileIntoList class.
 * 
 * @author Konstantina Saketou
 */
public class ReadFileIntoListTest {
	ReadFileIntoList readList = null;
    private static String expectedString;
    private static List<String> expectedList;
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
		//read a locally stored file into a List
		readList = new ReadFileIntoList(TYPE_LOCAL);
		List<String> actualList = readList.readFile(TEST_CLASS_LOCAL);
		
		String[] expecteds = expectedList.stream().toArray(String[]::new);
		String[] actuals = actualList.stream().toArray(String[]::new);
		
		assertArrayEquals(expecteds, actuals);
	}

    @Test
	public void testReadFileWeb() throws IOException {
		//read a file stored in the web into a List
		readList = new ReadFileIntoList(TYPE_WEB);
		List<String> actualList = readList.readFile(TEST_CLASS_WEB);
		
		String[] expecteds = expectedList.stream().toArray(String[]::new);
		String[] actuals = actualList.stream().toArray(String[]::new);
		
		assertArrayEquals(expecteds, actuals);
	}

    @Test
	public void testReadFileNull() throws IOException {
		//give a none existing type to cause a null List return
		readList = new ReadFileIntoList("non-existing-type");
		List<String> actualList = readList.readFile("any-filepath");
		
		assertNull(actualList);
	}
}
