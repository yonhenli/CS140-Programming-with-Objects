package assignment05;

import static java.time.DayOfWeek.*;
import static java.time.temporal.ChronoUnit.WEEKS;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.time.LocalDate;

public class Weekly extends CalendarEntry {
	private LocalDate endDate;
	
	public Weekly (LocalTime startTime, LocalTime endTime, LocalDate date) {
		super(startTime, endTime, WEEKS);
		if (date == null) {
			throw new IllegalArgumentException("The date must not be null");
		}
		
		setDate(date);
	}
	
	public void setEndDate(LocalDate date) {
		this.endDate = date;
	}
	
	public LocalDate getEndDate() {
		return endDate;
	}
	
	@Override
	public boolean meetsOn(LocalDate aDate) {
		boolean returnValue = false;
		boolean foundDate =false;
		
		if (aDate.isBefore(getDate())) {
			returnValue = false;
			foundDate = true;
		}
		
		if (getEndDate() != null) {
			if (aDate.isAfter(getEndDate())) {
				returnValue = false;
				foundDate = true;
			}
		}
		
		LocalDate temp = getDate();
		temp = temp.plusWeeks(1);
		
		while (! foundDate) {
			if (temp.isEqual(aDate)) {
				returnValue = true;
				foundDate = true;
			}
			
			else if (temp.isAfter(aDate)) {
				returnValue = false;
				foundDate = true;
			}
			
			temp = temp.plusWeeks(1);
		}
		return returnValue;
	}
	
	public Weekly copy(LocalDate aDate) {

		Weekly wk = new Weekly(super.getStartTime(), super.getEndTime(), getDate());
		wk.setDate(aDate);
		
		wk.setDescription(getDescription());
		wk.setLocation(getLocation());
		
		return wk;
	}
	
	@Override
	public Weekly copyTo(DayOfWeek newDay) {
		Weekly temp = new Weekly(getStartTime(), getEndTime(), getDate());
		LocalDate tempDate = getDate();
		
		while (tempDate.getDayOfWeek() != newDay) {
			tempDate = tempDate.plusDays(1);
//			System.out.println("debugging" + tempDate);
		}
		
		temp.setDate(tempDate);
		temp.setEndDate(getEndDate());
		temp.setDescription(getDescription());
		temp.setLocation(getLocation());
		
		return temp;
	}
}
