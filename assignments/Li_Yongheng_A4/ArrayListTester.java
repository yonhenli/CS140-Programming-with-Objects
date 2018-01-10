package assignment04;


import java.util.ArrayList;
import java.util.Arrays;
import static assignment04.ArrayListPractice.*;

public class ArrayListTester {
	public static void main (String[] args) {
		isNonDecreasingTester();
		isIncreasingTester();
		reverseTester();
		concatenateTester();
		endToEndTester();
		reverseInPlaceTester();

	}
	
	public static void isNonDecreasingTester() {
		System.out.println("------------------------------------------");
		System.out.println("This is the test output of isNonDereasing():");
		Integer[] array1 = null;
		Integer[] array2 = {};
		Integer[] array3 = {1, 2, 2, 4, 5};
		Integer[] array4 = {1, 3, 4, 2, 5};
		Integer[] array5 = {null, 2, 1, null, 4, 5};
		Integer[] array6 = {null, 2, 2, null, 4, 5};
		
		ArrayList<Integer> arrayList1 = arrayListConverter(array1);
		ArrayList<Integer> arrayList2 = arrayListConverter(array2);
		ArrayList<Integer> arrayList3 = arrayListConverter(array3);
		ArrayList<Integer> arrayList4 = arrayListConverter(array4);
		ArrayList<Integer> arrayList5 = arrayListConverter(array5);
		ArrayList<Integer> arrayList6 = arrayListConverter(array6);
		
		test(true, isNonDecreasing(arrayList1));
		test(true, isNonDecreasing(arrayList2));
		test(true, isNonDecreasing(arrayList3));
		test(false, isNonDecreasing(arrayList4));
		test(false, isNonDecreasing(arrayList5));
		test(true, isNonDecreasing(arrayList6));
	}
	
	public static void isIncreasingTester() {
		System.out.println("------------------------------------------");
		System.out.println("This is the test output of isIncreseaing():");
		Integer[] array1 = null;
		Integer[] array2 = {};
		Integer[] array3 = {1, 2, 4, 3, 5};
		Integer[] array4 = {1, 2, 3, 4, 5};
		Integer[] array5 = {1, 2, 2, 3, 5};
		Integer[] array6 = {null, 2, 1, null, 4, 5};
		Integer[] array7 = {null, 2, 2, null, 4, 5};
		Integer[] array8 = {null, 2, 3, null, 4, 5};
		
		ArrayList<Integer> arrayList1 = arrayListConverter(array1);
		ArrayList<Integer> arrayList2 = arrayListConverter(array2);
		ArrayList<Integer> arrayList3 = arrayListConverter(array3);
		ArrayList<Integer> arrayList4 = arrayListConverter(array4);
		ArrayList<Integer> arrayList5 = arrayListConverter(array5);
		ArrayList<Integer> arrayList6 = arrayListConverter(array6);
		ArrayList<Integer> arrayList7 = arrayListConverter(array7);
		ArrayList<Integer> arrayList8 = arrayListConverter(array8);
		
		test(true, isIncreseaing(arrayList1));
		test(true, isIncreseaing(arrayList2));
		test(false, isIncreseaing(arrayList3));
		test(true, isIncreseaing(arrayList4));
		test(false, isIncreseaing(arrayList5));
		test(false, isIncreseaing(arrayList6));
		test(false, isIncreseaing(arrayList7));
		test(true, isIncreseaing(arrayList8));
	}
	
	public static void reverseTester() {
		System.out.println("------------------------------------------");
		System.out.println("This is the test output of reverse():");
		Integer[] array1 = null;
		Integer[] array2 = {};
		Integer[] array3 = {1, 2, 4, 3, 5};
		Integer[] array4 = {1, 2, 3, 4, 5, 6};
		Integer[] array5 = {null, 2, 1, null, 4};
		Integer[] array6 = {null, 2, 1, null, 4, 5};
		
		Integer[] array1c = null;
		Integer[] array2c = {};
		Integer[] array3c = {5, 4, 3, 2, 1};
		Integer[] array4c = {6, 5, 4, 3, 2, 1};
		Integer[] array5c = {4, null, 1, 2, null};
		Integer[] array6c = {5, 4, null, 1, 2, null};
		
		ArrayList<Integer> arrayList1 = arrayListConverter(array1);
		ArrayList<Integer> arrayList2 = arrayListConverter(array2);
		ArrayList<Integer> arrayList3 = arrayListConverter(array3);
		ArrayList<Integer> arrayList4 = arrayListConverter(array4);
		ArrayList<Integer> arrayList5 = arrayListConverter(array5);
		ArrayList<Integer> arrayList6 = arrayListConverter(array6);
		
		ArrayList<Integer> arrayList1c = arrayListConverter(array1c);
		ArrayList<Integer> arrayList2c = arrayListConverter(array2c);
		ArrayList<Integer> arrayList3c = arrayListConverter(array3c);
		ArrayList<Integer> arrayList4c = arrayListConverter(array4c);
		ArrayList<Integer> arrayList5c = arrayListConverter(array5c);
		ArrayList<Integer> arrayList6c = arrayListConverter(array6c);
		
		test(arrayList1c, reverse(arrayList1));
		test(arrayList2c, reverse(arrayList2));
		test(arrayList3c, reverse(arrayList3));
		test(arrayList4c, reverse(arrayList4));
		test(arrayList5c, reverse(arrayList5));
		test(arrayList6c, reverse(arrayList6));

	}
	
	public static void concatenateTester() {
		System.out.println("------------------------------------------");
		System.out.println("This is the test output of concatenate():");
		Integer[] array1 = null;
		Integer[] array2 = {};
		Integer[] array3 = {1, 2, 3};
		Integer[] array4 = {4, 5, 6};
		Integer[] array5 = {1, 2, 3, 4, 5, 6};
		
		ArrayList<Integer> arrayList1 = arrayListConverter(array1);
		ArrayList<Integer> arrayList2 = arrayListConverter(array2);
		ArrayList<Integer> arrayList3 = arrayListConverter(array3);
		ArrayList<Integer> arrayList4 = arrayListConverter(array4);
		ArrayList<Integer> arrayList5 = arrayListConverter(array5);
		
		try {
		concatenate(arrayList1, arrayList2);
	    System.out.println("test failed - exception not thrown");
		}
		catch(IllegalArgumentException e) {
	    System.out.println("caught the expected illegal argument exception");
		}
		
		test(arrayList2, concatenate(arrayList2, arrayList2));
		test(arrayList3, concatenate(arrayList2, arrayList3));
		test(arrayList3, concatenate(arrayList3, arrayList2));
		test(arrayList5, concatenate(arrayList3, arrayList4));
	}
	
	public static void endToEndTester() {
		System.out.println("------------------------------------------");
		System.out.println("This is the test output of endToEnd():");
		Integer[] array1 = null;
		Integer[] array2 = {};
		Integer[] array3 = {1, 2, 3};
		Integer[] array4 = {4, 5, 6};
		Integer[] array5 = {3, 2, 1};
		Integer[] array6 = {1, 2, 3, 4, 5, 6};
		Integer[] array7 = {1, 2, 3, 6, 5, 4};
		
		ArrayList<Integer> arrayList1 = arrayListConverter(array1);
		ArrayList<Integer> arrayList2 = arrayListConverter(array2);
		ArrayList<Integer> arrayList3 = arrayListConverter(array3);
		ArrayList<Integer> arrayList4 = arrayListConverter(array4);
		ArrayList<Integer> arrayList5 = arrayListConverter(array5);
		ArrayList<Integer> arrayList6 = arrayListConverter(array6);
		ArrayList<Integer> arrayList7 = arrayListConverter(array7);
		
		try {
		concatenate(arrayList1, arrayList2);
	    System.out.println("test failed - exception not thrown");
		}
		catch(IllegalArgumentException e) {
	    System.out.println("caught the expected illegal argument exception");
		}
		
		test(arrayList2, endToEnd(arrayList2, arrayList2));
		test(arrayList5, endToEnd(arrayList2, arrayList3));
		test(arrayList3, endToEnd(arrayList3, arrayList2));
		test(arrayList7, endToEnd(arrayList3, arrayList4));
	}
	
	public static void reverseInPlaceTester() {
		System.out.println("------------------------------------------");
		System.out.println("This is the test output of reverseInPlace():");
		Integer[] array1 = null;
		Integer[] array2 = {};
		Integer[] array3 = {1, 2, 3};
		Integer[] array4 = {4, 5, 6, 7};
		Integer[] array5 = {null, 4, 5, 6, 7};
		Integer[] array3c = {3, 2, 1};
		Integer[] array4c = {7, 6, 5, 4};
		Integer[] array5c = {7, 6, 5, 4, null};
		
		ArrayList<Integer> arrayList1 = arrayListConverter(array1);
		ArrayList<Integer> arrayList2 = arrayListConverter(array2);
		ArrayList<Integer> arrayList3 = arrayListConverter(array3);
		ArrayList<Integer> arrayList4 = arrayListConverter(array4);
		ArrayList<Integer> arrayList5 = arrayListConverter(array5);
		ArrayList<Integer> arrayList3c = arrayListConverter(array3c);
		ArrayList<Integer> arrayList4c = arrayListConverter(array4c);
		ArrayList<Integer> arrayList5c = arrayListConverter(array5c);
		
		try {
			reverseInPlace(arrayList1);
			System.out.println("test failed - exception not thrown");
		}
		catch(IllegalArgumentException e) {
			System.out.println("caught the expected illegal argument exception");
		}
		
		reverseInPlace(arrayList2);
		reverseInPlace(arrayList3);
		reverseInPlace(arrayList4);
		reverseInPlace(arrayList5);
		System.out.println("Expected: " + arrayList2 + ", actual: "  + arrayList2);
		System.out.println("Expected: " + arrayList3c + ", actual: "  + arrayList3);
		System.out.println("Expected: " + arrayList4c + ", actual: "  + arrayList4);
		System.out.println("Expected: " + arrayList5c + ", actual: "  + arrayList5);
		
	}

	public static ArrayList<Integer> arrayListConverter (Integer[] array) {
		ArrayList<Integer> returnArrayList = new ArrayList<>();
		
		if (array == null) {
			returnArrayList = null;
		}
		
		else if (array.length != 0) {
			for (Integer i : array){
				returnArrayList.add(i);
			}
		}
		return returnArrayList;
		
	}
	
	public static void test(String expected, ArrayList<Integer> actual) {
	    System.out.println("Expected: " + expected +
	                       ", received: " + actual);
	}

	public static void test(ArrayList<Integer> expected, ArrayList<Integer> actual) {
		if (actual == null) {
			System.out.println("Expected: " + expected + ", received: " + actual);
		}
		
		else{
			System.out.println("Expected: " + expected +
	                       		", received: " + actual);
		}
	}

	public static void test(boolean expected, boolean actual) {
	    System.out.println("Expected: " + expected + ", received: " + actual);
	}
}
