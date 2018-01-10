/**
Li, Yongheng
CS140 A56
Assignment 2
*/

package assignment02;

import java.util.Arrays;

public class OneChangeBookTest {
	public static void main (String[] args) {
		Book[] test1 = {
				new Book("Book A", 3), 
				new Book("Book B", 7),
				new Book("Book C", 9),
				new Book("Book D", 10),
				new Book("Book E", 2),
				new Book("Book F", 6),
				new Book("Book G", 3),
				new Book("Book H", 1)
			};
		OneChangeBook one = new OneChangeBook(test1);
		System.out.println(Arrays.toString(test1));
		System.out.println(Arrays.toString(one.modify(4)));
	}
}
