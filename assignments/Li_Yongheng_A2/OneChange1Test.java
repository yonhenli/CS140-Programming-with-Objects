/**
Li, Yongheng
CS140 A56
Assignment 2
*/

package assignment02;

import java.util.Arrays;

public class OneChange1Test {
	public static void main (String[] args) {
		int[] test = {3,7,9,10,2,6,3,1,2};
		OneChange1 one = new OneChange1(test);
		System.out.println(Arrays.toString(test));
		System.out.println(Arrays.toString(one.modify(4)));

	}
}
