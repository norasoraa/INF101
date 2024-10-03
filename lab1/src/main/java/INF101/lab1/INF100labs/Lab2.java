package INF101.lab1.INF100labs;

/**
 * Implement the methods findLongestWords, isLeapYear and isEvenPositiveInt.
 * These programming tasks was part of lab2 in INF100 fall 2022/2023. You can find them here: https://inf100h22.stromme.me/lab/2/
 */
public class Lab2 {
    
    public static void main(String[] args) {
        findLongestWords("cow", "cat", "horse");
        System.out.println(isLeapYear(1996));
        System.out.println(isEvenPositiveInt(6538));
    }

    public static void findLongestWords(String word1, String word2, String word3) {
        int length1 = word1.length();
        int length2 = word2.length();
        int length3 = word3.length();
        int longestWord = Math.max(length1, Math.max(length2, length3));
        if (length1 >= longestWord) {
            System.out.println(word1);
        }
        if (length2 >= longestWord) {
            System.out.println(word2);
        }
        if (length3 >= longestWord) {
            System.out.println(word3);
        }
    }

    public static boolean isLeapYear(int year) {
        if (year % 400 == 0 && year % 100 == 0) {
            return true;
        }
        else if (year % 4 == 0 && year % 100 != 0) {
            return true;
        }
        else {
            return false;
        }
    }

    public static boolean isEvenPositiveInt(int num) {
        if (num % 2 == 0 && num > 0) {
            return true;
        }
        else {
            return false;
        }
    }

}
