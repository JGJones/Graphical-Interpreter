import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


/**
 * @author jgjones
 * 
 * Load a file
 * 
 */
public class UserData {

	public void load (String filename) throws FileNotFoundException 
	{

		Scanner s = new Scanner(new File(filename));	// create a scanner which scans from a file
		Draw execute = new Draw();

		String [] userCommand;	
		String line;	// stores the each line of text read from the file
		int n = 1;

		while ( s.hasNext() ) {

			line = s.nextLine().trim();		// read the next line of text from the file

		//	System.out.println(line);	// output the line of text to the console

		//	line = line.trim();

			// split the text into multiple elements by using a space " ",
			// as the separator and store in an array of String

			userCommand = line.split(" "); //with thanks to Mark Dixon for his SimpleParser code to split text

			if ( userCommand.length > 4 )
			{
				System.out.println("Error! Too many parameters entered at line" + n + "!");
				
			}
			n++;
			execute.runCommand(userCommand);

		}
		

	

	//System.out.println("\nEOF");	// Output and End Of File message.

	s.close();
}

}