package assignment05;

import java.time.LocalTime;
import java.time.LocalDate;
import static java.time.DayOfWeek.*;

public class Tester1 {
	public static void main(String[] args) {
		Weekly test = new Weekly(LocalTime.of(10, 50), LocalTime.of(11, 50), LocalDate.of(2017, 1, 18));
		test.setEndDate(LocalDate.of(2017, 5, 9));
		
		for(LocalDate d = test.getDate(); d.isBefore(LocalDate.of(2017, 5, 10)); d = d.plusDays(1)) {
		    if(test.meetsOn(d)) {
		        System.out.println(test.copy(d));
		    }
		}
		
		Weekly test1 = new Weekly(LocalTime.of(10, 50), LocalTime.of(11, 50), LocalDate.of(2017, 1, 18));
		test1.setEndDate(LocalDate.of(2017, 5, 9));
		test1.setDescription("CS 140 Class");
		test1.setLocation("UU 108");
		System.out.println(test1);
		
		Weekly test2 = test1.copyTo(FRIDAY);
		System.out.println(test2);
	}
}
