package lab04;

public class ArrayPractice{

/**
 * Determines if an array's elements are in non-decreasing order.
 * The array {1, 2, 2, 3, 4} is in non-decreasing order while
 * the array {1, 3, 4, 2, 5} is not in non-decreasing order as 2 < 4.
 * A null or empty array is by default in non-decreasing order.
 * @param array the array to inspect
 * @return true  if the array's elements are in non-decreasing order,
 *               or the array is null or empty
 *         false otherwise
 */
public static boolean isNonDecreasing(int[] array) {
	int lastValue;
	boolean returnValue = false;

	if (array == null || array.length == 0){
		returnValue = true;
	}

	if (array != null && array.length != 0) {
		returnValue = true;
		lastValue = array[0];
		
		for (int i = 1; returnValue == true && i < array.length; i++){
			if (lastValue > array[i]) {
				returnValue = false;
			}
			
			lastValue = array[i];
		}
		
//		returnValue = true;
//		for (int i = 0; i < array.length-1 && returnValue; i++) {
//			if (array[i+1] < array[i]) {
//				returnValue= false;
//			}
//		}
		
	}

	return returnValue;
}

/**
 * Determines if an array's elements are in strictly increasing order.
 * The array {1, 2, 3, 4, 5} is in increasing order while
 * the array {1, 2, 2, 4, 5} is not in increasing order as 2 == 2.
 * A null or empty array is by default in increasing order.
 * @param array the array to inspect
 * @return true  if the array's elements are in increasing order,
 *               or the array is null or empty
 *         false otherwise
 */
public static boolean isIncreasing(int[] array) {
	int lastValue;
	boolean returnValue = false;

	if (array == null || array.length == 0){
		returnValue = true;
	}

	if (array != null && array.length != 0) {
		returnValue = true;
		lastValue = array[0];
		
		for (int i = 1; returnValue == true && i < array.length; i++){
			if (lastValue >= array[i]) {
				returnValue = false;
			}
			
			lastValue = array[i];
		}
	}

	return returnValue;

}

/**
 * Computes the reverse an array.
 * The reverse of a null array is null.
 * The reverse of an empty array is the empty array.
 * Do NOT use reverseInPlace in the implementation of reverse
 * @param array the array whose elements are to be reversed
 * @return an array holding the contents of array in reverse order
 */
public static int[] reverse(int[] array) {
	int[] returnArray = array;
	int[] temp;

	if (array != null && array.length !=0) {
		temp = new int[array.length];
		
		for (int i = 0; i < array.length; i++) {
			temp[i] = array[array.length-(i+1)];
		}
		
		returnArray = temp;
	}
	
	return returnArray;
}

/**
 * Computes an array that is all the elements of arr1 in the order they appear,
 * followed by the elements of arr2 in the order they appear.
 * An empty array should contribute no elements to the concatenated
 * array.
 * e.g. concatenate({6, 3, 8}, {10, 1, 7}) should return {6, 3, 8, 10, 1, 7}
 * @param arr1 the first array
 * @param arr2 the second array
 * @return an array that is all the elements of arr1 in order,
 *         followed by the elements of arr2 in order.
 * @throws IllegalArgumentException if arr1 or arr2 is null
 */
public static int[] concatenate(int[] arr1, int[] arr2) {
	int[] returnArray = {};
	int[] temp;	
	boolean gotArray = false;
	
	if (arr1 == null || arr2 == null) {
		throw new IllegalArgumentException("cannot accept a null array!");
	}

	if (arr1.length == 0 && arr2.length != 0) {
		returnArray = arr2;
		gotArray = true;
	}

	else if (arr1.length != 0 && arr2.length == 0) {
		returnArray = arr1;
		gotArray = true;
	}

	else if (arr1.length == 0 && arr2.length == 0) {
		gotArray = true;
	}

	if (gotArray == false) {
		temp = new int[arr1.length + arr2.length];
		for (int i = 0; i < arr1.length; i++) {
			temp[i] = arr1[i];
		}
		
		int cnt = 0;
		for (int i = arr1.length; i < temp.length; i++) {
			temp[i] = arr2[cnt];
			cnt ++;
		}

		returnArray = temp;
	}

	return returnArray;

}

/**
 * Computes an array that is all the elements of arr1 in the order they appear,
 * followed by the elements of arr2 in the reverse order they appear
 * An empty array should contribute no elements to the resulting
 * array.
 * e.g. endToEnd({6, 3, 8}, {10, 1, 7}) should return {6, 3, 8, 7, 1, 10}
 * HINT: this method can use other methods in this class to assist it.
 *       ideally, this method is one short line of code.
 * @param arr1 the first array
 * @param arr2 the second array
 * @return an array that is all the elements of arr1 in order,
 * followed by the elements of arr2 in reverse order
 * @throws IllegalArgumentException if arr1 or arr2 is null
 */
public static int[] endToEnd(int[] arr1, int[] arr2) {
	int[] returnArray = {};
	int[] temp;	
	boolean gotArray = false;
	
	if (arr1 == null || arr2 == null) {
		throw new IllegalArgumentException("cannot accept a null array!");
	}

	if (arr1.length == 0 && arr2.length != 0) {
		returnArray = reverse(arr2);
		gotArray = true;
	}

	else if (arr1.length != 0 && arr2.length == 0) {
		returnArray = arr1;
		gotArray = true;
	}

	else if (arr1.length == 0 && arr2.length == 0) {
		gotArray = true;
	}

	if (gotArray == false) {
		temp = reverse(arr2);
		returnArray = concatenate(arr1, temp);
	}

	return returnArray;		
}

/**
 * Reverses the given array in-place.
 * Zero credit if another array is made.
 * The reverse of a null array is null.
 * The reverse of an empty array is the empty array.
 * Do NOT use reverse in the implementation of reverseInPlace
 * HINT: since we cannot make another array, we will have to swap certain
 *       elements one-by-one.
 * @param array the array to reverse
 */
public static void reverseInPlace(int[] array) {
	if (array == null) {
		throw new IllegalArgumentException("cannot accept a null array!");
	}
	
	if (array != null && array.length != 0) {
		if (array.length == 1) {}
		else {
			int temp;
			for (int i = 0; i < (array.length / 2); i++){
				temp = array[array.length-(1+i)];
				array[array.length-(1+i)] = array[i];
				array[i] = temp;
			}
		}
	}
}
}
