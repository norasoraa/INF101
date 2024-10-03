package eksamen.scrabble;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class ScrabbleSolution {

	/**
	 * This method is used by the game Scrabble where the goal is to rearrange
	 * some of the given letters into a word.
	 * A letter in Scrabble is always upper case, so we can ignore case in this method.
	 * You may assume that all letters in input are valid letters in the English alphabet.
	 * 
	 * @param letters - the letters you have to your disposal
	 * @param word - the word you are trying to form
	 * @return true if it is possible to form the word by rearranging the letters, false otherwise
	 */
	public static boolean canMake(String letters, String word) {
		//make all letters upper case as letters in Scrabble always is upper case
		letters = letters.toUpperCase();
		word = word.toUpperCase();
		
		for(Character c:word.toCharArray()) {
			if(countOccurences(word, c)>countOccurences(letters, c))
				return false;
		}
		return true;
	}
	
	/*
	 * Counts how many times c occurs in s
	 */
	private static int countOccurences(String s, Character c) {
		int count = 0;
		for(Character ch : s.toUpperCase().toCharArray()) {
			if(Character.toUpperCase(c) == Character.toUpperCase(ch)){
				count ++;
			}
		}
		return count;
	}

	@Test
	void testCanFormEksamen(){
		assertTrue(canMake("SKAMENE", "EKSAMEN"));
		assertTrue(canMake("skaMENE", "EKSAMEN"));
		assertTrue(canMake("SKAMENE", "eksAMEN"));
	}

	@Test
	void testCanNotFormFerie(){
		assertFalse(canMake("SKAMENE", "FERIE"));
	}

	@Test
	void testNotEnoughOfSameLetter(){
		assertFalse(Scrabble.canMake("SKAMNE", "EKSAMEN"));
	}

}
