/*
 * @author Joseph Gwynne-Jones
 * 
 * Student ID: c3383851
 * 
 * LeedsMet email: j.gwynne-jones4686@student.leedsmet.ac.uk
 */
import java.util.Scanner;

public class PhotoShop {

	private static Scanner input;

//	enum Commands //set up an enumerated type for commands. This would only allow a fixed list and can be added to easily.
//	{
//		help,
//		commands,
//		lineto,
//		moveto,
//		circle,
//		rect,
//		clear,
//		end;
//	};

	public static void main(String[] args) {

		String command;
		input = new Scanner (System.in);
//		GraphicsScreen g = new GraphicsScreen();
		Draw execute = new Draw();

		System.out.println("Welcome to Photoshop!");
		System.out.println("The graphical output is 500 unit wide and 400 units high by default.");
		System.out.println("The window is sizeable.The 0,0 point is located at the upper-left of the screen.");
		System.out.println("Hence increasing X values move right and increasing Y values move down.");
		System.out.println("Type 'help' for a guide and 'end' to finish");
		System.out.println("Type your commands below");

		do
		{ // start a do..while to run loop until the word "end" is entered.

			// declare a string array to store entered text	
			String [] userCommand;	

			do
			{// start a do...while loop - if too many words are entered, give an error message and repeat
				// the loop exits if there are 3 words or less entered (ie lineto 54 34 is valid as is sdfg sadfd ewew)

				command = input.nextLine();
				command = command.trim();

				// split the text into multiple elements by using a space " ",
				// as the separator and store in an array of String

				userCommand = command.split(" "); //with thanks to Mark Dixon for his SimpleParser code to split text

				if ( userCommand.length > 4 )
				{
					System.out.println("Error! Too many parameters entered!");
					System.out.println("Type commands for a list of all commands");
					System.out.println("Type help <command> for instructions on a command");
				}

			} while (userCommand.length < 5 == false);
			
			execute.runCommand(processCommand); //Execute the 


		} while (command.toLowerCase().equals("end") == false); 
		// !(something) - with a ! in front of brackets is NOT so for the above it need to be FALSE to exit loop
		//do..while loop ends when "end" is entered, it is case-insensitive: END, End, eNd all work
		// .trim() is also used to remove any whitespaces after 'end' is typed (so if a user input 'end  ' - this will still exit)
		System.out.println("Thank you for using the program!");
//		g.close(); //this close the drawing frame window
		input.close(); //close the text input as well
	}
}