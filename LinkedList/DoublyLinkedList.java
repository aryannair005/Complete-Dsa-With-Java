/*
 * Topic: Doubly Linked List (Data Structures & Algorithms)
 *
 * This file contains implementation of a Doubly Linked List
 * with basic operations commonly asked in interviews.
 *
 * Purpose:
 * - Understanding Doubly Linked List structure
 * - Daily DSA practice
 * - Interview preparation and revision
 *
 * Language: Java
 * Author: Aryan Nair
 */

public class DoublyLL {

    // ------------------------------------------------------------
    // Node Structure for Doubly Linked List
    // ------------------------------------------------------------
    public static class Node {
        int data;
        Node next;
        Node prev;

        public Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    // Head, Tail and Size of DLL
    public static Node head;
    public static Node tail;
    public static int size = 0;

    // ------------------------------------------------------------
    // Q1. Add Node at the Beginning of the DLL
    //
    // Time Complexity: O(1)
    // ------------------------------------------------------------
    public static void addFirst(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = tail = newNode;
            size++;
            return;
        }

        newNode.next = head;
        head.prev = newNode;
        head = newNode;
        size++;
    }

    // ------------------------------------------------------------
    // Q2. Add Node at the End of the DLL
    //
    // Time Complexity: O(1)
    // ------------------------------------------------------------
    public static void addLast(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = tail = newNode;
            size++;
            return;
        }

        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;
        size++;
    }

    // ------------------------------------------------------------
    // Q3. Remove First Node from the DLL
    //
    // Time Complexity: O(1)
    // ------------------------------------------------------------
    public static int removeFirst() {
        if (head == null) {
            System.out.println("DLL is empty.");
            return Integer.MIN_VALUE;
        }

        int value = head.data;

        // Single node case
        if (head == tail) {
            head = tail = null;
        } else {
            head = head.next;
            head.prev = null;
        }

        size--;
        return value;
    }

    // ------------------------------------------------------------
    // Q4. Remove Last Node from the DLL
    //
    // Time Complexity: O(1)
    // ------------------------------------------------------------
    public static int removeLast() {
        if (head == null) {
            System.out.println("DLL is empty.");
            return Integer.MIN_VALUE;
        }

        int value = tail.data;

        // Single node case
        if (head == tail) {
            head = tail = null;
        } else {
            tail = tail.prev;
            tail.next = null;
        }

        size--;
        return value;
    }

    // ------------------------------------------------------------
    // Q5. Print the Doubly Linked List
    //
    // Time Complexity: O(n)
    // ------------------------------------------------------------
    public static void print() {
        if (head == null) {
            System.out.println("DLL is empty.");
            return;
        }

        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    // ------------------------------------------------------------
    // Main Method (Test Code)
    // ------------------------------------------------------------
    public static void main(String[] args) {
        DoublyLL dll = new DoublyLL();

        dll.addFirst(1);
        dll.addFirst(2);
        dll.addLast(4);
        dll.addLast(5);

        dll.print();

        System.out.println(dll.removeFirst());
        dll.print();
    }
}