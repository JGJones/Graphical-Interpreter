
public class Validation 
{
	String[] commandlist = //array of all commands in use
		{
		"moveto", 		//0
		"lineto", 		//1
		"rect",			//2
		"fillrect",		//3
		"circle",		//4
		"fillcircle",	//5
		"pencolour",	//6
		"penposition",	//7
		"clear",		//8
		"load",			//9
		"commands",		//10
		"end",			//11
		"help",			//12
		"moo",			//13
		"moverel",		//14
		"linerel"		//15
		};

	int[] paramlist = //list of how many parameters each commands can have
		{
		2,	//		"moveto", 		//0
		2,	//		"lineto", 		//1
		2,	//		"rect",			//2
		2,	//		"fillrect",		//3
		1,	//		"circle",		//4
		1,	//		"fillcircle",	//5
		3,	//		"pencolour",	//6
		0,	//		"penposition",	//7
		0,	//		"clear",		//8
		3,	//		"load",			//9  
		0,	//		"commands",		//10
		0,	//		"end",			//11
		1,	//		"help",			//12
		0,	//		"moo"			//13
		2,	//		"moverel"		//14
		2	//		"linerel"		//15
		};
	
	public boolean commandcheck(String[] command)
	{
		
		int n = 0;
		boolean validcmd = false ,validparam = false, valid = false;

		while (n < commandlist.length)
		{

			if (command[0].equals(commandlist[n]) == true)
			{
				validcmd = true;
				
				if (command[0].equals("load") && command.length == 2) // in this case, we want command[1] to remain as string so this exits the loop without parsing
				{
					validparam = true;	
					break;
				}
				
				if ((command.length - 1) == paramlist[n])
				{
					int x = 0;

					if (command[0].equals("load"))
					{
						x++;
					}

					try 

					{ // Always expect the unexpected! If parseInt attempt to parse letters it throws a
						// NumberFormatException so using a try...catch statement to deal with unexpected inputs
						Integer.parseInt(command[1+x]);
						if (command.length > 2+x)
						{
							Integer.parseInt(command[2+x]);
						} if (command.length > 3+x)
						{
							Integer.parseInt(command[3+x]);
						} 		
					} catch (NumberFormatException e)
					{
						break;
					}

					validparam = true;
					break;
				}

			} 
			n++;
		}

		if (validcmd == false)
		{
			System.out.println("Please type \"help "+command[0]+"\" if you need help with \""+command[0]+"\".");
			System.out.println("The command \""+ command[0] + "\" is not valid!");
		} else if (validparam == false)
		{
			System.out.println("Please type \"help "+command[0]+"\" if you need help with \""+command[0]+"\".");
			System.out.println("The command \""+ command[0] + "\" does not have valid parameters!");
		} else if (validparam == true && validcmd == true)
		{
			valid = true;
		}
		return valid;
	}

	public boolean loadparam (String command)
	{
		
		if (command.equals(commandlist[0]) || command.equals(commandlist[1])) //check if it match moveto or lineto
		{
			return true;
		}else
		{
			return false;
		}
			
	}
	
//	public boolean paramCheck (String[] params, int maxparam)
//	{
//
//
//		if ( params.length == (maxparam + 1) ) //need to add one to include 1st word as it's counting an array.
//		{
//			return true; // all good!
//		}
//		else // not good, print out error message and return false
//		{
//			switch (maxparam)
//			{
//			case 1 :
//				System.out.println("Please enter a single parameter for " + params[0]);
//				System.out.println("Please type \"help " + params[0] + "\" if you need help with " + params[0]);
//				break;
//
//			default :
//				System.out.println("Please enter "+ maxparam +" parameters for " + params[0]);
//				System.out.println("Please type \"help " + params[0] + "\" if you need help with " + params[0]);
//
//			}
//
//			return false;
//		}
//	}
//
//	public boolean valid (String[] command, int n)
//	{
//
//		//int firstPar,secondPar,thirdPar;
//		boolean valid = true; //Assume it's a valid command to start with and do checks to confirm below
//
//		if ( valid == true) 
//		{
//			try 
//
//			{ // Always expect the unexpected! If parseInt attempt to parse letters it throws a
//				// NumberFormatException so using a try...catch statement to deal with unexpected inputs
//				Integer.parseInt(command[1+n]);
//				if (command.length > 2+n)
//				{
//					Integer.parseInt(command[2+n]);
//				} if (command.length > 3+n)
//				{
//					Integer.parseInt(command[3+n]);
//				} 		
//			} catch (NumberFormatException e)
//			{
//				System.out.println("Enter the correct values for the parameters!");
//				System.out.println("Please type \"help "+command[0]+"\" if you need help with \""+command[0]+"\".");
//				valid = false;
//			}
//		}
//
//		if (valid == false)
//		{
//			return false;
//		} else
//		{
//			return true;
//		}
//	}
}
