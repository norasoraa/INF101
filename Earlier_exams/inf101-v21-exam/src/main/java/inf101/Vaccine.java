package inf101;

import java.time.LocalDate;

public abstract class Vaccine implements Comparable<Vaccine> {

	private final LocalDate deliveryDate;
	
	public Vaccine(LocalDate deliveryDate) {
		this.deliveryDate = deliveryDate;
	}
	
	/**
	 * @return the date for when the vaccine is delivered.
	 */
	public LocalDate getDeliveryDate() {
		return deliveryDate;
	}
	
	/**
	 * @return the name of the vaccine.
	 */
	public abstract String getName();
	
	@Override
	public String toString() {
		return getName();
	}

	@Override
	public int compareTo(Vaccine o) {
		return this.deliveryDate.compareTo(o.deliveryDate);
	}
}
