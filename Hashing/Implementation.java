import java.util.LinkedList;
import java.util.ArrayList;

/*
 * Topic: Custom HashMap Implementation (Data Structures & Algorithms)
 *
 * This file contains a complete implementation of a HashMap
 * from scratch using:
 * - Array of LinkedLists (Separate Chaining)
 * - Dynamic resizing (Rehashing)
 *
 * Purpose:
 * - Understand internal working of HashMap
 * - Learn hashing, collision handling & rehashing
 * - Interview & DSA preparation
 *
 * Language: Java
 * Author: Aryan Nair
 */

public class HashMapCode {

    // ============================================================
    // CUSTOM HASHMAP CLASS
    // ============================================================
    static class HashMap<K, V> {

        // ------------------------------------------------------------
        // Node Class
        //
        // About:
        // Represents a single key-value pair stored
        // inside a bucket (LinkedList).
        // ------------------------------------------------------------
        private class Node {
            K key;
            V value;

            Node(K key, V value) {
                this.key = key;
                this.value = value;
            }
        }

        // ------------------------------------------------------------
        // Data Members
        //
        // size        -> total number of key-value pairs
        // bucketCount -> number of buckets
        // buckets     -> array of LinkedLists (separate chaining)
        // ------------------------------------------------------------
        private int size;
        private int bucketCount;
        private LinkedList<Node>[] buckets;

        // ------------------------------------------------------------
        // Constructor
        //
        // About:
        // Initializes HashMap with default bucket size.
        //
        // Time Complexity: O(n)
        // ------------------------------------------------------------
        @SuppressWarnings("unchecked")
        public HashMap() {
            bucketCount = 4;
            buckets = new LinkedList[bucketCount];

            for (int i = 0; i < bucketCount; i++) {
                buckets[i] = new LinkedList<>();
            }
        }

        // ------------------------------------------------------------
        // Hash Function
        //
        // About:
        // Converts a key into a bucket index using hashCode().
        //
        // Time Complexity: O(1)
        // ------------------------------------------------------------
        private int hashFunction(K key) {
            return Math.abs(key.hashCode()) % bucketCount;
        }

        // ------------------------------------------------------------
        // Search in Bucket (LinkedList)
        //
        // About:
        // Searches for a key inside a specific bucket.
        //
        // Time Complexity: O(n) (worst case)
        // ------------------------------------------------------------
        private int searchInBucket(K key, int bucketIndex) {
            LinkedList<Node> list = buckets[bucketIndex];

            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).key.equals(key)) {
                    return i;
                }
            }
            return -1;
        }

        // ------------------------------------------------------------
        // Rehashing
        //
        // About:
        // Doubles bucket size and reinserts all elements
        // when load factor exceeds threshold.
        //
        // Time Complexity: O(n)
        // ------------------------------------------------------------
        @SuppressWarnings("unchecked")
        private void rehash() {
            LinkedList<Node>[] oldBuckets = buckets;

            bucketCount = bucketCount * 2;
            buckets = new LinkedList[bucketCount];
            size = 0;

            for (int i = 0; i < bucketCount; i++) {
                buckets[i] = new LinkedList<>();
            }

            for (LinkedList<Node> list : oldBuckets) {
                while (!list.isEmpty()) {
                    Node node = list.remove();
                    put(node.key, node.value);
                }
            }
        }

        // ------------------------------------------------------------
        // Put (Insert / Update)
        //
        // About:
        // Inserts a new key-value pair or updates
        // value if key already exists.
        //
        // Average Time Complexity: O(1)
        // Worst Case: O(n)
        // ------------------------------------------------------------
        public void put(K key, V value) {
            int bucketIndex = hashFunction(key);
            int dataIndex = searchInBucket(key, bucketIndex);

            if (dataIndex != -1) {
                buckets[bucketIndex].get(dataIndex).value = value;
            } else {
                buckets[bucketIndex].add(new Node(key, value));
                size++;
            }

            double loadFactor = (double) size / bucketCount;
            if (loadFactor > 2.0) {
                rehash();
            }
        }

        // ------------------------------------------------------------
        // Get Value by Key
        //
        // About:
        // Returns value associated with a key.
        //
        // Average Time Complexity: O(1)
        // ------------------------------------------------------------
        public V get(K key) {
            int bucketIndex = hashFunction(key);
            int dataIndex = searchInBucket(key, bucketIndex);

            if (dataIndex != -1) {
                return buckets[bucketIndex].get(dataIndex).value;
            }
            return null;
        }

        // ------------------------------------------------------------
        // Contains Key
        //
        // About:
        // Checks whether a key exists in the HashMap.
        //
        // Average Time Complexity: O(1)
        // ------------------------------------------------------------
        public boolean containsKey(K key) {
            int bucketIndex = hashFunction(key);
            return searchInBucket(key, bucketIndex) != -1;
        }

        // ------------------------------------------------------------
        // Remove Key
        //
        // About:
        // Removes key-value pair and returns its value.
        //
        // Average Time Complexity: O(1)
        // ------------------------------------------------------------
        public V remove(K key) {
            int bucketIndex = hashFunction(key);
            int dataIndex = searchInBucket(key, bucketIndex);

            if (dataIndex != -1) {
                Node removed = buckets[bucketIndex].remove(dataIndex);
                size--;
                return removed.value;
            }
            return null;
        }

        // ------------------------------------------------------------
        // Key Set
        //
        // About:
        // Returns all keys present in the HashMap.
        //
        // Time Complexity: O(n)
        // ------------------------------------------------------------
        public ArrayList<K> keySet() {
            ArrayList<K> keys = new ArrayList<>();

            for (LinkedList<Node> list : buckets) {
                for (Node node : list) {
                    keys.add(node.key);
                }
            }
            return keys;
        }

        // ------------------------------------------------------------
        // Is Empty
        //
        // Time Complexity: O(1)
        // ------------------------------------------------------------
        public boolean isEmpty() {
            return size == 0;
        }
    }

    // ============================================================
    // Main Method (Test Code)
    // ============================================================
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();

        map.put("India", 100);
        map.put("China", 200);
        map.put("US", 300);

        System.out.println(map.get("India"));
        System.out.println(map.containsKey("China"));
        System.out.println(map.keySet());
    }
}
