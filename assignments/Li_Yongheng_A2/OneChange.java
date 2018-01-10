/**
Li, Yongheng
CS140 A56
Assignment 2
*/

package assignment02;

public class OneChange {
	private int [] array;
	
	public OneChange(int [] array){
		this.array = array;
	}
	
	public int smallestAfter(int start) {

		int smallestIndex = start;
		
		for (int i = start + 1; i < array.length; i++) {
			if (array[smallestIndex] > array[i]) {
				smallestIndex = i;
			}
		}
		return smallestIndex;
	}
	
	public int[] modify(int start) {
		int [] temp = new int [array.length];
		int k = smallestAfter(start);
		int j = 0;
		
		for (int i = 0; j < start; i++) {
			temp [i] = array[i];
			j++;
		}
		
		temp[start] = array[k];
		
		for (j = start; j < k; j++) {
			temp[j+1] = array[j];
		}
		
		for (j = k+1; j < array.length; j++) {
			temp[j] = array[j];
		}
		
		return temp;
	}
}
