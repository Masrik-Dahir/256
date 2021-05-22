/****************************************************************************
 * Masrik Dahir
 * **************************************************************************
 * Project Name: Binary Search Tree
 * File Name: BinSearchTree.java
 * The purpose of the class is to establish a binary tree that sort and
 * create a hierarchic structure of elements. Also the preorder,
 * postorder, and inorder traversal technique to go through the elements
 * **************************************************************************
 * 04 April 2021
 * CMSC 256-901
 ****************************************************************************/
/****************************************************************************
In this project you will implement a Binary Search Tree using bridges.base.BinTreeElement<E> as the node and by implementing the provided BinTreeInterface<E>.
Important note: The autograder will only be running about 2/3 of the unit tests prior to final grading of the project. The remaining unit tests will be run when final grading is completed for your project.
It is important that you test your code thoroughly on your own.
Create a class named BinSearchTree that implements the BinTreeInterface<E>  downloadinterface.
In the BinSearchTree class, implement the following additional methods:
Return the height of this binary tree
public int height()
Returns true if the tree is a full binary tree
public boolean isFullBST()
Return the number of leaf nodes
public int getNumberOfLeaves()
Return the number of non-leaf nodes
public int getNumberOfNonLeaves()
Include a main method that adds the following elements to the tree and visualize the tree in Bridges:
*********************************************************************************/
package cmsc256;
import bridges.base.BinTreeElement;



    public interface BinTreeInterface<E> {

        /** Returns the root of this tree
         */
        public BinTreeElement<E> getRoot();

        /** Insert element into the binary tree
         * Return true if the element is inserted successfully
         */
        public boolean add(E element);

        /** Delete the specified element from the tree
         * Return true if the element is deleted successfully
         */
        public boolean remove(E element);

        /** Returns the number of nodes in the tree
         */
        public int size();

        /** Return true if the tree is empty
         */
        public  boolean isEmpty();

        /** Removes all nodes from the tree
         */
        public void clear();

        /** Return true if the element is in the tree
         */
        public boolean search(E target);

        /** Inorder traversal from the root
         *  @returns a String representation of the traversal
         *           with two spaces between the String representation
         *           of each element
         */
        public String inorder();

        /** Postorder traversal from the root
         *  @returns a String representation of the traversal
         *           with two spaces between the String representation
         *           of each element
         */
        public String postorder();

        /** Preorder traversal from the root
         *  @returns a String representation of the traversal
         *           with two spaces between the String representation
         *           of each element
         */
        public String preorder();

    }
