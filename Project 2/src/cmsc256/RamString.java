/****************************************************************************
 * Masrik Dahir
 * 19 February 2021
 * CMSC 256-901
 ****************************************************************************/
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
