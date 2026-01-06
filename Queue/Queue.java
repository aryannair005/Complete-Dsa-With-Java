/*
 * Topic: Queue (Data Structures & Algorithms)
 *
 * This file contains multiple implementations of Queue and Stack
 * using different data structures, along with classic queue-based
 * interview questions.
 *
 * Purpose:
 * - Daily DSA practice
 * - Interview preparation
 * - Revision reference
 *
 * Language: Java
 * Author: Aryan Nair
 */

import java.util.LinkedList;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;
import java.util.Deque;

public class QueueBasics {

    // ============================================================
    // Q1. Queue using Array (Simple Array Implementation)
    // About:
    // Implements queue using array with shifting on removal
    //
    // Enqueue: O(1)
    // Dequeue: O(n)
    // ============================================================
    static class QueueArr {
        static int[] arr;
        static int size;
        static int rear;

        public QueueArr(int n) {
            arr = new int[n];
            size = n;
            rear = -1;
        }

        public static boolean isEmpty() {
            return rear == -1;
        }

        public static boolean isFull() {
            return rear == size - 1;
        }

        public static void add(int value) {
            if (isFull()) {
                System.out.println("Queue is full.");
                return;
            }
            rear = rear + 1;
            arr[rear] = value;
        }

        public static int remove() {
            if (isEmpty()) {
                System.out.println("Queue is empty.");
                return -1;
            }
            int front = arr[0];

            for (int i = 0; i < rear; i++) {
                arr[i] = arr[i + 1];
            }
            rear = rear - 1;
            return front;
        }

        public static int peek() {
            if (isEmpty()) {
                System.out.println("Queue is empty.");
                return -1;
            }
            return arr[0];
        }
    }

    // ============================================================
    // Q2. Circular Queue using Array
    // About:
    // Avoids shifting by reusing space in circular manner
    //
    // Enqueue: O(1)
    // Dequeue: O(1)
    // ============================================================
    static class CircularQueueArr {
        static int[] arr;
        static int rear;
        static int front;
        static int size;

        public CircularQueueArr(int n) {
            arr = new int[n];
            front = -1;
            rear = -1;
            size = n;
        }

        public static boolean isEmpty() {
            return front == -1 && rear == -1;
        }

        public static boolean isFull() {
            return (rear + 1) % size == front;
        }

        public static void add(int value) {
            if (isFull()) {
                System.out.println("Circullar queue is full.");
                return;
            }
            if (front == -1) {
                front = 0;
            }
            rear = (rear + 1) % size;
            arr[rear] = value;
        }

        public static int remove() {
            if (isEmpty()) {
                System.out.println("Circullar queue is empty.");
                return -1;
            }
            int result = arr[front];
            if (front == rear) {
                front = rear = -1;
            } else {
                front = (front + 1) % size;
            }
            return result;
        }

        public static int peek() {
            if (isEmpty()) {
                System.out.println("Circullar queue is empty.");
                return -1;
            }
            return arr[front];
        }
    }

    // ============================================================
    // Q3. Queue using Linked List
    // About:
    // Uses head (front) and tail (rear) pointers
    //
    // Enqueue: O(1)
    // Dequeue: O(1)
    // ============================================================
    static class QueueLL {
        public static class Node {
            int data;
            Node next;

            public Node(int data) {
                this.data = data;
                this.next = null;
            }
        }

        public static Node head;
        public static Node tail;

        public static boolean isEmpty() {
            return head == null;
        }

        public static void add(int value) {
            Node newNode = new Node(value);
            if (isEmpty()) {
                head = tail = newNode;
                return;
            }
            tail.next = newNode;
            tail = newNode;
        }

        public static int remove() {
            if (isEmpty()) {
                System.out.println("QueueLL is empty.");
                return -1;
            }
            int front = head.data;
            head = head.next;
            if (head == null) {
                tail = null;
            }
            return front;
        }

        public static int peek() {
            if (isEmpty()) {
                System.out.println("QueueLL is empty.");
                return -1;
            }
            return head.data;
        }
    }

    // ============================================================
    // Q4. Queue using Stack (Costly Enqueue)
    // About:
    // Uses two stacks to maintain FIFO order
    //
    // Enqueue: O(n)
    // Dequeue: O(1)
    // ============================================================
    static class QueueUsingStack {
        static Stack<Integer> st1 = new Stack<>();
        static Stack<Integer> st2 = new Stack<>();

        public static boolean isEmpty() {
            return st1.isEmpty();
        }

        public static void add(int value) {
            if (st1.isEmpty()) {
                st1.push(value);
                return;
            }
            while (!st1.isEmpty()) {
                st2.push(st1.pop());
            }
            st1.push(value);
            while (!st2.isEmpty()) {
                st1.push(st2.pop());
            }
        }

        public static int pop() {
            if (st1.isEmpty()) {
                System.out.println("Queue is empty.");
                return -1;
            }
            return st1.pop();
        }

        public static int peek() {
            if (st1.isEmpty()) {
                System.out.println("Queue is empty.");
                return -1;
            }
            return st1.peek();
        }
    }

    // ============================================================
    // Q5. Queue using Stack (Costly Dequeue)
    // About:
    // Push is easy, pop requires stack transfer
    //
    // Enqueue: O(1)
    // Dequeue: O(n)
    // ============================================================
    static class QueueUsingStack2 {
        static Stack<Integer> st1 = new Stack<>();
        static Stack<Integer> st2 = new Stack<>();

        public static boolean isEmpty() {
            return st1.isEmpty();
        }

        public static void add(int value) {
            st1.push(value);
        }

        public static int remove() {
            if (st1.isEmpty()) {
                System.out.println("Queue is empty.");
                return -1;
            }
            while (!st1.isEmpty()) {
                st2.push(st1.pop());
            }
            int value = st2.pop();
            while (!st2.isEmpty()) {
                st1.push(st2.pop());
            }
            return value;
        }

        public static int peek() {
            if (st1.isEmpty()) {
                System.out.println("Queue is empty.");
                return -1;
            }
            while (!st1.isEmpty()) {
                st2.push(st1.pop());
            }
            int value = st2.peek();
            while (!st2.isEmpty()) {
                st1.push(st2.pop());
            }
            return value;
        }
    }

    // ============================================================
    // Q6. Stack using Queue (Costly Push)
    // About:
    // Stack implemented using two queues
    //
    // Push: O(n)
    // Pop: O(1)
    // ============================================================
    static class StackUsingQueue {
        static Queue<Integer> q1 = new ArrayDeque<>();
        static Queue<Integer> q2 = new ArrayDeque<>();

        public static boolean isEmpty() {
            return q1.isEmpty();
        }

        public static void push(int value) {
            if (q1.isEmpty()) {
                q1.add(value);
                return;
            }
            while (!q1.isEmpty()) {
                q2.add(q1.remove());
            }
            q1.add(value);
            while (!q2.isEmpty()) {
                q1.add(q2.remove());
            }
        }

        public static int pop() {
            if (q1.isEmpty()) {
                System.out.println("Stack is empty.");
                return -1;
            }
            return q1.remove();
        }

        public static int peek() {
            if (q1.isEmpty()) {
                System.out.println("Stack is empty.");
                return -1;
            }
            return q1.peek();
        }
    }

    // ============================================================
    // Q7. First Non-Repeating Character in a Stream
    // About:
    // Uses queue + frequency array
    //
    // Time Complexity: O(n)
    // ============================================================
    public static String firstNonRepeating(String str) {
        int[] arr = new int[26];
        Queue<Character> q = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            arr[str.charAt(i) - 'a']++;
            q.add(str.charAt(i));

            while (!q.isEmpty() && arr[q.peek() - 'a'] > 1) {
                q.remove();
            }

            if (q.isEmpty()) {
                sb.append(-1);
            } else {
                sb.append(q.peek());
            }
        }
        return sb.toString();
    }

    // ============================================================
    // Q8. Interleave Queue
    // About:
    // Interleaves first half with second half
    //
    // Time Complexity: O(n)
    // ============================================================
    public static void interleaveQueue(Queue<Integer> q) {
        Queue<Integer> q2 = new ArrayDeque<>();
        int size = q.size();

        for (int i = 0; i < size / 2; i++) {
            q2.add(q.remove());
        }

        while (!q2.isEmpty()) {
            q.add(q2.remove());
            q.add(q.remove());
        }
    }

    // ============================================================
    // Q9. Reverse Queue using Recursion
    // Time Complexity: O(n)
    // ============================================================
    public static void queueReversal(Queue<Integer> q) {
        if (q.isEmpty()) {
            return;
        }
        int front = q.remove();
        queueReversal(q);
        q.add(front);
    }

    // ============================================================
    // Q10. Stack using Deque
    // ============================================================
    static class StackFromDeque {
        static Deque<Integer> deque = new ArrayDeque<>();

        public static void push(int data) {
            deque.addLast(data);
        }

        public static int pop() {
            if (deque.isEmpty()) {
                System.out.println("Stack is empty.");
                return -1;
            }
            return deque.removeLast();
        }

        public static int peek() {
            if (deque.isEmpty()) {
                System.out.println("Stack is empty.");
                return -1;
            }
            return deque.getLast();
        }
    }

    // ============================================================
    // Q11. Queue using Deque
    // ============================================================
    static class QueueFromDeque {
        static Deque<Integer> deque = new ArrayDeque<>();

        public static void add(int data) {
            deque.addLast(data);
        }

        public static int remove() {
            if (deque.isEmpty()) {
                System.out.println("Stack is empty.");
                return -1;
            }
            return deque.removeFirst();
        }

        public static int peek() {
            if (deque.isEmpty()) {
                System.out.println("Stack is empty.");
                return -1;
            }
            return deque.getFirst();
        }
    }
    // ============================================================
    // Q12. Minimum Cost to Connect Ropes
    //
    // About:
    // Given an array where each element represents the length of a rope,
    // the task is to connect all ropes into one rope with minimum total cost.
    // The cost of connecting two ropes is equal to the sum of their lengths.
    //
    // Approach:
    // - Use a Min Heap (PriorityQueue)
    // - Always pick the two smallest ropes
    // - Add their sum to the total cost
    // - Insert the combined rope back into the heap
    //
    // This is a greedy algorithm.
    //
    // Time Complexity: O(n log n)
    //   - n insertions into heap → O(n log n)
    //   - n removals and insertions → O(n log n)
    //
    // Space Complexity: O(n)
    //   - PriorityQueue stores all elements
    // ============================================================
    public static int minimumCost(int[] arr){
        int minCost=0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0;i<arr.length;i++){
            pq.add(arr[i]);
        }

        while(pq.size()>1){
            int element1=pq.remove();
            int element2=pq.remove();
            int sum=element1+element2;
            minCost+=sum;
            pq.add(sum);
        }
        return minCost;
    }
        // ============================================================
    // Q13. Reverse First K Elements of a Queue (Using Stack)
    //
    // About:
    // Given a queue and an integer k, reverse the first k elements
    // of the queue while keeping the remaining elements in the same order.
    //
    // Approach:
    // 1. Remove first k elements from the queue and push them into a stack
    // 2. Pop all elements from the stack and add them back to the queue
    // 3. Move the remaining (n - k) elements from front to back
    //
    // Time Complexity: O(n)
    // Space Complexity: O(k)
    // ============================================================
    public static Queue<Integer> reverseFirstKElements(Queue<Integer> q,int k){
        Stack<Integer> st=new Stack<>();

        for(int i=0;i<k;i++){
            st.push(q.remove());
        }
        while(st.isEmpty() != true){
            q.add(st.pop());
        }
        for(int i=0;i<q.size()-k;i++){
            q.add(q.remove());
        }
        return q;

    }

    // ============================================================
    // Q14. Reverse First K Elements of a Queue (Using Deque)
    //
    // About:
    // Same problem as above, but solved using a Deque instead of a Stack.
    //
    // Approach:
    // 1. Remove first k elements from queue and store them in deque
    // 2. Remove elements from the back of deque and add them to queue
    // 3. Rotate the remaining (n - k) elements to maintain order
    //
    // Time Complexity: O(n)
    // Space Complexity: O(k)
    // ============================================================
    public static Queue<Integer> reverseFirstKElements(Queue<Integer> q,int k){
        Deque<Integer> dq=new ArrayDeque<>();

        for(int i=0;i<k;i++){
            dq.addLast(q.remove());
        }
        for(int i=0;i<k;i++){
            q.add(dq.removeLast());
        }
        for(int i=0;i<q.size()-k;i++){
            q.add(q.remove());
        }
        return q;

    }

    // ============================================================
    // Q15. Kth Smallest Element in an Array
    //
    // About:
    // Given an array of integers and an integer k,
    // find the k-th smallest element in the array.
    //
    // Approach:
    // - Use a Min Heap (PriorityQueue)
    // - Insert all elements of the array into the heap
    // - Remove the smallest element (k-1) times
    // - The next removed element is the k-th smallest
    //
    // Time Complexity: O(n log n)
    //   - Inserting n elements into heap → O(n log n)
    //   - Removing k elements → O(k log n)
    //
    // Space Complexity: O(n)
    //   - PriorityQueue stores all elements
    // ============================================================
    class Solution {
        public int kthSmallest(int[] arr, int k) {
            // Code here
            PriorityQueue<Integer> pq=new PriorityQueue<>();
            
            for(int i=0;i<arr.length;i++){
                pq.add(arr[i]);
            }
            for(int i=0;i<k-1;i++){
                pq.remove();
            }
            
            return pq.remove();
        }
        
    }
    // ============================================================
    // Question: Kth Largest Element in an Array
    //
    // About:
    // Given an integer array and an integer k,
    // return the k-th largest element in the array.
    //
    // Approach:
    // - Use a Min Heap (PriorityQueue) of size k
    // - Insert elements one by one into the heap
    // - If heap size exceeds k, remove the smallest element
    // - At the end, the top of the heap is the k-th largest element
    //
    // Time Complexity: O(n log k)
    //   - n insertions into heap
    //   - Heap size is maintained at k
    //
    // Space Complexity: O(k)
    //   - PriorityQueue stores at most k elements
    // ============================================================
    class Solution {
        public int findKthLargest(int[] nums, int k) {
            PriorityQueue<Integer> pq=new PriorityQueue<>();

            for(int i=0;i<nums.length;i++){
                pq.add(nums[i]);
                if(pq.size()>k){
                    pq.remove();
                }
            }
            
            return pq.peek();
        }
    }



    // ------------------------------------------------------------
    // Main Method (Test Code)
    // ------------------------------------------------------------
    public static void main(String[] args) {
        QueueFromDeque st = new QueueFromDeque();
        st.add(1);
        st.add(2);
        System.out.println(st.remove());
    }
}
