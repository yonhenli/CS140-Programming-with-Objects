package lab07;

public class CyclicIterator implements IntIterator{
	private int[] arr;
	private int pos = 0;
	
	public CyclicIterator(int[] arr) {
		this.arr = arr;
	}
	
	public boolean hasNext() {
		return true;
	}

	public Integer next() {
		int temp = pos;
		pos ++;
		if (pos == arr.length) {
			pos = 0;
		}
		return arr[temp];
	}

}
