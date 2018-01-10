package assignment10;

import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;

/**
   A tree in which each node has an arbitrary number of children.
*/
public class Tree
{
   private Node root;

   class Node
   {
      public Object data;
      public List<Node> children;

      /**
     Computes the size of the subtree whose root is this node.
     @return the number of nodes in the subtree
  */
      public int size()
      {
         int sum = 0;
         for (Node child : children) { sum = sum + child.size(); }
         return 1 + sum;
      }
   }

   /**
      Constructs an empty tree.
   */
   public Tree()
   {
      root = null;
   }

   /**
      Constructs a tree with one node and no children.
      @param rootData the data for the root
   */
   public Tree(Object rootData)
   {
      root = new Node();
      root.data = rootData;
      root.children = new ArrayList<>();
   }

   /**
      Adds a subtree as the last child of the root.
   */
   public void addSubtree(Tree subtree)
   {
      root.children.add(subtree.root);
   }

   /**
      Computes the size of this tree.
      @return the number of nodes in the tree
   */
   public int size() 
   {
      if (root == null) { return 0; }
      else { return root.size(); }
   }
   
	public ArrayList<Object> bftravers() {
		ArrayList<Node> list = new ArrayList<>();
		list.add(root);
		return bftravers(list);
	}
	
	private ArrayList<Object> bftravers(ArrayList<Node> nodeQueue) {
		ArrayList<Object> retVal = new ArrayList<>();
		if (nodeQueue.size() == 0) return new ArrayList<Object>();
		
		else {
			retVal.add(nodeQueue.get(0).data);
			Node temp = nodeQueue.remove(0);
			
			if (temp.children != null) {
				for (int i = 0; i < temp.children.size(); i ++) {
					nodeQueue.add(temp.children.get(i));
				}
			}
		}
		
		retVal.addAll(bftravers(nodeQueue));
		
		return retVal;
	}
	
    public static void main(String[] args) {
    	Tree tree0 = new Tree(0);
    	Tree tree1 = new Tree(1);
    	Tree tree2 = new Tree(2);
    	Tree tree3 = new Tree(3);
    	tree1.addSubtree(new Tree(4));
    	tree1.addSubtree(new Tree(5));
    	tree2.addSubtree(new Tree(6));
    	tree2.addSubtree(new Tree(7));
    	tree3.addSubtree(new Tree(8));
    	tree3.addSubtree(new Tree(9));
    	tree3.addSubtree(new Tree(10));
    	tree3.addSubtree(new Tree(11));
    	tree0.addSubtree(tree1);
    	tree0.addSubtree(tree2);
    	tree0.addSubtree(tree3);
    	System.out.println("the size of the tree: " + tree0.size());
    	System.out.println(tree0.bftravers());
    }
}
