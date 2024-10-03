package INF101.lab1.INF100labs;

import java.util.ArrayList;

/**
 * Implement the methods removeRow and allRowsAndColsAreEqualSum.
 * These programming tasks was part of lab7 in INF100 fall 2022/2023. You can find
 * them here: https://inf100h22.stromme.me/lab/7/
 */
public class Lab7 {

    public static void main(String[] args) {
        // Call the methods here to test them on different inputs

    }

    public static void removeRow(ArrayList<ArrayList<Integer>> grid, int row) {
        grid.remove(row);
    }

    public static boolean allRowsAndColsAreEqualSum(ArrayList<ArrayList<Integer>> grid) {
        ArrayList<Integer> firstRow = new ArrayList<>(grid.get(0));
        int sumFirstRow = 0;
        for (int i = 0; i < firstRow.size(); i++) {
            sumFirstRow += firstRow.get(i);
        } 
        for (int i = 0; i < grid.size(); i++) {
            int sumCurrentRow = 0;
            ArrayList<Integer> currentRow = new ArrayList<>(grid.get(i));
            for (int j = 0; j < currentRow.size(); j++) {
                sumCurrentRow += currentRow.get(j);
            }
            if (sumFirstRow != sumCurrentRow) {
                return false;
            }
        }
        ArrayList<Integer> firstCol = new ArrayList<>();
        for (int i = 0; i < 1; i++) {
            for (int j = 0; j < (grid.get(i)).size(); j++) {
                firstCol.add(grid.get(j).get(i));
            }
        }
        int sumFirstCol = 0;
        for (int i = 0; i < firstCol.size(); i++) {
                sumFirstCol += firstCol.get(i);    
        }
        for (int i = 0; i < grid.size(); i++) {
            int sumCurrentCol = 0;    
            ArrayList<Integer> currentCol = new ArrayList<>();
            for (int j = 0; j < (grid.get(i)).size(); j++) {
                currentCol.add(grid.get(j).get(i));
            }
            for (int j = 0; j < currentCol.size(); j++) {
                sumCurrentCol += currentCol.get(j);
            }
            if (sumFirstCol != sumCurrentCol) {
                return false;
            }
        }
        return true;
    }

}