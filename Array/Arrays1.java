/*
 * Topic: Arrays (Data Structures & Algorithms)
 *
 * This file contains commonly asked array problems solved using
 * brute-force and optimized approaches.
 *
 * Concepts Covered:
 * - Linear Search
 * - Binary Search (Sorted Array)
 * - Reverse Array (Two-pointer approach)
 * - Pair generation
 * - Subarray generation
 * - Maximum Subarray Sum:
 *      1) Brute Force
 *      2) Prefix Sum
 *      3) Kadane’s Algorithm
 * - Trapping Rain Water Problem
 * - Buy and Sell Stock (Maximum Profit)
 *
 * Purpose:
 * - Daily DSA practice
 * - Interview preparation
 * - Revision reference
 *
 * Language: Java
 * Author: Aryan Nair
 */

public class Arrays {

    // ------------------------------------------------------------
    // Linear Search
    // Searches target element by traversing array sequentially
    // Time Complexity: O(n)
    // Space Complexity: O(1)
    // ------------------------------------------------------------
    public static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i; // target found
            }
        }
        return -1; // target not found
    }

    // ------------------------------------------------------------
    // Binary Search
    // Works only on sorted arrays
    // Uses divide and conquer technique
    // Time Complexity: O(log n)
    // Space Complexity: O(1)
    // ------------------------------------------------------------
    public static int binarySearch(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }

    // ------------------------------------------------------------
    // Reverse an Array
    // Uses two-pointer approach (start & end)
    // Time Complexity: O(n)
    // Space Complexity: O(1)
    // ------------------------------------------------------------
    public static void reverseArray(int[] arr) {
        int start = 0;
        int end = arr.length - 1;

        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }

        // Print reversed array
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    // ------------------------------------------------------------
    // Print All Pairs in an Array
    // Example: [1,2,3] → (1,2) (1,3) (2,3)
    // Time Complexity: O(n^2)
    // ------------------------------------------------------------
    public static void pairs(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                System.out.print("(" + arr[i] + "," + arr[j] + ")");
            }
            System.out.println();
        }
    }

    // ------------------------------------------------------------
    // Print All Subarrays
    // Total subarrays = n * (n + 1) / 2
    // Time Complexity: O(n^3)
    // ------------------------------------------------------------
    public static void subarrays(int[] arr) {
        int count = 0;

        for (int i = 0; i < arr.length; i++) {
            int start = i;
            for (int j = i; j < arr.length; j++) {
                int end = j;
                for (int k = start; k <= end; k++) {
                    System.out.print(arr[k] + " ");
                }
                count++;
                System.out.print(",");
            }
            System.out.println();
        }
        System.out.println("Total Subarrays: " + count);
    }

    // ------------------------------------------------------------
    // Maximum Subarray Sum (Brute Force)
    // Checks sum of every possible subarray
    // Time Complexity: O(n^3)
    // Space Complexity: O(1)
    // ------------------------------------------------------------
    public static int maxSumArraySum(int[] arr) {
        int maxSum = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            int start = i;
            for (int j = i; j < arr.length; j++) {
                int end = j;
                int currSum = 0;
                for (int k = start; k <= end; k++) {
                    currSum += arr[k];
                }
                maxSum = Math.max(currSum, maxSum);
            }
        }
        return maxSum;
    }

    // ------------------------------------------------------------
    // Maximum Subarray Sum (Prefix Sum Approach)
    // Optimizes brute force by precomputing sums
    // Time Complexity: O(n^2)
    // Space Complexity: O(n)
    // ------------------------------------------------------------
    public static int prefixSubArray(int[] arr) {
        int maxSum = Integer.MIN_VALUE;
        int[] prefix = new int[arr.length];

        prefix[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            prefix[i] = prefix[i - 1] + arr[i];
        }

        for (int i = 0; i < arr.length; i++) {
            int start = i;
            for (int j = i; j < arr.length; j++) {
                int end = j;
                int currSum;

                if (start == 0) {
                    currSum = prefix[end];
                } else {
                    currSum = prefix[end] - prefix[start - 1];
                }
                maxSum = Math.max(currSum, maxSum);
            }
        }
        return maxSum;
    }

    // ------------------------------------------------------------
    // Maximum Subarray Sum (Kadane’s Algorithm)
    // Resets current sum if it becomes negative
    // Time Complexity: O(n)
    // Space Complexity: O(1)
    // ------------------------------------------------------------
    public static int kadanes(int[] arr) {
        int maxSum = Integer.MIN_VALUE;
        int currSum = 0;

        for (int i = 0; i < arr.length; i++) {
            currSum += arr[i];
            maxSum = Math.max(currSum, maxSum);
            if (currSum < 0) {
                currSum = 0;
            }
        }
        return maxSum;
    }

    // ------------------------------------------------------------
    // Trapping Rain Water Problem
    // Uses left max and right max arrays
    // Water trapped = min(leftMax, rightMax) - height[i]
    // Time Complexity: O(n)
    // Space Complexity: O(n)
    // ------------------------------------------------------------
    public static int trappingWater(int[] height) {
        int trappedWater = 0;
        int n = height.length;

        int[] leftMax = new int[n];
        int[] rightMax = new int[n];

        leftMax[0] = height[0];
        rightMax[n - 1] = height[n - 1];

        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        }

        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], height[i]);
        }

        for (int i = 0; i < n; i++) {
            int waterLevel = Math.min(leftMax[i], rightMax[i]);
            trappedWater += waterLevel - height[i];
        }
        return trappedWater;
    }

    // ------------------------------------------------------------
    // Buy and Sell Stock (Maximum Profit)
    // Buy at lowest price and sell at highest future price
    // Time Complexity: O(n)
    // Space Complexity: O(1)
    // ------------------------------------------------------------
    public static int sellAndBuyStocks(int[] prices) {
        int maxProfit = 0;
        int buyingPrice = prices[0];

        for (int i = 1; i < prices.length; i++) {
            int currPrice = prices[i];

            if (buyingPrice > currPrice) {
                buyingPrice = currPrice;
            } else {
                int currProfit = currPrice - buyingPrice;
                maxProfit = Math.max(currProfit, maxProfit);
            }
        }
        return maxProfit;
    }

    // ------------------------------------------------------------
    // Main Method (Test Code)
    // ------------------------------------------------------------
    public static void main(String[] args) {
        int[] arr = {7, 1, 5, 3, 6, 4};
        System.out.println(sellAndBuyStocks(arr));
    }
}
