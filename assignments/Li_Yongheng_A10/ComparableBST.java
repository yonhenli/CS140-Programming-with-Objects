package assignment10;

import java.util.Comparator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ComparableBST<T extends Comparable<? super T>> {
	private T data;
	private ComparableBST<T> left;
	private ComparableBST<T> right;
	
	public ComparableBST(T data) {
		this.data = data;
	}
    
    public void insert(T element) {
    	if (this.data == null) {
    		this.data = element;
    		return;
    	}
    	
    	if (element == null) return;
    	
    	else if (this.data.compareTo(element) < 0) {
        	if (this.left == null) {
        		this.left = new ComparableBST<>(element);
        	}
        	else this.left.insert(element);
        }
        
        else if (this.data.compareTo(element) > 0) {
        	if (this.right == null) {
        		this.right = new ComparableBST<>(element);
        	}
        	else this.right.insert(element);
        }
    }
    
    public T find(T element) {
        if (element == null) return null;
        if (this.data.compareTo(element) == 0) return this.data;
        
        else if (this.data.compareTo(element) < 0) {
        	if (this.left != null){
        		return this.left.find(element);
        	}
        	else return null;
        }
        
        else{
        	if (this.right != null){
        		return this.right.find(element);
        	}
        	else return null;
        }
    }
    
    public int height() {
    	return height(this);
    }
    
    private int height(ComparableBST<T> tr) {
    	if (tr == null) return 0;
    	return 1 + Math.max(height(tr.left), height(tr.right));
    }
    
    public boolean heightBalanced() {
    	return heightBalanced(this);
    }
    
    private boolean heightBalanced(ComparableBST<T> tr) {
    	if (tr == null) return true;

    	return (height(tr.left) - height(tr.right) <= 1 ? 
    			heightBalanced(tr.left) && heightBalanced(tr.right) : false);
    }
    
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
        
        java.util.Collections.sort(list);

        return list;
    }
    
    public void prettyPrint() {
        prettyPrint(0);
    }
    
    private void prettyPrint(int indentLevel) {
        if (this.data == null) return;
        else{
        	if (this.left != null) {
        		this.left.prettyPrint(indentLevel+2);
        	}
        	for (int i = 0; i < indentLevel; i++){
        		System.out.print("      ");
        	}
        	System.out.println(this.data);
        	
        	if (this.right != null) {
        		this.right.prettyPrint(indentLevel+2);
        	}
        }
    }
    
	public ArrayList<T> bftravers() {
		ArrayList<ComparableBST<T>> list = new ArrayList<>();
		list.add(this);
		return bftravers(list);
	}
	
	private ArrayList<T> bftravers(ArrayList<ComparableBST<T>> nodeQueue) {
		ArrayList<T> retVal = new ArrayList<>();
		
		if (nodeQueue.size() == 0) return new ArrayList<T>();
		
		else {
			retVal.add(nodeQueue.get(0).data);
			ComparableBST<T> temp = nodeQueue.remove(0);
			
			if (temp.left != null) {
				nodeQueue.add(temp.left);
			}
			
			if (temp.right != null) {
				nodeQueue.add(temp.right);
			}
		}
		
		retVal.addAll(bftravers(nodeQueue));
		
		return retVal;
	}
}