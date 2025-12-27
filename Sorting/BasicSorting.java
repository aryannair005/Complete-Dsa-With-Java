/*
 * Topic: Basic Sorting Algorithms (Data Structures & Algorithms)
 *
 * This file contains frequently asked sorting algorithm
 * questions with clean Java implementations.
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
    // Utility Method: Write a program to print elements of an array
    // ------------------------------------------------------------
    public static void printArr(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    // ------------------------------------------------------------
    // Q1. Write a program to sort an array using Bubble Sort
    //
    // Description:
    // Repeatedly compares adjacent elements and swaps them
    // if they are in the wrong order.
    //
    // Time Complexity:
    // Best Case: O(n)
    // Average/Worst Case: O(n^2)
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
    // Q2. Write a program to sort an array using Selection Sort
    //
    // Description:
    // Selects the minimum element from the unsorted part
    // and places it at the beginning.
    //
    // Time Complexity:
    // Best/Average/Worst Case: O(n^2)
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
    // Q3. Write a program to sort an array using Insertion Sort
    //
    // Description:
    // Inserts each element into its correct position
    // in the already sorted part of the array.
    //
    // Time Complexity:
    // Best Case: O(n)
    // Average/Worst Case: O(n^2)
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
    // Q4. Write a program to sort an array using Counting Sort
    //
    // Description:
    // A non-comparison based sorting algorithm that counts
    // the frequency of elements and rebuilds the array.
    //
    // Time Complexity: O(n + k)
    // n = number of elements
    // k = range of elements
    //
    // Space Complexity: O(k)
    //
    // Limitation:
    // Does not work directly with negative numbers
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
        // bubbleSort(arr);
        // selectionSort(arr);
        // insertionSort(arr);
    }
}
