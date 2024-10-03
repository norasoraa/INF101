package inf101.shoppingList;

public class ShoppingItem {

	private String name;
	private double price;
	
	public ShoppingItem(String name, double price) {
		super();
		this.name = name;
		this.price = price;
	}

	public String getName() {
		return name;
	}
	
	public double getPrice() {
		return price;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof ShoppingItem) {
			return getName().equals(((ShoppingItem) obj).getName());
		}
		return false;
	}
}


