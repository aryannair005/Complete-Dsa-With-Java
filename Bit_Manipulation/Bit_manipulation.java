/*
 * Topic: Bit Manipulation (Data Structures & Algorithms)
 *
 * This file contains frequently asked bit manipulation
 * interview and exam questions implemented using bitwise operators.
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
    // Q1. Write a program to check whether a number is odd or even
    // using bitwise operators
    //
    // Concept:
    // Check Least Significant Bit (LSB)
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
    // Q2. Write a program to get the ith bit of a number
    //
    // Returns:
    // 0 or 1
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
    // Q3. Write a program to set the ith bit of a number
    //
    // Time Complexity: O(1)
    // Space Complexity: O(1)
    // ------------------------------------------------------------
    public static int setIthBit(int number, int i) {
        int bitmask = 1 << i;
        return number | bitmask;
    }

    // ------------------------------------------------------------
    // Q4. Write a program to clear the ith bit of a number
    //
    // Time Complexity: O(1)
    // Space Complexity: O(1)
    // ------------------------------------------------------------
    public static int clearIthBit(int number, int i) {
        int bitmask = ~(1 << i);
        return number & bitmask;
    }

    // ------------------------------------------------------------
    // Q5. Write a program to update the ith bit of a number
    // (Using conditional approach)
    //
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
    // Q6. Write a program to update the ith bit of a number
    // (Using clear + OR approach)
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
    // Q7. Write a program to clear the last i bits of a number
    //
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
    // Q8. Write a program to clear a range of bits from i to j
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
    // Q9. Write a program to check whether a number is a power of 2
    //
    // Property:
    // n & (n - 1) == 0
    //
    // Time Complexity: O(1)
    // Space Complexity: O(1)
    // ------------------------------------------------------------
    public static boolean isPowerOf2(int number) {
        return (number > 0) && ((number & (number - 1)) == 0);
    }

    // ------------------------------------------------------------
    // Q10. Write a program to count the number of set bits (1s)
    // in a given number
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
    // Q11. Write a program to calculate a^n using fast exponentiation
    // (Binary Exponentiation)
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
