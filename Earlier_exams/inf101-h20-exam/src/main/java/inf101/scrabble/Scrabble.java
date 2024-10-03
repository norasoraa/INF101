package inf101.scrabble;

import java.util.ArrayList;
import java.util.List;

public class Scrabble {

	
	/**
	 * This list contains all the words that are allowed to write in Scrabble.
	 * Words are only using upper case letters A-Z
	 */
	List<String> dictionary;

	/**
	 * Constructor creates a new Scrabble object.
	 * 
	 * @param dictionary - all the words that are allowed to write in Scrabble 
	 */
	public Scrabble(List<String> dictionary) {
		this.dictionary = new ArrayList<String>();
		for(String word : dictionary) {
			this.dictionary.add(word.toUpperCase());
		}
	}

	/**
	 * This method checks the dictionary to see if a given word can be found in
	 * the dictionary.
	 * 
	 * This method should ignore the case of the letters, i.e.
	 * "apple" and "aPPle" should return the same value
	 * 
	 * @param word - the word you want to write
	 * @return true if it is a word in the dictionary, otherwise false 
	 */
	public boolean canWrite(String word) {
		word = word.toUpperCase();
		if (dictionary.contains(word)) {
			return true;
		}
		return false;
	}
	
	/**
	 * This method searches through the dictionary to find 
	 * the longest word in the dictionary that is possible to make with the given letters.
	 * The method canMake() in this file may help you.
	 * 
	 * Normally in Scrabble each player have 7 letters available, 
	 * but your code should work for any number of letters.
	 * 
	 * @param letters - the letters you have available
	 * @return the longest word in the dictionary that can be made from the given letters.
	 */
	public String longestWord(String letters) {
		int wordLength = 0;
		String longestWord = "";
		for (String word : dictionary) {
			if (canMake(letters, word)) {
				if (word.length() > wordLength) {
					wordLength = word.length();
					longestWord = word;
				}
			}
		}
		return longestWord;
	}
	
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
}
