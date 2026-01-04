/*
 * Topic: Singly Linked List (Data Structures & Algorithms)
 *
 * This file contains implementation of a Singly Linked List
 * along with important interview-level operations.
 *
 * Purpose:
 * - Understanding Linked List internals
 * - Daily DSA practice
 * - Interview preparation and quick revision
 *
 * Language: Java
 * Author: Aryan Nair
 */

public class LinkedList {

    // ------------------------------------------------------------
    // Node Structure for Singly Linked List
    // ------------------------------------------------------------
    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Head, Tail and Size of Linked List
    public static Node head;
    public static Node tail;
    public static int size = 0;

    // ------------------------------------------------------------
    // Q1. Add Node at the Beginning
    //
    // Time Complexity: O(1)
    // ------------------------------------------------------------
    public static void addFirst(int data) {
        Node newNode = new Node(data);
        size++;

        if (head == null) {
            head = tail = newNode;
            return;
        }

        newNode.next = head;
        head = newNode;
    }

    // ------------------------------------------------------------
    // Q2. Add Node at the End
    //
    // Time Complexity: O(1)
    // ------------------------------------------------------------
    public static void addLast(int data) {
        Node newNode = new Node(data);
        size++;

        if (head == null) {
            head = tail = newNode;
            return;
        }

        tail.next = newNode;
        tail = newNode;
    }

    // ------------------------------------------------------------
    // Q3. Print the Linked List
    //
    // Time Complexity: O(n)
    // ------------------------------------------------------------
    public static void print(Node head) {
        if (head == null) {
            System.out.println("LL is empty.");
            return;
        }

        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    // ------------------------------------------------------------
    // Q4. Add Node at a Specific Index
    //
    // Time Complexity: O(n)
    // ------------------------------------------------------------
    public static void addOnIndex(int data, int idx) {
        if (idx == 0) {
            addFirst(data);
            return;
        }

        Node newNode = new Node(data);
        size++;

        Node temp = head;
        for (int i = 0; i < idx - 1; i++) {
            temp = temp.next;
        }

        newNode.next = temp.next;
        temp.next = newNode;
    }

    // ------------------------------------------------------------
    // Q5. Remove First Node
    //
    // Time Complexity: O(1)
    // ------------------------------------------------------------
    public static int removeFirst() {
        if (head == null) {
            System.out.println("LL is empty.");
            return Integer.MIN_VALUE;
        }

        int value = head.data;
        head = head.next;
        size--;

        return value;
    }

    // ------------------------------------------------------------
    // Q6. Remove Last Node
    //
    // Time Complexity: O(n)
    // ------------------------------------------------------------
    public static int removeLast() {
        if (head == null) {
            System.out.println("LL is empty.");
            return Integer.MIN_VALUE;
        }

        if (head.next == null) {
            int value = head.data;
            head = tail = null;
            size--;
            return value;
        }

        Node temp = head;
        while (temp.next.next != null) {
            temp = temp.next;
        }

        int value = temp.next.data;
        temp.next = null;
        tail = temp;
        size--;

        return value;
    }

    // ------------------------------------------------------------
    // Q7. Search an Element (Iterative)
    //
    // Returns index if found, else -1
    //
    // Time Complexity: O(n)
    // ------------------------------------------------------------
    public static int search(int key) {
        if (head == null) {
            System.out.println("LL is empty.");
            return -1;
        }

        Node temp = head;
        int idx = 0;

        while (temp != null) {
            if (temp.data == key) {
                return idx;
            }
            temp = temp.next;
            idx++;
        }
        return -1;
    }

    // ------------------------------------------------------------
    // Q8. Detect Cycle in Linked List (Floyd’s Algorithm)
    //
    // Time Complexity: O(n)
    // Space Complexity: O(1)
    // ------------------------------------------------------------
    public static boolean detectCycle(Node head) {
        if (head == null) {
            return false;
        }

        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    // ------------------------------------------------------------
    // Q9. Remove Cycle from Linked List
    // ------------------------------------------------------------
    public static void removeCycle(Node head) {
        if (head == null) {
            System.out.println("LL is empty.");
            return;
        }

        Node slow = head;
        Node fast = head;
        boolean isCycle = false;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                isCycle = true;
                break;
            }
        }

        if (!isCycle) return;

        slow = head;

        // Case 1: Cycle does not start at head
        if (slow != fast) {
            Node prev = null;
            while (slow != fast) {
                prev = fast;
                slow = slow.next;
                fast = fast.next;
            }
            prev.next = null;
        }
        // Case 2: Cycle starts at head
        else {
            while (fast.next != slow) {
                fast = fast.next;
            }
            fast.next = null;
        }
    }

    // ------------------------------------------------------------
    // Q10. Merge Sort on Linked List
    //
    // Time Complexity: O(n log n)
    // Space Complexity: O(log n)
    // ------------------------------------------------------------
    public static Node mergeSort(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        Node mid = getMid(head);
        Node rightHead = mid.next;
        mid.next = null;

        Node left = mergeSort(head);
        Node right = mergeSort(rightHead);

        return merge(left, right);
    }

    // ------------------------------------------------------------
    // Helper Method to Merge Two Sorted Linked Lists
    // ------------------------------------------------------------
    public static Node merge(Node left, Node right) {
        Node dummy = new Node(-1);
        Node temp = dummy;

        while (left != null && right != null) {
            if (left.data <= right.data) {
                temp.next = left;
                left = left.next;
            } else {
                temp.next = right;
                right = right.next;
            }
            temp = temp.next;
        }

        if (left != null) temp.next = left;
        if (right != null) temp.next = right;

        return dummy.next;
    }

    // ------------------------------------------------------------
    // Helper Method to Find Middle Node
    // ------------------------------------------------------------
    public static Node getMid(Node head) {
        Node slow = head;
        Node fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    // ------------------------------------------------------------
    // Q11. Zig-Zag Linked List
    //
    // Example:
    // 1->2->3->4->5 → 1->5->2->4->3
    // ------------------------------------------------------------
    public static Node zigZag(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        Node mid = getMid(head);
        Node secondHalf = mid.next;
        mid.next = null;

        Node rev = reverse(secondHalf);

        Node first = head;
        Node next1, next2;

        while (first != null && rev != null) {
            next1 = first.next;
            next2 = rev.next;

            first.next = rev;
            rev.next = next1;

            first = next1;
            rev = next2;
        }
        return head;
    }

    // ------------------------------------------------------------
    // Helper Method to Reverse a Linked List
    // ------------------------------------------------------------
    public static Node reverse(Node head) {
        Node prev = null;
        Node curr = head;

        while (curr != null) {
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    // ------------------------------------------------------------
    // Main Method (Test Code)
    // ------------------------------------------------------------
    public static void main(String[] args) {
        
    }
}
