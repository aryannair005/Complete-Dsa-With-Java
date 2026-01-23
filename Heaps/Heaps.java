import java.util.ArrayList;
import java.util.PriorityQueue;

/*
 * Topic: Heaps (Data Structures & Algorithms)
 *
 * This file contains:
 * - Min Heap & Max Heap implementation
 * - Heap Sort
 * - Heap-based interview problems
 *
 * Language: Java
 * Author: Aryan Nair
 */

public class HeapsBasics{

    // ============================================================
    // Q1. Min Heap Implementation using ArrayList
    //
    // About:
    // Implements a Min Heap where the smallest element
    // is always at the root.
    //
    // Time Complexity:
    // add()   -> O(log n)
    // remove()-> O(log n)
    // peek()  -> O(1)
    //
    // Space Complexity: O(n)
    // ============================================================
    static class minHeap{
        ArrayList<Integer> list=new ArrayList<>();

        public void add(int data){
            list.add(data);

            int x=list.size()-1;
            int par=(x-1)/2;

            while(x>0 && list.get(x) < list.get(par)){
                int temp=list.get(x);
                list.set(x,list.get(par));
                list.set(par,temp);
                x=par;
                par=(x-1)/2;
            }
            System.out.println(list);
        }

        public int peak(){
            return list.get(0);
        }

        private void Heapify(int i){
            int left=2*i+1;
            int right=2*i+2;
            int minIdx=i;

            if(left < list.size() && list.get(left) < list.get(minIdx)){
                minIdx=left;
            }
            if(right < list.size() && list.get(right) < list.get(minIdx)){
                minIdx=right;
            }

            if(i != minIdx){
                int temp=list.get(i);
                list.set(i,list.get(minIdx));
                list.set(minIdx,temp);
                Heapify(minIdx);
            }
        }

        public int remove(){
            int data=list.get(0);

            int temp=list.get(0);
            list.set(0,list.get(list.size()-1));
            list.set(list.size()-1,temp);

            list.remove(list.size()-1);
            Heapify(0);

            return data;
        }
    }

    // ============================================================
    // Q2. Max Heap Implementation using ArrayList
    //
    // About:
    // Root always contains the maximum element.
    //
    // Time Complexity:
    // add/remove -> O(log n)
    // peek       -> O(1)
    // ============================================================
    static class maxHeap{
        ArrayList<Integer> list=new ArrayList<>();

        public void add(int data){
            list.add(data);

            int x=list.size()-1;
            int par=(x-1)/2;

            while(x>0 && list.get(x) > list.get(par)){
                int temp=list.get(x);
                list.set(x,list.get(par));
                list.set(par,temp);
                x=par;
                par=(x-1)/2;
            }
            System.out.println(list);
        }

        public int peak(){
            return list.get(0);
        }

        private void Heapify(int i){
            int left=2*i+1;
            int right=2*i+2;
            int maxIdx=i;

            if(left < list.size() && list.get(left) > list.get(maxIdx)){
                maxIdx=left;
            }
            if(right < list.size() && list.get(right) > list.get(maxIdx)){
                maxIdx=right;
            }

            if(i != maxIdx){
                int temp=list.get(i);
                list.set(i,list.get(maxIdx));
                list.set(maxIdx,temp);
                Heapify(maxIdx);
            }
        }

        public int remove(){
            int data=list.get(0);

            int temp=list.get(0);
            list.set(0,list.get(list.size()-1));
            list.set(list.size()-1,temp);

            list.remove(list.size()-1);
            Heapify(0);

            return data;
        }
    }

    // ============================================================
    // Q3. Heapify Function (Array-based)
    //
    // About:
    // Maintains Max Heap property at index i.
    //
    // Time Complexity: O(log n)
    // ============================================================
    public static void Heapify(int[] arr,int i,int size){
        int left=2*i+1;
        int right=2*i+2;
        int maxIdx=i;

        if(left < size && arr[left] > arr[maxIdx]){
            maxIdx=left;
        }
        if(right < size && arr[right] > arr[maxIdx]){
            maxIdx=right;
        }

        if(maxIdx != i){
            int temp=arr[maxIdx];
            arr[maxIdx]=arr[i];
            arr[i]=temp;
            Heapify(arr,maxIdx,size);
        }
    }

    // ============================================================
    // Q4. Heap Sort
    //
    // About:
    // Sorts an array using Max Heap.
    //
    // Time Complexity: O(n log n)
    // Space Complexity: O(1)
    // ============================================================
    public static void heapSort(int[] arr){
        int n=arr.length;

        for(int i=n/2;i>=0;i--){
            Heapify(arr,i,n);
        }

        for(int i=n-1;i>0;i--){
            int temp=arr[0];
            arr[0]=arr[i];
            arr[i]=temp;
            Heapify(arr,0,i);
        }
    }

    // ============================================================
    // Q5. K Nearest Cars (PriorityQueue)
    //
    // About:
    // Finds k closest cars to origin using Min Heap.
    //
    // Time Complexity: O(n log n)
    // ============================================================
    static class CarsInfo implements Comparable<CarsInfo>{
        int idx;
        int distance;

        public CarsInfo(int idx,int distance){
            this.idx=idx;
            this.distance=distance;
        }

        @Override
        public int compareTo(CarsInfo c){
            return this.distance-c.distance;
        }
    }

    public static void nearbyCars(int[][] pts,int k){
        PriorityQueue<CarsInfo> pq=new PriorityQueue<>();

        for(int i=0;i<pts.length;i++){
            int xSq=pts[i][0] * pts[i][0];
            int ySq=pts[i][1] * pts[i][1];
            pq.add(new CarsInfo(i,xSq+ySq));
        }

        for(int i=0;i<k;i++){
            System.out.println("Car : "+pq.remove().idx);
        }
    }

    // ============================================================
    // Q6. Weakest Soldiers in the Army
    //
    // Time Complexity: O(n log n)
    // ============================================================
    static class ArmyInfo implements Comparable<ArmyInfo>{
        int soldiers;
        int idx;

        public ArmyInfo(int soldiers,int idx){
            this.soldiers=soldiers;
            this.idx=idx;
        }

        @Override
        public int compareTo(ArmyInfo a){
            if(this.soldiers == a.soldiers){
                return this.idx-a.idx;
            }else{
                return this.soldiers-a.soldiers;
            }
        }
    }

    public static void weakestSoldier(int[][] army,int k){
        PriorityQueue<ArmyInfo> pq=new PriorityQueue<>();

        for(int i=0;i<army.length;i++){
            int count=0;
            for(int j=0;j<army[0].length;j++){
                if(army[i][j] == 1){
                    count++;
                }
            }
            pq.add(new ArmyInfo(count,i));
        }

        for(int i=0;i<k;i++){
            System.out.println("row => "+pq.remove().idx);
        }
    }

    // ============================================================
    // Q7. Minimum Cost of Ropes
    //
    // Time Complexity: O(n log n)
    // ============================================================
    public static int minCostOfropes(int[] ropes){
        PriorityQueue<Integer> pq=new PriorityQueue<>();

        for(int i=0;i<ropes.length;i++){
            pq.add(ropes[i]);
        }

        int cost=0;
        while(pq.size() > 1){
            int first=pq.remove();
            int second=pq.remove();
            int currCost=first+second;
            cost+=currCost;
            pq.add(currCost);
        }
        return cost;
    }

    // ============================================================
    // Q8. Sliding Window Maximum
    //
    // About:
    // Finds max element in every window of size k.
    //
    // Time Complexity: O(n log k)
    // ============================================================
    static class SlidingWindowInfo implements Comparable<SlidingWindowInfo>{
        int value;
        int idx;

        public SlidingWindowInfo(int value,int idx){
            this.value=value;
            this.idx=idx;
        }

        @Override
        public int compareTo(SlidingWindowInfo s){
            return s.value - this.value;
        }
    }

    public static void slidingWindowMaximum(int[] nums,int k){
        PriorityQueue<SlidingWindowInfo> pq=new PriorityQueue<>();
        int[] result=new int[nums.length-k+1];

        for(int i=0;i<k;i++){
            pq.add(new SlidingWindowInfo(nums[i],i));
        }
        result[0]=pq.peek().value;

        for(int i=k;i<nums.length;i++){
            while(pq.size() > 0 && pq.peek().idx <= (i-k)){
                pq.remove();
            }
            pq.add(new SlidingWindowInfo(nums[i],i));
            result[i-k+1]=pq.peek().value;
        }

        for(int i=0;i<result.length;i++){
            System.out.print(result[i]+" ");
        }
    }

    public static void main(String[] args){
        int[] nums={1,3,-1,-3,5,3,6,7};
        slidingWindowMaximum(nums,3);
    }
}
