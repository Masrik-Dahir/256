/****************************************************************************
 * Masrik Dahir
 * **************************************************************************
 * Project Name: Iterating MySearchTree and MyHashTable
 * File Name: MyHashTable.java
 * The purpose of the class is to establish a Hash Table and iterate through
 * its elements using linear probing
 * **************************************************************************
 * 05 May 2021
 * CMSC 256-901
 ****************************************************************************/

package cmsc256;
/**
 *   CMSC 256
 *   Computer Science Department
 *   College of Engineering
 *   Virginia Commonwealth University
 */
import bridges.base.Label;
import bridges.base.Polyline;
import bridges.base.Rectangle;
import bridges.base.SymbolCollection;
import bridges.connect.Bridges;
import bridges.validation.RateLimitException;

import java.io.IOException;
import java.util.AbstractMap;
import java.util.AbstractMap.SimpleEntry;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

public class MyHashTable<K, V> implements java.lang.Iterable<Map.Entry<K, V>>
{
    private MapNode[] table;
    private int capacity;
    private double loadFactor;
    private int count;
    private final static int defaultCapacity = 30;
    private final static double defaultLoadFactor = 10.0;

    //	Default constructor uses the default values for both
//	capacity and load factor to create the hash table
    public MyHashTable() {
        this(defaultCapacity, defaultLoadFactor);
    }

    //	Single argument constructor uses the default values
//	for the load factor to create the hash table
    public MyHashTable(int capacity) {
        this(capacity, defaultLoadFactor);
    }

    public MyHashTable(int capacity, double loadFactor) {
        this.loadFactor = loadFactor;
        this.capacity = capacity;
        this.table = new MapNode[this.capacity];
        this.count = 0;
    }

    // boolean value of if the table full or not
    private boolean isFull() {
        return count > table.length * loadFactor;
    }

    // Return a has index for the key
    private int getHashIndex(K key)	{
        int hashIndex =  Math.abs(key.hashCode() % 1000) % table.length;
        return hashIndex;
    }

    //Return the next prime in the line
    private int getNextPrime(int integer) {
        // if even, add 1 to make odd
        if (integer % 2 == 0) {
            integer++;
        }

        // test odd integers
        while (!isPrime(integer)) {
            integer = integer + 2;
        }
        return integer;
    }

    // Returns true if the given integer is prime.
    private boolean isPrime(int integer) {
        boolean result;
        boolean done = false;

        // 1 and even numbers are not prime
        if ((integer == 1) || (integer % 2 == 0)) {
            result = false;
        }
        // 2 and 3 are prime
        else if ((integer == 2) || (integer == 3)) {
            result = true;
        }
        else  {				// integer is odd and >= 5
            result = true; 	// assume prime
            for (int divisor = 3; !done && (divisor * divisor <= integer);  																	divisor = divisor + 2) {
                if (integer % divisor == 0) {
                    result = false; // divisible; not prime
                    done = true;
                }
            }
        }
        return result;
    }
    //TODO: implement iterator logic by providing any missing code needed
    /*
     * Provides the implementation of the Iterator interface
     * for the hash table
     * Note: the optional remove method is not implemented
     * https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html
     */

    private class HashTableIterator implements Iterator<Map.Entry<K, V>> {


        //TODO: complete constructor implementation
        private int currentIndex; // Current position in hash table
        private int numberLeft;
        public HashTableIterator() {
            currentIndex = 0;
            numberLeft = count;

        }

        //TODO:
        // return true if there is another entry in the table
        public boolean hasNext() {
            return numberLeft > 0;
        }

        //TODO:
        // returns the next entry in the table
        public Map.Entry<K, V> next() {
            Map.Entry<K, V> sim;
            if (hasNext()) {

                // Skip table locations that do not contain a current entry
                while ((table[currentIndex] == null)){
                    currentIndex++;
                }

                sim = new SimpleEntry<K, V>((K)table[currentIndex].getKey(), (V) table[currentIndex].getValue());

                numberLeft--;
                currentIndex++;
            }
            else
                throw new NoSuchElementException();

            return sim;
        }
    }


    public Iterator<Map.Entry<K, V>> iterator() {
        return new HashTableIterator();
    }

    //TODO:
    //Getter
    public V get(K key) {
        if (key == null) {
            return null;
        }
        int index = getHashIndex(key);
        index = linearProbe (index, key);
        MapNode <K, V> item = table[index];
        if ((item  != null))
            return item.getValue();
        return null;
    }

    // Takes the hash index and the key and do linear probing
    private int linearProbe(int index, K keyIn) {

        boolean found = false;

        int removedStateIndex = -1; // Index of first removed location

        if(table[index] == null) {    // The hash index is available

            return index;
        }

        while (!found && table[index] != null) {



            if (keyIn.equals(table[index].getKey())) {

                found = true;       // Key found
            }

            else {                     // Follow probe sequence

                index = (index + 1) % table.length;

            }
        }




        if (found || (removedStateIndex == -1) ) {

            return index;             // Index of either key or null
        }

        else {

            return removedStateIndex; // Index of an available location
        }

    }


    //TODO
    // Setter
    public void set(K key, V value) {
        if (key == null || value == null){
            throw new IllegalArgumentException();
        }
        V oldValue = null;
        MapNode<K,V> entry = new MapNode<K, V>(key, value);
        int index = getHashIndex(entry.getKey());


        index = linearProbe (index, key);
        if (table[index] == null){
            table[index] = entry;
            count ++;
        }
        else{
            oldValue = (V) table[index].getValue();
            table[index] = entry;
        }
        if (isFull()) {

            resize(capacity);

        }

    }


    //TODO
    // Increasing the size of the table[] when needed
    private void resize(int capacity) {
        MapNode<K, V>[] oldTable = table;

        // The case is safe because the new array contains null entries
        @SuppressWarnings("unchecked")
        MapNode<K, V>[] temp = (MapNode<K, V>[]) new MapNode[capacity];
        table = temp;
        count = 0;

        // Rehash dictionary entries from old array to the new
        for (int index = 0; index < oldTable.length; index++) {
            if ((oldTable[index] != null))
                set(oldTable[index].getKey(), oldTable[index].getValue());
        }
    }

    //visualization function
    public void visualize(Bridges bridgesInstance) throws IOException, RateLimitException {
        SymbolCollection vis = new SymbolCollection();
        Rectangle rect;
        Label label;
        Polyline line;

        int maxx = 0;
        float label_width=100;
        float label_height=25;
        float spacing_width=50;


        for (int i = 0; i < this.table.length; ++i) {
            int x = 0;
            int y = (this.capacity - i) * 30;

            rect = new Rectangle(x, y, 25, 25);
            rect.setFillColor("white");
            vis.addSymbol(rect);

            label = new Label(String.valueOf(i));
            label.setLocation((float)(x+25/2.), (float)(y+25/2.));
            label.setFontSize(12);
            vis.addSymbol(label);

            x += 62.5;

            MapNode node = this.table[i];
            while (node != null) {
                rect = new Rectangle(x, y, label_width, label_height);
                rect.setFillColor("white");
                vis.addSymbol(rect);

                label = new Label(String.format("%s: %d", node.getKey(), node.getValue()));
                label.setLocation((float)(x+label_width/2.), (float)(y+label_height/2.));
                label.setFontSize(12);
                vis.addSymbol(label);

                line = new Polyline();
                line.addPoint((float)(x + label_width), (float)(y+label_height/2.));
                line.addPoint((float)(x + label_width+spacing_width), (float)(y+label_height/2.));
                line.addPoint((float)(x + label_width+3./4.*spacing_width), (float)(y) );
                line.addPoint((float)(x + label_width+spacing_width), (float)(y+label_height/2.));
                line.addPoint((float)(x + label_width+3./4.*spacing_width), (float)(y + label_height));
                line.setStrokeWidth(1);
                line.setStrokeColor("red");
                vis.addSymbol(line);

                x += label_width+spacing_width;
                node = node.getNext();
            }

            if (x > maxx)
                maxx=x;

            rect = new Rectangle(x, y, label_width, label_height);
            rect.setFillColor("white");
            vis.addSymbol(rect);

            label = new Label("null");
            label.setLocation((float)(x+label_width/2.), (float)(y+label_height/2.));
            label.setFontSize(12);
            vis.addSymbol(label);
        }

        vis.setViewport (-30.f, (float)(maxx+200), -30.f, (this.capacity+1)*30.f);
        bridgesInstance.setDataStructure(vis);
        bridgesInstance.visualize();
    }

    class MapNode<K, V> {
        private K key;
        private V value;
        private MapNode next;

        public MapNode(K key, V value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }


        public K getKey() {
            return key;
        }

        public void setKey(K key) {
            this.key = key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }

        public MapNode getNext() {
            return next;
        }

        public void setNext(MapNode next) {
            this.next = next;
        }
    }
}
