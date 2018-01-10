package assignment06;

public class BaseFormatter implements NumberFormatter {
	private int base;
	
	public BaseFormatter (int base) {
		this.base = base;
	}
	
	public String format(int n) {
		return Integer.toString(n, base);
	}
}
