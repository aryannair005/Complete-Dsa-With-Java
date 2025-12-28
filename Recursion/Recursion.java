/*
 * Topic: Recursion (Data Structures & Algorithms)
 *
 * This file contains frequently asked recursion interview
 * and exam questions implemented in Java.
 *
 * Purpose:
 * - Daily DSA practice
 * - Interview preparation
 * - Quick revision before exams
 *
 * Language: Java
 * Author: Aryan Nair
 */

import java.util.*;

public class Recursion {

    // ------------------------------------------------------------
    // Q1. Write a recursive program to find the factorial of a number
    //
    // Example:
    // 5! = 120
    //
    // Time Complexity: O(n)
    // Space Complexity: O(n)
    // ------------------------------------------------------------
    public static int factorial(int num) {
        if (num == 0 || num == 1) {
            return 1;
        }
        return num * factorial(num - 1);
    }

    // ------------------------------------------------------------
    // Q2. Write a recursive program to print numbers from N to 1
    //
    // Example:
    // n = 5 -> 5 4 3 2 1
    // ------------------------------------------------------------
    public static void printNToOne(int n) {
        if (n == 0) {
            return;
        }
        System.out.println(n);
        printNToOne(n - 1);
    }

    // ------------------------------------------------------------
    // Q3. Write a recursive program to print numbers from 1 to N
    //
    // Example:
    // n = 5 -> 1 2 3 4 5
    // ------------------------------------------------------------
    public static void printOneToN(int n) {
        if (n == 0) {
            return;
        }
        printOneToN(n - 1);
        System.out.println(n);
    }

    // ------------------------------------------------------------
    // Q4. Write a recursive program to find the sum of first N natural numbers
    //
    // Example:
    // n = 5 -> 15
    // ------------------------------------------------------------
    public static int sumOfNNaturalNumbers(int n) {
        if (n == 0) {
            return 0;
        }
        return n + sumOfNNaturalNumbers(n - 1);
    }

    // ------------------------------------------------------------
    // Q5. Write a recursive program to find the Nth Fibonacci number
    //
    // Example:
    // n = 6 -> 8
    //
    // Time Complexity: O(2^n)
    // Space Complexity: O(n)
    // ------------------------------------------------------------
    public static int nthFibonacci(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        return nthFibonacci(n - 1) + nthFibonacci(n - 2);
    }

    // ------------------------------------------------------------
    // Q6. Write a recursive program to check whether an array is sorted
    //
    // Example:
    // [1, 2, 3, 4] -> true
    // ------------------------------------------------------------
    public static boolean isArraySorted(int[] arr, int i) {
        if (i == arr.length - 1) {
            return true;
        }
        if (arr[i] > arr[i + 1]) {
            return false;
        }
        return isArraySorted(arr, i + 1);
    }

    // ------------------------------------------------------------
    // Q7. Write a recursive program to find the first occurrence of an element
    //
    // Example:
    // arr = [1, 2, 3, 2], key = 2 -> index 1
    // ------------------------------------------------------------
    public static int firstOccurrence(int[] arr, int key, int i) {
        if (i == arr.length) {
            return -1;
        }
        if (arr[i] == key) {
            return i;
        }
        return firstOccurrence(arr, key, i + 1);
    }

    // ------------------------------------------------------------
    // Q8. Write a recursive program to find the last occurrence of an element
    //
    // Example:
    // arr = [1, 2, 3, 2], key = 2 -> index 3
    // ------------------------------------------------------------
    public static int lastOccurrence(int[] arr, int key, int i) {
        if (i == arr.length) {
            return -1;
        }

        int isFound = lastOccurrence(arr, key, i + 1);
        if (isFound != -1) {
            return isFound;
        }

        if (arr[i] == key) {
            return i;
        }
        return -1;
    }

    // ------------------------------------------------------------
    // Q9. Write a recursive program to calculate power (x^n)
    // using divide and conquer
    //
    // Example:
    // x = 2, n = 10 -> 1024
    //
    // Time Complexity: O(log n)
    // Space Complexity: O(log n)
    // ------------------------------------------------------------
    public static int power(int x, int n) {
        if (n == 0) {
            return 1;
        }

        int halfPower = power(x, n / 2);
        int result = halfPower * halfPower;

        if (n % 2 != 0) {
            result *= x;
        }
        return result;
    }

    // ------------------------------------------------------------
    // Q10. Write a recursive program to solve the tiling problem
    // (Count ways to tile a 2×n board using 2×1 tiles)
    //
    // Example:
    // n = 4 -> 5
    // ------------------------------------------------------------
    public static int tilingProblem(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        return tilingProblem(n - 1) + tilingProblem(n - 2);
    }

    // ------------------------------------------------------------
    // Q11. Write a recursive program to solve the friends pairing problem
    //
    // Example:
    // n = 3 -> 4
    // ------------------------------------------------------------
    public static int friendsPairingProblem(int n) {
        if (n == 0 || n == 1 || n == 2) {
            return n;
        }

        int single = friendsPairingProblem(n - 1);
        int paired = (n - 1) * friendsPairingProblem(n - 2);

        return single + paired;
    }

    // ------------------------------------------------------------
    // Q12. Write a recursive program to remove duplicate characters
    //
    // Example:
    // "appnaacollege" -> "apnacoleg"
    // ------------------------------------------------------------
    public static String removeDuplicates(String str, int idx,
                                          StringBuilder newStr, boolean[] map) {
        if (idx == str.length()) {
            return newStr.toString();
        }

        char currChar = str.charAt(idx);
        if (!map[currChar - 'a']) {
            newStr.append(currChar);
            map[currChar - 'a'] = true;
        }

        return removeDuplicates(str, idx + 1, newStr, map);
    }

    // ------------------------------------------------------------
    // Q13. Write a recursive program to generate binary strings
    // without consecutive 1s
    //
    // Example:
    // n = 3 -> 000, 001, 010, 100, 101
    // ------------------------------------------------------------
    public static void binaryStringWithoutConsecutive(int n,
                                                      int lastPlace,
                                                      String str) {
        if (n == 0) {
            System.out.println(str);
            return;
        }

        binaryStringWithoutConsecutive(n - 1, 0, str + "0");
        if (lastPlace == 0) {
            binaryStringWithoutConsecutive(n - 1, 1, str + "1");
        }
    }

    // ------------------------------------------------------------
    // Q14. Write a recursive program to find the number of moves
    // required to solve the Tower of Hanoi problem
    //
    // Formula:
    // Moves = 2^n - 1
    // ------------------------------------------------------------
    public static int towerOfHanoi(int n, int source,
                                   int helper, int destination) {
        if (n == 0) {
            return 0;
        }

        int moves = 0;
        moves += towerOfHanoi(n - 1, source, destination, helper);
        moves++;
        moves += towerOfHanoi(n - 1, helper, source, destination);

        return moves;
    }

    // ------------------------------------------------------------
    // Q15. Write a recursive program to generate all subsets
    // of a given array
    //
    // Example:
    // nums = [1,2,3]
    // Output = [[], [1], [2], [1,2], [3], [1,3], [2,3], [1,2,3]]
    //
    // Time Complexity: O(2^n)
    // Space Complexity: O(n)
    // ------------------------------------------------------------
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        helper(nums, result, 0, new ArrayList<>());
        return result;
    }

    private static void helper(int[] nums, List<List<Integer>> result,
                               int idx, List<Integer> current) {
        if (idx == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }

        // Exclude current element
        helper(nums, result, idx + 1, current);

        // Include current element
        current.add(nums[idx]);
        helper(nums, result, idx + 1, current);

        // Backtrack
        current.remove(current.size() - 1);
    }

    // ------------------------------------------------------------
    // Main Method (Test Code)
    // ------------------------------------------------------------
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println(subsets(nums));
    }
}
