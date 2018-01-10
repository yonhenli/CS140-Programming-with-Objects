package lab10;

import java.util.Comparator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * A class to implement the Binary Search Tree data structure.
 * The structure is generic in the type of Objects it contains.
 * @param <T> the type of the contained elements this structure is to hold
 */
public class BinarySearchTree<T> {
    private Comparator<T> comparator;
    private T data;
    private BinarySearchTree<T> left;
    private BinarySearchTree<T> right;

    /**
     * Constructs an empty BST with a Comparator
     * @param comp the Comparator to use to impose an ordering on instances of T
     */
    public BinarySearchTree(Comparator<T> comp) {
        this.comparator = comp;
    }

    /**
     * Constructs a BST with data and a Comparator
     * @param data the data this BST should hold
     * @param comp the Comparator to use to impose an ordering on instances of T
     */
    public BinarySearchTree(T data, Comparator<T> comp) {
        this.data = data;
        this.comparator = comp;
    }

    /**
     * Inserts an element into this BST
     * @param element the element to insert into this BST
     */
    public void insert(T element) {
    	if (this.data == null) {
    		this.data = element;
    		return;
    	}
    	
    	if (element == null) return;
    	
    	else if (this.comparator.compare(element, this.data) < 0) {
        	if (this.left == null) {
        		this.left = new BinarySearchTree<>(element, this.comparator);
        	}
        	else this.left.insert(element);
        }
        
        else if (this.comparator.compare(element, this.data) > 0) {
        	if (this.right == null) {
        		this.right = new BinarySearchTree<>(element, this.comparator);
        	}
        	else this.right.insert(element);
        }
    }

    /**
     * Searchs for a given element in this BST
     * @param element the element to search this BST for
     * @return the element in this BST matching the given element, if found,
     *         otherwise null if the given element is not in this BST
     */
    public T find(T element) {
        if (element == null) return null;
        if (this.comparator.compare(element, this.data) == 0) return this.data;
        
        else if (this.comparator.compare(element, this.data) < 0) {
        	if (this.left != null){
        		return this.left.find(element);
        	}
        	else return null;
        	
        }
        
        else{
//        	this.right.find(element);
        	if (this.right != null){
        		return this.right.find(element);
        	}
        	else return null;
        }
        
        
    }

    /**
     * Gathers all the elements of this BST in order
     * @return a List holding the elements in this BST in order
     */
    public List<T> getElements() {
        List<T> list = new ArrayList<>();
        if (this.data == null) return list;
        else{
        	list.add(this.data);
        	if (this.left != null) {
        		list.addAll(this.left.getElements());
        	}
        	
        	if (this.right != null) {
        		list.addAll(this.right.getElements());
        	}
        }
        list.sort(comparator);

        return list;
    }

    /**
     * Pretty prints the contents of this BST in a horizontal tree-like fashion
     */
    public void prettyPrint() {
        prettyPrint(0);
    }

    private void prettyPrint(int indentLevel) {
        // TODO
        // similar to printInOrder from assignment09,
        // but print `indentLevel` amount of spaces before printing data on its own line
        // you may use a for loop to print `indentLevel` amount of spaces
        // each time you recurse, you add to indentLevel
        if (this.data == null) return;
        else{
        	if (this.left != null) {
        		this.left.prettyPrint(indentLevel+2);
        	}
        	for (int i = 0; i < indentLevel; i++){
        		System.out.print(" ");
        	}
        	System.out.println(this.data);
        	
        	if (this.right != null) {
        		this.right.prettyPrint(indentLevel+2);
        	}
        }
    }

    /**
     * A main method supplied for any debugging needs
     */
    public static void main(String[] args) {
        // Up to you how you use this main method, feel free to change it
       Comparator<Integer> intComp = (i, j) -> i - j; // lambda expression
        BinarySearchTree<Integer> tree = new BinarySearchTree<>(intComp);
        tree.insert(3);
        tree.insert(8);
        tree.insert(1);
        tree.insert(0);
        tree.insert(3);
        tree.insert(9);
        tree.insert(4);
        tree.prettyPrint();
//        System.out.println(tree.find(8));
//        System.out.println(tree.getElements());

    }
}