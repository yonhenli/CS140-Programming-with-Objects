/**
Li, Yongheng
CS140 A56
Assignment 2
*/

package assignment02;

public class OneChange1 {
	private int [] array;
	
	public OneChange1(int [] array){
		this.array = array;
	}
	
	public int greatestAfter(int start) {

		int greatestIndex = start;
		for (int i = start + 1; i < array.length; i++) {
			if (array[greatestIndex] < array[i]) {
				greatestIndex = i;
			}
		}

		return greatestIndex;
	}
	
	public int[] modify(int start) {
		int [] temp = new int [array.length];
		int k = greatestAfter(start);
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
