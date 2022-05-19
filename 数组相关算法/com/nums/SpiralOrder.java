package com.nums;

import java.util.ArrayList;

public class SpiralOrder {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        ArrayList<Integer> results = spiralOrder(matrix);
        results.forEach(r -> System.out.print(r + " "));
    }

    public static ArrayList<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> results = new ArrayList();
        if (matrix != null && matrix.length > 0) {
            int left = 0;
            int right = matrix[0].length - 1;
            int up = 0;
            int down = matrix.length - 1;
            int i;
            while (true) {
                for (i = left; i <= right; i++) {
                    results.add(matrix[up][i]);
                }
                if ((++up) > down) {
                    break;
                }
                for (i = up; i <= down; i++) {
                    results.add(matrix[i][right]);
                }
                if (--right < left) {
                    break;
                }
                for (i = right; i >= left; i--) {
                    results.add(matrix[down][i]);
                }
                if (--down < up) {
                    break;
                }
                for (i = down; i >= up; i--) {
                    results.add(matrix[i][left]);
                }
                if (++left > right) {
                    break;
                }
            }
        }
        return results;
    }
}