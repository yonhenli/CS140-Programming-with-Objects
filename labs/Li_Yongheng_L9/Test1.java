package lab09green;

import static org.junit.Assert.*;

import org.junit.Test;

public class Test1 {
	
	int[] nl = null;
    int[] ep = {};
    int[] arr1 = {5, 2, -3, 0, -4, 3};
    int[] arr2 = {5, -4, -3, 0, -4, 3};
	
    @Test
	public void test() {
		assertEquals(0.0, new Parent(nl).average(), 1e-6);
		assertEquals(0.0, new Parent(ep).average(), 1e-6);
		assertEquals(0.0, new Parent(nl).average(), 1e-6);
		assertEquals(0.5, new Parent(arr1).average(), 1e-6);
		assertEquals(-0.5, new Parent(arr2).average(), 1e-6);
		assertEquals(Integer.MAX_VALUE, new Parent(nl).min(), 1e-6);
		assertEquals(Integer.MAX_VALUE, new Parent(ep).min(), 1e-6);
		assertEquals(-4, new Parent(arr1).min(), 1e-6);
		assertEquals(-4, new Parent(arr2).min(), 1e-6);
		
		assertEquals(0.0, new Child(nl, ep).average(), 1e-6);
		assertEquals(0.0, new Child(ep, nl).average(), 1e-6);
		assertEquals(0.0, new Child(nl, nl).average(), 1e-6);
		assertEquals(0.0, new Child(ep, ep).average(), 1e-6);
		assertEquals(0.5, new Child(nl, arr1).average(), 1e-6);
		assertEquals(0.0, new Child(arr1, nl).average(), 1e-6);
    	assertEquals(0.0, new Child(arr1, ep).average(), 1e-6);
    	assertEquals(0.5, new Child(ep, arr1).average(), 1e-6);
    	assertEquals(0.5, new Child(arr2, arr1).average(), 1e-6);
    	assertEquals(-0.5, new Child(arr1, arr2).average(), 1e-6);
		assertEquals(Integer.MAX_VALUE, new Child(nl, ep).min(), 1e-6);
		assertEquals(Integer.MAX_VALUE, new Child(ep, nl).min(), 1e-6);
		assertEquals(Integer.MAX_VALUE, new Child(nl, nl).min(), 1e-6);
		assertEquals(Integer.MAX_VALUE, new Child(ep, ep).min(), 1e-6);
		assertEquals(-4, new Child(nl, arr1).min(), 1e-6);
		assertEquals(-4, new Child(arr1, nl).min(), 1e-6);
    	assertEquals(-4, new Child(arr1, ep).min(), 1e-6);
    	assertEquals(-4, new Child(ep, arr1).min(), 1e-6);
    	assertEquals(-4, new Child(arr2, arr1).min(), 1e-6);
    	assertEquals(-4, new Child(arr1, arr2).min(), 1e-6);
    	
	}

}
