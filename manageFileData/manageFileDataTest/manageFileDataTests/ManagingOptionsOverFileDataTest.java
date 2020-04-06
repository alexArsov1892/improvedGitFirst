package manageFileDataTests;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;

import org.junit.Test;

import manageFileData.AllFileDataOperations;
import manageFileData.ManagingOptionsOverFileData;

public class ManagingOptionsOverFileDataTest {
	
	public static final String FILE_INPUT_PATH2 = "C:\\2\\text3.txt";
	public static final String FILE_INPUT_PATH = AllFileDataOperations.FILE_INPUT_PATH_1;
	
	private String[] testWordsArray = {"wakanda", "Levski"};
	private int[] testPositions = {1, 2};
	private int[] ToBeSwappedWordsParameters = {1, 1, 2, 2};
	
	@Test
	public void testChooseOptions() throws FileNotFoundException
	{
		testAdd(FILE_INPUT_PATH, 2, testWordsArray, testPositions);
		testDelete(FILE_INPUT_PATH2, 1, testPositions);
		testSwap(FILE_INPUT_PATH, ToBeSwappedWordsParameters);
	}

	private void testAdd(String inputFile, int chosenFileLine, String[] wantedWordsToBeAdded, int[] chosenPositionsForTheNewWords) throws FileNotFoundException {
		
		ManagingOptionsOverFileData test = new ManagingOptionsOverFileData(inputFile);
		boolean wordsAreAdded = false;
		test.storingAppendedCharsIntoWordsAlgorithm();
		
		var getTheLine = test.getFileRowsContainer().get(chosenFileLine - 1);
		int currentSizeOfChosenLine = getTheLine.getFileRowWords().size();
		
		for(int i = 0; i < wantedWordsToBeAdded.length; i++) {
			
			String currentWord = wantedWordsToBeAdded[i];
			int getPositionForCurrentWord = chosenPositionsForTheNewWords[i];
			
			getTheLine.getFileRowWords().add(getPositionForCurrentWord - 1, currentWord);
						
		}
		
		int newSizeOfChosenLine = getTheLine.getFileRowWords().size();
		
		if(currentSizeOfChosenLine < newSizeOfChosenLine)
		{
			wordsAreAdded = true;
		}
		
		assertEquals(true, wordsAreAdded);
	}

	private void testDelete(String inputFile, int chosenFileLine, int[] chosenPositionsForTheNewWords) throws FileNotFoundException {
		
		ManagingOptionsOverFileData test = new ManagingOptionsOverFileData(inputFile);
		boolean wordsAreRemoved = false;
		test.storingAppendedCharsIntoWordsAlgorithm();
		
		var getTheLine = test.getFileRowsContainer().get(chosenFileLine - 1);
		int currentSizeOfChosenLine = getTheLine.getFileRowWords().size();
		
		String[] wordsToBeRemoved = new String[chosenPositionsForTheNewWords.length];
		for(int i = 0; i < wordsToBeRemoved.length; i++) {
			
			wordsToBeRemoved[i] = getTheLine.getFileRowWords().get(chosenPositionsForTheNewWords[i] - 1);
		}
		
		for(int i = 0; i < wordsToBeRemoved.length; i++) {
			
			getTheLine.getFileRowWords().remove(wordsToBeRemoved[i]);
		}
		
		int newSizeOfChosenLine = getTheLine.getFileRowWords().size();
		
		if(newSizeOfChosenLine < currentSizeOfChosenLine)
		{
			wordsAreRemoved = true;
		}
		
		assertEquals(true, wordsAreRemoved);
	}

	private void testSwap(String inputFile, int[] ToBeSwappedWordsParameters) throws FileNotFoundException {
		
		ManagingOptionsOverFileData test = new ManagingOptionsOverFileData(inputFile);
		test.storingAppendedCharsIntoWordsAlgorithm();

        int firstWordFileRow = ToBeSwappedWordsParameters[0] - 1;
        int firstWordFilePosition = ToBeSwappedWordsParameters[1] - 1;
        int secondWordFileRow = ToBeSwappedWordsParameters[2] - 1;
        int secondWordFilePosition  = ToBeSwappedWordsParameters[3] - 1;

        String firstWord = test.getFileRowsContainer().get(firstWordFileRow).getFileRowWords().get(firstWordFilePosition);
        String wordToBeChecked = firstWord;
        String secondWord = test.getFileRowsContainer().get(secondWordFileRow).getFileRowWords().get(secondWordFilePosition);
        
        test.getFileRowsContainer().get(firstWordFileRow).getFileRowWords().set(firstWordFilePosition, secondWord);
        test.getFileRowsContainer().get(secondWordFileRow).getFileRowWords().set(secondWordFilePosition, firstWord);
        
        String expectedFirstWordWithNewCoordinates = test.getFileRowsContainer().get(secondWordFileRow).getFileRowWords().get(secondWordFilePosition);
       
        assertEquals(true, expectedFirstWordWithNewCoordinates.equals(wordToBeChecked));
	}

}
