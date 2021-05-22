/****************************************************************************
 * Masrik Dahir
 * 19 Match 2021
 * CMSC 256-901
 ****************************************************************************/
/****************************************************************************
For this program, you will use the BRIDGES DLelement class (https://bridgesuncc.github.io/doc/java-api/current/html/classbridges_1_1base_1_1_d_lelement.htm (Links to an external site.)l), instead of the Link class to implement a doubly-linked list. This class is to be named BridgesDoublyLinkedList<E> and you it must implement the provided List.java  downloadclass. Test your implementation thoroughly and include a main method that produces the output described below.
Output. Use the BRIDGES visualizer to display the contents of the linked list after adding 35 Strings, testing all of the methods in the interface within a main method of your BridgesDoublyLinkedList class, and creating a visualization of your doubly-linked list on the Bridges platform.
Write the program in Java and compile it in JDK 8 or better.  Follow all commenting conventions discussed in class and include a comment block at the top of your class file, BridgesDoublyLinkedList.java, with your name, semester, the course number and section.
*******************************************************************************/
package cmsc256;

//List class ADT. Generalize the element type using Java Generics.
public interface List<E> { // List class ADT
    // Remove all contents from the list, so it is once again empty
    public void clear();

    // Insert "it" at the current location
    // The client must ensure that the list's capacity is not exceeded
    public boolean insert(E it);

    // Append "it" at the end of the list
    // The client must ensure that the list's capacity is not exceeded
    public boolean append(E it);

    // Remove and return the current element
    public E remove();

    // Set the current position to the start of the list
    public void moveToStart();

    // Set the current position to the end of the list
    public void moveToEnd();

    // Move the current position one step left, no change if already at beginning
    public void prev();

    // Move the current position one step right, no change if already at end
    public void next();

    // Return the number of elements in the list
    public int length();

    // Return the position of the current element
    public int currPos();

    // Set the current position to "pos"
    public boolean moveToPos(int pos);

    // Return true if current position is at end of the list
    public boolean isAtEnd();

    // Return the current element
    public E getValue();
}
