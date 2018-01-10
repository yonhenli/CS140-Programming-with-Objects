/**
Li, Yongheng
CS140 A56
Assignment 2
*/

package assignment02;

public class Book{

private String title;
private int numPages;

	public Book (String aTitle, int anNumPages) {
	this.title = aTitle;
	this.numPages = anNumPages;	
	}

	public String getTitle() {	
	return title;
	}

	public int getNumPages() {
	return numPages;
	}
	
	public String toString() {
	return "\n" + title + ", " + numPages + " pages";
	}
}
