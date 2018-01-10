package lab02;

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

	
}
