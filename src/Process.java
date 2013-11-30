import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Process 
{

	GraphicsScreen g = new GraphicsScreen();
	private int curX, curY;

	protected class Run
	{

		void Execute (String[] command)
		{
			//	Draw check = new Draw();
			Validation check = new Validation();
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

				//		case "load" :
				//
				//			try
				//			{
				//				fileio.load(command[1]);
				//			}catch (FileNotFoundException e)
				//			{
				//				System.out.println("Error 404! File not found! Make sure "+ command[1] +" does exist!");
				//			}
				//
				//			break;

			default :

				System.out.println("No valid command entered");
				System.out.println("Type commands for a list of all commands");
				System.out.println("Type help <command> for instructions on a command");

			}

		}
	}

	public void processCommand (String[] command)
	{
		Run execute = this.new Run();

		if (command[0].toLowerCase().equals("load"))
		{
			Validation check = new Validation();
			try
			{
				Scanner s = new Scanner(new File(command[1]));// create a scanner which scans from a file
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

//					if ( (userCommand.length > 4) || (check.valid(userCommand) == true))
//					{
//						System.out.println("Error! Too many parameters entered at line" + n + "!");
//
//					}

					execute.Execute(userCommand);
					n++;

				}
				s.close();

			}catch (FileNotFoundException e)
			{
				System.out.println("Error 404! File not found! Make sure "+ command[1] +" does exist!");
			}

		} else
		{
			execute.Execute(command);
		}



		/*		{
			switch (command[0].toLowerCase())
			{

			case "commands" :

				break;

			case "help" :

				break;

			case "moveto" :

				break;

			case "lineto" :

				break;

			case "rect" :

				break;

			case "fillrect" :

				break;

			case "circle" :

				break;

			case "fillcircle" :

				break;

			case "pencolour" :

				break;

			case "penposition" :

				break;

			case "clear" :

				break;

			case "end" :

				break;

			case "load" :

				break;

			default :

			}	
		}
		 */
	}
}