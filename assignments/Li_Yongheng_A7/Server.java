package assignment07;

public class Server{
	private Menu pancakeMenu;
	private Menu dinerMenu;
	
	public Server(Menu pancakeMenu, Menu dinerMenu){
		this.pancakeMenu = pancakeMenu;
		this.dinerMenu = dinerMenu;
	}
	
	private void printMenu(MenuEntryIterator iterator) {
		for (MenuEntry menuEntry : iterator.toIterable()){
			System.out.println(menuEntry);
		}
	}
	
	public void printMenu() {
		System.out.println("MENU\n----\nBREAKFAST");
		MenuEntryIterator pm = pancakeMenu.createIterator();
		printMenu(pm);
		System.out.println("\nLUNCH");
		MenuEntryIterator dm = dinerMenu.createIterator();
		printMenu(dm);
	}
	
	private boolean isVegetarian(String name, MenuEntryIterator iterator) {
		for (MenuEntry menuEntry : iterator.toIterable()){
			if (name  == menuEntry.getName() && menuEntry.getVegetarian()) {
				return true;
			}
		}
		return false;
	}
	
	private void printVegetarianMenu(MenuEntryIterator iterator) {
		for (MenuEntry menuEntry : iterator.toIterable()){
			if (menuEntry.getVegetarian()) {
				System.out.println(menuEntry);
			}
		}
	}
	
	public void printVegetarianMenu() {
		System.out.println("VEGETARIAN MENU\n----\nBREAKFAST");
		MenuEntryIterator pm = pancakeMenu.createIterator();
		printVegetarianMenu(pm);
		System.out.println("\nLUNCH");
		MenuEntryIterator dm = dinerMenu.createIterator();
		printVegetarianMenu(dm);
	}
	
	public boolean isEntryVegetarian(String name){
		return isVegetarian(name, pancakeMenu.createIterator()) ||
				isVegetarian(name, dinerMenu.createIterator());
	}
}
