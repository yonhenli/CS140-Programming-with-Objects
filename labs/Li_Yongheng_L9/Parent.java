package lab09green;

public class Parent {
	private int[] arr;
	
	public Parent(int[] arr) {
		this.arr = arr;
	}
	
	public double average() {
		if (arr == null || arr.length == 0) return 0;
		
		double sum = 0.0;
		for (int i = 0; i < arr.length; i++) {
			sum = sum + arr[i];
		}
		return sum / arr.length;
	}
	
	public int min() {
		if (arr == null || arr.length == 0) return Integer.MAX_VALUE;
	
		int min = 0;	
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] < min) min = arr[i];
		}
		return min;
	}
	
	
	
}
