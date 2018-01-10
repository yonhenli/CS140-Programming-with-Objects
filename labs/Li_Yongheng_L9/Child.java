package lab09green;

public class Child extends Parent{
	private int[] array;
	
	public Child(int[] arr, int[] array) {
		super(arr);
		this.array = array;
	}
	
	@Override
	public double average() {
		return new Parent(array).average();
	}
	
	@Override
	public int min() {
		return ((super.min() < new Parent(array).min()) ? super.min() : new Parent(array).min());
	}
}
