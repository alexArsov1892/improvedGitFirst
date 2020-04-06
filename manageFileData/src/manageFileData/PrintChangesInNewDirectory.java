package manageFileData;

import java.io.FileNotFoundException;
import java.io.PrintStream;

public class PrintChangesInNewDirectory extends ManagingOptionsOverFileData{
	
	public PrintChangesInNewDirectory(String fileInput) throws FileNotFoundException {
		super(fileInput);
	}

	private PrintStream fileWriter;
		
	public void printChangesInNewFile(String fileOutputPath)
	{
	        String fileRow = "";

	        try {
	        	
	            this.fileWriter = new PrintStream(fileOutputPath);
	            
	            for (int i = 0; i < getFileRowsContainer().size(); i++) 
	            {
	                var currentRow = getFileRowsContainer().get(i);
	                
	                for (int j = 0; j < currentRow.getFileRowWords().size(); j++) {
	                    var element = currentRow.getFileRowWords().get(j);
	                    if (j == 0)
	                    {
	                        fileRow += element;
	                    }
	                    else if (Character.isLetterOrDigit(element.charAt(0)))
	                    {
	                        fileRow += ' ';
	                        fileRow += element;
	                    }
	                    else if (!Character.isLetterOrDigit(element.charAt(0)))
	                    {
	                        fileRow += element;
	                    }


	                }
	                
	                fileWriter.println(fileRow);
	                fileRow = "";
	            }
	        } catch (FileNotFoundException e) {
	            e.printStackTrace();
	        }finally {
	            fileWriter.close();
	        }
	    }


	public PrintStream getFileWriter() {
		return fileWriter;
	}


	public void setFileWriter(PrintStream fileWriter) {
		this.fileWriter = fileWriter;
	}
	}
	
