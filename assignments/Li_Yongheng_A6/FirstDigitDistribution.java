package assignment06;

public class FirstDigitDistribution {
	private int[] counters;

	public FirstDigitDistribution() {
		counters = new int[10];
	}

	public void process(Sequence seq, int valuesToProcess) {
    	for (int i = 1; i <= valuesToProcess; i++) {
    		int value = seq.next();
    		
		    while (Math.abs(value) >= 10 ) {
		    	value = value / 10;
    		}
    		
    		counters[Math.abs(value)]++;
    	}
	}

	public void display() {
		for (int i = 0; i < counters.length; i++){          
		    System.out.print(i + ": " + counters[i] + " ");       
		    for ( int j = 0 ; j < counters[i] ; j++ ) {
		       System.out.print('*');       
		    }
		    System.out.println();
		}
	}
}