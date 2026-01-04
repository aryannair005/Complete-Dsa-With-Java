/*
 * Topic: Stack (Data Structures & Algorithms)
 *
 * This file contains stack implementation using:
 * - ArrayList
 * - Linked List
 * - Java Inbuilt Stack class
 *
 * Also includes frequently asked stack-based interview problems.
 *
 * Purpose:
 * - Daily DSA practice
 * - Interview preparation
 * - Quick revision before exams
 *
 * Language: Java
 * Author: Aryan Nair
 */

import java.util.ArrayList;
import java.util.Stack;

public class StackBasics {

    // ------------------------------------------------------------
    // Q1. Stack Implementation using ArrayList
    // ------------------------------------------------------------
    public static class StackAL {
        static ArrayList<Integer> list = new ArrayList<>();

        static boolean isEmpty() {
            return list.size() == 0;
        }

        static void push(int data) {
            list.add(data);
        }

        static int pop() {
            if (isEmpty()) {
                System.out.println("Stack is empty.");
                return Integer.MIN_VALUE;
            }
            int top = list.get(list.size() - 1);
            list.remove(list.size() - 1);
            return top;
        }

        static int peek() {
            if (isEmpty()) {
                System.out.println("Stack is empty.");
                return Integer.MIN_VALUE;
            }
            return list.get(list.size() - 1);
        }
    }

    // ------------------------------------------------------------
    // Node Structure for Stack using Linked List
    // ------------------------------------------------------------
    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // ------------------------------------------------------------
    // Q2. Stack Implementation using Linked List
    // ------------------------------------------------------------
    public static class StackLL {
        static Node head = null;

        static boolean isEmpty() {
            return head == null;
        }

        static void push(int data) {
            Node newNode = new Node(data);
            newNode.next = head;
            head = newNode;
        }

        static int pop() {
            if (isEmpty()) {
                System.out.println("Stack is empty.");
                return Integer.MIN_VALUE;
            }
            int value = head.data;
            head = head.next;
            return value;
        }

        static int peek() {
            if (isEmpty()) {
                System.out.println("Stack is empty.");
                return Integer.MIN_VALUE;
            }
            return head.data;
        }
    }

    // ------------------------------------------------------------
    // Q3. Push an Element at the Bottom of a Stack (Recursion)
    // ------------------------------------------------------------
    public static void pushAtBottom(Stack<Integer> st, int value) {
        if (st.isEmpty()) {
            st.push(value);
            return;
        }
        int top = st.pop();
        pushAtBottom(st, value);
        st.push(top);
    }

    // ------------------------------------------------------------
    // Q4. Reverse a String using Stack
    //
    // Time Complexity: O(n)
    // Space Complexity: O(n)
    // ------------------------------------------------------------
    public static String reverseString(String s) {
        StringBuilder sb = new StringBuilder();
        Stack<Character> st = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            st.push(s.charAt(i));
        }

        while (!st.isEmpty()) {
            sb.append(st.pop());
        }
        return sb.toString();
    }

    // ------------------------------------------------------------
    // Q5. Reverse a Stack using Recursion
    // ------------------------------------------------------------
    public static void reverseStack(Stack<Integer> st) {
        if (st.isEmpty()) {
            return;
        }
        int top = st.pop();
        reverseStack(st);
        pushAtBottom(st, top);
    }

    // ------------------------------------------------------------
    // Q6. Stock Span Problem
    //
    // Time Complexity: O(n)
    // Space Complexity: O(n)
    // ------------------------------------------------------------
    public static void stockSpan(int[] stock) {
        Stack<Integer> st = new Stack<>();
        int[] span = new int[stock.length];

        span[0] = 1;
        st.push(0);

        for (int i = 1; i < stock.length; i++) {
            while (!st.isEmpty() && stock[st.peek()] <= stock[i]) {
                st.pop();
            }
            span[i] = st.isEmpty() ? (i + 1) : (i - st.peek());
            st.push(i);
        }

        for (int i = 0; i < span.length; i++) {
            System.out.print(span[i] + " ");
        }
        System.out.println();
    }

    // ------------------------------------------------------------
    // Q7. Previous Greater Element
    // ------------------------------------------------------------
    public static ArrayList<Integer> previousGreater(int[] arr) {
        Stack<Integer> st = new Stack<>();
        ArrayList<Integer> result = new ArrayList<>();

        st.push(arr[0]);
        result.add(-1);

        for (int i = 1; i < arr.length; i++) {
            while (!st.isEmpty() && st.peek() <= arr[i]) {
                st.pop();
            }
            result.add(st.isEmpty() ? -1 : st.peek());
            st.push(arr[i]);
        }
        return result;
    }

    // ------------------------------------------------------------
    // Q8. Valid Parenthesis Check
    // ------------------------------------------------------------
    public static boolean validParenthesis(String str) {
        Stack<Character> st = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            char curr = str.charAt(i);

            if (curr == '(') {
                st.push(curr);
            } else {
                if (!st.isEmpty() && st.peek() == '(') {
                    st.pop();
                } else {
                    return false;
                }
            }
        }
        return st.isEmpty();
    }

    // ------------------------------------------------------------
    // Q9. Duplicate Parenthesis Detection
    // ------------------------------------------------------------
    public static boolean duplicateParenthesis(String str) {
        Stack<Character> st = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            char curr = str.charAt(i);

            if (curr != ')') {
                st.push(curr);
            } else {
                int count = 0;
                while (!st.isEmpty() && st.peek() != '(') {
                    st.pop();
                    count++;
                }
                if (count == 0) {
                    return true; // duplicate found
                }
                st.pop(); // remove '('
            }
        }
        return false;
    }

    // ------------------------------------------------------------
    // Q10. Maximum Area in Histogram
    //
    // Time Complexity: O(n)
    // Space Complexity: O(n)
    // ------------------------------------------------------------
    public static int maxAreaHistogram(int[] height) {
        Stack<Integer> st = new Stack<>();
        int[] nsl = new int[height.length];
        int[] nsr = new int[height.length];

        // Next Smaller Left
        for (int i = 0; i < height.length; i++) {
            while (!st.isEmpty() && height[st.peek()] >= height[i]) {
                st.pop();
            }
            nsl[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }

        st.clear();

        // Next Smaller Right
        for (int i = height.length - 1; i >= 0; i--) {
            while (!st.isEmpty() && height[st.peek()] >= height[i]) {
                st.pop();
            }
            nsr[i] = st.isEmpty() ? height.length : st.peek();
            st.push(i);
        }

        int maxArea = 0;

        for (int i = 0; i < height.length; i++) {
            int width = nsr[i] - nsl[i] - 1;
            int area = height[i] * width;
            maxArea = Math.max(maxArea, area);
        }
        return maxArea;
    }

    // ------------------------------------------------------------
    // Main Method (Test Code)
    // ------------------------------------------------------------
    public static void main(String[] args) {

        int[] height = {2, 1, 5, 6, 2, 3};
        System.out.println(maxAreaHistogram(height));

        // Stack<Integer> st = new Stack<>();
        // st.push(1);
        // st.push(2);
        // st.push(3);
        // reverseStack(st);
    }
}
