package manageFileDataTests;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


import org.junit.Assert;
import org.junit.Test;

import manageFileData.AllFileDataOperations;
import manageFileData.FileRowAsAnArrayList;
import manageFileData.StoreFileData;

public class StoreFileDataTest {
	
	public static final String FILE_INPUT_PATH = AllFileDataOperations.FILE_INPUT_PATH_1;
	public static final String FILE_INPUT_PATH2 = "C:\\2\\text3.txt";
	public static final String FILE_INPUT_PATH3 = "C:\\3\\text5.txt";
	public static final String FILE_INPUT_PATH4 = "C:\\4\\text7.txt";
	
	@Test
	public void allStoreFileDataTests() throws FileNotFoundException
	{
		testStoreFileData(StoreFileDataTest.FILE_INPUT_PATH);
		testStoreFileData(StoreFileDataTest.FILE_INPUT_PATH2);
		testStoreFileData(StoreFileDataTest.FILE_INPUT_PATH3);
		testStoreFileData(StoreFileDataTest.FILE_INPUT_PATH4);
	}

	public void testStoreFileData(String fileInput) throws FileNotFoundException {
		
		StoreFileData test = new StoreFileData(fileInput);
		String firstLine = test.getScanner().nextLine();
		boolean fileIsOpened = false;
		if(firstLine.length() > 0)
		{
			fileIsOpened = true;
		}
		
		assertEquals(true, fileIsOpened);
	}
	

	@Test
	public void test1CollectWordsPerRow() throws FileNotFoundException {
		
		List<String> expectedWords = new ArrayList<>(Arrays.asList("Alex", "Ivaylov", "Arsov"));
		
		StoreFileData test = new StoreFileData(StoreFileDataTest.FILE_INPUT_PATH);
		FileRowAsAnArrayList firstFileRow = new FileRowAsAnArrayList();
		String firstLine = test.getScanner().nextLine();
		String word = "";
		
		  for (int i = 0; i < firstLine.length(); i++) {
         	 
              char symbol = firstLine.charAt(i);
              if (Character.isLetterOrDigit(symbol) || symbol == '\'')
              {
                  word += String.valueOf(symbol);
              }
              else if (!Character.isLetterOrDigit(symbol) && symbol != ' ')
              {
                  if (!word.equals("")) {
                 	 
                      firstFileRow.getFileRowWords().add(word);
                      word = "";
                      word += String.valueOf(symbol);
                      
                   }
              }
              else if (symbol == ' ')
              {
                  if (!word.equals("")) {
                 	 
                	 firstFileRow.getFileRowWords().add(word);
                 	 word = "";
                 	 
                  }
              }
           }
                       
           if (!word.equals("")) {
         	  
        	  firstFileRow.getFileRowWords().add(word);
         	  word = "";
         	  
           }   
           
           Assert.assertEquals(firstFileRow.getFileRowWords(), expectedWords);
		
	}
		
}
