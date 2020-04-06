package manageFileData;

import java.io.FileNotFoundException;

public class AllFileDataOperations extends PrintChangesInNewDirectory{

	public AllFileDataOperations(String fileInput) throws FileNotFoundException {
		super(fileInput);
	}

	public static final String FILE_INPUT_PATH_1 = "C:\\Users\\I535102\\Desktop\\1\\text.txt";
	public static final String FILE_OUTPUT_PATH_1 = "C:\\Users\\I535102\\Desktop\\1\\text2.txt";
	
	public static void main(String[] args) throws FileNotFoundException {
		
		AllFileDataOperations fileDataManager = new AllFileDataOperations(FILE_INPUT_PATH_1);
		
		executeAllFileDataOperations(fileDataManager);
		
	}
	
	public static void executeAllFileDataOperations(AllFileDataOperations fileDataManager)
	{
		fileDataManager.storingAppendedCharsIntoWordsAlgorithm();
		fileDataManager.showFileRowsCount();
		fileDataManager.countWordsPerRow();
		fileDataManager.chooseYourOption();
		fileDataManager.printChangesInNewFile(FILE_OUTPUT_PATH_1);
				
	}

}
