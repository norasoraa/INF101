package inf101.fridge;

import java.time.LocalDate;

public class FridgeItem implements Comparable<FridgeItem> {

	private String name;
	private LocalDate expirationDate;

	public FridgeItem(String name, LocalDate expirationDate) {
		this.name = name;this.expirationDate = expirationDate;
	}

	/** Checks the expiration date of the item against the current date.
	 *If the expiration date is later than the current date then the item
	 *has expired
	 *
	 *@return true if fridge item has expired
	 */
	public boolean hasExpired() {
		return LocalDate.now().isAfter(expirationDate);
	}

	public String getName() {
		return name;
	}

	public LocalDate getExpirationDate() {
		return expirationDate;
	}

	@Override
	public String toString() {
		return name + ", " + expirationDate;
	}
	
	@Override
	public int compareTo(FridgeItem o) {
		return expirationDate.compareTo(o.expirationDate);
	}
}