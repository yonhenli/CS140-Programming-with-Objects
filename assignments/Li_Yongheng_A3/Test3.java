/**
Li, Yongheng
CS140 A56
Assignment 2
*/

package assignment03;

public class Test3 {
	public static void main (String[] args) {
		Space space1 = new Space ("bedroom", 20.0);
		Space space2 = new Space ("kitchen", 15.0);
		Space space3 = new Space ("living room 1", 30.0);
		Space space4 = new Space ("living room 2", 35.0);
		Space space5 = new Space ("living room 2", 40.0);
		
		House house1 = new House();
		house1.add(space1);
		house1.add(space2);
		house1.add(space3);
		house1.add(space4);
		
		System.out.println("This is the test output of House: ");
		System.out.println(house1);
		System.out.println("\n");
		System.out.println("The area of the house: " + house1.totalArea());
		
		
		// test the biggestFloorSpace()
		House house2 = new House();
		house2.add(space1);
		house2.add(space2);
		house2.add(space3);
		house2.add(space5);
		House[] houseArray1 = null;
		House[] houseArray2 = {};
		House[] houseArray3 = {null, null, null};
		House[] houseArray4 = {house1, house2, house2, house1};
		House[] houseArray5 = {house1, null, house2, house1};
		System.out.println("\n");
		System.out.println("This is the test output for biggestFloorSpace(): ");
		System.out.println(biggestFloorSpace(houseArray1));
		System.out.println(biggestFloorSpace(houseArray2));
		System.out.println(biggestFloorSpace(houseArray3));
		System.out.println(biggestFloorSpace(houseArray4));
		System.out.println(biggestFloorSpace(houseArray5));
	}
	
	
	public static House biggestFloorSpace(House[] houses) {
		House returnObj = null;
		double biggestArea;
		boolean findInitialValue = false;
		
		if (houses != null) {
			for (int i = 0; i < houses.length; i++) {

				if (houses[i] != null && ! findInitialValue) {
					returnObj = houses[i];
					findInitialValue = true;
				}
				
				if (houses[i] != null && houses[i].totalArea() > returnObj.totalArea()) {
					returnObj = houses[i];
				}
			}
		}
		return returnObj;
	}
}
