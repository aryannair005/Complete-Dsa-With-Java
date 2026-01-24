import java.util.HashMap;
import java.util.Set;

/*
 * Topic: Hashing (Data Structures & Algorithms)
 *
 * This file contains problems solved using HashMap.
 *
 * Problems Covered:
 * 1. Majority Element (n/3)
 * 2. Valid Anagram
 *
 * Purpose:
 * - Practice frequency counting using HashMap
 * - Learn string and array based hashing problems
 *
 * Language: Java
 * Author: Aryan Nair
 */

public class Hashing{

    // ------------------------------------------------------------
    // Q1. Majority Element (Elements appearing more than n/3 times)
    //
    // About:
    // Finds all elements in the array that appear more than ⌊n/3⌋ times
    // using frequency counting with HashMap.
    //
    // Time Complexity: O(n)
    // Space Complexity: O(n)
    // ------------------------------------------------------------
    public static void majorityElement(int[] nums){
        HashMap<Integer,Integer> map=new HashMap<>();
        int n=nums.length;

        for(int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i])){
                int value=map.get(nums[i]);
                map.put(nums[i],value+1);
            }else{
                map.put(nums[i],1);
            }
        }

        Set<Integer> keys=map.keySet();
        for(Integer k: keys){
            if(map.get(k) > n/3){
                System.out.println(k);
            }
        }
    }

    // ------------------------------------------------------------
    // Q2. Valid Anagram
    //
    // About:
    // Checks whether two strings are anagrams of each other.
    // Uses HashMap to count character frequencies.
    //
    // Time Complexity: O(n)
    // Space Complexity: O(n)
    // ------------------------------------------------------------
    public static boolean validAnagram(String s,String n){
        HashMap<Character,Integer> map=new HashMap<>();

        if(s.length() != n.length()){
            return false;
        }

        // Count frequency of characters in string s
        for(int i=0;i<s.length();i++){
            if(map.containsKey(s.charAt(i))){
                int value=map.get(s.charAt(i));
                map.put(s.charAt(i),value+1);
            }else{
                map.put(s.charAt(i),1);
            }
        }

        // Reduce frequency using characters from string n
        for(int i=0;i<n.length();i++){
            if(!map.containsKey(n.charAt(i))){
                return false;
            }else{
                int value=map.get(n.charAt(i))-1;
                if(value == 0){
                    map.remove(n.charAt(i));
                }else{
                    map.put(n.charAt(i),value);
                }
            }
        }

        return map.isEmpty();
    }

    // ------------------------------------------------------------
    // Main Method (Test Code)
    // ------------------------------------------------------------
    public static void main(String[] args){
        String s="raae";
        String n="care";
        System.out.println(validAnagram(s,n));
    }
}
