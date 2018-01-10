package assignment04;

import java.util.ArrayList;

public class ArrayListPractice {

	public static boolean isNonDecreasing(ArrayList<Integer> arrayList) {
		boolean returnValue = false;

		if (arrayList == null || arrayList.size() == 0){
			returnValue = true;
		}

		if (arrayList != null && arrayList.size() != 0) {
			returnValue = true;
			Integer lastValue = 0;
			boolean findFirstValue = false;
			int firstIndexValue = 0;
			
			for (int i = 0; returnValue == true && i < arrayList.size(); i++){
				if (arrayList.get(i) != null) {
					if (!findFirstValue) {
						lastValue = arrayList.get(i);
						findFirstValue = true;
						firstIndexValue = i;
					}
					
					if (findFirstValue && i != firstIndexValue) {
						if (lastValue > arrayList.get(i)) {
							returnValue = false;
						}
					
						lastValue = arrayList.get(i);
					}
				}
			}
		}

		return returnValue;
	}

	public static boolean isIncreseaing(ArrayList<Integer> arrayList) {
		boolean returnValue = false;

		if (arrayList == null || arrayList.size() == 0){
			returnValue = true;
		}

		if (arrayList != null && arrayList.size() != 0) {
			returnValue = true;
			Integer lastValue = 0;
			boolean findFirstValue = false;
			int firstIndexValue = 0;
			
			for (int i = 0; returnValue == true && i < arrayList.size(); i++){
				if (arrayList.get(i) != null) {
					if (!findFirstValue) {
						lastValue = arrayList.get(i);
						findFirstValue = true;
						firstIndexValue = i;
					}
					
					if (findFirstValue && i != firstIndexValue) {
						if (lastValue >= arrayList.get(i)) {
							returnValue = false;
						}
					
						lastValue = arrayList.get(i);
					}
				}
			}
		}

		return returnValue;
	}

	public static ArrayList<Integer> reverse(ArrayList<Integer> arrayList) {
		ArrayList<Integer> returnArrayList = arrayList;
		ArrayList<Integer> temp = new ArrayList<>();

		if (arrayList != null && arrayList.size() > 0) {
			for (int i = 0; i < arrayList.size(); i++) {
				temp.add(arrayList.get(arrayList.size()-(i+1)));
			}
			
			returnArrayList = temp;
		}
		
		return returnArrayList;
	}
	
	public static ArrayList<Integer> concatenate(ArrayList<Integer> arrayList1, ArrayList<Integer> arrayList2) {
		ArrayList<Integer> returnArray = new ArrayList<>();
		ArrayList<Integer> temp = new ArrayList<>();	
		boolean gotArray = false;
		
		if (arrayList1 == null || arrayList2 == null) {
			throw new IllegalArgumentException("cannot accept a null array!");
		}

		if (arrayList1.size() == 0 && arrayList2.size() != 0) {
			returnArray = arrayList2;
			gotArray = true;
		}

		else if (arrayList1.size() != 0 && arrayList2.size() == 0) {
			returnArray = arrayList1;
			gotArray = true;
		}

		else if (arrayList1.size() == 0 && arrayList1.size() == 0) {
			gotArray = true;
		}

		if (gotArray == false) {
			for (int i = 0; i < arrayList1.size(); i++) {
				temp.add(arrayList1.get(i));
			}
			
			for (int i = 0; i < arrayList2.size(); i++) {
				temp.add(arrayList2.get(i));
			}

			returnArray = temp;
		}

		return returnArray;
	}

	public static ArrayList<Integer> endToEnd(ArrayList<Integer> arrayList1, ArrayList<Integer> arrayList2) {
		ArrayList<Integer> returnArray = new ArrayList<>();
		ArrayList<Integer> temp = new ArrayList<>();	
		boolean gotArray = false;
		
		if (arrayList1 == null || arrayList2 == null) {
			throw new IllegalArgumentException("cannot accept a null array!");
		}

		if (arrayList1.size() == 0 && arrayList2.size() != 0) {
			returnArray = reverse(arrayList2);
			gotArray = true;
		}

		else if (arrayList1.size() != 0 && arrayList2.size() == 0) {
			returnArray = arrayList1;
			gotArray = true;
		}

		else if (arrayList1.size() == 0 && arrayList2.size() == 0) {
			gotArray = true;
		}

		if (gotArray == false) {
			temp = reverse(arrayList2);
			returnArray = concatenate(arrayList1, temp);
		}
		return returnArray;		
	}

	public static void reverseInPlace(ArrayList<Integer> arrayList) {
		if (arrayList == null) {
			throw new IllegalArgumentException("cannot accept a null array!");
		}
		
		if (arrayList != null && arrayList.size() != 0) {
			if (arrayList.size() > 1) {
				Integer temp;
				for (int i = 0; i < (arrayList.size() / 2); i++){
					temp = arrayList.get(arrayList.size()-(1+i));
					arrayList.set(arrayList.size()-(1+i), arrayList.get(i));
					arrayList.set(i, temp);
				}
			}
		}
	}
}
