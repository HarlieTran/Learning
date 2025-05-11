package Project1;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class BabyNamesRankings {

	public static void main(String[] args) {		
		
		final String FILENAME_PREFIX = "babynameranking";	
		
		String year = "2010";		
		
		File file = new File("src\\Data\\babynameranking" + year + ".txt");
		
		try (Scanner fileScanner = new Scanner(file)) {
            while (fileScanner.hasNextLine()) {
                String[] line = fileScanner.nextLine().split("\\s+");
                System.out.println(line[0] + " - " + line[1] + " - " + line[2] );
            }

        } catch (IOException ioException) {
            ioException.printStackTrace();
        }	

	}

}
