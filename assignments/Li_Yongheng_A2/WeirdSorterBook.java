/**
Li, Yongheng
CS140 A56
Assignment 2
*/

package assignment02;

public class WeirdSorterBook {
	private Book [] array;
	
	public WeirdSorterBook (Book [] array) {
		this.array = array;
	}
	
	public Book [] sorted () {
		for (int i = 0; i < array.length; i++) {
			OneChangeBook onchange = new OneChangeBook(array);
			array = onchange.modify(i);
		}
		return array;
	}
}
