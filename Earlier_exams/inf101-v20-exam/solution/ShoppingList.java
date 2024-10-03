package eksamen.shopping;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ShoppingList implements IShoppingList {

	private ArrayList<ShoppingItem> items;
	private final LocalDate date;

	/**
	 * Constructor with no arguments
	 */
	public ShoppingList() {
		this(LocalDate.now());
	}
	
	/**
	 * Constructor with Date as input
	 */
	public ShoppingList(LocalDate date){
		this.date = date;
		items = new ArrayList<ShoppingItem>();
	}
	
	@Override
	public List<ShoppingItem> getAllItems() {
		return new ArrayList<ShoppingItem>(items);
	}

	@Override
	public void add(ShoppingItem item) {
		if(item == null)
			throw new NullPointerException();
		items.add(item);
	}

	@Override
	public LocalDate getDate() {
		return date;
	}

	@Override
	public double totalPrice() {
		double sum = 0.0;
		for(ShoppingItem item : getAllItems())
			sum += item.getPrice();
		return sum;
	}

	@Override
	public int getItemCount(String itemName) {
		int count = 0;
		for(ShoppingItem item : getAllItems()) {
			if(item.getName().contentEquals(item.getName()))
				count ++;
		}
		return count;
	}
}
