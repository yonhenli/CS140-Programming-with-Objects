package assignment05;

import static java.time.DayOfWeek.*;
import static java.time.temporal.ChronoUnit.MONTHS;

import java.time.LocalTime;
import java.time.LocalDate;

public class Monthly extends CalendarEntry {
	public Monthly (LocalTime startTime, LocalTime endTime, LocalDate date) {
		super(startTime, endTime, MONTHS);
		if (date == null) {
			throw new IllegalArgumentException("The date must not be null");
		}
		
		setDate(date);
	}
}
