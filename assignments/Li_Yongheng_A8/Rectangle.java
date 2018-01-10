package assignment08;

public class Rectangle {
	private int width;
	private int height;
	
	public Rectangle(int width, int height) {
		if (width < 0 || height < 0) {
			throw new IllegalArgumentException("illegal input!");
		}
		this.width = width;
		this.height = height;
	}
	
	public int getArea() {
		if (height == 0) return 0;
		else if (width == 1) return 1*height;
		else if (width == 0) return 0;
		Rectangle smallerRect = new Rectangle(width-1, height);
		int smallerArea = smallerRect.getArea();
		return smallerArea + 1 * height;
	}
}
