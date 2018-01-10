package assignment05;

import static java.time.DayOfWeek.*;
import java.time.LocalTime;
import java.time.LocalDate;

public class OneTime extends CalendarEntry{
	public OneTime(LocalTime startTime, LocalTime endTime, LocalDate date) {
		super(startTime, endTime, null);
		setDate(date);
	}
}
