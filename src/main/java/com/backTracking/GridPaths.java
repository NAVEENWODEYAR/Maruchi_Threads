package com.backTracking;

/**
 * @author NaveenWodeyar
 * @date 18-Jul-2025
 */

public class GridPaths {
    public static void findPaths(int row, int col, int n, int m, String path) {
        if (row == n - 1 && col == m - 1) {
            System.out.println(path);
            return;
        }

        // Move Right
        if (col + 1 < m) {
            findPaths(row, col + 1, n, m, path + "R");
        }

        // Move Down
        if (row + 1 < n) {
            findPaths(row + 1, col, n, m, path + "D");
        }
    }

    public static void main(String[] args) {
        int n = 2, m = 2;
        findPaths(0, 0, n, m, "");
    }
}
