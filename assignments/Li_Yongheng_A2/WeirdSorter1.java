/**
Li, Yongheng
CS140 A56
Assignment 2
*/

package assignment02;

public class WeirdSorter1 {
	private int [] array;
	
	public WeirdSorter1 (int [] array) {
		this.array = array;
	}
	
	public int [] sorted () {
		for (int i = 0; i < array.length; i++) {
			OneChange1 onchange = new OneChange1(array);
			array = onchange.modify(i);
		}
		return array;
	}
}
