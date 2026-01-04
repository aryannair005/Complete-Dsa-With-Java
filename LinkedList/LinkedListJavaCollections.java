/*
 * Topic: Java Inbuilt LinkedList (Collections Framework)
 *
 * This file demonstrates commonly used operations
 * of Java's inbuilt LinkedList class.
 *
 * Purpose:
 * - Understanding LinkedList methods in Java
 * - Daily DSA / Java Collections practice
 * - Interview preparation & quick revision
 *
 * Language: Java
 * Author: Aryan Nair
 */

import java.util.LinkedList;

public class LinkedListQuestions {

    // ------------------------------------------------------------
    // Main Method (Demonstration of LinkedList Operations)
    // ------------------------------------------------------------
    public static void main(String[] args) {

        // Create LinkedList
        LinkedList<Integer> list = new LinkedList<>();

        // --------------------------------------------------------
        // Q1. Add Operations
        // --------------------------------------------------------
        list.add(10);              // add at end
        list.add(20);
        list.addFirst(5);          // add at beginning
        list.addLast(30);          // add at end
        list.add(2, 15);           // add at specific index

        System.out.println("After adding: " + list);

        // --------------------------------------------------------
        // Q2. Access Operations
        // --------------------------------------------------------
        System.out.println("First element: " + list.getFirst());
        System.out.println("Last element: " + list.getLast());
        System.out.println("Element at index 2: " + list.get(2));

        // --------------------------------------------------------
        // Q3. Update Operation
        // --------------------------------------------------------
        list.set(2, 100);
        System.out.println("After update: " + list);

        // --------------------------------------------------------
        // Q4. Remove Operations
        // --------------------------------------------------------
        list.remove();             // removes first element
        list.removeFirst();        // removes first element
        list.removeLast();         // removes last element
        list.remove(1);            // remove by index

        System.out.println("After removals: " + list);

        // --------------------------------------------------------
        // Q5. Search Operations
        // --------------------------------------------------------
        System.out.println("Contains 20? " + list.contains(20));
        System.out.println("Index of 20: " + list.indexOf(20));
        System.out.println("Last index of 20: " + list.lastIndexOf(20));

        // --------------------------------------------------------
        // Q6. Size & Empty Check
        // --------------------------------------------------------
        System.out.println("Size: " + list.size());
        System.out.println("Is Empty? " + list.isEmpty());

        // --------------------------------------------------------
        // Q7. Traversal
        // --------------------------------------------------------
        System.out.print("Traversal using for-each: ");
        for (int x : list) {
            System.out.print(x + " ");
        }
        System.out.println();

        // --------------------------------------------------------
        // Q8. Clear the LinkedList
        // --------------------------------------------------------
        list.clear();
        System.out.println("After clear: " + list);
    }
}
