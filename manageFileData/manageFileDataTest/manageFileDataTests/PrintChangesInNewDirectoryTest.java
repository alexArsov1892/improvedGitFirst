package manageFileDataTests;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;

import java.util.List;

import org.junit.Test;

import manageFileData.StoreFileData;

public class PrintChangesInNewDirectoryTest {
	
	private PrintStream fileWriter;
	
	public static final String FILE_OUTPUT_PATH = "C:\\Users\\I535102\\Desktop\\1\\text2.txt";
	public static final String FILE_OUTPUT_PATH2 = "C:\\2\\text4.txt";
	public static final String FILE_OUTPUT_PATH3 = "C:\\3\\text6.txt";
	public static final String FILE_OUTPUT_PATH4 = "C:\\4\\text8.txt";
	
	@Test
	public void allPrintChangesInNewFileTests() throws FileNotFoundException {
		
		testPrintChangesInNewFile(StoreFileDataTest.FILE_INPUT_PATH, FILE_OUTPUT_PATH);
		testPrintChangesInNewFile(StoreFileDataTest.FILE_INPUT_PATH2, FILE_OUTPUT_PATH2);
		testPrintChangesInNewFile(StoreFileDataTest.FILE_INPUT_PATH3, FILE_OUTPUT_PATH3);
		testPrintChangesInNewFile(StoreFileDataTest.FILE_INPUT_PATH4, FILE_OUTPUT_PATH4);
	}
	
	private void testPrintChangesInNewFile(String fileInputPath, String fileOutputPath) throws FileNotFoundException {
		
	 	List<String> expected = new ArrayList<>();
		
        fileWriter = new PrintStream(fileOutputPath);
        StoreFileData fileReader = new StoreFileData(fileInputPath);     
        fileReader.storingAppendedCharsIntoWordsAlgorithm();
        
       	var firstFileRow = fileReader.getFileRowsContainer().get(0);
        	
       	for (int j = 0; j < firstFileRow.getFileRowWords().size(); j++) {
        		
       		String currentWord = firstFileRow.getFileRowWords().get(j);
       		expected.add(currentWord);
       		fileWriter.print(currentWord + " "); 
       	}
            
       	StoreFileData readTheNewPrintedRow = new StoreFileData(fileOutputPath);
       	
        readTheNewPrintedRow.storingAppendedCharsIntoWordsAlgorithm();
        
        List<String> actual = new ArrayList<>();
        var firstPrintedRow = readTheNewPrintedRow .getFileRowsContainer().get(0);
        
        for(int i = 0; i < firstPrintedRow.getFileRowWords().size(); i++)
        {
        	actual.add(firstPrintedRow.getFileRowWords().get(i));
        }
        
        assertEquals(actual, expected);
	}
}
