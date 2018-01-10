package assignment06;

public class DecimalSeperatorFormatter implements NumberFormatter {

	public String format(int n) {
		String intStr = Integer.toString(n);
		String intStrCopy = Integer.toString(n);
		
		// remove "-" if it is a negative
		if (n < 0) {
			intStr = intStr.replace("-", "");
			intStrCopy = intStr.replace("-", "");
		}
		
		int divisor = intStr.length() % 3;
		
		String temp = "";
		
		if (divisor != 0){
		temp = intStr.substring(0, divisor) + ",";
		intStrCopy = intStrCopy.substring(divisor, intStr.length());
		}
		
		for (int j = 0; j < intStrCopy.length() - divisor; j = j + 3) {
			temp = temp + intStrCopy.substring(j, j+3) + ",";
		}
		
		temp = temp.substring(0, temp.length() -1);
		
		if (n < 0) temp = "-" + temp;
		
		return temp;
	}
}
