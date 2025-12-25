/*
 * Topic: 2D Arrays (Data Structures & Algorithms)
 *
 * This file contains important 2D array problems commonly asked
 * in coding interviews and exams.
 *
 * Concepts Covered:
 * - Spiral Matrix Traversal
 * - Diagonal Sum (Brute Force)
 * - Diagonal Sum (Optimized Approach)
 * - Search in Sorted 2D Matrix (Staircase Search)
 *
 * Purpose:
 * - Daily DSA practice
 * - Interview preparation
 * - Quick revision reference
 *
 * Language: Java
 * Author: Aryan Nair
 */

public class Arrays {

    // ------------------------------------------------------------
    // Spiral Matrix Traversal
    // Prints elements of matrix in spiral order
    //
    // Time Complexity: O(n * m)
    // Space Complexity: O(1)
    // ------------------------------------------------------------
    public static void spiralMatrix(int[][] arr) {
        int st_row = 0;
        int st_col = 0;
        int end_row = arr.length - 1;
        int end_col = arr[0].length - 1;

        while (st_row <= end_row && st_col <= end_col) {

            // Top row
            for (int j = st_col; j <= end_col; j++) {
                System.out.print(arr[st_row][j] + " ");
            }

            // Right column
            for (int i = st_row + 1; i <= end_row; i++) {
                System.out.print(arr[i][end_col] + " ");
            }

            // Bottom row
            for (int j = end_col - 1; j >= st_col; j--) {
                if (st_row == end_row) {
                    break;
                }
                System.out.print(arr[end_row][j] + " ");
            }

            // Left column
            for (int i = end_row - 1; i >= st_row + 1; i--) {
                if (st_col == end_col) {
                    break;
                }
                System.out.print(arr[i][st_col] + " ");
            }

            st_row++;
            st_col++;
            end_row--;
            end_col--;
        }
        System.out.println();
    }

    // ------------------------------------------------------------
    // Diagonal Sum (Brute Force Approach)
    // Calculates sum of primary and secondary diagonals
    //
    // Time Complexity: O(n^2)
    // Space Complexity: O(1)
    // ------------------------------------------------------------
    public static int diagonalSumBruteForce(int[][] matrix) {
        int sum = 0;

        // Primary diagonal
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (i == j) {
                    sum += matrix[i][j];
                }
            }
        }

        // Secondary diagonal (avoid double count for center element)
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (i + j == matrix.length - 1 && i != j) {
                    sum += matrix[i][j];
                }
            }
        }
        return sum;
    }

    // ------------------------------------------------------------
    // Diagonal Sum (Optimized Approach)
    // Uses single loop instead of nested loops
    //
    // Time Complexity: O(n)
    // Space Complexity: O(1)
    // ------------------------------------------------------------
    public static int diagonalSumOptimizedForce(int[][] matrix) {
        int sum = 0;
        int n = matrix.length;

        for (int i = 0; i < n; i++) {
            // Primary diagonal
            sum += matrix[i][i];

            // Secondary diagonal (avoid double count if same element)
            if (i != n - 1 - i) {
                sum += matrix[i][n - 1 - i];
            }
        }
        return sum;
    }

    // ------------------------------------------------------------
    // Search in Sorted 2D Matrix (Staircase Search)
    // Matrix must be sorted row-wise and column-wise
    //
    // Time Complexity: O(n + m)
    // Space Complexity: O(1)
    // ------------------------------------------------------------
    public static void searchIn2DMatrix(int[][] matrix, int target) {
        int row = 0;
        int col = matrix[0].length - 1;

        while (row <= matrix.length - 1 && col >= 0) {
            if (matrix[row][col] == target) {
                System.out.println("Found at row " + row + " col " + col);
                return;
            } else if (matrix[row][col] < target) {
                row++;
            } else {
                col--;
            }
        }
        System.out.println("Not Found");
    }

    // ------------------------------------------------------------
    // Main Method (Test Code)
    // ------------------------------------------------------------
    public static void main(String[] args) {
        int[][] arr = {
            {10, 20, 30, 40},
            {15, 25, 35, 45},
            {27, 29, 37, 45},
            {32, 33, 39, 50}
        };

        searchIn2DMatrix(arr, 233);
        // spiralMatrix(arr);
        // System.out.println(diagonalSumOptimizedForce(arr));
    }
}