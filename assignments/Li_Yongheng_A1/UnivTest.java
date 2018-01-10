/**
Li, Yongheng
CS140 A56
Assignment 1
*/

package assignment01;

public class UnivTest {
	public static void main(String[] args) {
		University unv1 = new University("Binghamton University", "Binghamton");
		System.out.println(unv1.getName() + ", " + unv1.getCity());		
		
		University unv2 = new University("Brown University", "Providence");
		System.out.println(unv2.getName() + ", " + unv2.getCity());	
	}
}
