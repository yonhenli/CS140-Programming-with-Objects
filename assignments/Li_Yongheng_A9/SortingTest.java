package assignment09;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

public class SortingTest {

	@Test
	public void selectionTest() {
		ArrayList<Integer> arr = new ArrayList<>();
		ArrayList<Integer> arr1 = new ArrayList<>(Arrays.asList(-8, 10, -10, 3, -4));
		ArrayList<Integer> arrSorted = new ArrayList<>(Arrays.asList(-10, -8, -4, 3,10));
		assertEquals(null, Sorting.selection(null));
		assertEquals(arr, Sorting.selection(arr));
		assertEquals(arrSorted, Sorting.selection(arr1));
	}
	
	public void inOrderTest() {
		ArrayList<Integer> arr = new ArrayList<>();
		ArrayList<Integer> arr1 = new ArrayList<>(Arrays.asList(-8, 10, -10, 3, -4));
		ArrayList<Integer> arrSorted = new ArrayList<>(Arrays.asList(-10, -8, -4, 3,10));
		assertEquals(true, Sorting.inOrder(null));
		assertEquals(true, Sorting.inOrder(arr));
		assertEquals(false, Sorting.inOrder(arr1));
		assertEquals(true, Sorting.inOrder(arrSorted));
	}
	
	public void qsort() {
		ArrayList<Integer> arr = new ArrayList<>();
		ArrayList<Integer> arr1 = new ArrayList<>(Arrays.asList(-8, 10, -10, 3, -4));
		ArrayList<Integer> arrSorted = new ArrayList<>(Arrays.asList(-10, -8, -4, 3, 10));
		assertEquals(null, Sorting.qsort(null));
		assertEquals(arr, Sorting.qsort(arr));
		assertEquals(arrSorted, Sorting.qsort(arr1));
	}

}
