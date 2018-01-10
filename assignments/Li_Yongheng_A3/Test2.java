/**
Li, Yongheng
CS140 A56
Assignment 2
*/

package assignment03;

import java.util.Arrays;

public class Test2 {
	public static void main (String[] args) {
	double[] array1 = null;
	double[] array2 = {};
	double[] array3 = {1.200000000000000,
					   1.0000000000000001,
					   -1.00000111100000000,
					   1.11100000000000000};
	double[] array4 = {1.2000000000000001,
					   1.1000000000000000,
					   -1.00000111100000000,
					   1.11100000000000000};
	double doubleValue = 1.0;
	
	System.out.println("This is the test output for indexOf:");
	System.out.println(Assig3.indexOf(doubleValue, array1));
	System.out.println(Assig3.indexOf(doubleValue, array2));
	System.out.println(Assig3.indexOf(doubleValue, array3));
	System.out.println(Assig3.indexOf(doubleValue, array4));
	
	System.out.println("This is the test output for indexOf2:");
	System.out.println(Assig3.indexOf2(doubleValue, array1));
	System.out.println(Assig3.indexOf2(doubleValue, array2));
	System.out.println(Assig3.indexOf2(doubleValue, array3));
	System.out.println(Assig3.indexOf2(doubleValue, array4));
	
	int[] array5 = {1, 1, 2, 4, 4, 5};
	System.out.println("This is the test output for indexOf3:");
	System.out.println(Assig3.indexOf3(-1, array5));
	System.out.println(Assig3.indexOf3(6, array5));
	System.out.println(Assig3.indexOf3(3, array5));
	System.out.println(Assig3.indexOf3(4, array5));
	
	System.out.println("This is the test output for insertIfNeeded():");
	System.out.println(Arrays.toString(Assig3.insertIfNeeded(7, array5)));
	}
}
