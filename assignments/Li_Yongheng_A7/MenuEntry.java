package assignment07;

public class MenuEntry {
	private String name;
	private String description;
	private boolean vegetarian;
	private Price price;
	
	public MenuEntry(String name, String description,
			 boolean vegetarian, Price price) {
		this.name = name;
		this.description = description;
		this.vegetarian = vegetarian;
		this.price = price;
	}
	
	public void changeUp(double percent) {
		price.changeUp(percent);
	}

	public void changeDown(double percent) {
		price.changeDown(percent);
	}
	
	public String getName() {
		return name;
	}
	
	public String getDescription() {
		return description;
	}
	
	public boolean getVegetarian() {
		return vegetarian;
	}
	
	public Price getPrice() {
		return price;
	}
	
	@Override
	public String toString() {
		return name + ", " + price.toString() + " -- " + description;
	}
}
