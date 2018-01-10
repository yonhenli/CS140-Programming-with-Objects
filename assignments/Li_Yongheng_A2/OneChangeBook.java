/**
Li, Yongheng
CS140 A56
Assignment 2
*/

package assignment02;

public class OneChangeBook {
	private Book [] array;
	
	public OneChangeBook(Book [] array){
		this.array = array;
	}
	
	public int smallestAfter(int start) {

		int smallestIndex = start;
		
		for (int i = start + 1; i < array.length; i++) {
			if (array[smallestIndex].getNumPages() > array[i].getNumPages()) {
				smallestIndex = i;
			}
		}
		
		return smallestIndex;
	}
	
	public Book [] modify(int start) {
		Book [] temp = new Book [array.length];
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
