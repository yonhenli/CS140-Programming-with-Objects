package assignment05;

import java.time.LocalTime;
import java.time.LocalDate;
import static java.time.temporal.ChronoUnit.DAYS;

public class Daily extends CalendarEntry {
	private LocalDate endDate;
	
	public Daily (LocalTime startTime, LocalTime endTime, LocalDate date) {
		super(startTime, endTime, DAYS);
		if (date == null) {
			throw new IllegalArgumentException("The date must not be null");
		}
		
		setDate(date);
	}
	
	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}
	
	public LocalDate getLocalDate() {
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
		
		if (endDate != null) {
			if (aDate.isAfter(endDate)) {
				returnValue = false;
				foundDate = true;
			}
		}
		
		LocalDate temp = getDate();
		temp = temp.plusDays(1);
		
		while (! foundDate) {
			if (temp.isEqual(aDate)) {
				returnValue = true;
				foundDate = true;
			}
			
			else if (temp.isAfter(aDate)) {
				returnValue = false;
				foundDate = true;
			}
			
			temp = temp.plusDays(1);
		}
	
		return returnValue;
	}
}
