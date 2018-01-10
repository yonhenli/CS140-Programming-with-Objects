/**
Li, Yongheng
CS140 A56
Assignment 2
*/

package assignment02;

import java.util.Arrays;

public class WeirdSorterBookTest {
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
		WeirdSorterBook ws = new WeirdSorterBook(test1);
		System.out.println(Arrays.toString(ws.sorted()));
		
		System.out.println("The average pages of the books: " + avgPagesInLibrary(test1));
	}
	

	public static double avgPagesInLibrary(Book[] books) {
		double avgPages = 0.0;
		int totalPages = 0;
		
		for (int i = 0; i < books.length; i++) {
			totalPages += books[i].getNumPages();
		}
		
		avgPages = (double)totalPages / (double)books.length;
		
		return avgPages;
	}
}
