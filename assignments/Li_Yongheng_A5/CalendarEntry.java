package assignment05;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.time.DayOfWeek;
	
public class CalendarEntry {
	private LocalTime startTime;
	private LocalTime endTime;
	private LocalDate date;
	private ChronoUnit period;
	private DayOfWeek day;
	private String description;
	private String location;
	
	public CalendarEntry(LocalTime startTime, LocalTime endTime, ChronoUnit period){
		this.startTime = startTime;
		this.endTime = endTime;
		this.period = period;
	}
	
	public void setDate(LocalDate date) {
		this.date = date;
		day = date.getDayOfWeek();
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public void setLocation(String location) {
		this.location = location;
	}
	
	public LocalTime getStartTime() {
		return startTime;
	}
	
	public LocalTime getEndTime() {
		return endTime;
	}
	
	public LocalDate getDate() {
		return date;
	}
	
	public ChronoUnit getPeriod() {
		return period;
	}
	
	public DayOfWeek getDay() {
		return day;
	}
	
	public String getDescription() {
		return description;
	}
	
	public String getLocation() {
		return location;
	}
	
	public boolean meetsOn(LocalDate aDate) {
		return date.equals(aDate);
	}
	
	public CalendarEntry copyTo(DayOfWeek newDay) {
		CalendarEntry temp = new CalendarEntry(startTime, endTime, period);
		LocalDate tempDate = date;
		
		while (tempDate.getDayOfWeek() != newDay) {
			tempDate = tempDate.plusDays(1);
//			System.out.println("debugging" + tempDate);
		}
		
		temp.setDate(tempDate);
		temp.setDescription(description);
		temp.setLocation(location);
		
		return temp;
	}
	
	public String toString() {
		DateTimeFormatter df = DateTimeFormatter.ofPattern("EE MMMM dd, yyyy");
		DateTimeFormatter tf = DateTimeFormatter.ofPattern("hh:mm a");
		
		return description + ", " + location + ", " + date.format(df) + " from " + startTime.format(tf) + " to " + endTime.format(tf);
	}
}

