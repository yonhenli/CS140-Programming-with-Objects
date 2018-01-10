package assignment06;

public class PrimeSequence implements Sequence{
	private int num = 1;
	
	public int next() {
		do {
		    num += 1;
		} while (!isPrime(num));
		
		return num;
	}
	
	boolean isPrime(int n) {
	    for(int i=2; i<n; i++) {
    		if(n % i == 0) return false;
	    }
	    return true;
	}
	
}
