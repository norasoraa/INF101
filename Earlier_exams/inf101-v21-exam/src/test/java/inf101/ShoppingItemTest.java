package inf101;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ShoppingItemTest {

	@Test
	public void shoppingItemEqualsTest() {
		ShoppingItem chicken1 = new ShoppingItem("chicken", "Prior");
		ShoppingItem chicken2 = new ShoppingItem("chicken", "Prior");
		ShoppingItem noodles = new ShoppingItem("noodles", "MrLee");
		assertNotEquals(chicken1, null);assertNotEquals(null, chicken1);
		assertNotEquals(chicken1, noodles);assertNotEquals(noodles, chicken1);
		assertEquals(chicken1, chicken1);
		assertEquals(chicken1, chicken2);
	}

}
