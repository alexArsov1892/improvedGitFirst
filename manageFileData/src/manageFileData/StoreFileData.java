package manageFileData;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StoreFileData{
	
	private Scanner scanner;
    private String word = "";
    private  List<FileRowAsAnArrayList> fileRowsContainer = new ArrayList<>();
    
	public StoreFileData(String fileInput) throws FileNotFoundException
	{				
		this.scanner = new Scanner(new FileInputStream(fileInput));
	}
		
	public void collectWordsPerRow(FileRowAsAnArrayList fileRow, String word)
	{
		fileRow.getFileRowWords().add(word);
	}
	
	public void collectFileRowsInAContainer(FileRowAsAnArrayList fileRow)
	{
		fileRowsContainer.add(fileRow);
	}

	public void storingAppendedCharsIntoWordsAlgorithm() {
		
		
		 while (scanner.hasNextLine())
         {
			 FileRowAsAnArrayList fileRow = new FileRowAsAnArrayList();
             String currentLine = scanner.nextLine();
             
             for (int i = 0; i < currentLine.length(); i++) {
            	 
                 char symbol = currentLine.charAt(i);
                 if (Character.isLetterOrDigit(symbol) || symbol == '\'')
                 {
                     word += String.valueOf(symbol);
                 }
                 else if (!Character.isLetterOrDigit(symbol) && symbol != ' ')
                 {
                     if (!word.equals("")) {
                    	 
                         collectWordsPerRow(fileRow, word);
                         word = "";
                         word += String.valueOf(symbol);
                         
                      }
                 }
                 else if (symbol == ' ')
                 {
                     if (!word.equals("")) {
                    	 
                    	 collectWordsPerRow(fileRow, word);
                    	 word = "";
                    	 
                     }
                 }
              }
                          
              if (!word.equals("")) {
            	  
            	  collectWordsPerRow(fileRow, word);
            	  word = "";
            	  
              }     
            
              collectFileRowsInAContainer(fileRow);            
          }
	}

	public List<FileRowAsAnArrayList> getFileRowsContainer() {
		return fileRowsContainer;
	}


	public void setFileRowsContainer(List<FileRowAsAnArrayList> fileRowsContainer) {
		this.fileRowsContainer = fileRowsContainer;
	}


	public Scanner getScanner() {
		return scanner;
	}

	public void setScanner(Scanner scanner) {
		this.scanner = scanner;
	}
	
}
