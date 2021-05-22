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
// Import Bridges and relevant data source
import bridges.connect.Bridges;
import bridges.data_src_dependent.Shakespeare;

import java.util.List;
import java.util.Map;


public class Project6 {

    // Splits string into an array of words
    // Tutorial on regular expressions:
    // https://www.vogella.com/tutorials/JavaRegularExpressions/article.html
    public static String[] splitText(String text) {
        // remove '.' from all sentences by replacing with empty space
        text = text.replaceAll("[.]", "");

        // remove non-printing white-space beginning and end of text
        text = text.trim();

        // separate each word based on spaces and add to word array
        String[] words = text.split("\\s+");

        // remove special characters from before/after words in the array
        for (int i = 0; i < words.length; i++) {
            // \W+ is to find any non-word character
            words[i] = words[i].replaceAll("\\W+$", "");  	// $ looks at end of the word
            words[i] = words[i].replaceAll("^\\W+", "");	// ^ looks at the beginning
            words[i] = words[i].trim();
        }

        return words;
    }


    public static void main(String[] args){

        // Initialize a Bridges connection with your credentials
        Bridges bridges = new Bridges(8, "masrikdahir", "610313897399");

        // Set an assignment title
        bridges.setTitle("Project6");

        try {
            List<Shakespeare> shakespeare_list = bridges.getDataSource().getShakespeareData("poems");
            // Look at the first literary work, a poem
            Shakespeare po1 = shakespeare_list.get(1);

            // Display text as written
            System.out.println(po1.getText());

            // Separate into individual words
            String[] wordlist = splitText(po1.getText());

            // Display word array, one word per line
            for (int i=0; i<wordlist.length; ++i)
                System.out.println(wordlist[i]);

            // All three objects
            StandardDictionary<String,Integer> my_dictionary = new StandardDictionary<String, Integer>();
            MyHashTable<String,Integer> my_map = new MyHashTable<String, Integer>();
            MySearchTree<String, Integer> my_tree = new MySearchTree<String, Integer>();


            //TODO: 2.Use StandardDictionary to compute the number of occurrences of each word.
            for (String word : wordlist) {
                int count = 0;
                for (int index = 0; index < wordlist.length; index++)
                {
                    //Every time the word on the enhance for loop found in he poem increment the number by 1
                    if (word.equals(wordlist[index])) {
                        count++;
                    }
                }

                // Adding those words and its count on the objects
                my_dictionary.set(word, count);
                my_map.set(word, count);
                my_tree.set(word, count);
            }

            // Printing out the objects to test
            for (Map.Entry<String,Integer> e : my_dictionary)
                System.out.println(e.getKey() + " " + e.getValue());

            for (Map.Entry<String,Integer> e : my_map)
                System.out.println(e.getKey() + " " + e.getValue());

            for (Map.Entry<String,Integer> e : my_tree)
                System.out.println(e.getKey() + " " + e.getValue());


            //TODO: uncomment after completing step 2
            my_map.visualize(bridges);
            my_tree.visualize(bridges);
        }
        catch(Exception ex) {
            System.out.println("Unable to access BRIDGES");
        }


    }
}
