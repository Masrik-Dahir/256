/****************************************************************************
 * Masrik Dahir
 * 04 Match 2021
 * CMSC 256-901
 ****************************************************************************/
/****************************************************************************
Write a Java class CustomDate that represents a calendar date consisting of a month, day, and year.  Use three data fields of type int to represent the date.  For example, July 4, 1776, is month 7, day 4, and year 1776.  There should be no other instance variables other than these three integer values.

Use the same package structure as for the previous projects: package cmsc256;
Write both default and parameterized constructors – the default date should be set to January 1, 1900.
Setter methods (setDay, setMonth, setYear) with one argument to change the day month or year (the month setter is overloaded – one setter to accept an integer value and the other to accept a String representing the month);
Getter methods (getDay, getMonth, getYear) that return the day, month, or year as an int;
A toString method (public String toString()).
In addition, provide methods that
Determine whether the current year is a leap year (public boolean isLeapYear())
Advance the current date by one day (public void advanceOneDay())
Advance the current date by one week (public void advanceOneWeek())
Override the equals method from Object (public boolean equals(Object obj))
Compares this CustomDate object with the object passed as a parameter for chronological order and returns a negative integer, zero, or a positive integer, if this object is less than, equal to, or greater than the specified object. (public int compareTo (CustomDate obj) )
 

A year is a leap year if it is divisible by 4 but not by 100.  If the year is divisible by 100, it is a leap year only if it is also divisible by 400.

           

Write a class to test your class called CustomDateTest using JUnit4 as done in the lab assignment for the previous project. You will submit your JUnit test class as part of your grade.

You will submit your CustomDate.java file into Gradescope. However, I will test your class with my own JUnit tests for your grade after the due date.

Write this program in JAVA and compile it in JDK 8 or better.  Follow all commenting conventions discussed in class and include a comment block at the top of each file with your name, date, the course number and section. In addition, the comment block at the top of the test class must include a description of the test program purpose.
*******************************************************************************/
package cmsc256;

public class CustomDate implements Comparable<CustomDate>  {

    /*
     * Instance variables
     */
    private int day;
    private int month;
    private int year;

    /*
     * Default constructor
     */
    public CustomDate(){
        this.day = 1;
        this.month =  1;
        this.year = 1900;
    }

    /*
     * int, int, int constructor
     */
    public CustomDate(int newMonth, int newDay, int newYear){
        if (newMonth > 0 && newMonth <= 12 && newYear > 0 &&
                newYear <= 9999 && valid(newDay, newMonth, newYear)) {
            this.day = newDay;
            this.month = newMonth;
            this.year = newYear;
        }
        else{
            throw new IllegalArgumentException();
        }
    }

    /*
     * string, int, int constructor
     */
    public CustomDate(String newMonth, int newDay, int newYear){
        if (newYear > 0 && newYear <= 9999 && convertMonth(newMonth) >= 1 &&
                convertMonth(newMonth) <= 12 && valid(newDay, convertMonth(newMonth), newYear)) {
            this.day = newDay;
            this.month = convertMonth(newMonth);
            this.year = newYear;
        }
        else{
            throw new IllegalArgumentException();
        }
    }

    /*
     * check if a date (day, month, year) is valid or not
     */
    private boolean valid(int day, int month, int year) {
        if (year >= 1 && year <= 9999) {
            if (month == 1 || month == 3 || month == 5 ||
                    month == 7 || month == 8 || month == 10 ||
                    month == 12) {
                if (day <= 31 && day >= 1) {
                    return true;
                } else {
                    return false;
                }
            } else if ((month == 4 || month == 6 ||
                    month == 9 || month == 11)) {
                if (day <= 30 && day >= 1) {
                    return true;
                } else {
                    return false;
                }
            } else if (month == 2) {
                if (((year%4 == 0 && year%100 != 0) || (year%400 == 0 && year%100 == 0)) && day <= 29 && day >= 1) {
                    return true;
                } else if (!((year%4 == 0 && year%100 != 0) || (year%400 == 0 && year%100 == 0) && day <= 29 && day >= 1) && day <= 28 && day >= 1) {
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }
        else{
            return false;
        }
    }

    /*
     * check if the year is leap year or not
     */
    public boolean isLeapYear(){
        if ((this.year%4 == 0 && this.year%100 != 0) || (this.year%400 == 0 && this.year%100 == 0)){
            return true;
        }
        else {
            return false;
        }
    }

    /*
     * Convert the String month name from constructor (String, int, int) into integer
     */
    private int convertMonth(String month){
        String month_lowercase = month.toLowerCase();
        int result;
        switch(month_lowercase) {
            case "january":
                result = 1;
                break;
            case "february":
                result = 2;
                break;
            case "march":
                result = 3;
                break;
            case "april":
                result = 4;
                break;
            case "may":
                result = 5;
                break;
            case "june":
                result = 6;
                break;
            case "july":
                result = 7;
                break;
            case "august":
                result = 8;
                break;
            case "september":
                result = 9;
                break;
            case "october":
                result = 10;
                break;
            case "november":
                result = 11;
                break;
            case "december":
                result = 12;
                break;
            default:
                throw new IllegalArgumentException();
        }
        return result;
    }

    /*
     * set the day of in the day instance variable
     */
    public void setDay(int newDay) {
        if (valid(newDay, this.month, this.year)){
            this.day = newDay;
        }
        else{
            throw new IllegalArgumentException();
        }
    }
    /*
     * set the month (int) in the month instance variable
     */
    public void setMonth(int newMonth) {
        if (newMonth >= 1 && newMonth <= 12){
            this.month = newMonth;
        }
        else{
            throw new IllegalArgumentException();
        }
    }
    /*
     * set the month (String) in the month instance variable
     */
    public void setMonth(String newMonth) {
        String month_lowercase = newMonth.toLowerCase();
        switch(month_lowercase) {
            case "january":
                this.month = 1;
                break;
            case "february":
                this.month = 2;
                break;
            case "march":
                this.month = 3;
                break;
            case "april":
                this.month = 4;
                break;
            case "may":
                this.month = 5;
                break;
            case "june":
                this.month = 6;
                break;
            case "july":
                this.month = 7;
                break;
            case "august":
                this.month = 8;
                break;
            case "september":
                this.month = 9;
                break;
            case "october":
                this.month = 10;
                break;
            case "november":
                this.month = 11;
                break;
            case "december":
                this.month = 12;
                break;
            default:
                throw new IllegalArgumentException();
        }
    }

    /*
     * set the year in year instance variable
     */
    public void setYear(int newYear) {
        if (newYear >= 1 && newYear <= 9999){
            this.year = newYear;
        }
        else{
            throw new IllegalArgumentException();
        }
    }
    /*
     * return the value of day instance variable
     */
    public int getDay() {
        return day;
    }
    /*
     * return the value of month instance variable
     */
    public int getMonth() {
        return month;
    }
    /*
     * return the value of year instance variable
     */
    public int getYear() {
        return year;
    }
    /*
     * compare two CustomDate object and return int values (-1, 0, 1)
     * representing greater than, equal, and less than respectively
     */
    @Override
    public int compareTo(CustomDate obj) {
        if (this.year > obj.year) {
            return 1;
        } else if (this.year < obj.year) {
            return -1;
        } else {
            if (this.month > obj.month) {
                return 1;
            } else if (this.month < obj.month) {
                return -1;
            } else {
                if (this.day > obj.day) {
                    return 1;
                } else if (this.day < obj.day) {
                    return -1;

                } else {
                    return 0;
                }
            }
        }


    }

    /*
     * return the instance variables in mm/dd/yyyy format
     */
    @Override
    public String toString() {
        String localDay;
        String localMonth;
        String localYear;
        // local day
        if (day >= 1 && day <= 9){
            localDay = "0" + Integer.toString(day);
        }
        else{
            localDay = Integer.toString(day);
        }

        // local month
        if (month >= 1 && month <= 9){
            localMonth = "0" + Integer.toString(month);
        }
        else{
            localMonth = Integer.toString(month);
        }

        // local year
        if (year >= 1 && year <= 9){
            localYear = "000" + Integer.toString(year);
        }
        else if (year >= 10 && year <= 99){
            localYear = "00" + Integer.toString(year);
        }
        else if (year >= 100 && year <= 999){
            localYear = "0" + Integer.toString(year);
        }
        else{
            localYear = Integer.toString(year);
        }

        return localMonth +
                "/" + localDay +
                "/" + localYear;
    }
    /*
     * set the instance variables to advance one day
     */
    public void advanceOneDay(){
        if (valid(this.day + 1, this.month, this.year)){
            this.day = this.day + 1;
        }
        else if (valid(1, this.month + 1, this.year)){
            this.day = 1;
            this.month = this.month + 1;
        }
        else if (valid(1, 1, this.year + 1)){
            this.day = 1;
            this.month = 1;
            this.year = this.year + 1;
        }
        else{
            throw new IllegalArgumentException();
        }
    }
    /*
     * set the instance variable to advance one week
     */
    public void advanceOneWeek(){
        if (valid(this.day + 7, this.month, this.year)){
            this.day = this.day + 7;
        }
        else if (valid(6, this.month + 1, this.year)){
            int lastDay = 0;
            int remaining;
            for (int d = 1; d <= 7; d ++){
                if (valid(this.day+d,this.month,this.year)){
                    lastDay = d;
                }
                else{
                    break;
                }
            }
            this.day = 7 - lastDay;
            this.month = this.month + 1;
        }
        else if (valid(6, 1, this.year + 1)){
            int lastDay = 0;
            int remaining;
            for (int d = 1; d <= 7; d ++){
                if (valid(this.day+d,this.month,this.year)){
                    lastDay = d;
                }
                else{
                    break;
                }
            }
            this.day = 7 - lastDay;
            this.month = 1;
            this.year = this.year + 1;
        }
        else{
            throw new IllegalArgumentException();
        }
    }

    /*
     * compare two CustomerDate object and returns whether they are equal or not
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CustomDate)) return false;
        CustomDate that = (CustomDate) o;
        return getDay() == that.getDay() && getMonth() == that.getMonth() && getYear() == that.getYear();
    }

}
