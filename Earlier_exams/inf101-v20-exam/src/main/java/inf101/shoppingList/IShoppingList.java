package inf101.shoppingList;

import java.time.LocalDate;
import java.util.List;

public interface IShoppingList {

	/**
	 * Returns a list of all items you need to buy.
	 * The order of items on this list is irrelevant.
	 * Multiple items to shop for should occur multiple times on the list.
	 * 
	 * E.g. If you have 3 apples on your shopping list 
	 * the list this method returns should contain 3 apples.
	 * 
	 * @return a list of all items to buy
	 */
	public List<ShoppingItem> getAllItems();
	
	/**
	 * Adds an item to this list.
	 * If item is not a valid ShoppingItem this method should throw an Exception.
	 * 
	 * @param item - the item to add
	 */
	public void add(ShoppingItem item);
	
	/**
	 * This gives the date this ShoppingList was created
	 * @return a date
	 */
	public LocalDate getDate();
	
	/**
	 * This gives the total sum of the price for all items in the list
	 * @return
	 */
	public double totalPrice();
	
	/**
	 * This methods checks how many items on the list has a given name.
	 * 
	 * @param itemName - the name of the item to count
	 * @return the number of items with the given name
	 */
	public int getItemCount(String itemName);
}
