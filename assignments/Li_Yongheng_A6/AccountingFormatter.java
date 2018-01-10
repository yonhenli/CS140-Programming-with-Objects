package assignment06;

public class AccountingFormatter implements NumberFormatter {

	public String format(int n) {
		if (n < 0) return "(" + Integer.toString(n).replace("-", "") + ")";
		return "" + n;
	}

}
