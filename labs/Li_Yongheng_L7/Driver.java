package lab07;

public class Driver {

	public static void printFor(IntIterator itr, int limit) {
		int temp = 0;
		for (int i : itr.toIterable()) {
			System.out.print(i + ", ");
			temp ++;
			if (temp == limit) break;
		}
		
		System.out.println();
	}
	
	public static void main (String[] args) {
		//this is the test of RepeatIterator:
		RepeatIterator ri1 = new RepeatIterator(10);
		RepeatIterator ri2 = new RepeatIterator(20);
		System.out.println("this is the test output of RepeatIterator:");
		printFor(ri1, 5);
		printFor(ri2, 10);
		
		//this is the test of CyclicIetrator:
		int[] arrA = {1,2,3};
		int[] arrB = {1,2,3,4};
		CyclicIterator ci1 = new CyclicIterator(arrA);
		CyclicIterator ci2 = new CyclicIterator(arrB);
		System.out.println("this is the test output of CyclicIetrator:");
		printFor(ci1, 5);
		printFor(ci1, 7);
		
		//this is the test of CountIterator:
		CountIterator cni1 = new CountIterator(2,2);
		System.out.println("this is the test output of CountIterator:");
		printFor(cni1, 7);
		
		CountIterator cni2 = new CountIterator(2,3,10);
		for (int i : cni2.toIterable()) {
			System.out.print(i + ", ");
		}
		System.out.println();
		
		//this is the test of ZipIterator:
		System.out.println("this is the test output of ZipIterator:");
		Integer[] arr2 = {1,2,3,4};
		Double[] arr3 = {1.0,2.0,3.0,4.0,5.0};
		String[] arr4 = {"a","b","c","d","2"};
		Double[] arr5 = {1.0,2.0,3.0,4.0};
		
		ZipIterator<Integer, Double> zi1 = new ZipIterator<>(arr2, arr3);
		ZipIterator<String, Double> zi2 = new ZipIterator<>(arr4, arr5);
		
		for (Pair<Integer, Double> i : zi1.toIterable()) {
			System.out.print(i + ", ");
		}
		System.out.println();
		
		for (Pair<String, Double> i : zi2.toIterable()) {
			System.out.print(i + ", ");
		}
		System.out.println();
	}
}
	
