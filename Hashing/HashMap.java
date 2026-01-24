import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.LinkedHashMap;
import java.util.TreeMap;

/*
 * Topic: Hashing (Data Structures & Algorithms)
 *
 * This file demonstrates the usage of:
 * - HashMap
 * - LinkedHashMap
 * - TreeMap
 *
 * Covers basic operations like:
 * insertion, deletion, traversal, search, and utility methods.
 *
 * Purpose:
 * - Understand differences between HashMap, LinkedHashMap, TreeMap
 * - Practice hashing operations for interviews
 *
 * Language: Java
 * Author: Aryan Nair
 */

public class HashingBasics {

    // ============================================================
    // Q1. Insert Elements into HashMap
    //
    // About:
    // Inserts key-value pairs into a HashMap.
    //
    // Time Complexity: O(1) average per insertion
    // ============================================================
    public static void insert(HashMap<String, Integer> map) {
        map.put("India", 100);
        map.put("China", 69);
        map.put("US", 60);
        map.put("Korea", 10);   
    }

    // ============================================================
    // Q2. Print HashMap using keySet()
    //
    // About:
    // Iterates over keys and prints key-value pairs.
    //
    // Time Complexity: O(n)
    // ============================================================
    public static void printUsingKeySet(HashMap<String, Integer> map) {
        Set<String> keys = map.keySet();
        for (String k : keys) {
            System.out.println(k + " => " + map.get(k));
        }
    }

    // ============================================================
    // Q3. Print HashMap using entrySet()
    //
    // About:
    // Uses Map.Entry for key-value traversal.
    //
    // Time Complexity: O(n)
    // ============================================================
    public static void printUsingEntrySet(HashMap<String, Integer> map) {
        for (Map.Entry<String, Integer> e : map.entrySet()) {
            System.out.println(e.getKey() + " = " + e.getValue());
        }
    }

    // ============================================================
    // Q4. Get Value for a Given Key (HashMap)
    //
    // Time Complexity: O(1)
    // ============================================================
    public static void getValue(HashMap<String, Integer> map, String key) {
        System.out.println(map.get(key));
    }

    // ============================================================
    // Q5. Remove a Key from HashMap
    //
    // Time Complexity: O(1)
    // ============================================================
    public static void removeKey(HashMap<String, Integer> map, String key) {
        System.out.println("Removed value: " + map.remove(key));
    }

    // ============================================================
    // Q6. Remove a Key from LinkedHashMap
    //
    // Time Complexity: O(1)
    // ============================================================
    public static void removeKey(LinkedHashMap<String, Integer> map, String key) {
        System.out.println("Removed value: " + map.remove(key));
    }

    // ============================================================
    // Q7. Check if Key Exists (HashMap)
    //
    // Time Complexity: O(1)
    // ============================================================
    public static void containsKey(HashMap<String, Integer> map, String key) {
        System.out.println(map.containsKey(key));
    }

    // ============================================================
    // Q8. Clear HashMap
    //
    // Time Complexity: O(n)
    // ============================================================
    public static void clearMap(HashMap<String, Integer> map) {
        map.clear();
    }

    // ============================================================
    // Q9. Check if HashMap is Empty
    //
    // Time Complexity: O(1)
    // ============================================================
    public static void isEmpty(HashMap<String, Integer> map) {
        System.out.println(map.isEmpty());
    }

    // ============================================================
    // Q10. Insert Elements into LinkedHashMap
    //
    // About:
    // Maintains insertion order.
    //
    // Time Complexity: O(1)
    // ============================================================
    public static void insert(LinkedHashMap<String, Integer> map) {
        map.put("India", 100);
        map.put("China", 69);
        map.put("US", 60);
        map.put("Korea", 10);
    }

    // ============================================================
    // Q11. Traverse LinkedHashMap using keySet()
    //
    // Time Complexity: O(n)
    // ============================================================
    public static void printUsingKeySet(LinkedHashMap<String, Integer> map) {
        Set<String> keys = map.keySet();
        for (String k : keys) {
            System.out.println(k + " => " + map.get(k));
        }
    }

    // ============================================================
    // Q12. Traverse LinkedHashMap using entrySet()
    //
    // Time Complexity: O(n)
    // ============================================================
    public static void printUsingEntrySet(LinkedHashMap<String, Integer> map) {
        for (Map.Entry<String, Integer> e : map.entrySet()) {
            System.out.println(e.getKey() + " = " + e.getValue());
        }
    }

    // ============================================================
    // Q13. Get Value from LinkedHashMap
    //
    // Time Complexity: O(1)
    // ============================================================
    public static void getValue(LinkedHashMap<String, Integer> map, String key) {
        System.out.println(map.get(key));
    }

    public static void isEmpty(LinkedHashMap<String, Integer> map) {
        System.out.println(map.isEmpty());
    }

    public static void containsKey(LinkedHashMap<String, Integer> map, String key) {
        System.out.println(map.containsKey(key));
    }

    public static void clearMap(LinkedHashMap<String, Integer> map) {
        map.clear();
    }

    // ============================================================
    // Q14. Insert Elements into TreeMap
    //
    // About:
    // Stores keys in sorted order.
    //
    // Time Complexity: O(log n)
    // ============================================================
    public static void insert(TreeMap<String, Integer> map) {
        map.put("India", 100);
        map.put("China", 69);
        map.put("US", 60);
        map.put("Korea", 10);
    }

    // ============================================================
    // Q15. Traverse TreeMap using keySet()
    //
    // Time Complexity: O(n)
    // ============================================================
    public static void printUsingKeySet(TreeMap<String, Integer> map) {
        Set<String> keys = map.keySet();
        for (String k : keys) {
            System.out.println(k + " => " + map.get(k));
        }
    }

    // ============================================================
    // Q16. Traverse TreeMap using entrySet()
    //
    // Time Complexity: O(n)
    // ============================================================
    public static void printUsingEntrySet(TreeMap<String, Integer> map) {
        for (Map.Entry<String, Integer> e : map.entrySet()) {
            System.out.println(e.getKey() + " = " + e.getValue());
        }
    }

    public static void getValue(TreeMap<String, Integer> map, String key) {
        System.out.println(map.get(key));
    }

    public static void isEmpty(TreeMap<String, Integer> map) {
        System.out.println(map.isEmpty());
    }

    public static void containsKey(TreeMap<String, Integer> map, String key) {
        System.out.println(map.containsKey(key));
    }

    public static void clearMap(TreeMap<String, Integer> map) {
        map.clear();
    }

    // ============================================================
    // Main Method (Test Code)
    // ============================================================
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();
        TreeMap<String,Integer> tmap=new TreeMap<>();

        insert(map);
        insert(tmap);

        System.out.println(map);
        System.out.println(tmap);
    }
}
