package inf101.scrabble;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class ScrabbleTest {

	@Test
	void testCanMakeEksamen(){
		assertTrue(Scrabble.canMake("SKAMENE", "EKSAMEN"));
		assertTrue(Scrabble.canMake("skaMENE", "EKSAMEN"));
		assertTrue(Scrabble.canMake("SKAMENE", "eksAMEN"));
	}

	@Test
	void testCanNotMakeFerie(){
		assertFalse(Scrabble.canMake("SKAMENE", "FERIE"));
	}

	@Test
	void testNotEnoughOfSameLetter() {
		assertFalse(Scrabble.canMake("skamen", "EKSAMEN"));
	}
}
