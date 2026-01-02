/*
 * Topic: ArrayList Basics (Data Structures & Algorithms)
 *
 * This file contains basic operations performed on
 * ArrayList in Java, commonly asked in interviews
 * and useful for beginners.
 *
 * Purpose:
 * - Understanding Java ArrayList
 * - Daily DSA practice
 * - Quick revision before exams
 *
 * Language: Java
 * Author: Aryan Nair
 */

import java.util.ArrayList;

public class ArrayListBasics {

    // ------------------------------------------------------------
    // Q1. Add an element to the ArrayList
    //
    // Time Complexity: O(1) (Amortized)
    // ------------------------------------------------------------
    public static ArrayList<Integer> addElements(ArrayList<Integer> list, int element) {
        list.add(element);
        return list;
    }

    // ------------------------------------------------------------
    // Q2. Add an element at a specific index
    //
    // Note:
    // Elements after index are shifted right
    //
    // Time Complexity: O(n)
    // ------------------------------------------------------------
    public static ArrayList<Integer> addElementAtIndex(ArrayList<Integer> list,
                                                       int element, int idx) {
        list.add(idx, element);
        return list;
    }

    // ------------------------------------------------------------
    // Q3. Get an element from a specific index
    //
    // Time Complexity: O(1)
    // ------------------------------------------------------------
    public static int getElement(ArrayList<Integer> list, int idx) {
        return list.get(idx);
    }

    // ------------------------------------------------------------
    // Q4. Update (Set) an element at a specific index
    //
    // Time Complexity: O(1)
    // ------------------------------------------------------------
    public static ArrayList<Integer> setElement(ArrayList<Integer> list,
                                                int element, int idx) {
        list.set(idx, element);
        return list;
    }

    // ------------------------------------------------------------
    // Q5. Remove an element from a specific index
    //
    // Note:
    // Elements after index are shifted left
    //
    // Time Complexity: O(n)
    // ------------------------------------------------------------
    public static ArrayList<Integer> removeElement(ArrayList<Integer> list, int idx) {
        list.remove(idx);
        return list;
    }

    // ------------------------------------------------------------
    // Q6. Check if an element exists in the ArrayList
    //
    // Time Complexity: O(n)
    // ------------------------------------------------------------
    public static boolean contain(ArrayList<Integer> list, int element) {
        return list.contains(element);
    }

    // ------------------------------------------------------------
    // Q7. Get the size of the ArrayList
    //
    // Time Complexity: O(1)
    // ------------------------------------------------------------
    public static int size(ArrayList<Integer> list) {
        return list.size();
    }

    // ------------------------------------------------------------
    // Main Method (Test Code)
    // ------------------------------------------------------------
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>(10);

        System.out.println(addElements(list, 2));
        System.out.println(addElementAtIndex(list, 3, 1));
        System.out.println(getElement(list, 0));
        System.out.println(setElement(list, 5, 1));
        System.out.println(removeElement(list, 0));
        System.out.println(contain(list, 3));
        System.out.println(size(list));
    }
}
