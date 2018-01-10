package assignment05;

import static java.time.DayOfWeek.*;
import java.time.LocalTime;
import java.time.LocalDate;

public class Tester {
	public static void main(String[] args) {
		LocalTime startTime = LocalTime.of(10, 50);
		LocalTime endTime = LocalTime.of(11, 50);
		LocalDate date = LocalDate.of(2017, 1, 18);
		
		CalendarEntry ce = new CalendarEntry(startTime, endTime, null);
		ce.setDate(date);
		
		System.out.println(ce);
		
		CalendarEntry ce2 = ce.copyTo(FRIDAY);
		System.out.println(ce2);
		
		CalendarEntry ce3 = ce.copyTo(MONDAY);
		System.out.println(ce3);
	}
}
