package assignment04;

import static assignment04.ArrayListPractice.concatenate;

import java.util.ArrayList;
import java.util.Arrays;

import assignment03.Space;

public class House {
	private ArrayList<Space> spaces = new ArrayList<>();
	
	public void add(Space sp) {
		if (sp == null) {
			throw new IllegalArgumentException("cannot accept a null ArrayList!");
		}
		
		else {
			spaces.add(sp);
		}
	}
	
	
	public double totalArea() {
		double sumArea = 0.0;
		for (int i = 0; i < spaces.size(); i++) {
			if (spaces.get(i) != null) {
				sumArea += spaces.get(i).getArea();
			}
		}
		return sumArea;
	}
	
	public String toString() {
		return Arrays.toString(spaces.toArray());
	}
}

