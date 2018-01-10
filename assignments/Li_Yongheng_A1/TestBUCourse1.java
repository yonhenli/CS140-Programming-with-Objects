/**
Li, Yongheng
CS140 A56
Assignment 1
*/

package assignment01;

import java.io.IOException;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class TestBUCourse1 {
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		BUCourse1 crs = null;
		int cnt1 = 0;
		int cnt2 = 0;
		
		try (FileInputStream inStream = new FileInputStream("courses.objs");) {
			ObjectInputStream objInStream = new ObjectInputStream(inStream);
			while(true) {
				crs = (BUCourse1)objInStream.readObject();	
				if(crs != null) {
					if (crs.getCrs().charAt(0) == '1') {
						cnt1 ++;
					}
					
					if (crs.getCrs().charAt(0) == '2') {
						cnt2 ++;
					}
					
				}
			}
		} catch(IOException ex) {
			System.out.println("Number of 100-level courses = " + cnt1);
			System.out.println("Number of 200-level courses = " + cnt2);
		}
	}
}
