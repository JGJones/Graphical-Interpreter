/**
 * 
 * This code shows how a string can be split up into a number of separate words.
 * 
 * @author M. Dixon
 *
 */
public class SimpleParser {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		

		String text = "this is some text";				// define some text
		
		String [] splitupText = text.split(" ");		// split the text into multiple elements, and store in an array of String
		
		String firstWord, secondWord, thirdWord;		// declare some variables to store the separate words
		
		if ( splitupText.length > 0 ) {					// test at least one word is available.
			
			firstWord = splitupText[0];					// get the first word
			
			if ( splitupText.length > 2 ) {
				
				secondWord = splitupText[1];			// get the second word
				
				if ( splitupText.length > 3 ) {
					
					thirdWord = splitupText[2];			// get the third word
					
					System.out.println("The first three words are:  1) " + firstWord + ", 2) " + secondWord + ", 3) " + thirdWord);
				}
			}
		}
	}

}