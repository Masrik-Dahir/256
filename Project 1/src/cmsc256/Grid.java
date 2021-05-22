/****************************************************************************
 * Masrik Dahir
 * 3 February 2021
 * CMSC 256-901
 ****************************************************************************/

/****************************************************************************
* Develop a Java class called Grid that correctly implements the specified methods. A grid is a 2-dimensional array that has 3 rows and 3 columns.

* The class has a parameterless constructor to create the 2-dimensional character array instance variable. You will implement a parameterless constructor to your Grid class to create the 2-dimensional character array instance variable. The remaining methods of the class all act upon the instance variable that represents the 2-D array. The semantics of the methods can be determined from their name and from the Javadoc comments in the starter code file. If not, please ask for clarification on the Discussion Board forum.

* This class and every other project file this semester must be implemented in a package called cmsc256. If you do not have the package named correctly, your code will not compile in Gradescope.

* Incomplete (skeleton) code is provided for you to help you get started with the project. If you choose not to use the starter code, you might have problems submitting to Gradescope for grading.

* Write this program in JAVA and compile it in JDK 8. Be aware that Gradescope uses JDK version 8, so features in more recent releases may not work in Gradescope.

* Follow all coding and commenting conventions posted in Canvas and include a comment block at the top of each file with your name, date, the course number and section.

* Upload the project source code file, Grid.java to Gradescope on or before the due date. 
*****************************************************************************/

package cmsc256;

public class Grid {


    private char [][] grid;

    /*
    * Initializes a 3 by 3 grid to default char values ('\u0000')
    * */
    public Grid() {
        this.grid = new char[3][3];
    }

    /**
     * Formats the grid row to a String that consists of a space, the char,
     *  a space, a vertical pipe, a space, the char, a space, a vertical pipe,
     * a space, the char, and a final space,
     * for example: " X | X | X "
     *
     * @param rowIndex  the index of the row to convert to a String
     * @return a formatted String representation of the row
     * @throws IllegalArgumentException if an invalid row index is given
     */
    public String getRow(int rowIndex) throws IllegalArgumentException{
        String result = "";
        if (rowIndex >= 0 && rowIndex <= 2){
            result = " " + grid[rowIndex][0] + " | " + grid[rowIndex][1]+ " | " + grid[rowIndex][2] + " ";

        }
        else{
            throw new IllegalArgumentException();
        }
        return result.replaceAll("\u0000", " ");
    }

    /**
     * Sets the grid location to the given value
     * @param value         char value for the grid location
     * @param rowIndex      the index of the row position
     * @param columnIndex   the index of the column position
     * @throws IllegalArgumentException if the row index or column index is invalid
     *                                  or if the position is not null
     */
    public void setPosition(char value, int rowIndex, int columnIndex) throws IllegalArgumentException{
        if (rowIndex <= 2 && rowIndex >= 0 && columnIndex <= 2 && columnIndex >=0 && value != '\u0000' && grid[rowIndex][columnIndex] == '\u0000'){
            this.grid[rowIndex][columnIndex] = value;
        }
        else{
            throw new IllegalArgumentException();
        }
    }

    /**
     * Checks for valid input value
     * @param inputValue the char value to be checked
     * @return true if input value is X, x, O, or o
     * @throws IllegalArgumentException if character is not X or O
     */
    public boolean checkInput(char inputValue) throws IllegalArgumentException{
        if (inputValue == 'X' || inputValue == 'x' || inputValue == 'O' || inputValue == 'o' ) {
            return true;
        }
        else if (inputValue == '\u0000'){
            return false;
        }
        else{
            throw new IllegalArgumentException();
        }
    }

    /**
     * Checks if all positions have a char value
     * @return true if none of the grid locations contain the null character ('\u0000')
     */
    public boolean isFull(){
        int n = 0;
        for (int row = 0; row < grid.length;row++){
            for (int column = 0; column < grid[row].length; column++) {
                if (grid[row][column] != '\u0000'){
                    n += 1;
                }
            }
        }
        if (n == 9){
            return true;
        }
        else{
            return false;
        }

    }

    /**
     *  Check if row has all the same characters
     * @param rowIndex  the row index to check
     * @return  true if row contains the same char value
     * @throws IllegalArgumentException if an invalid row index is given
     */
    public boolean isRowMatching(int rowIndex) throws IllegalArgumentException{
        if (rowIndex >= 0 && rowIndex <= 2) {
            if (Character.toLowerCase(grid[rowIndex][0]) == Character.toLowerCase(grid[rowIndex][1]) &&
                    Character.toLowerCase(grid[rowIndex][1]) == Character.toLowerCase(grid[rowIndex][2]) &&
                    (checkInput(grid[rowIndex][0]))) {
                return true;
            } else {
                return false;
            }
        }else{
            throw new IllegalArgumentException();
        }

    }

    /**
     * Check if column has all the same characters
     * @param columnIndex   the column index to check
     * @return  true if column contains the same char value
     * @throws IllegalArgumentException if an invalid column index is given
     */
    public boolean isColumnMatching(int columnIndex) throws IllegalArgumentException{
        if (columnIndex >= 0 && columnIndex <= 2) {
            if (Character.toLowerCase(grid[0][columnIndex]) == Character.toLowerCase(grid[1][columnIndex]) &&
                    Character.toLowerCase(grid[1][columnIndex]) == Character.toLowerCase(grid[2][columnIndex]) &&
                    (checkInput(grid[0][columnIndex]))) {
                return true;
            } else {
                return false;
            }
        }else{
            throw new IllegalArgumentException();
        }
    }

    /**
     * Checks if either diagonal has the same characters
     * @return true if grid position 0,0; 1,1; and 2,2 are the same
     *              if grid position 2,0; 1,1; and 0,2 are the same
     */
    public boolean hasDiagonalMatch(){

        if (Character.toLowerCase(grid[0][0]) == Character.toLowerCase(grid[1][1]) &&
                Character.toLowerCase(grid[1][1]) == Character.toLowerCase(grid[2][2]) &&
                (checkInput(grid[0][0]))) {
            return true;
        }
        else if(Character.toLowerCase(grid[2][0]) == Character.toLowerCase(grid[1][1]) &&
                Character.toLowerCase(grid[1][1]) == Character.toLowerCase(grid[0][2]) &&
                (checkInput(grid[2][0]))){
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * Checks if there is a character with three in a row on the grid
     * @return winning character if there is a row, column or diagonal match
     *          otherwise returns the null character
     */
    public char checkForWinner(){
        for (int i = 0; i <= 2; i++) {
            if (isRowMatching(i)) {
                return grid[i][0];
            }
            else if (isColumnMatching(i)) {
                return grid[0][i];
            }
        }
        if (hasDiagonalMatch()) {
            return grid[1][1];
        } else {
            return '\u0000';
        }

    }

    @Override
    /**
     * Returns a string representation of the grid with each row separated by a line
     * @return string
     */
    public String toString() {
        String result = "";
        for (int i = 0; i<grid.length; i++){
            result += getRow(i) + "\n";
            if(i<2){
                result += "---------\n";
            }
        }
        return result;
    }

}
