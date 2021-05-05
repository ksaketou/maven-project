package math;

import static org.mockito.Mockito.*;

import java.io.File;

import org.junit.Assert;
import org.junit.Test;

import io.FileIO;

/**
 * This is a test class for the class ArrayOperations.
 * 
 * @author Konstantina Saketou
 * 
 */
public class ArrayOperationsTest {
	
	@Test
	public void testFindPrimesInFileException() {
		ArrayOperations obj = new ArrayOperations();
		MyMath math = mock(MyMath.class);
		FileIO file = mock(FileIO.class);
		File filepath = new File("src/test/resources/findPrimes_Exception.txt");
		
		int [] int_array = {8, 10, 1, 0};
		when(file.readFile(filepath.getAbsolutePath())).thenReturn(int_array);

		Assert.assertArrayEquals(new int[] {}, 
				obj.findPrimesInFile(file, filepath.getAbsolutePath(), math));
		
	}
	
	@Test
	public void testFindPrimesInFileSuccess() {
		ArrayOperations obj = new ArrayOperations();
		MyMath math = mock(MyMath.class);
		FileIO file = mock(FileIO.class);
		File f = new File("src/test/resources/findPrimes_Success.txt");

		int [] int_array = {4, 5, 7, 8};
		when(file.readFile(f.getAbsolutePath())).thenReturn(int_array);

		when(math.isPrime(4)).thenReturn(false);
		when(math.isPrime(5)).thenReturn(true);
		when(math.isPrime(7)).thenReturn(true);
		when(math.isPrime(8)).thenReturn(false);

		Assert.assertArrayEquals(new int[]{5, 7},
				obj.findPrimesInFile(file, f.getAbsolutePath(), math));
	}

}
