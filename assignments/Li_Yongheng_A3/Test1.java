/**
Li, Yongheng
CS140 A56
Assignment 2
*/

package assignment03;

public class Test1 {
	public static void main (String[] args) {
	double[] array1 = null;
	double[] array2 = {};
	double[] array3 = {1, 2, 3, 4};
	double[] array4 = {1, 2, -3, 4};
	
		Assig3 test = new Assig3();
		System.out.println("This is the test output of hasNegative(): ");
		System.out.println(test.hasNegative(array1));
		System.out.println(test.hasNegative(array2));
		System.out.println(test.hasNegative(array3));
		System.out.println(test.hasNegative(array4));
	}
}
