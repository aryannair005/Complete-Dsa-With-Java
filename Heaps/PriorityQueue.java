import java.util.PriorityQueue;
import java.util.Comparator;

/*
 * Topic: Priority Queue (Data Structures & Algorithms)
 *
 * Problem Covered:
 * Ordering Custom Objects using PriorityQueue
 *
 * Purpose:
 * - Understand how PriorityQueue works internally
 * - Learn Comparable vs Comparator
 * - Practice custom object ordering
 *
 * Language: Java
 * Author: Aryan Nair
 */

public class PriorityQueueBasics{

    // ------------------------------------------------------------
    // Q1. Priority Queue with Custom Objects (Student Ranking)
    //
    // About:
    // Uses PriorityQueue to store Student objects.
    // Ordering is defined using Comparable interface.
    // Comparator.reverseOrder() is used to reverse natural order.
    //
    // Time Complexity:
    // Insert (add): O(log n)
    // Remove (poll/remove): O(log n)
    // Peek: O(1)
    //
    // Space Complexity: O(n)
    // ------------------------------------------------------------
    static class Student implements Comparable<Student>{
        String name;
        int rank;

        public Student(String name,int rank){
            this.name=name;
            this.rank=rank;
        }

        @Override
        public int compareTo(Student s2){
            return this.rank-s2.rank;
        }
    }

    // ------------------------------------------------------------
    // Main Method (Test Code)
    // ------------------------------------------------------------
    public static void main(String[] args){
        PriorityQueue<Student> pq=new PriorityQueue<>(Comparator.reverseOrder());

        pq.add(new Student("Aryan",2));
        pq.add(new Student("Sanjana",1));
        pq.add(new Student("Talim",3));
        pq.add(new Student("Aditya",4));

        while(pq.isEmpty() != true){
            System.out.println(pq.peek().name+"->"+pq.peek().rank);
            pq.remove();
        }
    }
}
