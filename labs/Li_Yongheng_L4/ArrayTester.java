package lab04;

import java.util.Arrays;
import static lab04.ArrayPractice.*;

public class ArrayTester {
	public static void main (String[] args) {
	System.out.println("This is the test output of isNonDereasing():");
	int[] indArray1 = null;
	int[] indArray2 = {};
	int[] indArray3 = {1, 2, 3, 4, 5};
	int[] indArray4 = {1, 3, 4, 2, 5};
	int[] indAarray5 = {1, 2, 2, 3, 4, 5};
	test(true, isNonDecreasing(indArray1));
	test(true, isNonDecreasing(indArray2));
	test(true, isNonDecreasing(indArray3));
	test(false, isNonDecreasing(indArray4));
	test(true, isNonDecreasing(indAarray5));
	
	System.out.println("------------------------------------------");
	System.out.println("This is the test output of isIncreasing():");
	int[] isArray1 = null;
	int[] isArray2 = {};
	int[] isArray3 = {1, 2, 3, 4, 5, 6};
	int[] isArray4 = {1, 2, 3, 4, 4, 5};
	int[] isArray5 = {6, 5, 4, 3, 2, 1};
	test(true, isIncreasing(isArray1));
	test(true, isIncreasing(isArray2));
	test(true, isIncreasing(isArray3));
	test(false, isIncreasing(isArray4));
	test(false, isIncreasing(isArray5));
	
	System.out.println("------------------------------------------");
	System.out.println("This is the test output of reverse():");
	int[] rvArray1 = null;
	int[] rvArray2 = {};
	int[] rvArray3 = {1, 2, 3, 4, 5, 6};
	int[] rvArray4 = {1, 2, 3, 4, 4, 5};
	int[] rvArray1c = null;
	int[] rvArray2c = {};
	int[] rvArray3c = {6, 5, 4, 3, 2, 1};
	int[] rvArray4c = {5, 4, 4, 3 , 2, 1};
	test(rvArray1c, reverse(rvArray1));
	test(rvArray2c, reverse(rvArray2));
	test(rvArray3c, reverse(rvArray3));
	test(rvArray4c, reverse(rvArray4));

	
	System.out.println("------------------------------------------");
	System.out.println("This is the test output of concatenate():");
	int[] ccArray1 = null;
	int[] ccArray2 = {};
	int[] ccArray3 = {1, 2, 3};
	int[] ccArray4 = {4, 5, 6};
	int[] ccArray34c = {1, 2, 3, 4, 5, 6};
	
	try {
	concatenate(ccArray1, null);
    System.out.println("test failed - exception not thrown");
	}
	catch(IllegalArgumentException e) {
    System.out.println("caught the expected illegal argument exception");
	}
	
	test(ccArray2, concatenate(ccArray2, ccArray2));
	test(ccArray3, concatenate(ccArray2, ccArray3));
	test(ccArray3, concatenate(ccArray3, ccArray2));
	test(ccArray34c, concatenate(ccArray3, ccArray4));
	
	
	System.out.println("------------------------------------------");
	System.out.println("This is the test output of endToEnd():");
	int[] ntnArray1 = null;
	int[] ntnArray2 = {};
	int[] ntnrray3 = {1, 2, 3};
	int[] ntnArray4 = {4, 5, 6};
	int[] ntnrray3c = {3, 2, 1};
	int[] ntnArray34c = {1, 2, 3, 6, 5, 4};
	
	try {
	endToEnd(ntnArray2, null);
    System.out.println("test failed - exception not thrown");
	}
	catch(IllegalArgumentException e) {
    System.out.println("caught the expected illegal argument exception");
	}
	
	test(ntnArray2, endToEnd(ntnArray2, ntnArray2));
	test(ntnrray3c, endToEnd(ntnArray2, ntnrray3));
	test(ntnrray3, endToEnd(ntnrray3, ntnArray2));
	test(ntnArray34c, endToEnd(ntnrray3, ntnArray4));

	System.out.println("------------------------------------------");
	System.out.println("This is the test output of reverseInPlace():");
	int[] riArray1 = null;
	int[] riArray2 = {};
	int[] riArray3 = {1, 2, 3};
	int[] riArray4 = {4, 5, 6, 7};
	
	try {
		reverseInPlace(riArray1);
		System.out.println("test failed - exception not thrown");
	}
	catch(IllegalArgumentException e) {
		System.out.println("caught the expected illegal argument exception");
	}
	
	reverseInPlace(riArray2);
	reverseInPlace(riArray3);
	reverseInPlace(riArray4);
	System.out.println("Expected: [], " + "actual: "  + Arrays.toString(riArray2));
	System.out.println("Expected: {3, 2, 1}, " + "actual: "  + Arrays.toString(riArray3));
	System.out.println("Expected: {7, 6, 5, 4}, " + "actual: "  + Arrays.toString(riArray4));
	
	}
	
	
	public static void test(String expected, int[] actual) {
	    System.out.println("Expected: " + expected +
	                       ", received: " + Arrays.toString(actual));
	}

	public static void test(int[] expected, int[] actual) {
	    System.out.println("Expected: " + Arrays.toString(expected) +
	                       ", received: " + Arrays.toString(actual));
	}

	public static void test(boolean expected, boolean actual) {
	    System.out.println("Expected: " + expected + ", received: " + actual);
	}

}
