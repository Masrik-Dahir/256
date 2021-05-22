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

import static org.junit.Assert.*;

public class CustomDateTest {

    /*
     * Testing with for leap year with an value divisible by 4, 100, and 400
     */
    @org.junit.Test
    public void isLeapYear1() {
        CustomDate cd = new CustomDate(12,3,2000);
        assertEquals(true,cd.isLeapYear());
    }
    /*
     * Testing with for leap year with an value divisible by 4 only
     */
    @org.junit.Test
    public void isLeapYear2() {
        CustomDate cd = new CustomDate(12,3,2012);
        assertEquals(true,cd.isLeapYear());
    }
    /*
     * Testing with for leap year with an value divisible by 4 and 100 but not 400
     */
    @org.junit.Test
    public void isLeapYear3() {
        CustomDate cd = new CustomDate(12,3,1900);
        assertEquals(false,cd.isLeapYear());
    }
    /*
     * Testing with for leap year with an value not divisible by 4
     */
    @org.junit.Test
    public void isLeapYear4() {
        CustomDate cd = new CustomDate(12,3,2021);
        assertEquals(false,cd.isLeapYear());
    }
    /*
     * Testing to set with a valid date when the default constructor (July 4, 1776) is set
     */
    @org.junit.Test
    public void setDay1() {
        CustomDate cd = new CustomDate();
        cd.setDay(31);
        assertEquals(31, cd.getDay());
    }
    /*
     * Testing to set with a invalid date when the default constructor (July 4, 1776) is set
     */
    @org.junit.Test (expected=IllegalArgumentException.class)
    public void setDay2() {
        CustomDate cd = new CustomDate();
        cd.setDay(32);
    }
    /*
     * Testing to set with a valid date when the first parameter constructor (March 1, 2021) is set
     */
    @org.junit.Test
    public void setDay3() {
        CustomDate cd = new CustomDate(3,1,2021);
        cd.setDay(31);
        assertEquals(31, cd.getDay());
    }
    /*
     * Testing to set with an invalid day when the first parameter constructor (March 1, 2021) is set
     */
    @org.junit.Test (expected = IllegalArgumentException.class)
    public void setDay4() {
        CustomDate cd = new CustomDate(3,1,2021);
        cd.setDay(34);
    }
    /*
     * Testing to set with a valid day when the second parameter constructor (March 31, 2021) is set
     */
    @org.junit.Test
    public void setDay5() {
        CustomDate cd = new CustomDate("march",31,2021);
        cd.setDay(16);
        assertEquals(16, cd.getDay());
    }
    /*
     * Testing to set with an invalid day when the second parameter constructor (March 31, 2021) is set
     */
    @org.junit.Test (expected = IllegalArgumentException.class)
    public void setDay6() {
        CustomDate cd = new CustomDate("march",31,2021);
        cd.setDay(46);
    }

    /*
     * Testing to setMonth with a valid month when the default constructor is called
     */
    @org.junit.Test
    public void setMonth1() {
        CustomDate cd = new CustomDate();
        cd.setMonth(12);
        assertEquals(12,cd.getMonth());
    }
    /*
     * Testing to setMonth with an invalid month when the default constructor is called
     */
    @org.junit.Test (expected = IllegalArgumentException.class)
    public void setMonth2() {
        CustomDate cd = new CustomDate();
        cd.setMonth(0);
    }
    /*
     * Testing to setMonth with a valid month when the first parameter constructor is called
     */
    @org.junit.Test
    public void setMonth3() {
        CustomDate cd = new CustomDate(9,28,2021);
        cd.setMonth(1);
        assertEquals(1,cd.getMonth());
    }
    /*
     * Testing to setMonth with an invalid month when the first parameter constructor is called
     */
    @org.junit.Test (expected = IllegalArgumentException.class)
    public void setMonth4() {
        CustomDate cd = new CustomDate(8,30,2019);
        cd.setMonth(14);
    }
    /*
     * Testing to setMonth with a valid month when the second parameter constructor is called
     */
    @org.junit.Test
    public void setMonth5() {
        CustomDate cd = new CustomDate("march",31,2021);
        cd.setMonth(5);
        assertEquals(5,cd.getMonth());
    }
    /*
     * Testing to setMonth with an invalid month when the second parameter constructor is called
     */
    @org.junit.Test (expected = IllegalArgumentException.class)
    public void setMonth6() {
        CustomDate cd = new CustomDate("march",31,2021);
        cd.setMonth(15);
    }
    /*
     * Testing to setYear with a valid year when the default constructor is called
     */
    @org.junit.Test
    public void setYear1() {
        CustomDate cd = new CustomDate();
        cd.setYear(9999);
        assertEquals(9999,cd.getYear());
    }
    /*
     * Testing to setYear with an invalid year when the default constructor is called
     */
    @org.junit.Test (expected = IllegalArgumentException.class)
    public void setYear2() {
        CustomDate cd = new CustomDate();
        cd.setYear(10000);
    }
    /*
     * Testing to setYear with a valid year when the first parameter constructor is called
     */
    @org.junit.Test
    public void setYear3() {
        CustomDate cd = new CustomDate(9,28,2021);
        cd.setYear(2035);
        assertEquals(2035,cd.getYear());
    }
    /*
     * Testing to setYear with an invalid year when the first parameter constructor is called
     */
    @org.junit.Test (expected = IllegalArgumentException.class)
    public void setYear4() {
        CustomDate cd = new CustomDate(8,30,2019);
        cd.setYear(0);
    }
    /*
     * Testing to setYear with a valid year when the second parameter constructor is called
     */
    @org.junit.Test
    public void setYear5() {
        CustomDate cd = new CustomDate("march",31,2021);
        cd.setYear(5);
        assertEquals(5,cd.getYear());
    }
    /*
     * Testing to setYear with an invalid year when the second parameter constructor is called
     */
    @org.junit.Test (expected = IllegalArgumentException.class)
    public void setYear6() {
        CustomDate cd = new CustomDate("march",31,2021);
        cd.setYear(23456);
    }
    /*
     * Testing getDay when the default constructor is called
     */
    @org.junit.Test
    public void getDay1() {
        CustomDate cd = new CustomDate();
        assertEquals(1,cd.getDay());
    }
    /*
     * Testing getDay when the first parameter constructor is called
     */
    @org.junit.Test
    public void getDay2() {
        CustomDate cd = new CustomDate(12, 24, 1971);
        assertEquals(24,cd.getDay());
    }
    /*
     * Testing getDay when the second parameter constructor is called
     */
    @org.junit.Test
    public void getDay3() {
        CustomDate cd = new CustomDate("septembeR",21,1996);
        assertEquals(21,cd.getDay());
    }
    /*
     * Testing getMonth when the default constructor is called
     */
    @org.junit.Test
    public void getMonth1() {
        CustomDate cd = new CustomDate();
        assertEquals(1,cd.getMonth());
    }
    /*
     * Testing getMonth when the first parameter constructor is called
     */
    @org.junit.Test
    public void getMonth2() {
        CustomDate cd = new CustomDate(12, 24, 1971);
        assertEquals(12,cd.getMonth());
    }
    /*
     * Testing getMonth when the second parameter constructor is called
     */
    @org.junit.Test
    public void getMonth3() {
        CustomDate cd = new CustomDate("septembeR",21,1996);
        assertEquals(9,cd.getMonth());
    }
    /*
     * Testing getYear when the default constructor is called
     */
    @org.junit.Test
    public void getYear1() {
        CustomDate cd = new CustomDate();
        assertEquals(1900,cd.getYear());
    }
    /*
     * Testing getYear when the first parameter constructor is called
     */
    @org.junit.Test
    public void getYear2() {
        CustomDate cd = new CustomDate(12, 24, 1971);
        assertEquals(1971,cd.getYear());
    }
    /*
     * Testing getYear when the second parameter constructor is called
     */
    @org.junit.Test
    public void getYear3() {
        CustomDate cd = new CustomDate("septembeR",21,1996);
        assertEquals(1996,cd.getYear());
    }
    /*
     * Testing compareTo when the the first day is greater than the second day
     */
    @org.junit.Test
    public void compareTo1() {
        CustomDate first = new CustomDate(12, 03,2020);
        CustomDate second = new CustomDate(12, 02, 2020);
        assertEquals(1, first.compareTo(second));

    }
    /*
     * Testing compareTo when the the first day is equal to the second day
     */
    @org.junit.Test
    public void compareTo2() {
        CustomDate first = new CustomDate(12, 03,2020);
        CustomDate second = new CustomDate(12, 03, 2020);
        assertEquals(0, first.compareTo(second));

    }
    /*
     * Testing compareTo when the the first day is less than the second day
     */
    @org.junit.Test
    public void compareTo3() {
        CustomDate first = new CustomDate(12, 02,2020);
        CustomDate second = new CustomDate(12, 03, 2020);
        assertEquals(-1, first.compareTo(second));

    }
    /*
     * Testing compareTo when the the first month is greater than the second month
     */
    @org.junit.Test
    public void compareTo4() {
        CustomDate first = new CustomDate(12, 1,2020);
        CustomDate second = new CustomDate(11, 1, 2020);
        assertEquals(1, first.compareTo(second));

    }
    /*
     * Testing compareTo when the the first month is equal to the second month
     */
    @org.junit.Test
    public void compareTo5() {
        CustomDate first = new CustomDate(12, 1,2020);
        CustomDate second = new CustomDate(12, 1, 2020);
        assertEquals(0, first.compareTo(second));

    }
    /*
     * Testing compareTo when the the first month is less than the second month
     */
    @org.junit.Test
    public void compareTo6() {
        CustomDate first = new CustomDate(11, 1,2020);
        CustomDate second = new CustomDate(12, 1, 2020);
        assertEquals(-1, first.compareTo(second));

    }
    /*
     * Testing compareTo when the the first year is greater than the second year
     */
    @org.junit.Test
    public void compareTo7() {
        CustomDate first = new CustomDate(12, 1,2021);
        CustomDate second = new CustomDate(12, 1, 2020);
        assertEquals(1, first.compareTo(second));

    }
    /*
     * Testing compareTo when the the first year is equal to the second year
     */
    @org.junit.Test
    public void compareTo8() {
        CustomDate first = new CustomDate(12, 1,2020);
        CustomDate second = new CustomDate(12, 1, 2020);
        assertEquals(0, first.compareTo(second));

    }
    /*
     * Testing compareTo when the the first year is less than the second year
     */
    @org.junit.Test
    public void compareTo9() {
        CustomDate first = new CustomDate(12, 1,2020);
        CustomDate second = new CustomDate(12, 1, 2021);
        assertEquals(-1, first.compareTo(second));

    }
    /*
     * Testing toString with default constructor
     */
    @org.junit.Test
    public void testToString1() {
        CustomDate cd = new CustomDate();
        assertEquals("01/01/1900", cd.toString());
    }
    /*
     * Testing toString with first parameter constructor
     */
    @org.junit.Test
    public void testToString2() {
        CustomDate cd = new CustomDate(1,5,34);
        assertEquals("01/05/0034", cd.toString());
    }
    /*
     * Testing toString with second parameter constructor
     */
    @org.junit.Test
    public void testToString3() {
        CustomDate cd = new CustomDate("december",3,9999);
        assertEquals("12/03/9999", cd.toString());
    }
    /*
     * Testing toString for correct dd/mm/yyyy format
     */
    @org.junit.Test
    public void testToString4() {
        CustomDate cd = new CustomDate(1,1,1);
        assertEquals("01/01/0001", cd.toString());
    }
    /*
     * advancing one day that is not the last day of the month
     */
    @org.junit.Test
    public void advanceOneDay1() {
        CustomDate cd = new CustomDate(11, 29, 2020);
        cd.advanceOneDay();
        assertEquals("11/30/2020", cd.toString());

    }
    /*
     * advancing one day that is the last day of the month
     */
    @org.junit.Test
    public void advanceOneDay2() {
        CustomDate cd = new CustomDate(2, 29, 2020);
        cd.advanceOneDay();
        assertEquals("03/01/2020", cd.toString());

    }
    /*
     * advancing one day that is the last day of the year
     */
    @org.junit.Test
    public void advanceOneDay3() {
        CustomDate cd = new CustomDate(12, 31, 1999);
        cd.advanceOneDay();
        assertEquals("01/01/2000", cd.toString());

    }
    /*
     * advancing one day that is the last day of the year 9999
     */
    @org.junit.Test (expected = IllegalArgumentException.class)
    public void advanceOneDay4() {
        CustomDate cd = new CustomDate(12, 31, 9999);
        cd.advanceOneDay();
    }
    /*
     * advancing one day after default constructor
     */
    @org.junit.Test
    public void advanceOneDay5() {
        CustomDate cd = new CustomDate();
        cd.advanceOneDay();
        assertEquals("01/02/1900", cd.toString());
    }
    /*
     * advancing one day after first parameter constructor
     */
    @org.junit.Test
    public void advanceOneDay6() {
        CustomDate cd = new CustomDate(11, 30, 9999);
        cd.advanceOneDay();
        assertEquals("12/01/9999", cd.toString());

    }
    /*
     * advancing one day after second parameter constructor
     */
    @org.junit.Test
    public void advanceOneDay7() {
        CustomDate cd = new CustomDate("march", 23, 2022);
        cd.advanceOneDay();
        assertEquals("03/24/2022", cd.toString());
    }
    /*
     * advancing one week that is not the last week of the month
     */
    @org.junit.Test
    public void advanceOneWeek1() {
        CustomDate cd = new CustomDate(11, 20, 2020);
        cd.advanceOneWeek();
        assertEquals("11/27/2020", cd.toString());

    }
    /*
     * advancing one week that is the last week of the month
     */
    @org.junit.Test
    public void advanceOneWeek2() {
        CustomDate cd = new CustomDate(2, 29, 2020);
        cd.advanceOneWeek();
        assertEquals("03/07/2020", cd.toString());

    }
    /*
     * advancing one week that is the last week of the year
     */
    @org.junit.Test
    public void advanceOneWeek3() {
        CustomDate cd = new CustomDate(12, 31, 1999);
        cd.advanceOneWeek();
        assertEquals("01/07/2000", cd.toString());

    }
    /*
     * advancing one week that is the last week of the year 9999
     */
    @org.junit.Test (expected = IllegalArgumentException.class)
    public void advanceOneWeek4() {
        CustomDate cd = new CustomDate(12, 26, 9999);
        cd.advanceOneWeek();
    }
    /*
     * advancing one week after default constructor
     */
    @org.junit.Test
    public void advanceOneWeek5() {
        CustomDate cd = new CustomDate();
        cd.advanceOneWeek();
        assertEquals("01/08/1900", cd.toString());
    }
    /*
     * advancing one week after first parameter constructor
     */
    @org.junit.Test
    public void advanceOneWeek6() {
        CustomDate cd = new CustomDate(11, 30, 9999);
        cd.advanceOneWeek();
        assertEquals("12/07/9999", cd.toString());

    }
    /*
     * advancing one week after second parameter constructor
     */
    @org.junit.Test
    public void advanceOneWeek7() {
        CustomDate cd = new CustomDate("march", 23, 2022);
        cd.advanceOneWeek();
        assertEquals("03/30/2022", cd.toString());
    }
    /*
     * Test equals() with default constructor
     */
    @org.junit.Test
    public void testEquals1() {
        CustomDate first = new CustomDate();
        CustomDate second = new CustomDate();
        assertEquals(true, first.equals(second));
    }
    /*
     * Test equals() with first parameter constructor
     */
    @org.junit.Test
    public void testEquals2() {
        CustomDate first = new CustomDate(12,23,2021);
        CustomDate second = new CustomDate(12,23,2021);
        assertEquals(true, first.equals(second));
    }
    /*
     * Test equals() with default constructor
     */
    @org.junit.Test
    public void testEquals3() {
        CustomDate first = new CustomDate("march",4,2025);
        CustomDate second = new CustomDate("MARCH", 4, 2025);
        assertEquals(true, first.equals(second));
    }
    /*
     * Test equals() with same value and different constructor
     */
    @org.junit.Test
    public void testEquals4() {
        CustomDate first = new CustomDate();
        CustomDate second = new CustomDate(1,1,1900);
        assertEquals(true, first.equals(second));
    }
    /*
     * Test equals() with different value and different constructor
     */
    @org.junit.Test
    public void testEquals5() {
        CustomDate first = new CustomDate(1,5,2013);
        CustomDate second = new CustomDate("sepTember",4,2034);
        assertEquals(false, first.equals(second));
    }
    /*
     * Test default constructor
     */
    @org.junit.Test
    public final void testCustomDateDefaultConstructor1() {
        CustomDate defaultDate = new CustomDate();
        assertTrue(defaultDate.getDay() == 1 &&
                defaultDate.getMonth() == 1 && defaultDate.getYear() == 1900);
    }
    /*
     * Test first parameter constructor
     */
    @org.junit.Test
    public final void testCustomDateIntIntIntConstructor1(){
        CustomDate defaultDate = new CustomDate(12,31,9999);
        assertTrue(defaultDate.getDay() == 31 &&
                defaultDate.getMonth() == 12 && defaultDate.getYear() == 9999);

    }
    /*
     * Test first parameter constructor with invalid day
     */
    @org.junit.Test (expected = IllegalArgumentException.class)
    public final void testCustomDateIntIntIntConstructor2(){
        CustomDate defaultDate = new CustomDate(12,32,9999);

    }
    /*
     * Test first parameter constructor with invalid month
     */
    @org.junit.Test (expected = IllegalArgumentException.class)
    public final void testCustomDateIntIntIntConstructor3(){
        CustomDate defaultDate = new CustomDate(13,29,2021);

    }
    /*
     * Test first parameter constructor with invalid year
     */
    @org.junit.Test (expected = IllegalArgumentException.class)
    public final void testCustomDateIntIntIntConstructor4(){
        CustomDate defaultDate = new CustomDate(12,31,10000);

    }
    /*
     * Test first parameter constructor with leap year
     */
    @org.junit.Test
    public final void testCustomDateIntIntIntConstructor5(){
        CustomDate defaultDate = new CustomDate(2,29,2000);
        assertTrue(defaultDate.getDay() == 29 &&
                defaultDate.getMonth() == 2 && defaultDate.getYear() == 2000);
    }
    /*
     * Test first parameter constructor with not a leap year
     */
    @org.junit.Test (expected = IllegalArgumentException.class)
    public final void testCustomDateIntIntIntConstructor6(){
        CustomDate defaultDate = new CustomDate(2,29,2007);
    }
    /*
     * Test second parameter constructor
     */
    @org.junit.Test
    public final void testCustomDateStringIntIntConstructor1(){
        CustomDate defaultDate = new CustomDate("januArY",4,2019);
        assertTrue(defaultDate.getDay() == 4 &&
                defaultDate.getMonth() == 1 && defaultDate.getYear() == 2019);
    }
    /*
     * Test second parameter constructor with invalid day
     */
    @org.junit.Test (expected = IllegalArgumentException.class)
    public final void testCustomDateStringIntIntConstructor2(){
        CustomDate defaultDate = new CustomDate("januArY",45,2019);
    }
    /*
     * Test second parameter constructor with invalid month
     */
    @org.junit.Test (expected = IllegalArgumentException.class)
    public final void testCustomDateStringIntIntConstructor3(){
        CustomDate defaultDate = new CustomDate("febru",4,2019);
    }
    /*
     * Test second parameter constructor with invalid year
     */
    @org.junit.Test (expected = IllegalArgumentException.class)
    public final void testCustomDateStringIntIntConstructor4(){
        CustomDate defaultDate = new CustomDate("januArY",4,20000);
    }
    /*
     * Test second parameter constructor with leap year
     */
    @org.junit.Test
    public final void testCustomDateStringIntIntConstructor5(){
        CustomDate defaultDate = new CustomDate("febRuary",29,2000);
        assertTrue(defaultDate.getDay() == 29 &&
                defaultDate.getMonth() == 2 && defaultDate.getYear() == 2000);
    }
    /*
     * Test second parameter constructor with not a leap year
     */
    @org.junit.Test (expected = IllegalArgumentException.class)
    public final void testCustomDateStringIntIntConstructor6(){
        CustomDate defaultDate = new CustomDate("febRuary",29,2001);
    }
}
