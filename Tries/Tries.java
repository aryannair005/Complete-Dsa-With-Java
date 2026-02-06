/*
 * Topic: Trie (Data Structures & Algorithms)
 *
 * This file contains basic Trie implementation and
 * common Trie-based problems.
 *
 * Problems Covered:
 * 1. Insert a word in Trie
 * 2. Search a word in Trie
 * 3. Check prefix existence
 * 4. Word Break Problem using Trie
 *
 * Purpose:
 * - Understand Trie data structure
 * - Practice string-based problems
 * - Interview preparation
 *
 * Language: Java
 * Author: Aryan Nair
 */
import java.util.ArrayList;

public class TriesBasics {

    // ============================================================
    // Trie Node Structure
    // ============================================================
    static class Node {
        Node[] children = new Node[26];
        boolean endOfWord = false;

        Node() {
            for (int i = 0; i < children.length; i++) {
                children[i] = null;
            }
        }
    }

    // Root of Trie
    public static Node root = new Node();

    // ------------------------------------------------------------
    // Q1. Insert a Word into Trie
    //
    // About:
    // Inserts characters of the word one by one into the Trie.
    //
    // Time Complexity: O(L)
    // Space Complexity: O(L)
    // (L = length of the word)
    // ------------------------------------------------------------
    public static void insert(String word) {
        Node curr = root;

        for (int level = 0; level < word.length(); level++) {
            int idx = word.charAt(level) - 'a';

            if (curr.children[idx] == null) {
                curr.children[idx] = new Node();
            }
            curr = curr.children[idx];
        }

        curr.endOfWord = true;
    }

    // ------------------------------------------------------------
    // Q2. Search a Word in Trie
    //
    // About:
    // Checks whether a complete word exists in the Trie.
    //
    // Time Complexity: O(L)
    // ------------------------------------------------------------
    public static boolean search(String word) {
        Node curr = root;

        for (int level = 0; level < word.length(); level++) {
            int idx = word.charAt(level) - 'a';

            if (curr.children[idx] == null) {
                return false;
            } else {
                curr = curr.children[idx];
            }
        }

        if (curr.endOfWord != true) {
            return false;
        }
        return true;
    }

    // ------------------------------------------------------------
    // Q3. Check if Prefix Exists in Trie
    //
    // About:
    // Verifies whether a prefix exists in the Trie.
    //
    // Time Complexity: O(L)
    // ------------------------------------------------------------
    public static boolean isPrefix(String word) {
        Node curr = root;

        for (int level = 0; level < word.length(); level++) {
            int idx = word.charAt(level) - 'a';

            if (curr.children[idx] == null) {
                return false;
            } else {
                curr = curr.children[idx];
            }
        }
        return true;
    }

    // ------------------------------------------------------------
    // Q4. Word Break Problem using Trie
    //
    // About:
    // Checks if a given string can be segmented into
    // valid dictionary words stored in Trie.
    //
    // Approach:
    // - Try all prefixes recursively
    // - If prefix exists and remaining string is valid, return true
    //
    // Time Complexity: Exponential (Worst Case)
    // ------------------------------------------------------------
    public static boolean workBreak(String key) {

        // Base case
        if (key.length() == 0) {
            return true;
        }

        // Try all possible prefixes
        for (int i = 0; i < key.length(); i++) {

            // Prefix from index 0 to i
            String prefix = key.substring(0, i + 1);

            // Remaining string
            String remaining = key.substring(i + 1);

            if (search(prefix) && workBreak(remaining)) {
                return true;
            }
        }
        return false;
    }
    // ------------------------------------------------------------
    // Q5. Count Total Nodes in Trie
    //
    // About:
    // Counts total number of nodes present in the Trie.
    // Each node represents a unique prefix.
    //
    // Time Complexity: O(N)
    // (N = total number of nodes in Trie)
    // ------------------------------------------------------------
    public static int countNodes(Node root){
        if(root == null){
            return 0;
        }

        int count=0;
        for(int i=0;i<26;i++){
            if(root.children[i] != null){
                count+=countNodes(root.children[i]);
            }
        }
        return count+1;
    }

    // ------------------------------------------------------------
    // Q6. Count Unique Substrings of a String
    //
    // About:
    // Inserts all suffixes of the string into the Trie.
    // Number of unique substrings =
    // Total number of Trie nodes.
    //
    // Time Complexity: O(N^2)
    // Space Complexity: O(N^2)
    // ------------------------------------------------------------
    public static int uniqueSubString(String str){

        for(int i=0;i<str.length();i++){
            insert(str.substring(i));
        }

        return countNodes(root);
    }

    // ------------------------------------------------------------
    // Q7. Longest Word with All Prefixes Present
    //
    // About:
    // Finds the longest word such that all its prefixes
    // are present in the Trie.
    //
    // If multiple answers exist, lexicographically
    // smallest word is chosen.
    //
    // Time Complexity: O(N * 26)
    // ------------------------------------------------------------
    public static String ans="";
    public static void longestWord(Node root,StringBuilder temp){
        if(root == null){
            return;
        }

        for(int i=0;i<26;i++){
            if(root.children[i] != null && root.children[i].endOfWord == true){
                char ch=(char) (i+'a');
                temp.append(ch);

                if(temp.length() > ans.length()){
                    ans=temp.toString();
                }

                longestWord(root.children[i],temp);
                temp.deleteCharAt(temp.length()-1);
            }
        }
    }


    // ------------------------------------------------------------
    // Main Method (Test Code)
    // ------------------------------------------------------------
    public static void main(String[] args) {
        String[] str={"a","banana","app","appl","ap","apply","apple"};
        for(int i=0;i<str.length;i++){
            insert(str[i]);
        }
        longestWord(root,new StringBuilder());
        System.out.println(ans);
    }
}