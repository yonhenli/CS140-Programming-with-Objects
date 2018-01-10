package lab08;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

public class Tests {
	@Test
	public void testFactorial() {
		assertEquals(1, Recursion.factorial(0));
		assertEquals(1, Recursion.factorial(1));
	    assertEquals(120, Recursion.factorial(5));
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void testSquareRoot() {
		assertEquals(0.0, Recursion.squareRoot(0.0), 1e-6);
		assertEquals(1.0, Recursion.squareRoot(1.0), 1e-6);
		assertEquals(3.0, Recursion.squareRoot(9.0), 1e-6);
	}
	
	@Test
	public void testSumArrayList() {
		ArrayList<Integer> arr1 = new ArrayList<>(Arrays.asList(1, 2, 3));
		ArrayList<Integer> arr2 = new ArrayList<>(Arrays.asList(4, 5, 6));
		ArrayList<Integer> arr3 = new ArrayList<>(Arrays.asList(7, 8, 9));
		assertEquals(6, Recursion.sum(arr1));
		assertEquals(15, Recursion.sum(arr2));
		assertEquals(24, Recursion.sum(arr3));
	}
	
	
	@Test
	public void testSumArray() {
		int[] arr1 = {1, 2, 3};
		int[] arr2 = {4, 5, 6};
		int[] arr3 = {7, 8, 9};
		assertEquals(6, Recursion.sum(arr1));
		assertEquals(15, Recursion.sum(arr2));
		assertEquals(24, Recursion.sum(arr3));
	}
	
	@Test
	public void testBinomialCoefficient() {
		assertEquals(28, Recursion.binomialCoefficient(8, 2));
		assertEquals(210, Recursion.binomialCoefficient(10, 6));
	}
}
