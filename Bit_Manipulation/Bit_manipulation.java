/*
 * Topic: Bit Manipulation (Data Structures & Algorithms)
 *
 * This file contains commonly used bit manipulation techniques
 * to perform operations efficiently using bitwise operators.
 *
 * Concepts Covered:
 * - Odd / Even check using bits
 * - Get, Set, Clear ith bit
 * - Update ith bit (2 approaches)
 * - Clear last i bits
 * - Clear range of bits
 * - Check power of 2
 * - Count set bits
 * - Fast exponentiation using bits
 *
 * Purpose:
 * - Daily DSA practice
 * - Interview preparation
 * - Understanding low-level optimizations
 *
 * Language: Java
 * Author: Aryan Nair
 */

public class BitManipulation {

    // ------------------------------------------------------------
    // Check if a Number is Odd or Even
    // Uses LSB (Least Significant Bit)
    //
    // Time Complexity: O(1)
    // Space Complexity: O(1)
    // ------------------------------------------------------------
    public static void oddEven(int number) {
        int bitmask = 1;

        if ((number & bitmask) == 0) {
            System.out.println("Even");
        } else {
            System.out.println("Odd");
        }
    }

    // ------------------------------------------------------------
    // Get ith Bit
    // Returns 0 or 1 based on ith bit
    //
    // Time Complexity: O(1)
    // Space Complexity: O(1)
    // ------------------------------------------------------------
    public static int getIthBit(int number, int i) {
        int bitmask = 1 << i;

        if ((number & bitmask) == 0) {
            return 0;
        }
        return 1;
    }

    // ------------------------------------------------------------
    // Set ith Bit
    // Sets ith bit to 1
    //
    // Time Complexity: O(1)
    // Space Complexity: O(1)
    // ------------------------------------------------------------
    public static int setIthBit(int number, int i) {
        int bitmask = 1 << i;
        return number | bitmask;
    }

    // ------------------------------------------------------------
    // Clear ith Bit
    // Sets ith bit to 0
    //
    // Time Complexity: O(1)
    // Space Complexity: O(1)
    // ------------------------------------------------------------
    public static int clearIthBit(int number, int i) {
        int bitmask = ~(1 << i);
        return number & bitmask;
    }

    // ------------------------------------------------------------
    // Update ith Bit (1st Approach)
    // If newBit = 1 → set bit
    // If newBit = 0 → clear bit
    //
    // Time Complexity: O(1)
    // Space Complexity: O(1)
    // ------------------------------------------------------------
    public static int updateIthBit1stApproach(int number, int i, int newBit) {
        if (newBit == 1) {
            return setIthBit(number, i);
        }
        return clearIthBit(number, i);
    }

    // ------------------------------------------------------------
    // Update ith Bit (2nd Approach)
    // Clear ith bit first, then OR with new bit
    //
    // Time Complexity: O(1)
    // Space Complexity: O(1)
    // ------------------------------------------------------------
    public static int updateIthBit2ndApproach(int number, int i, int newBit) {
        number = clearIthBit(number, i);
        int newBitmask = newBit << i;

        return number | newBitmask;
    }

    // ------------------------------------------------------------
    // Clear Last i Bits
    // Example:
    // number = 15 (1111), i = 2 → result = 12 (1100)
    //
    // Time Complexity: O(1)
    // Space Complexity: O(1)
    // ------------------------------------------------------------
    public static int clearIthBits(int number, int i) {
        int bitmask = (~0) << i;
        return number & bitmask;
    }

    // ------------------------------------------------------------
    // Clear Range of Bits from i to j
    //
    // Time Complexity: O(1)
    // Space Complexity: O(1)
    // ------------------------------------------------------------
    public static int clearRangeOfBits(int number, int i, int j) {
        int leftBitmask = (~0) << (j + 1);
        int rightBitmask = (1 << i) - 1;
        int finalBitmask = leftBitmask | rightBitmask;

        return number & finalBitmask;
    }

    // ------------------------------------------------------------
    // Check if Number is Power of 2
    // Property: n & (n - 1) == 0
    //
    // Time Complexity: O(1)
    // Space Complexity: O(1)
    // ------------------------------------------------------------
    public static boolean isPowerOf2(int number) {
        return (number > 0) && ((number & (number - 1)) == 0);
    }

    // ------------------------------------------------------------
    // Count Number of Set Bits (1s)
    //
    // Time Complexity: O(log n)
    // Space Complexity: O(1)
    // ------------------------------------------------------------
    public static int noOfSetBits(int number) {
        int count = 0;

        while (number != 0) {
            if ((number & 1) == 1) {
                count++;
            }
            number = number >> 1;
        }
        return count;
    }

    // ------------------------------------------------------------
    // Fast Exponentiation (Binary Exponentiation)
    // Calculates a^n efficiently
    //
    // Time Complexity: O(log n)
    // Space Complexity: O(1)
    // ------------------------------------------------------------
    public static int fastExponentiation(int a, int n) {
        int ans = 1;

        while (n != 0) {
            if ((n & 1) == 1) {
                ans *= a;
            }
            a = a * a;
            n = n >> 1;
        }
        return ans;
    }

    // ------------------------------------------------------------
    // Main Method (Test Code)
    // ------------------------------------------------------------
    public static void main(String[] args) {
        int number = 3;
        System.out.println(fastExponentiation(number, 5));
    }
}
