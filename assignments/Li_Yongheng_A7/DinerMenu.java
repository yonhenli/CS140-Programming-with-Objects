package assignment07;

import java.util.ArrayList;

public class DinerMenu implements Menu{
	private ArrayList<MenuEntry> menuEntries = new ArrayList<>();
	
	public DinerMenu() {
		menuEntries.add(new MenuEntry("item 1", "description 1", true, new Price(10,50)));
		menuEntries.add(new MenuEntry("item 2", "description 2", false, new Price(11,99)));
		menuEntries.add(new MenuEntry("item 3", "description 3", true, new Price(12,28)));
		menuEntries.add(new MenuEntry("item 4", "description 4", false, new Price(6,68)));
		menuEntries.add(new MenuEntry("item 5", "description 5", true, new Price(8,68)));
		menuEntries.add(new MenuEntry("item 6", "description 6", false, new Price(9,98)));
	}
	
	public void addItem(String n, String d, boolean v, Price p) {
		menuEntries.add(new MenuEntry(n, d, v, p));
	}
	
	@Override
	public MenuEntryIterator createIterator() {
		return new DinerMenuIterator(menuEntries.toArray(new MenuEntry[]{}));
	}

}
