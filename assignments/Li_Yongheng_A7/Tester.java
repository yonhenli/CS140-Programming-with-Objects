package assignment07;

public class Tester {

	public static void main(String[] args) {
		PancakeMenu pancakeMenu = new PancakeMenu();
		DinerMenu dinerMenu = new DinerMenu();
		Server server = new Server(pancakeMenu, dinerMenu);
		dinerMenu.addItem("item 7", "description 7", true, new Price(11,50));
		server.printMenu();
		server.printVegetarianMenu();

		System.out.println("\nCustomer asks, is the Item 3 vegetarian?"); 
		// use the name of a lunch item that is not vegetarian in place of Item 3
		System.out.print("Server says: ");
		System.out.println(server.isEntryVegetarian("item 3")?"Yes":"No");
		System.out.println("\nCustomer asks, are the Item 7 vegetarian?");
		// use the name of a pancake item that is vegetarian in place of Item 7
		System.out.print("Server says: ");
		System.out.println(server.isEntryVegetarian("item 7")?"Yes":"No");
		
		changePrices(pancakeMenu);
		changePrices(dinerMenu);
		server.printMenu();
		server.printVegetarianMenu();
	}
	
	public static void changePrices(Menu menu) {
		for (MenuEntry menuEntry : menu.createIterator().toIterable()) {
			if (menuEntry.getVegetarian()) menuEntry.changeDown(5);
			else menuEntry.changeUp(10);
		}
	}

}
