package assignment08;

import static org.junit.Assert.*;

import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

import assignment08.Rectangle;

public class Tests {

	@Test
	public void test() {
		Rectangle rct = new Rectangle(0,5);
		assertEquals(0, rct.getArea());
		
		Rectangle rct1 = new Rectangle(5,0);
		assertEquals(0, rct.getArea());
		
		Rectangle rct2 = new Rectangle(6,5);
		assertEquals(30, rct2.getArea());
	}
	
	@Test
	public void test1() {
		ArrayList<Integer> arr = new  ArrayList<>();
		ArrayList<Integer> arr1 = new  ArrayList<>(Arrays.asList(2, 3, 11));
		ArrayList<Integer> arr2 = new  ArrayList<>(Arrays.asList(67));
		assertEquals(arr, Factorize.factors(0));
		assertEquals(arr, Factorize.factors(1));
		assertEquals(arr1, Factorize.factors(66));
		assertEquals(arr2, Factorize.factors(67));
	}
	
	@Test
	public void test2() {
		assertEquals("100110", Factorize.recursive(38));
		assertEquals("100111", Factorize.recursive(39));
	}
	
	@Test
	public void test3() {
		assertEquals("cba", Factorize.reverse("abc"));
		assertEquals("", Factorize.reverse(""));
		assertEquals(null, Factorize.reverse(null));
	}
	
	@Test
	public void test4() {
		assertEquals(-1, Factorize.indexOf("abcdefg", "z"));
		assertEquals(10, Factorize.indexOf("abcdefghijklmnopq", "jklmn"));
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void test5() {
		Point2D.Double[] pts = 
			{new Point2D.Double(1,3), new Point2D.Double(2,2),
			new Point2D.Double(2,1), new Point2D.Double(1,0),
			new Point2D.Double(0,1), new Point2D.Double(0,2)};
		
		Point2D.Double[] pts1 = 
			{new Point2D.Double(0,0), new Point2D.Double(0,0),
			new Point2D.Double(0,0)};
		
		assertEquals(4.0, Factorize.area(pts), 1e-6);
		assertEquals(0.0, Factorize.area(pts1), 1e-6);
	}

}
