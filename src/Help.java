import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * @author jgjones
 * 
 * Read help text from a text file that contains the help text for each commands
 */
public class Help {

	public void helptext (String command) throws FileNotFoundException 
	{


		Scanner s = new Scanner(new File("helptext"));	// create a scanner which scans from a file
		Boolean exist = false; // if a command exists in the help text, it will be set to true.


		//		while ( s.hasNext() ) 
		//		{
		//			if ( command.equals( s.next() )) 
		//			{ 
		//				while ( s.findInLine("EOT") == null ) 
		//				{
		//					String line = s.nextLine().trim();
		//					if (!(line.equals("")))
		//					{
		//						System.out.println(line);
		//					}
		//					 
		//				} 
		//				
		//				exist = true; //command exists so set to true
		//				
		//				break;
		//			}
		//		}

		while ( s.hasNext() ) 
		{
			if ( command.equals( s.next() ) && s.nextLine().equals("")) 
			{ 
				while ( s.findInLine("EOT") == null ) 
				{
					String line = s.nextLine().trim();
					if (!(line.equals("")))
					{
						System.out.println(line);
					}

				} 

				exist = true; //command exists so set to true

				break;
			}
		}


		if (exist == false) //the command isn't in the help text so display message below
		{
			System.out.println("No help is available for '"+ command + "'");
			System.out.println("Please type 'commands' for a list of available commands that you can use");
			System.out.println("'help <command>' for instructions for specified command.");
		}
		s.close();
	}

}