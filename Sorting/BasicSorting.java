/*
 * Topic: Basic Sorting Algorithms (Data Structures & Algorithms)
 *
 * This file contains implementation of basic comparison and
 * non-comparison based sorting algorithms.
 *
 * Sorting Algorithms Covered:
 * - Bubble Sort
 * - Selection Sort
 * - Insertion Sort
 * - Counting Sort
 *
 * Purpose:
 * - Daily DSA practice
 * - Understanding sorting logic
 * - Interview and exam preparation
 *
 * Language: Java
 * Author: Aryan Nair
 */

public class BasicSorting {

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
    // Bubble Sort
    // Repeatedly swaps adjacent elements if they are in wrong order
    //
    // Time Complexity:
    //   Best Case: O(n)
    //   Average/Worst Case: O(n^2)
    //
    // Space Complexity: O(1)
    // ------------------------------------------------------------
    public static void bubbleSort(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    // swap
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        printArr(arr);
    }

    // ------------------------------------------------------------
    // Selection Sort
    // Finds the minimum element and places it at correct position
    //
    // Time Complexity:
    //   Best/Average/Worst Case: O(n^2)
    //
    // Space Complexity: O(1)
    // ------------------------------------------------------------
    public static void selectionSort(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            int minPos = i;

            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minPos]) {
                    minPos = j;
                }
            }

            // swap
            int temp = arr[i];
            arr[i] = arr[minPos];
            arr[minPos] = temp;
        }
        printArr(arr);
    }

    // ------------------------------------------------------------
    // Insertion Sort
    // Builds sorted array one element at a time
    //
    // Time Complexity:
    //   Best Case: O(n)
    //   Average/Worst Case: O(n^2)
    //
    // Space Complexity: O(1)
    // ------------------------------------------------------------
    public static void insertionSort(int[] arr) {
        int n = arr.length;

        for (int i = 1; i < n; i++) {
            int curr = arr[i];
            int prev = i - 1;

            // shift elements to the right
            while (prev >= 0 && arr[prev] > curr) {
                arr[prev + 1] = arr[prev];
                prev--;
            }
            arr[prev + 1] = curr;
        }
        printArr(arr);
    }

    // ------------------------------------------------------------
    // Counting Sort (Non-comparison based sorting)
    // Works best when range of input values is small
    //
    // Time Complexity: O(n + k)
    //   n = number of elements
    //   k = range of elements (max value)
    //
    // Space Complexity: O(k)
    //
    // NOTE: Does NOT work for negative numbers directly
    // ------------------------------------------------------------
    public static void countingSort(int[] arr) {
        int max = Integer.MIN_VALUE;

        // find maximum element
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
        }

        // count array
        int[] countArr = new int[max + 1];

        // frequency count
        for (int i = 0; i < arr.length; i++) {
            countArr[arr[i]]++;
        }

        // rebuild sorted array
        int j = 0;
        for (int i = 0; i < countArr.length; i++) {
            while (countArr[i] > 0) {
                arr[j] = i;
                j++;
                countArr[i]--;
            }
        }
        printArr(arr);
    }

    // ------------------------------------------------------------
    // Main Method (Test Code)
    // ------------------------------------------------------------
    public static void main(String[] args) {
        int[] arr = {5, 4, 1, 3, 2};

        countingSort(arr);
        // Try others:
        // bubbleSort(arr);
        // selectionSort(arr);
        // insertionSort(arr);
    }
}
