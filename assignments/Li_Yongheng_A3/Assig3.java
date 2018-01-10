/**
Li, Yongheng
CS140 A56
Assignment 2
*/

package assignment03;

public class Assig3 {
	public static boolean hasNegative (double[] arr) {
		boolean returnValue = false;
		
		if (arr != null && arr.length >0) {
			for (int i = 0; i < arr.length && !returnValue; i++){
				if (arr[i] < 0) {
					returnValue = true;
					}
				}
		}
		return returnValue;
	}
	
	public static int indexOf(double value, double[] arr) {
		int returnValue = -1;

		if (arr == null) {
			returnValue = -3;
		}
		
		else if (arr != null && arr.length == 0) {
			returnValue = -2;
		}
		
		else if ((arr != null) && (arr.length > 0)) {
			for (int i = 0; (i < arr.length) && (returnValue < 0); i++) {
				if (Math.abs(value - arr[i]) < 1e-9) {
					returnValue = i;
				}
			}
		}
		
		return returnValue;
	}
	
	public static int indexOf2(double value, double[] arr) {
		
		if (arr == null) {
			return -3;
		}
		
		else if (arr != null && arr.length == 0) {
			return -2;
		}
		
		else if ((arr != null) && (arr.length > 0)) {
			for (int i = 0; i < arr.length; i++) {
				if (Math.abs(value - arr[i]) < 1e-9) {
					return i;
				}
			}
		}
		return -1;
	}
	
	public static int indexOf3(int value, int[] arr) {
		int returnValue = - arr.length - 1;
		boolean hasValue = false;
		
		for (int i = 0; i < arr.length && ! hasValue; i++) {
			if (value == arr[i]) {
				returnValue = i;
				hasValue = true;
			}
		}
		
		if ( value < arr[0] ) {
			returnValue = -1;
			hasValue = true;
		}
		
		for (int i = 0; i < arr.length && ! hasValue; i++) {
			if (value < arr[i]) {
				returnValue = - i - 1;
				hasValue = true;
			}
		}
		
		return returnValue;
	}
	
	public static int[] insertIfNeeded(int value, int[] arr) {
		int k;
		int[] returnArray = {};
		int[] arr1 = new int[arr.length+1];
		k = indexOf3(value, arr);
		
		if (k >= 0) {
			returnArray = arr;
		}
		
		if (k < 0) {
			System.arraycopy(arr, 0, arr1, 0, -k-1);
			arr1[-k-1] = value;
			System.arraycopy(arr, -k-1, arr1, -k, arr.length+k+1);
			returnArray = arr1;
		}
		
		return returnArray;
	}

}
