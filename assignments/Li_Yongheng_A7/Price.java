package assignment07;

public class Price {
	private long dollars;
	private int cents;
	
	public Price(long dollars, int cents) {
		if (dollars < 0 || cents < 0 || cents >= 100) {
			throw new IllegalArgumentException(
					"illegal input!");
		}
		
		this.dollars = dollars;
		this.cents = cents;
	}
	
	public void changeUp(double percent) {
		if (percent < 0) {
			throw new IllegalArgumentException("percent must be positive!");
		}
		
		double pct = (double) percent / 100;
		double after = (double)((dollars * 100 + cents)) * (pct + 1.0) / 100;
		double appr = Math.round(after*100.0)/100.0;
		String apprStr = String.valueOf(appr);
		String[] strArr = apprStr.split("\\.");
		dollars = Long.parseLong(strArr[0]);
		cents = Integer.parseInt(strArr[1]);
	}
	
	public void changeDown(double percent) {
		if (percent < 0) {
			throw new IllegalArgumentException("percent must be positive!");
		}
		
		double pct = (double) percent / 100;
		double after = (double)((dollars * 100 + cents)) * (1.0 - pct) / 100;
		double appr = Math.round(after*100.0)/100.0;
		String apprStr = String.valueOf(appr);
		String[] strArr = apprStr.split("\\.");
		dollars = Long.parseLong(strArr[0]);
		cents = Integer.parseInt(strArr[1]);
	}
	
	@Override
	public String toString() {
		if (cents <= 9 ) {
			return "$" + dollars + "." + "0" + cents;
		}
		
		return "$" + dollars + "." + cents;
	}
}
