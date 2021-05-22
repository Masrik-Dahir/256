/****************************************************************************
 * Masrik Dahir
 * **************************************************************************
 * Project Name: Iterating MySearchTree and MyHashTable
 * File Name: MySearchTree.java
 * The purpose of the class is to iterate (in-order traversal) through the
 * MySearchTree.java and visualize it on Project6.java
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
