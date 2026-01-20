import java.util.PriorityQueue;
import java.util.Comparator;


public class PriorityQueueBasics{
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