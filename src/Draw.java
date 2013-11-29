import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class Draw 
{
	GraphicsScreen g = new GraphicsScreen();

	private int curX, curY;

	//	private enum CommandKind {
	//		MOVETO,
	//		LINETO,
	//		CIRCLE,
	//		FILLCIRCLE,
	//		PEN_COLOUR,
	//		RECT,
	//		FILLRECT,
	//		HELP,
	//		COMMANDS,
	//		END,
	//		LOAD,
	//		CLEAR,
	//	}

	private class UserData
	{
		public void load (String filename) throws FileNotFoundException 
		{

			Scanner s = new Scanner(new File(filename));	// create a scanner which scans from a file Scanner s = new Scanner(new File(filename));
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
			s.close(); //close the scanner
		}
	}

	private class Validation 
	{/*
	 * 
	 * This method simply just check for the correct number of parameters for a given command. Ie moveTo have 2 parameters so this would
	 * be called as check.paramCheck(splitupText, firstWord, 2). If correct, it returns true, otherwise it print out error message and return false.
	 * 
	 */

		public boolean paramCheck(String[] params, int maxparam)
		{


			if ( params.length == (maxparam + 1) ) //need to add one to include 1st word as it's counting an array.
			{
				return true; // all good!
			}
			else // not good, print out error message and return false
			{
				switch (maxparam)
				{
				case 1 :
					System.out.println("Please enter a single parameter for " + params[0]);
					System.out.println("Please type \"help " + params[0] + "\" if you need help with " + params[0]);
					break;

				default :
					System.out.println("Please enter "+ maxparam +" parameters for " + params[0]);
					System.out.println("Please type \"help " + params[0] + "\" if you need help with " + params[0]);

				}

				return false;
			}
		}

		public boolean valid (String[] command)
		{

			//int firstPar,secondPar,thirdPar;
			boolean valid = true; //Assume it's a valid command to start with and do checks to confirm below


			if ( /* command.length > 1 && */ valid == true) 
			{
				try 

				{ // Always expect the unexpected! If parseInt attempt to parse letters it throws a
					// NumberFormatException so using a try...catch statement to deal with unexpected inputs
					Integer.parseInt(command[1]);
					if (command.length > 2)
					{
						Integer.parseInt(command[2]);
					} if (command.length > 3)
					{
						Integer.parseInt(command[3]);
					} 		
				} catch (NumberFormatException e)
				{
					System.out.println("Please enter the correct values for the parameters");
					System.out.println("Please type \"help "+command[0]+"\" if you need help with \""+command[0]+"\".");
					valid = false;
				}
			}

			if (valid == false)
			{
				return false;
			} else
			{
				return true;
			}
		}

	}


	public void Execute (String[] command)
	{
		UserData fileio = this.new UserData();
		Validation check = this.new Validation();
		Help helpcommand = new Help();

		switch (command[0].toLowerCase()) // run code based on what the first word is. If it's a valid command, it'll execute otherwise it's an error message
		{

		case "commands" :

			System.out.println("Commands: moveTo, lineTo, rect, fillrect, circle, fillcircle, penColour, penPosition, clear, load, commands, end");
			System.out.println("Type \"help <command>\" for instructions on a command");

			break;

		case "help" :

			if (command.length == 2)
			{
				try
				{
					helpcommand.helptext(command[1]);
				}catch (FileNotFoundException e)
				{
					System.out.println("Help text is missing!");
				}
			} else
			{
				System.out.println("Type \"help <command>\" for instructions on a command");
			}

			break;

		case "moveto" :

			if ((check.paramCheck(command, 2) == true) && (check.valid(command) == true))
			{
				g.moveTo(Integer.parseInt(command[1]), Integer.parseInt(command[2]));

				curX = Integer.parseInt(command[1]);
				curY = Integer.parseInt(command[2]);
			}

			break;

		case "lineto" :

			if ((check.paramCheck(command, 2) == true) && (check.valid(command) == true))
			{
				g.lineTo(Integer.parseInt(command[1]), Integer.parseInt(command[2]));
				curX = Integer.parseInt(command[1]);
				curY = Integer.parseInt(command[2]);
			}
			break;

		case "rect" :

			if ((check.paramCheck(command, 2) == true) && (check.valid(command) == true))
			{
				g.Rect(Integer.parseInt(command[1]), Integer.parseInt(command[2]));
			}

			break;

		case "fillrect" :

			if ((check.paramCheck(command, 2) == true) && (check.valid(command) == true))
			{
				g.fillRect(Integer.parseInt(command[1]), Integer.parseInt(command[2]));
			}

			break;

		case "circle" :

			if ((check.paramCheck(command, 1) == true) && (check.valid(command) == true))

			{
				g.circle(Integer.parseInt(command[1]));
			}

			break;

		case "fillcircle" :

			if ((check.paramCheck(command, 1) == true) && (check.valid(command) == true))

			{
				g.fillCircle(Integer.parseInt(command[1]));
			}

			break;

		case "pencolour" :


			if ((check.paramCheck(command, 3) == true) && (check.valid(command) == true))

			{
				g.penColour(Integer.parseInt(command[1]), Integer.parseInt(command[2]), Integer.parseInt(command[3]));
			}

			break;

		case "penposition" :

			if ( command.length == 1 )
			{
				System.out.println("The current pen position is x: "+ curX + " and y: "+curY);
			} else
			{
				System.out.println("All input(s) entered after penPosition is ignored");
				System.out.println("The current pen position is x: "+ curX + " and y: "+curY);
			}


			break;

		case "clear" :

			g.clear();

			break;

		case "end" :

			if ( command.length > 1 )
			{
				System.out.println("I see that you are trying to quit the program.");
				System.out.println("Type end on its own to quit program. Does not end all life on planet.");
			} else
			{
				g.close();
			}

			break;

		case "load" :

			try
			{
				fileio.load(command[1]);
			}catch (FileNotFoundException e)
			{
				System.out.println("Error 404! File not found! Make sure "+ command[1] +" does exist!");
			}

			break;

		default :

			System.out.println("No valid command entered");
			System.out.println("Type commands for a list of all commands");
			System.out.println("Type help <command> for instructions on a command");

		}


		//validation checks


	}
}
