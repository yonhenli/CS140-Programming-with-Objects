package assignment10;
/**
   This class demonstrates the tree class.
*/
public class TreeDemo
{
   public static void main(String[] args)
   {
      Tree t1 = new Tree("Anne");
      Tree t2 = new Tree("Peter");
      t1.addSubtree(t2);
      Tree t3 = new Tree("Zara");
      t1.addSubtree(t3);
      Tree t4 = new Tree("Savannah");
      t2.addSubtree(t4);
      System.out.println("Size: " + t1.size());
      System.out.println(t1.bftravers());
   }
}
