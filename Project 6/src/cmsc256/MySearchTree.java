/****************************************************************************
 * Masrik Dahir
 * **************************************************************************
 * Project Name: Iterating MySearchTree and MyHashTable
 * File Name: Project6.java
 * The purpose of the class is to Create the dictionary object and the object
 * from MyHashTable, and MySearchTree, then testing and visualizing on Bridges
 * **************************************************************************
 * 05 May 2021
 * CMSC 256-901
 ****************************************************************************/
/****************************************************************************
In this programming project you will write a program to read text data from the BRIDGES API, implement a Map (Dictionary) using two different data structures (a binary search tree and a hash table) using BRIDGES elements, and visualize them with BRIDGES. Additionally, you will examine the efficiency of these two approaches. To start the project, you’ll analyze a short poem to determine which words are used most often, then analyze the entire Shakespeare work to explore algorithmic efficiency. The main assignment is to count how many times each word appears in a single poem. This will be accomplished using a Dictionary implemented as a Binary Search Tree and as a Hash Map.

Counting word appearances using a Dictionary

A Dictionary is used to store and retrieve (key, value) pairs. In this assignment they will be useful to count how many times a particular word appears in a literary work. The keys are going to be words. And the value associated with that key is going to be how many times that word appears. Counting the words then becomes:

       Algorithm:

Dictionary d

for each word w in document

  entry = d.get(w)

  if (entry is NULL)

    d.insert (w, 1)

  else

    entry.value += 1

Clone the GitHub repository at https://github.com/DebMDuke/project6spring2021.git (Links to an external site.), open your scaffolded code, plug in your credentials, review the Dictionary interface, Dictionary.java, and the implementation of the StandardDictionary.java class that uses a Java HashMap to store the key-value pairs.
Run the scaffold code by executing the main method in the Project 6 class that uses the StandardDictionary to read and separate the words in the text.
Follow the algorithm given above to compute the number of occurrences of each work in the main method TODO location and visualize the dictionary.
Implement the Dictionary interface by completing the implementation of the MySearchTree.java class using a Binary Search Tree and the BSTElement of BRIDGES.
Add code in the main method of the Project6 class to use the SearchTreeDictionary and visualize the Dictionary using BRIDGES.
Implement the Dictionary interface by completing the implementation of the MyHashTable.java class using a hash table.
Use BRIDGES SymbolCollection to generate a visualization of the hash table.
Use the complete works of Shakespeare to observe the performance difference between the hash table and the binary search tree implementation of the dictionary.
Submit the following files to Gradescope: Project6.java, MyHashTable.java, and MySearchTree.java
*********************************************************************************/

package cmsc256;
/**
 *   CMSC 256
 *   Computer Science Department
 *   College of Engineering
 *   Virginia Commonwealth University
 */
import bridges.base.BSTElement;
import bridges.connect.Bridges;
import java.util.AbstractMap.SimpleEntry;
import java.lang.Comparable;
import java.security.Key;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.AbstractMap;
import java.util.Stack;

public class MySearchTree<K extends Comparable<? super K>, V> implements java.lang.Iterable<Map.Entry<K, V>> {
    private BSTElement<K, V> root;

    public MySearchTree(){
        root = null;
    }

    ///TODO: Implement iterator logic for MySearchTree
    class SearchTreeIterator implements Iterator<Map.Entry<K, V>>  {
        private Iterator<SimpleEntry<K, V>> iter;

        // Creating a lined list of SimpleEntry in the constructor
        // helper method buildList
        // iterating the linkedlist
        SearchTreeIterator(BSTElement<K, V> node) {
            List<AbstractMap.SimpleEntry<K, V>> linkedlist = new LinkedList<>();
            buildList(root, linkedlist);
            iter = linkedlist.iterator();
        }

        // iterating to the next element
        public SimpleEntry<K,V> next(){
            return iter.next();
        }

        // Checking if there is an next() element or not
        public boolean hasNext() {
            return iter.hasNext();
        }

        // In order traversal of the tree and adding it to the linkedlist creatred on the constructor
        private void buildList(BSTElement<K, V> s_root, List<SimpleEntry<K, V>> linked_list) {
            if (s_root == null) {
                return;
            }

            if (s_root.getLeft() != null) {
                buildList(s_root.getLeft(), linked_list);
            }
            linked_list.add(new java.util.AbstractMap.SimpleEntry(s_root.getKey(), s_root.getValue()));
            if (s_root.getRight() != null) {
                buildList(s_root.getRight(), linked_list);
            }

        }

    }

    public Iterator<Map.Entry<K, V>> iterator() {
        return new SearchTreeIterator(root);
    }

    //TODO:
    // Getter
    public V get(K k) {
        if (k == null) {
            return null;
        }
        Iterator<Map.Entry<K, V>> it = iterator();

        while (it.hasNext()) {
            Map.Entry<K, V> node = it.next();
            if (k.equals(node.getKey())) {
                return node.getValue();
            }
        }


        return null;
    }

    // The boolean method to add to the parent node - parent node and hte new node on the parameter
    private boolean addToParent(BSTElement<K, V> parentNode, BSTElement<K, V> addNode){
        int compare = (parentNode.getKey()).compareTo(addNode.getKey());
        boolean wasAdded = false;

        if (compare > 0) {
            // if parent has no left node, add new node as left
            if (parentNode.getLeft() == null) {
                parentNode.setLeft(addNode);  // fill in this blank
                wasAdded = true;
            }
            else {
                // otherwise, add to parentNode's left (recursive)
                wasAdded = addToParent(parentNode.getLeft(), addNode);
            }
        }
        else if (compare < 0) {
            // if parent has no right node, add new node as right
            if (parentNode.getRight() == null) {
                parentNode.setRight(addNode);
                wasAdded = true;
            }
            else {
                // otherwise, add to parentNode's right (recursive)
                wasAdded = addToParent(parentNode.getRight(), addNode);
            }

        }
        else{
            parentNode.setValue(addNode.getValue());;
            return true;

        }
        return wasAdded;
    }

    // boolean method to add elements - takes key and value of the object
    private boolean add(K element, V value) {
        BSTElement<K, V> node = new BSTElement<K, V>(element, value);
        node.setLabel(element.toString());
        boolean wasAdded = true;

        if (root == null) {
            root = node;
        }
        else {
            wasAdded = addToParent(root, node);
        }
        return false;
    }

    //TODO:
    // Setter
    public void set(K k, V e) {
        if (k == null) {
            throw new IllegalArgumentException();
        }
        else {
            add(k,e);
        }


    }

    ///visualization function
    public void visualize (Bridges bridges) {
        if (root != null) {
            bridges.setDataStructure(root);
            try {
                bridges.visualize();
            } catch (Exception e) {
                System.err.println ("Exception :" + e.getMessage());
            }
        }
    }

}
