/****************************************************************************
 * Masrik Dahir
 * 19 Match 2021
 * CMSC 256-901
 ****************************************************************************/
package cmsc256;
import bridges.base.DLelement;
import bridges.connect.Bridges;

public class BridgesDoublyLinkedList<E> implements List<E>{
    DLelement<E> first;
    DLelement<E> last;
    DLelement<E> current;
    int numElements;

    public BridgesDoublyLinkedList(){
        clear();
    }
    public BridgesDoublyLinkedList(DLelement<E> node){
        first = new DLelement<>();
        last = new DLelement<>();
        node.setPrev(first);
        node.setNext(last);
        first.setNext(node);
        last.setPrev(node);
        current = node;
        numElements = 1;
    }

    // Remove all contents from the list, so it is once again empty
    @Override
    public void clear() {
        first = new DLelement<>();
        last = new DLelement<>();
        first.setNext(last);  // set the null first node's next reference to last
        last.setPrev(first);  // set the null last node's prev reference to first
        //curr will point to the trailer node if the current position is at the end of the list
        current = last;
        numElements = 0;
    }

    // Insert "it" at the current location
    // The client must ensure that the list's capacity is not exceeded
    @Override
    public boolean insert(E it) {
        DLelement<E> element = new DLelement<E>();
        element.setValue(it);
        element.setPrev(current.getPrev());
        element.getPrev().setNext(element);
        element.setNext(current);
        current.setPrev(element);
        current = element;
        numElements ++;

        return true;
    }

    // Append "it" at the end of the list
    // The client must ensure that the list's capacity is not exceeded
    @Override
    public boolean append(E it) {
        DLelement<E> element = new DLelement<E>();
        element.setValue(it);

        element.setNext(last);
        last.getPrev().setNext(element);
        element.setPrev(last.getPrev());
        last.setPrev(element);
        current = element;

        numElements++;

        return true;
    }

    // Remove and return the current element
    @Override
    public E remove() {
        if (!isEmpty()) {
            DLelement<E> value = current;
            current.getPrev().setNext(current.getNext());
            current.getNext().setPrev(current.getPrev());
            current = current.getNext();

            numElements--;
            return value.getValue();
        }else{
            return null;
        }
    }

    // Set the current position to the start of the list
    @Override
    public void moveToStart() {
        //1
        current = first.getNext();
    }

    // Set the current position to the end of the list
    @Override
    public void moveToEnd() {
        //1
        current = last;
    }

    // Move the current position one step left, no change if already at beginning
    @Override
    public void prev() {
        //1
        current = current.getPrev();
    }

    // Move the current position one step right, no change if already at end
    @Override
    public void next() {
        //1
        if(current.getNext() != null) {
            current = current.getNext();
        }
        else{
        }
    }

    // Return the number of elements in the list
    @Override
    public int length() {
        return numElements;
    }

    // Return the position of the current element
    @Override
    public int currPos() {
        DLelement<E> save = current;
        int index = 0;
        if (numElements == 0) {
            return -1;
        }
        else if (current.getValue() == first.getValue()){
            return 0;
        }
        else if (current.getValue() == last.getValue()){
            return numElements;
        }
        else {
            while (save.getNext()!=null){
                index += 1;
                save = save.getNext();
            }
        }
        return numElements - index;
    }

    // Set the current position to "pos"
    @Override
    public boolean moveToPos(int pos) {
        DLelement<E> save = first.getNext();
//        System.out.println(first.getValue());
        if (pos >= 0 && pos < numElements) {
            for (int i = 0; i < numElements; i++) {
                if (i == pos) {
                    current = save;
                } else {
                    save = save.getNext();
                }
            }
        }
        else{
            return false;
        }

        return true;
    }

    // Return true if current position is at end of the list
    @Override
    public boolean isAtEnd() {
        return current.getNext() == null;
    }

    // Return the current element
    @Override
    public E getValue() {
        //1
        return current.getValue();
    }

    // Return the elements of the BridgesDoublyLinkedList with a space in between and in a single line
    @Override
    public String toString() {
        String anything = "";
        while (current.getNext()!=null){
            anything += current.getValue().toString() + " ";
            current = current.getNext();
        }
        return anything;
    }

    // Return boolean expression of whether the BridgesDoublyLinkedList empty or not
    public Boolean isEmpty(){
        return numElements == 0;
    }

    public static void main(String[] args) {

        //Creating Object for Bridge and BridgesDoublyLinkedList
        Bridges bridges = new Bridges(4, "masrikdahir", "610313897399");
        BridgesDoublyLinkedList<String> states = new BridgesDoublyLinkedList<>();

        // Inserting 35 elements
        states.insert("Arizona");
        states.insert("Arkansas");
        states.insert("California");
        states.insert("Virginia");
        states.insert("Colorado");
        states.insert("Connecticut");
        states.insert("Delaware");
        states.insert("Florida");
        states.insert("Georgia");
        states.insert("Hawaii");
        states.insert("Idaho");
        states.insert("Illinois");
        states.insert("Indiana");
        states.insert("Iowa");
        states.insert("Kansas");
        states.insert("Kentucky");
        states.insert("Louisiana");
        states.insert("Maine");
        states.insert("Maryland");
        states.insert("Massachusetts");
        states.insert("Michigan");
        states.insert("Minnesota");
        states.insert("Mississippi");
        states.insert("Missouri");
        states.insert("Montana");
        states.insert("Nebraska");
        states.insert("Nevada");
        states.insert("New Hampshire");
        states.insert("New Jersey");
        states.insert("New Mexico");
        states.insert("New York");
        states.insert("North Carolina");
        states.insert("North Dakota");
        states.insert("Ohio");
        states.insert("Oklahoma");

        System.out.println(states.toString());

        //Visualizing the elements in Bridge API
        bridges.setDataStructure(states.first);
        try {
            bridges.visualize();
        }
        catch (Exception a){
            System.out.println(a.getMessage());
        }
    }
}
