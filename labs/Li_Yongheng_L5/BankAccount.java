package lab05;

public class BankAccount {
	private double balance;
	private int idNum;
	static int numAccounts = 0;
	
	public BankAccount (double balance) {
		this.balance = balance;
		if (balance < 0 ) {
			throw new IllegalArgumentException("the balance is negative!");
		}
		
		this.idNum = numAccounts;
		numAccounts ++;
	}
	
	public double getBalance() {
		return balance;
	}
	
	public int getIdNum() {
		return idNum;
	}
	
	public void deposit(double amount) {
		balance = balance + amount;
	}
	
	public double withdraw(double amount) {
		if (balance < amount) {
			balance = 0.0;
			amount = amount - balance;
		}
		
		else {
			balance = balance - amount;
		}
		
		return amount;
	}
	
	@Override
	public String toString() {
		return "Acct. #" + idNum + " has $" + balance;
	}
}
