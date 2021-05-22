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

package cmsc256;
import bridges.base.BinTreeElement;
import bridges.connect.Bridges;

public class BinSearchTree<E extends Comparable<E>> implements BinTreeInterface<E>{

    private BinTreeElement<E> root = null;
    private int size = 0;

    @Override
    public BinTreeElement<E> getRoot() {
        return root;
    }

    private boolean addToParent(BinTreeElement<E> parentNode, BinTreeElement<E> addNode){
        int compare = parentNode.getValue().compareTo(addNode.getValue());
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
            return false;
        }
        return wasAdded;
    }

    @Override
    public boolean add(E element) {
        BinTreeElement<E> node = new BinTreeElement<E>(element);
        node.setLabel(element.toString());
        boolean wasAdded = true;

        if (root == null) {
            root = node;
        }
        else {
            wasAdded = addToParent(root, node);
        }
        if (wasAdded) {
            size = size + 1;
            return true;
        }
        return false;
    }

    private boolean removeSubNode(BinTreeElement<E> parent, E rev_value) {
        BinTreeElement<E> remove = new BinTreeElement<E>(rev_value);
        int compareParent = parent.getValue().compareTo(remove.getValue());
        BinTreeElement<E> subTree = null;

        if (compareParent > 0)
            subTree = parent.getLeft();
        else
            subTree = parent.getRight();

        if (subTree == null) {
            return false;
        }

        if (subTree.getValue().compareTo(remove.getValue()) == 0) {
            BinTreeElement<E> replacement;
            if (subTree.getLeft() == null) {
                replacement = subTree.getRight();
            }
            else if (subTree.getRight() == null) {
                replacement = subTree.getLeft();
            }
            else {
                BinTreeElement<E> formerRight = subTree.getRight();
                replacement = subTree.getLeft();
                addToParent(replacement, formerRight);
            }

            if (compareParent > 0) {
                parent.setLeft(replacement);
            }
            else {
                parent.setRight(replacement);
            }

            size--;
            return true;
        }
        return removeSubNode(subTree, rev_value);
    }

    @Override
    public boolean remove(E element) {
        BinTreeElement<E> node = new BinTreeElement<E>(element);
        if (root == null) {
            return false;
        }
        else if (root.getValue().compareTo(node.getValue()) == 0) {
            if (root.getLeft() == null) {
                root.setRight(root);
            }
            else if (root.getRight() == null) {
                root.setLeft(root);
            }
            else {
                BinTreeElement<E> formerRight = root.getRight();
                root.setLeft(root);
                addToParent(root, formerRight);
            }
            size--;
            return true;
        }
        else if (node != root){
            return removeSubNode(root, element);
        }
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {
        root = null;
        size = 0;
    }

    private boolean search(BinTreeElement<E> root, E target) {
        BinTreeElement<E> node = new BinTreeElement<E>(target);
        int compare = root.getValue().compareTo(node.getValue());

        if (compare != 0 && root.getRight()== null && root.getLeft() == null) {
            return false;
        }

        else if (compare == 0){
            return true;
        }
        else if (compare < 0)
            return search(root.getRight(), target);

        else {
            return search(root.getLeft(), target);
        }
    }


    @Override
    public boolean search(E target) {
        if (isEmpty()){
            return false;
        }
        return search(root, target);
    }


    private String inorder(BinTreeElement<E> node){
        String result = "";

        if (node == null) {
            return "";
        }

        else {
            result += inorder(node.getLeft());
            result += node.getValue().toString() + "  ";
            result += inorder(node.getRight());
        }
        return result;
    }


    @Override
    public String inorder() {
        if (isEmpty()){
            return null;
        }
        return inorder(root);
    }

    private String postorder(BinTreeElement<E> node){

        if (node == null) {
            return  "";
        }
        String result = "";
        result += postorder(node.getLeft());
        result += postorder(node.getRight());
        result += node.getValue().toString() + "  ";

        return result;

    }

    @Override
    public String postorder() {
        if (isEmpty()){
            return null;
        }
        return postorder(root);
    }

    private String preorder(BinTreeElement<E> node){
        if (node == null) {
            return  "";
        }
        String result = node.getValue().toString() + "  ";
        result += preorder(node.getLeft());
        result += preorder(node.getRight());

        return result;
    }

    @Override
    public String preorder() {
        if (isEmpty()){
            return null;
        }
        return preorder(root);
    }

    private int height(BinTreeElement<E> Node) {
        if (Node == null) {
            return -1;
        }

        int left_height = height(Node.getLeft());
        int right_height = height(Node.getRight());

        if (left_height > right_height) {
            return left_height + 1;
        } else {
            return right_height + 1;
        }
    }

    /** Return the height of this binary tree */
    public int height(){
        if(isEmpty()){
            return -1;
        }
        else{
            BinTreeElement<E> root_node =  root;
            return height(root_node);
        }
    }

    private boolean isFullBST(BinTreeElement<E> node){
        if(root == null)
            return false;

        else if(node.getLeft() == null && node.getRight() == null )
            return true;

        else if((node.getLeft()!=null) && (node.getRight()!=null))
            return (isFullBST(node.getLeft()) && isFullBST(node.getRight()));

        return false;
    }
    /** Returns true if the tree is a full binary tree */
    public boolean isFullBST(){
        return isFullBST(root);
    }

    private int getNumberOfLeaves(BinTreeElement<E> node) {
        if (node == null) {
            return 0;
        }
        else if (node.getLeft() == null && node.getRight() == null) {
            return 1;
        }
        else {
            return getNumberOfLeaves(node.getLeft()) + getNumberOfLeaves(node.getRight());
        }
    }

    /** Return the number of leaf nodes */
    public int getNumberOfLeaves(){
        return getNumberOfLeaves(root);
    }

    /** Return the number of non-leaf nodes */
    public int getNumberOfNonLeaves(){
        int numberOfLeaves = getNumberOfLeaves();
        return size - numberOfLeaves;
    }

    public static void main(String[] args) {
        Bridges bridges = new Bridges(5, "masrikdahir", "610313897399");
        bridges.setTitle("Binary Search Tree");
        bridges.setDescription("Masrik Dahir");


        BinSearchTree <String> names = new BinSearchTree<>();

        names.add("Frodo");
        names.add("Dori");
        names.add("Bilbo");
        names.add("Kili");
        names.add("Gandalf");
        names.add("Fili");
        names.add("Thorin");

        bridges.setDataStructure(names.getRoot());
        try {
            bridges.visualize();
        }
        catch (Exception a){
            System.out.println(a.getMessage());
        }
    }

}
