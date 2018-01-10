package lab05;

import java.util.ArrayList;

public class BankTester {
	public static void main (String[] args) {
		ArrayList<BankAccount> accounts = new ArrayList<>();
		BankAccount bkAc1 = new BankAccount(10);
		BankAccount bkAc2 = new BankAccount(20);
		
		SavingAccount svAc1 = new SavingAccount(30, 0.1);
		SavingAccount svAc2 = new SavingAccount(40, 0.2);
		
		CheckingAccount ckAc1 = new CheckingAccount(50, 3);
		CheckingAccount ckAc2 = new CheckingAccount(60, 4);
		
		accounts.add(bkAc1);
		accounts.add(svAc1);
		accounts.add(bkAc2);
		accounts.add(ckAc1);
		accounts.add(svAc2);
		accounts.add(ckAc2);
		
		System.out.println(accounts);
		
		for (BankAccount ba: accounts) {
			ba.deposit(100);
		}
		
		System.out.println(accounts);
		
		for (int i = 0; i < accounts.size(); i++) {
			for (int j = 0; j < 7; j++){
				accounts.get(i).withdraw(20);
			}
		}
		
		System.out.println(accounts);
		
		double temp1 = 10.0;
		int temp2 = 9;
		boolean temp3 = true;
		int[] temp4 = new int[4];
		
		
		
		ArrayList<Object> objectArray = new ArrayList<>();
		objectArray.add(bkAc1);
		objectArray.add(svAc1);
		objectArray.add(ckAc1);
		objectArray.add(bkAc2);
		objectArray.add(temp1);
		objectArray.add(temp2);
		objectArray.add(temp3);
		objectArray.add(temp4);
		
		for (Object ob: objectArray) {
			System.out.println(ob);
		}

		
	}
}
