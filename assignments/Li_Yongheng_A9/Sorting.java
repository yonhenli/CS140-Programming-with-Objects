package assignment09;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Sorting {
	public static ArrayList<Integer> selection(ArrayList<Integer> list) {
		if (list == null) return null;
		else if (list.size() == 0) return new ArrayList<Integer>();
		
		int min = Collections.min(list);
		list.remove(list.indexOf(min));
		ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(min));
		arr.addAll(selection(list));
		
		return arr;
	}
	
	public static boolean inOrder(ArrayList<Integer> list) {
		if (list == null) return true;
		else if (list.size() == 0) return true;
	    
		boolean sorted = true;        
	    for (int i = 1; i < list.size() && sorted; i++) {
	        if (list.get(i-1).compareTo(list.get(i)) > 0) sorted = false;
	    }

	    return sorted;
	}
	
	private static ArrayList<Integer> less(ArrayList<Integer> list) {
		ArrayList<Integer> arr = new ArrayList<>();
		if (list.size() >= 1) {
			for (int i = 1; i < list.size(); i++) {
				if (list.get(i) < list.get(0)) {
					arr.add(list.get(i));
				}
			}
		}
		
		return arr;
	}
	
	private static ArrayList<Integer> geq(ArrayList<Integer> list) {
		ArrayList<Integer> arr = new ArrayList<>();
		for (int i = 1; i < list.size(); i++) {
			if (list.get(i) >= list.get(0)) {
				arr.add(list.get(i));
			}
		}
		
		return arr;
	}
	
	public static ArrayList<Integer> qsort(ArrayList<Integer> list) {
		if (list == null) return null;
		else if (list.size() == 0) return new ArrayList<Integer>();
		
		if (inOrder(list)) return new ArrayList<>(list);
		else {
			Integer pivot = list.get(0);
			ArrayList<Integer> temp = qsort(less(list));
			temp.add(pivot);
			temp.addAll(qsort(geq(list)));
			
			return temp;
		}
	}
}
