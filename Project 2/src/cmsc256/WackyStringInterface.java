/****************************************************************************
 * Masrik Dahir
 * 19 February 2021
 * CMSC 256-901
 ****************************************************************************/
/****************************************************************************
Develop a Java class called RamString that correctly implements the WackyStringInterface. (The semantics of the methods in the interface can be determined from their name and from the Javadoc comments in the code. If not, please ask for clarification on the Discussion Board forum.) Add two constructors to your RamString class – one with a single string argument and a second, default, no-arg constructor. The no-argument constructor should set the instance variable to the string, "Let's Go Rams and CS@VCU!" and the value of the string should never be set to null.
Important note: This project is focused on character and String manipulation and you are not allowed to use regular expressions or any classes or methods that make use of regular expressions. You are to consult the Java API for methods in the String, StringBuilder or StringBuffer classes and use those methods or develop your own algorithms to implement the required functionality of these methods.
Write a test plan for class RamString using the Test Plan Template document. Specifically, you should create several different tests for each method in the interface. Make sure that the tests are not trivial (i.e., have a specific purpose). In other words, each test should:
test a specific piece of functionality and
check that the it behaves as expected. In addition, at least two of the tests for method convertDigitsToRomanNumeralsInSubstring should result in expected exceptions: MyIndexOutOfBoundsException (provided) in one case, and IllegalArgumentException in the other.
Add a concise comment to each test that you write to clarify its rationale (e.g., “This test checks whether the method convertDigitsToWordsInSubstring suitably throws an IllegalArgumentException if startPosition is greater than endPosition").
Notes:
You may NOT modify the provided interface, WackyStringInterface  download.
You must use the provided MyIndexOutOFBoundsException  downloadclass and may not change it.
I will run your code against a standard set of test cases in Gradescope to make sure that you implemented the functionality of the required methods correctly.
 
Write this program in JAVA and compile it in JDK 8. Be aware that Gradescope uses JDK version 8, so features in more recent releases may not work in Gradescope.
Follow all commenting conventions discussed in class and include a comment block at the top of your file with your name, date, the course number and section.
*****************************************************************************/
package cmsc256;

/**
 * This is an interface for a class that represents a string, 
 * defined as a sequence of characters. It provides methods 
 * that 
 */
public interface WackyStringInterface {

	/**
	 * Sets the value of the current string.
	 *
	 * @param string
	 *            The value to be set
	 */
	void setWackyString(String string);

	/**
	 * Returns the current string
	 *
	 * @return Current string
	 */
	String getWackyString();

	/**
	 * Returns a string that consists of all and only the characters
	 * in every third positions (i.e., third, sixth, and so on) in
	 * the current string, in the same order and with the same case as
	 * in the current string. The first character in the string is
	 * considered to be in Position 1.
	 *
	 * @return String made of characters in every third positions in the
	 * current string
	 */
	String getEveryThirdCharacter();

	/**
	 * Returns a string that consists of all and only the characters
	 * in either the odd positions (i.e., first, third, fifth, and so on)
	 * or in the even positions (i.e., second, fourth, sixth, and so on)
	 * current string, in the same order and with the same case as in
	 * the current string. The first character in the string is
	 * considered to be in Position 1.
	 * @param  String to determine if odd or even characters are to be returned.
	 * @return String made of characters in odd positions in the
	 * current string
	 * @throws  IllegalArgumentException if parameter is other than "odd" or "even"
	 */
	String getEvenOrOddCharacters(String evenOrOdd);

	/**
	 * Returns the number of characters that are digits in the current string
	 *  if two (and no more than two) of the same digit appear side by side.
	 *
	 * @return Number of double-digits in the current string
	 */
	int countDoubleDigits();

	/**
	 * Returns true if the current string contains on or more characters
	 * before an '@' character, followed by either "vcu.edu" or "mymail.vcu.edu"
     * For example, RodneyTheRam@vcu.edu a valid vcu email address also 
	 * and RamFan@gmail.com is not.
	 *
	 * @return true if current string is formated as valid VCU email address
	 * 	        Returns false otherwise.
	 */
	boolean isValidVCUEmail();
	
	/**
	 * Extracts a phone number (with area code) from this String and returns it 
	 * in a standard format with the area code in parenthesis followed by a 
	 * then a dash separating the third and fourth digits "(000) 000-0000"
	 * space if this string does not contain exactly 10 digits, returns the 
	 * message "This WackyString is not a phone number." 
	 * Note: any characters that are not digits should not be included
	 *   in the returned string.
	 *   For example: "Office phone: 804-828-7135" --> "(804) 828-7135"
	 * 
=	 * @return			String containing the formatted phone number
	 */
	String standardizePhoneNumber();

    /**
     * Replace all occurrences of a single zero (0) with the string "Go Rams"
	  * in the current string,
     * and all occurrences of a double zero (00) with the string "CS@VCU"
     */
    void ramifyString();

	/**
	 * Replace the _individual_ digits in the current string, between
	 * startPosition and endPosition (included), with the corresponding
	 * Roman numeral symbol(s). The first character in the string is
	 * considered to be in Position 1. Digits are converted individually,
	 * even if contiguous, and digit "0" is not converted (e.g., 460 is
	 * converted to IVVI0). In case you are not familiar with Roman
	 * numerals, see https://en.wikipedia.org/wiki/Roman_numerals
	 *
	 * @param startPosition  Position of the first character to consider
	 * @param endPosition    Position of the last character to consider
	 * @throws MyIndexOutOfBoundsException
	 *            If either "startPosition" or "endPosition" are out of
	 *            bounds (i.e., either less than 1 or greater than the
	 *            length of the string)
	 * @throws IllegalArgumentException
	 *            If "startPosition" > "endPosition" (but both are
	 *            within bounds)
	 */
	void convertDigitsToRomanNumeralsInSubstring(int startPosition, int endPosition)
			throws MyIndexOutOfBoundsException, IllegalArgumentException;
}
