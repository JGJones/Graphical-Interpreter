import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Process 
{
	int curX =0 , curY = 0 , RelX =0 , RelY =0;

	Validation check = new Validation();
	GraphicsScreen g = new GraphicsScreen();
	Run execute = this.new Run(); 
	LoadCommand load = this.new LoadCommand();

	private class Run // Execute the actual command and calls to the GraphicsScreen class for drawing
	{
		void Execute (String[] command, boolean Rel)
		{
			Help helpcommand = new Help();
		

			switch (command[0]) // run code based on what the first word is. If it's a valid command, it'll execute otherwise it's an error message
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

				//if ((check.paramCheck(command, 2) == true) && (check.valid(command,0) == true))
				if (check.commandcheck(command) == true)	
				{
					if (Rel == false)
					{
						g.moveTo(Integer.parseInt(command[1]), Integer.parseInt(command[2]));

						curX = Integer.parseInt(command[1]);
						curY = Integer.parseInt(command[2]);
					} else
					{
						int a,b;
						
						a = Integer.parseInt(command[1]);
						b = Integer.parseInt(command[2]);
						
						a = a + RelX;
						b = b + RelY;
						
						g.moveTo(a, b);
						curX = a;
						curY = b;
								
					}

				}

				break;

			case "lineto" :

				if (check.commandcheck(command) == true)
				{
					if (Rel == false)
					{
						g.lineTo(Integer.parseInt(command[1]), Integer.parseInt(command[2]));
						curX = Integer.parseInt(command[1]);
						curY = Integer.parseInt(command[2]);
					} else
					{
						int a,b;
						
						a = Integer.parseInt(command[1]);
						b = Integer.parseInt(command[2]);
						
						a = a + RelX;
						b = b + RelY;
						
						g.lineTo(a, b);
						
						curX = a;
						curY = b;
					}
				}
				break;

			case "rect" :

				if (check.commandcheck(command) == true)
				{
					g.Rect(Integer.parseInt(command[1]), Integer.parseInt(command[2]));
				}

				break;

			case "fillrect" :

				if (check.commandcheck(command) == true)
				{
					g.fillRect(Integer.parseInt(command[1]), Integer.parseInt(command[2]));
				}

				break;

			case "circle" :

				if (check.commandcheck(command) == true)

				{
					g.circle(Integer.parseInt(command[1]));
				}

				break;

			case "fillcircle" :

				if (check.commandcheck(command) == true)

				{
					g.fillCircle(Integer.parseInt(command[1]));
				}

				break;

			case "pencolour" :


				if (check.commandcheck(command) == true)
				{
					if ((Integer.parseInt(command[1]) >= 0) && (Integer.parseInt(command[1]) <= 255) && (Integer.parseInt(command[2]) >= 0) && (Integer.parseInt(command[2]) <= 255) && (Integer.parseInt(command[3]) >= 0) && (Integer.parseInt(command[3]) <= 255))
					{
						g.penColour(Integer.parseInt(command[1]), Integer.parseInt(command[2]), Integer.parseInt(command[3]));
					} else
					{
						System.out.println("RGB values must be a number between 0-255");
					}
				}

				break;

			case "penposition" :

				if ( command.length == 1 )
				{
					System.out.println("The current pen position is x: "+ curX + " and y: "+ curY);
				} else
				{
					System.out.println("All input(s) entered after penPosition is ignored");
					System.out.println("The current pen position is x: "+ curX + " and y: "+ curY);
				}


				break;

			case "load" :

				if (command.length == 1)
				{
					System.out.println("Please enter a filename!");
				} else
				{
					load.Execute(command);
				}
				break;

			case "clear" :

				g.clear();
				curX = 0;
				curY = 0;

				break;

			case "end" :

				if ( command.length > 1 )
				{
					System.out.println("I see that you are trying to quit the program.");
					System.out.println("Type end on its own to quit program. Does not end all life on planet.");
				} else
				{
					g.close(); //this close the drawing frame window
				}

				break;

			case "moo" : // Easter egg - copied from apt-get moo!

				System.out.println("		         (__)"); 
				System.out.println("		         (oo)"); 
				System.out.println("		   /------\\/"); 
				System.out.println("		  / |    ||");   
				System.out.println("		 *  /\\---/\\ ");
				System.out.println("		    ~~   ~~  "); 
				System.out.println("		....Have you mooed today?...");

				break;

			default :

				System.out.println("The command \""+ command[0] + "\" is not valid!");
				System.out.println("Type \"commands\" for a list of all commands");
				System.out.println("Type help <command> for instructions on a command");

			}

		}
	}

	private class LoadCommand // read from a file and process for parameters if needed
	{
		boolean rel = false;

		void Execute (String[] command)
		{
			try
			{
				Scanner s = new Scanner(new File(command[1]));// create a scanner which scans from a file
				String [] userCommand;	
				String line;	// stores the each line of text read from the file
				int x = 1;

				if (command.length == 2)
				{
					while ( s.hasNext() )
					{
						line = s.nextLine().trim();		// read the next line of text from the file, remove leading and ending whitespace as well.

						userCommand = line.toLowerCase().split(" "); // split text using a space " "

						if (/*(check.valid(userCommand, 0) == false) ||*/ check.commandcheck(userCommand) == false)
						{
							System.out.println("Error at line "+ x +" in file \""+ command[1]+"\"!");
							break;
						}

						x++;
						execute.Execute(userCommand,rel); // execute the line from file
					}
				}
				else if (command.length == 4 )
				{
					
					if (check.commandcheck(command) == true)
					{
						
						g.moveTo(Integer.parseInt(command[2]), Integer.parseInt(command[3])); //moveto $1 $2
						rel = true;
						
						while ( s.hasNext() )
						{
							line = s.nextLine().trim();		// read the next line of text from the file

							userCommand = line.toLowerCase().split(" "); // split text using a space " "
							if (/*(check.valid(userCommand, 0) == false) ||*/ check.commandcheck(userCommand) == false)
							{
								System.out.println("Error at line "+ x +" in file \""+ command[1]+"\"!");
								break;
							}
							x++;

							RelX = Integer.parseInt(command[2]);
							RelY = Integer.parseInt(command[3]);

							execute.Execute(userCommand,rel); // execute the line from file
						}
					}
				}
				else //if (command.length == 3)
				{
					System.out.println("You must have two parameters if using parameters for loading files");
				}

				s.close();

			}catch (FileNotFoundException e)
			{
				System.out.println("Error 404! File not found! Make sure the file \""+ command[1] +"\" does exist!");
			}

		}
	}

	public void processCommand (String[] command)
	{
		execute.Execute(command,false);
	}
}