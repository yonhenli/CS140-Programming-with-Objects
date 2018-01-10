package assignment05;

import java.time.LocalTime;
import java.time.LocalDate;

public class Tester2 {
	public static void main(String[] args) {
		Daily bk1 = new Daily(LocalTime.of(0, 1), LocalTime.of(23, 59), LocalDate.of(2017, 3, 3));
		Daily bk2 = new Daily(LocalTime.of(0, 1), LocalTime.of(23, 59), LocalDate.of(2017, 4, 8));
		bk1.setEndDate(LocalDate.of(2017, 3, 7));
		bk2.setEndDate(LocalDate.of(2017, 4, 17));
		
		Weekly cd1 = new Weekly(LocalTime.of(10, 50), LocalTime.of(11, 50), LocalDate.of(2017, 1, 9));
		Weekly cd2 = new Weekly(LocalTime.of(10, 50), LocalTime.of(11, 50), LocalDate.of(2017, 1, 11));
		Weekly cd3 = new Weekly(LocalTime.of(16, 25), LocalTime.of(17, 50), LocalDate.of(2017, 1, 12));
		Weekly cd4 = new Weekly(LocalTime.of(10, 50), LocalTime.of(11, 50), LocalDate.of(2017, 1, 13));
		cd1.setEndDate(LocalDate.of(2017, 5, 10));
		cd2.setEndDate(LocalDate.of(2017, 5, 10));
		cd2.setEndDate(LocalDate.of(2017, 5, 10));
		cd3.setEndDate(LocalDate.of(2017, 5, 10));
		
		cd1.setDescription("CS 140 class");
		cd1.setLocation("UU 108");
		cd2.setDescription("CS 140 class");
		cd2.setLocation("UU 108");
		cd3.setDescription("CS 140 lab");
		cd3.setLocation("LSG 108");
		cd4.setDescription("CS 140 class");
		cd4.setLocation("UU 108");
		
		ClassSchedule schedule = new ClassSchedule();
		schedule.addSkipDate(bk1);
		schedule.addSkipDate(bk2);

		schedule.addClassDay(cd1);
		schedule.addClassDay(cd2);
		schedule.addClassDay(cd3);
		schedule.addClassDay(cd4);
		
		for(LocalDate d = LocalDate.of(2017, 1, 18); d.isBefore(LocalDate.of(2017, 5, 10)); d = d.plusDays(1)) {
			if(schedule.meetsOn(d)) {
				System.out.println(schedule.getCopyForDay(d));
			}		
		}
	}
}
