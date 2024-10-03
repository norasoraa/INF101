package inf101.fridge;

import java.util.List;
public interface IFridge {
	
	/**
	 * Returns the number of items currently in the fridge
	 * 
	 * @return number of items in the fridge
	 */
	int nItemsInFridge();

	/**
	 * The fridge has a fixed (final) max size.
	 * Returns the total number of items there is space for in the fridge
	 * 
	 * @return total size of the fridge
	 */
	int totalSize();
	
	/***Place a food item in the fridge. Items can only be placed 
	 * in the fridge if there is space
	 * 
	 * @param item to be placed
	 * @return true if the item was placed in the fridge, false if not
	 */
	boolean placeIn(FridgeItem item);
	
	/** Remove item from fridge
	 * 
	 * @param item to be removed
	 * @throws IllegalArgumentException if fridge does not contain <code>item</code>
	 */
	void takeOut(FridgeItem item);

	/** Remove item from fridge.
	 * Finds fridgeItem with <code>itemName</code>. If there is more than one
	 * item with <code>itemName</code> find the item with oldest expirationdate
	 * 
	 * @param itemName
	 * @throws IllegalArgumentException if fridge does not contain <code>item</code>
	 * @return fridge item with oldest expiration date
	 */
	FridgeItem takeOut(String itemName);
	
	/** 
	 * Remove all items from the fridge
	 */
	void emptyFridge();
	
	/** Remove all items that have expired from the fridge
	 * 
	 * @return a list of all expired items
	 */
	List<FridgeItem> removeExpiredFood();
}
