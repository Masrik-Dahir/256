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

public class RamString implements WackyStringInterface{

    private String ram;
    public RamString(){
        this.ram = "Let's Go Rams and CS@VCU!";

    }
    public RamString(String ram) {
        this.ram = ram;
        if (this.ram == null){
            throw new IllegalArgumentException();
        }
    }

    public void setRam(String ram) {
        this.ram = ram;
    }

    @Override
    public void setWackyString(String string) {
        if (string == null){
            throw new IllegalArgumentException();
        }
        else{
            setRam(string);
        }
    }

    @Override
    public String getWackyString() {
        return ram;
    }

    @Override
    public String getEveryThirdCharacter() {
        String result = "";
        for (int i = 1; i <= ram.length(); i++){
            if (i%3 == 0){
                result += ram.charAt(i-1);
            }
        }
        return result;
    }

    @Override
    public String getEvenOrOddCharacters(String evenOrOdd) {
        String result = "";
        if (evenOrOdd.equals("even")){
            for (int i = 1; i <= ram.length(); i++){
                if (i%2 == 0){
                    result += ram.charAt(i-1);
                }
            }
        }
        else if (evenOrOdd.equals("odd")){
            for (int i = 1; i <= ram.length(); i++){
                if (i%2 != 0){
                    result += ram.charAt(i-1);
                }
            }
        }
        else{
            throw new IllegalArgumentException();
        }
        return result;
    }
    @Override
    public int countDoubleDigits() {
        int result = 0;
        for (int i = 0; i < ram.length(); i++) {
            if (Character.isDigit(ram.charAt(i)) && (i != ram.length()-1)){
                if (i > 0 && Character.isDigit(ram.charAt(i-1)) && Character.isDigit(ram.charAt(i)) &&
                        Character.isDigit(ram.charAt(i+1)) && String.valueOf(ram.charAt(i)).equals(String.valueOf(ram.charAt(i + 1))) &&
                        String.valueOf(ram.charAt(i-1)).equals(String.valueOf(ram.charAt(i)))) {
                    result += 0;
                }
                else if (i >= 0 && i < ram.length() - 2 && Character.isDigit(ram.charAt(i)) && Character.isDigit(ram.charAt(i+1)) &&
                        Character.isDigit(ram.charAt(i+2)) && Character.isDigit(ram.charAt(i+2)) &&
                        String.valueOf(ram.charAt(i)).equals(String.valueOf(ram.charAt(i + 1))) &&
                        String.valueOf(ram.charAt(i)).equals(String.valueOf(ram.charAt(i + 2)))) {
                    result += 0;
                }
                else if (Character.isDigit(ram.charAt(i)) && Character.isDigit(ram.charAt(i+1)) && String.valueOf(ram.charAt(i)).equals(String.valueOf(ram.charAt(i + 1)))) {
                    result += 1;
                }
            }
        }
        return result;
    }

    @Override
    public boolean isValidVCUEmail() {
        boolean result = false;
        if (ram.endsWith("@vcu.edu") || ram.endsWith("@mymail.vcu.edu")){
            int extra = 0;
            if (ram.endsWith("@vcu.edu")){
                extra = "@vcu.edu".length();
            }
            else if (ram.endsWith("@mymail.vcu.edu")){
                extra = "@mymail.vcu.edu".length();
            }
            int user_id_length = ram.length() - extra;
            String user_id = ram.substring(0,user_id_length);
            if (user_id.length() >= 1){
                result = true;
                return result;
            }

        }
        return result;
    }

    @Override
    public String standardizePhoneNumber() {
        String only_digit = "";
        String result = "";
        for (int i = 0; i < ram.length(); i++){
            if (Character.isDigit(ram.charAt(i))){
                only_digit += ram.charAt(i);
            }
        }
        if (only_digit.length() != 10){
            result = "This WackyString is not a phone number.";
        }
        else{
            result = "(" + only_digit.substring(0,3) + ") " + only_digit.substring(3,6) + "-" + only_digit.substring(6,10);
        }
        return result;
    }

    @Override
    public void ramifyString() {
        String pre = "";
        String result = "";
        for (int i = 0; i < ram.length(); i++){
            if (Character.isDigit(ram.charAt(i)) && (i != ram.length()-1)) {
                if (ram.length() >=3 && i <= ram.length()-3 && String.valueOf(ram.charAt(i)).equals("0") && String.valueOf(ram.charAt(i + 1)).equals("0") && String.valueOf(ram.charAt(i + 2)).equals("0")){
                    this.ram = ram;
                }
                else if (i > 0 && i <= ram.length()-2 && ram.length() >=3 && String.valueOf(ram.charAt(i)).equals("0") && String.valueOf(ram.charAt(i + 1)).equals("0") && String.valueOf(ram.charAt(i - 1)).equals("0")){
                    this.ram = ram;
                }
                else if (i > 1 && i <= ram.length()-1 && ram.length() >=3 && String.valueOf(ram.charAt(i)).equals("0") && String.valueOf(ram.charAt(i - 1)).equals("0") && String.valueOf(ram.charAt(i - 2)).equals("0")){
                    this.ram = ram;
                }
                else if (String.valueOf(ram.charAt(i)).equals("0") && String.valueOf(ram.charAt(i + 1)).equals("0")) {
                    pre = ram.substring(0,i);
                    this.ram = pre + "CS@VCU" + ram.substring(i+2,ram.length());
                }
            }
        }
        for (int i = 0; i < ram.length(); i++) {
            if (ram.length() >=3 && i <= ram.length()-3 && String.valueOf(ram.charAt(i)).equals("0") && String.valueOf(ram.charAt(i + 1)).equals("0") && String.valueOf(ram.charAt(i + 2)).equals("0")){
                this.ram = ram;
            }
            else if (i > 0 && i <= ram.length()-2 && ram.length() >=3 && String.valueOf(ram.charAt(i)).equals("0") && String.valueOf(ram.charAt(i + 1)).equals("0") && String.valueOf(ram.charAt(i - 1)).equals("0")){
                this.ram = ram;
            }
            else if (i > 1 && i <= ram.length()-1 && ram.length() >=3 && String.valueOf(ram.charAt(i)).equals("0") && String.valueOf(ram.charAt(i - 1)).equals("0") && String.valueOf(ram.charAt(i - 2)).equals("0")){
                this.ram = ram;
            }
            else if (String.valueOf(ram.charAt(i)).equals("0")) {
                pre = ram.substring(0, i);
                this.ram = pre + "Go Rams" + ram.substring(i + 1, ram.length());
            }
        }
        System.out.println(ram);

    }

    @Override
    public void convertDigitsToRomanNumeralsInSubstring(int startPosition, int endPosition) throws MyIndexOutOfBoundsException, IllegalArgumentException {
        String pre = "";
        String result = "";
        if (startPosition < 1 || endPosition > ram.length()){
            throw new MyIndexOutOfBoundsException();
        }
        else if(startPosition > endPosition){
            throw new IllegalArgumentException();
        }
        else {
            for (int i = startPosition; i <= endPosition; i++) {
                if (String.valueOf(ram.charAt(i-1)).equals("1")) {
                    this.ram = ram.substring(0, i-1) + "I" + ram.substring(i, ram.length());
                }
                if (String.valueOf(ram.charAt(i-1)).equals("2")) {
                    this.ram = ram.substring(0, i-1) + "II" + ram.substring(i, ram.length());
                    endPosition +=1;
                }
                if (String.valueOf(ram.charAt(i-1)).equals("3")) {
                    this.ram = ram.substring(0, i-1) + "III" + ram.substring(i, ram.length());
                    endPosition += 2;
                }
                if (String.valueOf(ram.charAt(i-1)).equals("4")) {
                    this.ram = ram.substring(0, i-1) + "IV" + ram.substring(i, ram.length());
                    endPosition += 1;
                }
                if (String.valueOf(ram.charAt(i-1)).equals("5")) {
                    this.ram = ram.substring(0, i-1) + "V" + ram.substring(i, ram.length());
                }
                if (String.valueOf(ram.charAt(i-1)).equals("6")) {
                    this.ram = ram.substring(0, i-1) + "VI" + ram.substring(i, ram.length());
                    endPosition += 1;
                }
                if (String.valueOf(ram.charAt(i-1)).equals("7")) {
                    this.ram = ram.substring(0, i-1) + "VII" + ram.substring(i, ram.length());
                    endPosition += 2;
                }
                if (String.valueOf(ram.charAt(i-1)).equals("8")) {
                    this.ram = ram.substring(0, i-1) + "VIII" + ram.substring(i, ram.length());
                    endPosition += 3;
                }
                if (String.valueOf(ram.charAt(i-1)).equals("9")) {
                    this.ram = ram.substring(0, i-1) + "IX" + ram.substring(i, ram.length());
                    endPosition += 1;
                }
            }
        }
    }

    public static void main(String[] args) {
        RamString ram = new RamString("can you convert 0 and 10 11…");
        ram.convertDigitsToRomanNumeralsInSubstring(20,28);
        System.out.println(ram.getWackyString());
    }

}
