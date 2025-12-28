/*
 * Topic: Divide and Conquer (Data Structures & Algorithms)
 *
 * This file contains frequently asked divide and conquer
 * algorithms used in sorting and problem solving.
 *
 * Purpose:
 * - Daily DSA practice
 * - Interview preparation
 * - Quick revision before exams
 *
 * Language: Java
 * Author: Aryan Nair
 */

public class DivideAndConquer {

    // ------------------------------------------------------------
    // Utility Method to Print Array
    // ------------------------------------------------------------
    public static void printArr(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();
    }

    // ------------------------------------------------------------
    // Q1. Merge Sort (Divide and Conquer Algorithm)
    //
    // Logic:
    // 1. Divide the array into two halves
    // 2. Recursively sort both halves
    // 3. Merge the sorted halves
    //
    // Time Complexity:
    // Best / Average / Worst Case: O(n log n)
    //
    // Space Complexity: O(n)
    // ------------------------------------------------------------
    public static void mergeSort(int[] nums, int start, int end) {
        if (start >= end) {
            return;
        }

        int mid = start + (end - start) / 2;

        mergeSort(nums, start, mid);
        mergeSort(nums, mid + 1, end);
        merge(nums, start, mid, end);
    }

    // ------------------------------------------------------------
    // Helper Method to Merge Two Sorted Halves
    // ------------------------------------------------------------
    public static void merge(int[] nums, int start, int mid, int end) {
        int[] temp = new int[end - start + 1];

        int i = start;     // pointer for left half
        int j = mid + 1;   // pointer for right half
        int k = 0;         // pointer for temp array

        while (i <= mid && j <= end) {
            if (nums[i] < nums[j]) {
                temp[k++] = nums[i++];
            } else {
                temp[k++] = nums[j++];
            }
        }

        // remaining elements of left half
        while (i <= mid) {
            temp[k++] = nums[i++];
        }

        // remaining elements of right half
        while (j <= end) {
            temp[k++] = nums[j++];
        }

        // copy temp array back to original array
        for (k = 0, i = start; k < temp.length; k++, i++) {
            nums[i] = temp[k];
        }
    }

    // ------------------------------------------------------------
    // Q2. Quick Sort (Divide and Conquer Algorithm)
    //
    // Logic:
    // 1. Choose a pivot element
    // 2. Partition array around pivot
    // 3. Recursively apply quick sort on left & right parts
    //
    // Time Complexity:
    // Best / Average Case: O(n log n)
    // Worst Case: O(n^2)
    //
    // Space Complexity: O(log n)
    // ------------------------------------------------------------
    public static void quickSort(int[] nums, int start, int end) {
        if (start >= end) {
            return;
        }

        int partitionIndex = partitioning(nums, start, end);
        quickSort(nums, start, partitionIndex - 1);
        quickSort(nums, partitionIndex + 1, end);
    }

    // ------------------------------------------------------------
    // Partition Method (Lomuto Partition Scheme)
    // ------------------------------------------------------------
    public static int partitioning(int[] nums, int start, int end) {
        int pivot = nums[end];
        int i = start - 1;

        for (int j = start; j < end; j++) {
            if (nums[j] < pivot) {
                i++;
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
            }
        }

        // place pivot at correct position
        i++;
        nums[end] = nums[i];
        nums[i] = pivot;

        return i;
    }

    // ------------------------------------------------------------
    // Main Method (Test Code)
    // ------------------------------------------------------------
    public static void main(String[] args) {
        int[] nums = {6, 3, 9, 8, 2, 5};

        quickSort(nums, 0, nums.length - 1);
        // mergeSort(nums, 0, nums.length - 1);

        printArr(nums);
    }
}
