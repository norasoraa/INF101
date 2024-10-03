package INF101.lab1.INF100labs;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Implement the methods removeThrees, uniqueValues and addList.
 * These programming tasks was part of lab5 in INF100 fall 2022/2023. You can find them here: https://inf100h22.stromme.me/lab/5/
 */
public class Lab5 {
    
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(1,4,5,6,3,2,3));
        ArrayList<Integer> list2 = new ArrayList<>(Arrays.asList(7,8,4,2,4,45));
        System.out.println(multipliedWithTwo(list));
        System.out.println(removeThrees(list));
        System.out.println(uniqueValues(list2));
        addList(list, list2);
        System.out.println(list);
    }

    public static ArrayList<Integer> multipliedWithTwo(ArrayList<Integer> list) {
        ArrayList<Integer> multipliedWithTwo = new ArrayList<>();
        for (int number : list) {
            multipliedWithTwo.add(number*2);
        }
        return multipliedWithTwo;
    }

    public static ArrayList<Integer> removeThrees(ArrayList<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == 3) {
                list.remove(i);
                i--;
            }
        }
        return list;
    }

    public static ArrayList<Integer> uniqueValues(ArrayList<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.size(); j++) {
                if (i != j & list.get(i) == list.get(j)) {
                    list.remove(j);
                    j--;
                }
            }
        }
        return list;
    }

    public static void addList(ArrayList<Integer> a, ArrayList<Integer> b) {
        for (int i = 0; i < a.size(); i++) {
            a.set(i, a.get(i)+b.get(i));
        }
    }

}