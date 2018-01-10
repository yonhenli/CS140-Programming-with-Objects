package lab07;

public class RepeatIterator implements IntIterator{
	private int field;
	
	public RepeatIterator(int field) {
		super();
		this.field = field;
	}

	public boolean hasNext() {
		return true;
	}

	public Integer next() {
		return field;
	}
	
}
