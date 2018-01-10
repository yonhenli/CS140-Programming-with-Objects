package assignment04;

import static assignment04.ArrayListPractice.concatenate;

import java.util.ArrayList;
import assignment03.Space;

public class HouseTester {
	public static void main (String[] args) {
		System.out.println("This is the test output of House: ");
		
		Space space1 = new Space ("bedroom", 20.0);
		Space space2 = new Space ("kitchen", 15.0);
		Space space3 = new Space ("living room 1", 30.0);
		Space space4 = new Space ("living room 2", 35.0);
		Space space5 = new Space ("living room 2", 40.0);
		Space space6 = null;
		
		House house1 = new House();
		
		house1.add(space1);
		house1.add(space2);
		house1.add(space3);
		house1.add(space4);
		
		try {
			house1.add(space6);
			System.out.println("test failed - exception not thrown");
		}
		catch(IllegalArgumentException e) {
			System.out.println("caught the expected illegal argument exception");
		}
		
		System.out.println("This is the test output of House: ");
		System.out.println(house1);
		System.out.println("\n");
		System.out.println("The area of the house: " + house1.totalArea());
	
		
		//test for biggestFloorSpace()
		House house2 = new House();
		house2.add(space1);
		house2.add(space2);
		house2.add(space3);
		house2.add(space5);
		House[] houseArray1 = null;
		House[] houseArray2 = {};
		House[] houseArray3 = {house1};
		House[] houseArray4 = {house1, house2, house2, house1};
		House[] houseArray5 = {house1, house2, house2, house1, house1};
		
		ArrayList<House> arrayList1 = arrayListConverter(houseArray1);
		ArrayList<House> arrayList2 = arrayListConverter(houseArray2);
		ArrayList<House> arrayList3 = arrayListConverter(houseArray3);
		ArrayList<House> arrayList4 = arrayListConverter(houseArray4);
		ArrayList<House> arrayList5 = arrayListConverter(houseArray5);
		
		System.out.println("\n");
		System.out.println("This is the test output for biggestFloorSpace(): ");
		System.out.println(biggestFloorSpace(arrayList1));
		System.out.println(biggestFloorSpace(arrayList2));
		System.out.println(biggestFloorSpace(arrayList3));
		System.out.println(biggestFloorSpace(arrayList4));
		System.out.println(biggestFloorSpace(arrayList5));
	}

	public static House biggestFloorSpace(ArrayList<House> houses) {
		House returnObj = null;
		boolean findInitialValue = false;
		
		if (houses != null) {
			for (int i = 0; i < houses.size(); i++) {
	
				if (houses.get(i) != null && ! findInitialValue) {
					returnObj = houses.get(i);
					findInitialValue = true;
				}
				
				if (houses.get(i) != null && houses.get(i).totalArea() > returnObj.totalArea()) {
					returnObj = houses.get(i);
				}
			}
		}
		return returnObj;
	}

	public static ArrayList<House> arrayListConverter (House[] array) {
		ArrayList<House> returnArrayList = new ArrayList<>();
	
		if (array == null) {
			returnArrayList = null;
		}
		
		else if (array.length != 0) {
			for (House i : array){
				returnArrayList.add(i);
			}
		}
		return returnArrayList;
	}
}
