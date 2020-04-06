package manageFileDataTests;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;

import org.junit.Test;

import manageFileData.AllFileDataOperations;
import manageFileData.CountWordsPerRow;

public class CountWordsPerRowTest {

	public static final String FILE_INPUT_PATH = AllFileDataOperations.FILE_INPUT_PATH_1;
	public static final String FILE_INPUT_PATH2 = "C:\\2\\text3.txt";
	public static final String FILE_INPUT_PATH3 = "C:\\3\\text5.txt";
	public static final String FILE_INPUT_PATH4 = "C:\\4\\text7.txt";
	
	@Test
	public void allTestShowFileRowsCount() throws FileNotFoundException {
		
		testShowFileRowsCount(FILE_INPUT_PATH);
		testShowFileRowsCount(FILE_INPUT_PATH2);
		testShowFileRowsCount(FILE_INPUT_PATH3);
	}
	
	
	public void testShowFileRowsCount(String fileInputPath) throws FileNotFoundException {
		
		CountWordsPerRow test = new CountWordsPerRow(fileInputPath);
		test.storingAppendedCharsIntoWordsAlgorithm();
		int actualNumOfFileRows = test.getFileRowsContainer().size();
		boolean foundRows = false;
		if(actualNumOfFileRows > 0)
		{
			foundRows = true;
		}
		assertEquals(true, foundRows);
		
	}
	
	@Test
	public void testCountWordsPerRow() {
		
		
	}

}
