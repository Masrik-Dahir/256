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
import java.util.Map;

public interface Dictionary<K, V> extends Iterable<Map.Entry<K,V>> {
    /**
     * Returns the node at key
     *
     * @param key key of node to get
     * @return value
     */
    public V get(K key);

    /**
     * sets the value of node at key with value
     *
     * @param key   key of node to be set
     * @param value new value of node
     */
    public void set(K key, V value);
}
