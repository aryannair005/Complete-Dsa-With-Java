/*
 * Topic: Backtracking (Data Structures & Algorithms)
 *
 * This file contains frequently asked backtracking
 * interview and exam problems implemented in Java.
 *
 * Purpose:
 * - Daily DSA practice
 * - Interview preparation
 * - Quick revision before exams
 *
 * Language: Java
 * Author: Aryan Nair
 */

import java.util.ArrayList;

public class Backtracking {

    // ------------------------------------------------------------
    // Utility Method to Print Array
    // ------------------------------------------------------------
    public static void printArr(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    // ------------------------------------------------------------
    // Q1. Change Array using Backtracking
    //
    // Demonstrates backtracking by modifying values
    // and reverting changes while returning
    // ------------------------------------------------------------
    public static void changeArray(int[] arr, int i) {
        if (i == arr.length) {
            return;
        }
        arr[i] = i + 1;
        changeArray(arr, i + 1);
        arr[i] -= 2; // backtracking step
    }

    // ------------------------------------------------------------
    // Q2. Generate All Subsets of a String (Using String)
    //
    // Example:
    // "abc" -> null a b ab c ac bc abc
    //
    // Time Complexity: O(2^n)
    // ------------------------------------------------------------
    public static void subsets(String str, String newStr, int idx) {
        if (idx == str.length()) {
            if (newStr.equals("")) {
                System.out.print("null ");
            } else {
                System.out.print(newStr + " ");
            }
            return;
        }

        // Exclude
        subsets(str, newStr, idx + 1);

        // Include
        subsets(str, newStr + str.charAt(idx), idx + 1);
    }

    // ------------------------------------------------------------
    // Q3. Generate All Subsets of a String (Using StringBuilder)
    //
    // Optimized version using backtracking
    // ------------------------------------------------------------
    public static void subsets(String str, StringBuilder newStr, int idx) {
        if (idx == str.length()) {
            if (newStr.length() == 0) {
                System.out.print("null ");
            } else {
                System.out.print(newStr + " ");
            }
            return;
        }

        // Exclude
        subsets(str, newStr, idx + 1);

        // Include
        newStr.append(str.charAt(idx));
        subsets(str, newStr, idx + 1);

        // Backtrack
        newStr.deleteCharAt(newStr.length() - 1);
    }

    // ------------------------------------------------------------
    // Q4. Generate All Permutations of a String
    //
    // Example:
    // "abc" -> abc acb bac bca cab cba
    //
    // Time Complexity: O(n!)
    // ------------------------------------------------------------
    public static void permutations(String str, String ans) {
        if (str.length() == 0) {
            System.out.print(ans + " ");
            return;
        }

        for (int i = 0; i < str.length(); i++) {
            char curr = str.charAt(i);
            String newStr = str.substring(0, i) + str.substring(i + 1);
            permutations(newStr, ans + curr);
        }
    }

    // ------------------------------------------------------------
    // Q5. N-Queens Problem (Print All Solutions)
    // ------------------------------------------------------------
    static int count = 0;

    public static void nQueen(char[][] board, int row) {
        if (row == board.length) {
            count++;
            printBoard(board);
            return;
        }

        for (int j = 0; j < board[0].length; j++) {
            if (isSafe(board, row, j)) {
                board[row][j] = 'Q';
                nQueen(board, row + 1);
                board[row][j] = '.'; // backtrack
            }
        }
    }

    // ------------------------------------------------------------
    // Q6. N-Queens Problem (Find One Solution)
    // ------------------------------------------------------------
    public static boolean nQueenOneSolution(char[][] board, int row) {
        if (row == board.length) {
            printBoard(board);
            return true;
        }

        for (int j = 0; j < board[0].length; j++) {
            if (isSafe(board, row, j)) {
                board[row][j] = 'Q';
                if (nQueenOneSolution(board, row + 1)) {
                    return true;
                }
                board[row][j] = '.';
            }
        }
        return false;
    }

    // ------------------------------------------------------------
    // Helper Method to Check Queen Safety
    // ------------------------------------------------------------
    public static boolean isSafe(char[][] board, int row, int col) {

        // Vertical up
        for (int i = row; i >= 0; i--) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }

        // Left diagonal
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        // Right diagonal
        for (int i = row, j = col; i >= 0 && j < board.length; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        return true;
    }

    // ------------------------------------------------------------
    // Utility Method to Print Chess Board
    // ------------------------------------------------------------
    public static void printBoard(char[][] board) {
        System.out.println("-----Board-----");
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    // ------------------------------------------------------------
    // Q7. Grid Ways Problem
    // (Count paths from (0,0) to (n-1,m-1))
    //
    // Time Complexity: O(2^(n+m))
    // ------------------------------------------------------------
    public static int gridWays(int i, int j, int n, int m) {
        if (i == n - 1 && j == m - 1) {
            return 1;
        } else if (i == n || j == m) {
            return 0;
        }

        return gridWays(i + 1, j, n, m) + gridWays(i, j + 1, n, m);
    }

    // ------------------------------------------------------------
    // Q8. Sudoku Solver
    // ------------------------------------------------------------
    public static boolean sudokuSolver(int[][] sudoku, int row, int col) {
        if (row == 9) {
            return true;
        }

        int nextRow = row;
        int nextCol = col + 1;
        if (nextCol == 9) {
            nextRow = row + 1;
            nextCol = 0;
        }

        if (sudoku[row][col] != 0) {
            return sudokuSolver(sudoku, nextRow, nextCol);
        }

        for (int digit = 1; digit <= 9; digit++) {
            if (isSafe(sudoku, row, col, digit)) {
                sudoku[row][col] = digit;
                if (sudokuSolver(sudoku, nextRow, nextCol)) {
                    return true;
                }
                sudoku[row][col] = 0; // backtrack
            }
        }
        return false;
    }

    // ------------------------------------------------------------
    // Helper Method for Sudoku Safety Check
    // ------------------------------------------------------------
    public static boolean isSafe(int[][] sudoku, int row, int col, int digit) {

        // Row & Column
        for (int i = 0; i < 9; i++) {
            if (sudoku[i][col] == digit || sudoku[row][i] == digit) {
                return false;
            }
        }

        // 3x3 Grid
        int sr = (row / 3) * 3;
        int sc = (col / 3) * 3;

        for (int i = sr; i < sr + 3; i++) {
            for (int j = sc; j < sc + 3; j++) {
                if (sudoku[i][j] == digit) {
                    return false;
                }
            }
        }
        return true;
    }

    // ------------------------------------------------------------
    // Q9. Rat in a Maze Problem
    // ------------------------------------------------------------
    public static ArrayList<String> helper(int[][] maze) {
        ArrayList<String> result = new ArrayList<>();
        ratInMaze(maze, 0, 0, "", result);
        return result;
    }

    public static void ratInMaze(int[][] maze, int i, int j,
                                 String ans, ArrayList<String> result) {

        if (i < 0 || j < 0 || i >= maze.length || j >= maze.length || maze[i][j] == 0) {
            return;
        }

        if (i == maze.length - 1 && j == maze.length - 1) {
            result.add(ans);
            return;
        }

        maze[i][j] = 0; // mark visited

        ratInMaze(maze, i + 1, j, ans + "D", result);
        ratInMaze(maze, i - 1, j, ans + "U", result);
        ratInMaze(maze, i, j + 1, ans + "R", result);
        ratInMaze(maze, i, j - 1, ans + "L", result);

        maze[i][j] = 1; // backtrack
    }

    // ------------------------------------------------------------
    // Main Method (Test Code)
    // ------------------------------------------------------------
    public static void main(String[] args) {
        int[][] maze = {
            {1, 0, 0, 0},
            {1, 1, 0, 1},
            {1, 1, 0, 0},
            {0, 1, 1, 1}
        };

        System.out.println(helper(maze));
    }
}
