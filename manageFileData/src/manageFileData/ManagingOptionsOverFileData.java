package manageFileData;

import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ManagingOptionsOverFileData extends CountWordsPerRow{
	
	
	public ManagingOptionsOverFileData(String fileInput) throws FileNotFoundException {
		super(fileInput);
		
	}
	private Scanner scanner2 = new Scanner(System.in);	
    private String command = "";

    public void chooseYourOption()
    {
    	System.out.print("Choose your option: ");

        System.out.println("Add/Delete/Swap/End");

        while (!"End".equals(command = scanner2.nextLine()))
        {
        	System.out.println();
        	
            if (command.equals("Add")){
                add(scanner2, getFileRowsContainer());
            }
            else if (command.equals("Delete"))
            {
               delete(scanner2, getFileRowsContainer());
            }
            else if (command.equals("Swap"))
            {
                swap(command, scanner2, getFileRowsContainer());
            }

        }
    }
    
    
    public static void add(Scanner scanner2, List<FileRowAsAnArrayList> fileRowsContainer)
    {
        System.out.print("Choose the line where you want to add some words: ");
        int myLine = Integer.parseInt(scanner2.nextLine());
        while (myLine > fileRowsContainer.size())
        {
            System.out.println("Invalid row!");
            myLine = Integer.parseInt(scanner2.nextLine());
        }
        var wantedLine = fileRowsContainer.get(myLine - 1);

        System.out.print(String.format("Choose the words you want to add at line %d: ", myLine));
        String[] myWords = scanner2.nextLine().split("\\s+");

        for (int i = 0; i < myWords.length; i++)
        {
            String myWord = myWords[i];
            System.out.printf("Choose the position of the word %s -> ", myWord);
            int myPosition = Integer.parseInt(scanner2.nextLine());
            while (myPosition > fileRowsContainer.get(myLine - 1).getFileRowWords().size())
            {
                System.out.println("Invalid position!");
                myPosition = Integer.parseInt(scanner2.nextLine());
            }
            wantedLine.getFileRowWords().add(myPosition - 1, myWord);
        }
    }
    public static void delete(Scanner scanner2, List<FileRowAsAnArrayList> fileRowsContainer)
    {
        System.out.print("Choose the line where you want to delete some words: ");
        int myLine = Integer.parseInt(scanner2.nextLine());
        while (myLine > fileRowsContainer.size())
        {
            System.out.println("Invalid row!");
            myLine = Integer.parseInt(scanner2.nextLine());
        }
        var wantedLine = fileRowsContainer.get(myLine - 1);

        System.out.print(String.format("Choose the words you want to delete at line %d: ", myLine));
        int[] wantedPos = Arrays.stream(scanner2.nextLine().split("\\s+"))
                .mapToInt(value -> Integer.parseInt(value))
                .toArray();
        for (int i = 0; i < wantedPos.length; i++) {
            if (wantedPos[i] > fileRowsContainer.get(myLine - 1).getFileRowWords().size())
            {
                System.out.println(String.format("%d is an invalid position!", wantedPos[i]));
                int newPos = Integer.parseInt(scanner2.nextLine());
                while (newPos > fileRowsContainer.get(myLine - 1).getFileRowWords().size())
                {
                    System.out.println("Invalid position!");
                    newPos = Integer.parseInt(scanner2.nextLine());
                }
                wantedPos[i] = newPos;
            }
        }
        String[] data = new String[wantedPos.length];
        for (int i = 0; i < wantedPos.length; i++) {
            data[i] = wantedLine.getFileRowWords().get(wantedPos[i] - 1);
        }

        for (String element : data) {
            wantedLine.getFileRowWords().remove(element);
        }
    }
    public static void swap(String command, Scanner scanner2, List<FileRowAsAnArrayList> fileRowsContainer)
    {
        System.out.print(command + " -> ");
        int[] parameters = Arrays.stream(scanner2.next().split(","))
                .mapToInt(value -> Integer.parseInt(value))
                .toArray();

        int FWfileRow = parameters[0] - 1;
        int FWwordPos = parameters[1] - 1;
        int SWfileRow = parameters[2] - 1;
        int SWwordPos = parameters[3] - 1;

        String fW = fileRowsContainer.get(FWfileRow).getFileRowWords().get(FWwordPos);
        String sW = fileRowsContainer.get(SWfileRow).getFileRowWords().get(SWwordPos);
        fileRowsContainer.get(FWfileRow).getFileRowWords().set(FWwordPos, sW);
        fileRowsContainer.get(SWfileRow).getFileRowWords().set(SWwordPos, fW);
    }
}
