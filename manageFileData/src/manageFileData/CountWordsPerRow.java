package manageFileData;

import java.io.FileNotFoundException;

public class CountWordsPerRow extends StoreFileData{

	public CountWordsPerRow(String fileInput) throws FileNotFoundException {
		super(fileInput);
		
	}

	private int isNotAWord = 0;
	
	public void showFileRowsCount()
	{
		 System.out.printf("Number of rows: %d", getFileRowsContainer().size());
	     System.out.println();
	}
	
	public void countWordsPerRow()
	{
		 for (int i = 0; i < getFileRowsContainer().size(); i++) {			 
		 
	            var currentRow = getFileRowsContainer().get(i);
	            for (int j = 0; j < currentRow.getFileRowWords().size(); j++) {
	                var element = currentRow.getFileRowWords().get(j);
	                if (!Character.isLetterOrDigit(element.charAt(0)))
	                {
	                    isNotAWord++;
	                }
	            }
	            
	            int wordsPerRow = currentRow.getFileRowWords().size() - isNotAWord;
	            int indexOfRow = getFileRowsContainer().indexOf(currentRow) + 1;
	            System.out.println(String.format("Row %d has -> %d words!",indexOfRow, wordsPerRow));
	            isNotAWord = 0;
	}
		 		 
		   System.out.println();
	
	}
	
}
