package lab09green;

import java.util.ArrayList;

public class Question3 {
	private int num;
	
	public Question3(int num) {
		this.num = Math.abs(num);
	}
	
	//???
	public int smallestNum() {
		if (num <= 1) return num;
		for (int i = 2; i < num; i++) {
			if (num % i == 0) return i;
		}
		return num;
	}
	
	public ArrayList<Integer> decomp() {
		int numCopy = num;
		ArrayList<Integer> arr = new ArrayList<>();
		
		if (num <= 1) return arr;
		
		while (num > 1) {
			int temp = smallestNum();
			arr.add(temp);
			num = num / temp;
		}
		
		num = numCopy;
		
		return arr;
	}
	
	public String toString() {
		if (num == 0) return "0 = 0";
		else if (num == 1) return "1 = 1";
		String arrStr = decomp().toString();
		arrStr = arrStr.replace(",", " x");
		arrStr = arrStr.replace("[", "");
		arrStr = arrStr.replace("]", "");
		
		return num + " = " + arrStr;
	}

}
