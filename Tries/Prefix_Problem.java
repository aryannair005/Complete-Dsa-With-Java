import java.util.*;

/*
 * Topic: Trie – Prefix Problems (Data Structures & Algorithms)
 *
 * Problem Name:
 * Shortest Unique Prefix for Each Word
 *
 * About:
 * Given a list of words, find the shortest unique prefix
 * for each word such that no two words share the same prefix.
 *
 * Approach:
 * - Use Trie with frequency count at each node
 * - While inserting words, increase frequency
 * - While finding prefix, stop when frequency becomes 1
 *
 * Example:
 * Input  : ["zebra", "dog", "duck", "dove"]
 * Output : ["z", "dog", "du", "dov"]
 *
 * Purpose:
 * - Practice Trie with frequency concept
 * - Common interview problem
 *
 * Language: Java
 * Author: Aryan Nair
 */

public class PrefixProblem {

    // ============================================================
    // Trie Node Structure
    // ============================================================
    static class Node {
        Node[] children = new Node[26];
        boolean endOfWord = false;
        int frequency = 1;

        public Node() {
            for (int i = 0; i < children.length; i++) {
                children[i] = null;
            }
        }
    }

    // Root of Trie
    public static Node root = new Node();

    // ------------------------------------------------------------
    // Q1. Insert Word into Trie with Frequency Count
    //
    // About:
    // Inserts each character of the word into Trie.
    // If node already exists, increments its frequency.
    //
    // Time Complexity: O(L)
    // Space Complexity: O(L)
    // ------------------------------------------------------------
    public static void insert(String word) {
        Node curr = root;

        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';

            if (curr.children[idx] == null) {
                curr.children[idx] = new Node();
            } else {
                curr.children[idx].frequency++;
            }
            curr = curr.children[idx];
        }

        curr.endOfWord = true;
    }

    // ------------------------------------------------------------
    // Q2. Find Shortest Unique Prefix of a Word
    //
    // About:
    // Traverses Trie until frequency becomes 1,
    // which guarantees uniqueness.
    //
    // Time Complexity: O(L)
    // ------------------------------------------------------------
    public static void findPrefix(String word, ArrayList<String> list) {
        Node curr = root;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';
            curr = curr.children[idx];
            sb.append(word.charAt(i));

            if (curr.frequency == 1) {
                break;
            }
        }
        list.add(sb.toString());
    }

    // ------------------------------------------------------------
    // Main Method (Test Code)
    // ------------------------------------------------------------
    public static void main(String[] args) {
        String[] arr = {"zebra", "dog", "duck", "dove"};

        for (int i = 0; i < arr.length; i++) {
            insert(arr[i]);
        }

        // Root frequency is not used
        root.frequency = -1;

        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            findPrefix(arr[i], list);
        }

        System.out.println(list);
    }
}
