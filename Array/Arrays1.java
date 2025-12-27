/*
 * Topic: Arrays (Data Structures & Algorithms)
 *
 * This file contains frequently asked array-related
 * interview and exam questions with optimized solutions.
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
    // Q1. Write a program to perform Linear Search on an array
    //
    // Time Complexity: O(n)
    // Space Complexity: O(1)
    // ------------------------------------------------------------
    public static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;
    }

    // ------------------------------------------------------------
    // Q2. Write a program to perform Binary Search on a sorted array
    //
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
    // Q3. Write a program to reverse an array using two-pointer approach
    //
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

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    // ------------------------------------------------------------
    // Q4. Write a program to print all possible pairs in an array
    //
    // Example:
    // [1, 2, 3] → (1,2) (1,3) (2,3)
    //
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
    // Q5. Write a program to print all subarrays of an array
    //
    // Total Subarrays = n * (n + 1) / 2
    //
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
    // Q6. Write a program to find maximum subarray sum using brute force
    //
    // Time Complexity: O(n^3)
    // Space Complexity: O(1)
    // ------------------------------------------------------------
    public static int maxSumArraySum(int[] arr) {
        int maxSum = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                int currSum = 0;
                for (int k = i; k <= j; k++) {
                    currSum += arr[k];
                }
                maxSum = Math.max(currSum, maxSum);
            }
        }
        return maxSum;
    }

    // ------------------------------------------------------------
    // Q7. Write a program to find maximum subarray sum
    // using Prefix Sum technique
    //
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
            for (int j = i; j < arr.length; j++) {
                int currSum = (i == 0)
                        ? prefix[j]
                        : prefix[j] - prefix[i - 1];
                maxSum = Math.max(currSum, maxSum);
            }
        }
        return maxSum;
    }

    // ------------------------------------------------------------
    // Q8. Write a program to find maximum subarray sum
    // using Kadane’s Algorithm
    //
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
    // Q9. Write a program to solve the Trapping Rain Water problem
    //
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
    // Q10. Write a program to find the maximum profit
    // in Buy and Sell Stock problem
    //
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
