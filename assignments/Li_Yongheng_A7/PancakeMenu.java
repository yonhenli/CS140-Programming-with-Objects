package assignment07;

import java.util.ArrayList;

public class PancakeMenu implements Menu{
	private ArrayList<MenuEntry> menuEntries = new ArrayList<>();
	
	public PancakeMenu() {
		menuEntries.add(new MenuEntry("pancake 1", "description 1", true, new Price(9,50)));
		menuEntries.add(new MenuEntry("pancake 2", "description 2", false, new Price(10,99)));
		menuEntries.add(new MenuEntry("pancake 3", "description 3", true, new Price(11,28)));
		menuEntries.add(new MenuEntry("pancake 4", "description 4", false, new Price(8,68)));
	}
	
	public void addItem(String n, String d, boolean v, Price p) {
		menuEntries.add(new MenuEntry(n, d, v, p));
	}
	
	@Override
	public MenuEntryIterator createIterator() {
		return MenuEntryIterator.adapt(menuEntries.iterator());
	}
	
}
