/**
Li, Yongheng
CS140 A56
Assignment 2
*/

package assignment02;

public class WeirdSorter {
	private int [] array;
	
	public WeirdSorter (int [] array) {
		this.array = array;
	}
	
	public int [] sorted () {
		for (int i = 0; i < array.length; i++) {
			OneChange onchange = new OneChange(array);
			array = onchange.modify(i);
		}
		return array;
	}
}
