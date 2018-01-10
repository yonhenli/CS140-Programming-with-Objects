package assignment08;

import java.util.ArrayList;
import java.util.Arrays;
import java.awt.geom.Point2D;

public class Factorize {
	public static ArrayList<Integer> factors(int n){
		ArrayList<Integer> arr = new ArrayList<>();
		int f = 2;
		
		if (n < 0){
			throw new IllegalArgumentException("illegal input!");
		}
	
		else if (n == 0 || n == 1) {
			return arr;
		}
	
		else if (n == 2) {
			arr.add(n);
			return arr;
		}
		
		while (n % f != 0) f++;
		arr.add(f);
		arr.addAll(factors(n/f));
		
		return arr;
	}
	
	public static String recursive(int n) {
		if (n < 0) {
			throw new IllegalArgumentException("illegal input!");
		}
		
		if (n == 0) return "";
		
		if (n % 2 == 0){
			return recursive(n/2) + "0";
		}
		
		return recursive(n/2) + "1";
	}
	
	public static String reverse(String text) {
		if (text == null) return null;
		else if (text.length() <= 0) return "";
		else if (text.length() == 1) return text;
		return text.charAt(text.length()-1) + 
				reverse(text.substring(1, text.length()-1)) +
				text.charAt(0);
	}
	
	public static int indexOf(String text, String str) {
		if (! text.toLowerCase().contains(str.toLowerCase())){
			return -1;
		}
		return indexOf(1, text, str);
	}
	
	private static int indexOf(int count, String text, String str) {
		if (text.startsWith(str)) return count;
		return indexOf(count+1, text.substring(1, text.length()), str);
	}
	
	public static double area(Point2D.Double[] pts) {
		if (pts.length == 3) {
			double a = pts[0].getX();
			double b = pts[0].getY();
			double c = pts[1].getX();
			double d = pts[1].getY();
			double e = pts[2].getX();
			double f = pts[2].getY();
			
			return Math.abs(a*d+c*f+e*b-b*c-d*e-f*a)/2;
		}
		
		double a = pts[0].getX();
		double b = pts[0].getY();
		double c = pts[1].getX();
		double d = pts[1].getY();
		double e = pts[pts.length-1].getX();
		double f = pts[pts.length-1].getY();
		
		double ar = Math.abs(a*d+c*f+e*b-b*c-d*e-f*a)/2;
		
		return ar + area(Arrays.copyOfRange(pts, 1, pts.length));
	}
}
