import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.TreeSet;  
import java.util.ArrayList; 
import java.util.HashMap;

/*
 * Topic: HashSet & HashMap (Data Structures & Algorithms)
 *
 * Problems Covered:
 * 1. HashSet Traversal
 * 2. Intersection of Two Arrays
 * 3. Union of Two Arrays
 * 4. Reconstruct Itinerary
 * 5. Largest Subarray with Sum Zero
 *
 * Purpose:
 * - Understand HashSet & HashMap usage
 * - Practice common interview problems
 *
 * Language: Java
 * Author: Aryan Nair
 */

public class HashSetBasics{

    // ------------------------------------------------------------
    // Q1. Traverse HashSet using Iterator
    //
    // Time Complexity: O(n)
    // ------------------------------------------------------------
    public static void traverseUsingIterator(HashSet<Integer> hs){
        Iterator it=hs.iterator();
        while(it.hasNext()){
            System.out.print(it.next()+" ");
        }
    }

    // ------------------------------------------------------------
    // Q2. Traverse HashSet using Enhanced For Loop
    //
    // Time Complexity: O(n)
    // ------------------------------------------------------------
    public static void traverseUsingAdvanceLoop(HashSet<Integer> hs){
        for(int i:hs){
            System.out.print(i+" ");
        }
    }

    // ------------------------------------------------------------
    // Q3. Intersection of Two Arrays
    //
    // About:
    // Finds common elements between two arrays using HashSet.
    //
    // Time Complexity: O(n + m)
    // Space Complexity: O(n)
    // ------------------------------------------------------------
    public static ArrayList<Integer> intersect(int[] a, int[] b) {
        HashSet<Integer> hs=new HashSet<>();
        HashSet<Integer> result=new HashSet<>();
        ArrayList<Integer> list=new ArrayList<>();
        
        for(int i=0;i<a.length;i++){
            hs.add(a[i]);
        }
        for(int i=0;i<b.length;i++){
            if(hs.contains(b[i])){
                result.add(b[i]);
            }
        }
        for(int i:result){
            list.add(i);
        }
        return list;
    }

    // ------------------------------------------------------------
    // Q4. Union of Two Arrays
    //
    // About:
    // Finds all unique elements from both arrays.
    //
    // Time Complexity: O(n + m)
    // Space Complexity: O(n)
    // ------------------------------------------------------------
    public static ArrayList<Integer> findUnion(int[] a, int[] b) {
        HashSet<Integer> hs=new HashSet<>();
        ArrayList<Integer> list=new ArrayList<>();
        
        for(int i=0;i<a.length;i++){
            hs.add(a[i]);
        }
        for(int i=0;i<b.length;i++){
            hs.add(b[i]);
        }
        
        for(int i:hs){
            list.add(i);
        }
        return list;
    }

    // ------------------------------------------------------------
    // Q5. Reconstruct Itinerary
    //
    // About:
    // Given source-destination pairs, reconstruct the travel path.
    //
    // Time Complexity: O(n)
    // Space Complexity: O(n)
    // ------------------------------------------------------------
    public static ArrayList<String> itinerary(String[][] tickets){
        ArrayList<String> list=new ArrayList<>();
        HashMap<String,String> map=new HashMap<>();

        for(int i=0;i<tickets.length;i++){
            map.put(tickets[i][0],tickets[i][1]);
        }

        HashMap<String,String> reverseMap=new HashMap<>();
        
        for(String key:map.keySet()){
            reverseMap.put(map.get(key),key);
        }

        String start=null;

        for(String key:map.keySet()){
            if(reverseMap.containsKey(key) != true){
                start=key;
            }
        }

        list.add(start);
        for(String key: map.keySet()){
            list.add(map.get(start));
            start=map.get(start);
        }

        return list;
    }

    // ------------------------------------------------------------
    // Q6. Largest Subarray with Sum Zero
    //
    // About:
    // Finds the maximum length subarray having sum = 0
    // using prefix sum and HashMap.
    //
    // Time Complexity: O(n)
    // Space Complexity: O(n)
    // ------------------------------------------------------------
    public static int largestSubarrayWithSumZero(int[] arr){
        HashMap<Integer,Integer> map=new HashMap<>();
        map.put(0,-1);
        int length=0;
        int sum=0;

        for(int i=0;i<arr.length;i++){
            sum+=arr[i];
            if(map.containsKey(sum)){
                int currLength=i-map.get(sum);
                length=Math.max(length,currLength);
            }else{
                map.put(sum,i);
            }
        }

        return length;
    }

    // ------------------------------------------------------------
    // Main Method (Test Code)
    // ------------------------------------------------------------
    public static void main(String[] args){
        String[][] tickets={{"Chennai","Bengaluru"},{"Mumbai","Delhi"},{"Goa","Chennai"},{"Delhi","Goa"}};
        int[] arr={-31 ,-48, -90, 54, 20, 95, 6, -86 ,22};
        
        System.out.println(largestSubarrayWithSumZero(arr));
    }
}
