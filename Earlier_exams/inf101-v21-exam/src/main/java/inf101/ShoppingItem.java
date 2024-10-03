package inf101;

/**
 * A shopping item is an item you purchase at the store. 
 * A shopping item has an item type, such as chicken, fruit,
 * vegetables, cleaning tools, soda, snacks, etc.,
 * and a brand, such as Fjordland, Tine, Prior, etc.
 * 
 * @author Sondre Bolland
 */
public class ShoppingItem {
	
	/** Type of shopping item */
	private String itemType;
	/** Brand (producer) of shopping item */
	private String brand;
	
	public ShoppingItem(String itemType, String brand) {
		this.itemType = itemType;
		this.brand = brand;
	}
	
	public String getItemType() {
		return itemType;
	}

	public String getBrand() {
		return brand;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof ShoppingItem) {
			ShoppingItem item = (ShoppingItem) obj;
			if (brand.equals(item.brand)) {
				return true;
			}
		}
		return false;
	}
}
