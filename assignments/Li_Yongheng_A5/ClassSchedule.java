package assignment05;

import java.util.ArrayList;
import java.time.LocalDate;

public class ClassSchedule {
	private ArrayList<Weekly> classDays = new ArrayList<>();
	private ArrayList<Daily> skipDays = new ArrayList<>();
	
	public void addClassDay(Weekly aDate) {
		classDays.add(aDate);
	}
	
	public void addSkipDate(Daily aDate) {
		skipDays.add(aDate);
	}
	
	public boolean meetsOn(LocalDate aDate) {
		boolean returnValue = false;
		boolean foundDate = false;

		for (int i = 0; i < skipDays.size() && ! foundDate; i++) {
			if (skipDays.get(i).meetsOn(aDate)) {
				returnValue = false;
				foundDate = true;
			}
		}
		
		for (int i = 0; i < classDays.size() && ! foundDate; i++) {
			if (classDays.get(i).meetsOn(aDate)) {
				returnValue = true;
				foundDate = true;
			}
		}
		return returnValue;
	}
	
	public Weekly getCopyForDay(LocalDate aDate) {
		
		for (int i = 0; i < classDays.size(); i++) {
			if (classDays.get(i).meetsOn(aDate)) {
				if (meetsOn(aDate)){
					return classDays.get(i).copy(aDate);
				}
			}
		}
		
		return null;
	}
}
