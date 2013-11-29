
public class Validation 
{

	
	private class Params 
	{
		
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
	}
	
	public boolean valid (String[] command)
	{

		//int firstPar,secondPar,thirdPar;
		boolean valid = true; //Assume it's a valid command to start with and do checks to confirm below
		
		Params paramcheck = this.new Params();
		
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
