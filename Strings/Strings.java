/*
 * Topic: Strings (Data Structures & Algorithms)
 *
 * This file contains commonly asked string-based problems
 * with efficient solutions.
 *
 * Concepts Covered:
 * - Palindrome Check
 * - Shortest Path Distance (Direction String)
 * - String Compression
 * - Anagram Check
 *
 * Purpose:
 * - Daily DSA practice
 * - Interview preparation
 * - Quick revision reference
 *
 * Language: Java
 * Author: Aryan Nair
 */

public class Strings {

    // ------------------------------------------------------------
    // Check if a String is Palindrome
    // Uses two-pointer approach
    //
    // Example:
    // "madam" -> true
    // "hello" -> false
    //
    // Time Complexity: O(n)
    // Space Complexity: O(1)
    // ------------------------------------------------------------
    public static boolean isPalindrome(String s) {
        int start = 0;
        int end = s.length() - 1;

        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    // ------------------------------------------------------------
    // Shortest Distance from Origin
    // Given a string containing directions:
    // N = North, S = South, E = East, W = West
    //
    // Calculates shortest distance from (0,0)
    //
    // Time Complexity: O(n)
    // Space Complexity: O(1)
    // ------------------------------------------------------------
    public static int shortestDistance(String s) {
        int x = 0;
        int y = 0;

        for (int i = 0; i < s.length(); i++) {
            char dir = s.charAt(i);

            if (dir == 'W') {
                x--;
            } else if (dir == 'N') {
                y++;
            } else if (dir == 'E') {
                x++;
            } else if (dir == 'S') {
                y--;
            }
        }

        // Distance using Pythagoras theorem
        return (int) Math.sqrt((x * x) + (y * y));
    }

    // ------------------------------------------------------------
    // String Compression
    // Compresses repeated characters
    //
    // Example:
    // "aaabbc" -> "a3b2c"
    // "abc"    -> "abc"
    //
    // Time Complexity: O(n)
    // Space Complexity: O(n)
    // ------------------------------------------------------------
    public static String stringCompression(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }

        char ch = s.charAt(0);
        int count = 0;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ch) {
                count++;
            } else {
                sb.append(ch);
                if (count > 1) {
                    sb.append(count);
                }
                ch = s.charAt(i);
                count = 1;
            }
        }

        // handle last character
        sb.append(ch);
        if (count > 1) {
            sb.append(count);
        }

        return sb.toString();
    }

    // ------------------------------------------------------------
    // Check if Two Strings are Anagrams
    // Uses frequency count of characters
    //
    // Example:
    // "anagram" & "nagaram" -> true
    // "rat" & "car" -> false
    //
    // Assumption: lowercase English letters only
    //
    // Time Complexity: O(n)
    // Space Complexity: O(1)
    // ------------------------------------------------------------
    public static boolean isAnagram(String s, String a) {
        if (s.length() != a.length()) {
            return false;
        }

        int[] count = new int[26];

        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
            count[a.charAt(i) - 'a']--;
        }

        for (int i = 0; i < count.length; i++) {
            if (count[i] != 0) {
                return false;
            }
        }
        return true;
    }

    // ------------------------------------------------------------
    // Main Method (Test Code)
    // ------------------------------------------------------------
    public static void main(String[] args) {
        String s = "nagaram";
        String a = "anagram";

        System.out.println(isAnagram(s, a));
        // System.out.println(isPalindrome("madam"));
        // System.out.println(shortestDistance("WNEENESENNN"));
        // System.out.println(stringCompression("aaabbcccdd"));
    }
}
