package lab05;

public class CheckingAccount extends BankAccount{
	private int withdrawLimit;
	private int withdrawCount = 0;
	
	public CheckingAccount(double balance, int limit) {
		super(balance);
		this.withdrawLimit = limit;
	}
	
	public int getWithdrawLimit() {
		return withdrawLimit;
	}
	
	public int getWithdrawCount() {
		return withdrawCount;
	}
	
	@Override
	public double withdraw(double amount) {
		double temp = 0.0;
		
		if (withdrawCount < withdrawLimit) {
			temp = super.withdraw(amount);
			withdrawCount ++;
		}
		
		return temp;
	}
	
	@Override
	public String toString() {
		return super.toString() + " (" + withdrawCount + "/" + withdrawLimit + ")";
	}
}
