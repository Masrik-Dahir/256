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

public class MyIndexOutOfBoundsException extends RuntimeException {

	public MyIndexOutOfBoundsException(String message) {
		super(message);
	}

	public MyIndexOutOfBoundsException() {
		super();
	}
}
