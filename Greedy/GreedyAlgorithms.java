/*
 * Topic: Greedy Algorithms (Data Structures & Algorithms)
 *
 * This file contains classic greedy algorithm problems
 * frequently asked in interviews and exams.
 *
 * Greedy Strategy:
 * - At each step, make the locally optimal choice
 * - Hope that it leads to a globally optimal solution
 *
 * Language: Java
 * Author: Aryan Nair
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Collections;

public class GreedyAlgorithm{

    // ============================================================
    // Q1. Activity Selection Problem (End Time Sorted)
    //
    // About:
    // Select the maximum number of non-overlapping activities
    // assuming activities are already sorted by end time.
    //
    // Time Complexity: O(n)
    // ============================================================
    public static int maxActivityEndSorted(int[] start,int[] end){
        ArrayList<Integer> list=new ArrayList<>();
        int maxActivity=1;
        list.add(0);
        int lastEnd=end[0];

        for(int i=1;i<start.length;i++){
            if(start[i] >= lastEnd){
                maxActivity++;
                list.add(i);
                lastEnd=end[i];
            }
        }
        System.out.println(list);
        return maxActivity;
    }

    // ============================================================
    // Q2. Activity Selection Problem (End Time Not Sorted)
    //
    // About:
    // Same problem as above, but activities are not sorted.
    // Sorting is done based on end time.
    //
    // Time Complexity: O(n log n)
    // ============================================================
    public static int maxActivityEndNotSorted(int[] start,int[] end){
        ArrayList<Integer> list=new ArrayList<>();
        int maxActivity=1;
        int[][] activity=new int[start.length][3];

        for(int i=0;i<start.length;i++){
            activity[i][0]=i;
            activity[i][1]=start[i];
            activity[i][2]=end[i];
        }
        Arrays.sort(activity,Comparator.comparingDouble(o->o[2]));

        list.add(activity[0][0]);
        int lastEnd=activity[0][2];

        for(int i=1;i<start.length;i++){
            if(activity[i][1] >= lastEnd){
                maxActivity++;
                list.add(activity[i][0]);
                lastEnd=activity[i][2];
            }
        }
        System.out.println(list);
        return maxActivity;
    }

    // ============================================================
    // Q3. Activity Selection (GFG Version)
    //
    // About:
    // Same as activity selection but uses strict condition
    // (start > lastEnd)
    //
    // Time Complexity: O(n log n)
    // ============================================================
    public static int maxActivityGfg(int[] start,int[] end){
        ArrayList<Integer> list=new ArrayList<>();
        int maxActivity=1;
        int[][] activity=new int[start.length][3];

        for(int i=0;i<start.length;i++){
            activity[i][0]=i;
            activity[i][1]=start[i];
            activity[i][2]=end[i];
        }
        Arrays.sort(activity,Comparator.comparingDouble(o->o[2]));

        list.add(activity[0][0]);
        int lastEnd=activity[0][2];

        for(int i=1;i<start.length;i++){
            if(activity[i][1] > lastEnd){
                maxActivity++;
                list.add(activity[i][0]);
                lastEnd=activity[i][2];
            }
        }
        System.out.println(list);
        return maxActivity;
    }

    // ============================================================
    // Q4. Fractional Knapsack (Greedy using Ratio)
    //
    // About:
    // Maximize value by picking items based on value/weight ratio.
    // Items can be taken fractionally.
    //
    // Time Complexity: O(n log n)
    // ============================================================
    public static double knapsackProblemByGreedy(int[] value,int[] weight,int totolCapacity){
        double[] ratio=new double[value.length];
        for(int i=0;i<ratio.length;i++){
            ratio[i]=(double)value[i]/weight[i];
        }
        double maxValue=0;
        int remainingCapacity=totolCapacity;
        double[][] knapsack=new double[value.length][3];

        for(int i=0;i<value.length;i++){
            knapsack[i][0]=ratio[i];
            knapsack[i][1]=value[i];
            knapsack[i][2]=weight[i];
        }
        Arrays.sort(knapsack,Comparator.comparingDouble((double[] o)->o[0]).reversed());

        for(int i=0;i<value.length;i++){
            if(remainingCapacity>0){
                if(knapsack[i][2] <= remainingCapacity){
                    maxValue+=knapsack[i][1];
                    remainingCapacity-=knapsack[i][2];
                }else{
                    double valueWeightRatio=remainingCapacity*knapsack[i][0];
                    maxValue+=valueWeightRatio;
                    remainingCapacity=0;
                }
            }else{
                break;
            }
        }
        return maxValue;
    }

    // ============================================================
    // Q5. Fractional Knapsack (Alternative Implementation)
    //
    // Time Complexity: O(n log n)
    // ============================================================
    public static double knapsackProblem(int[] value,int[] weight,int W){
        double[][] ratio=new double[value.length][2];
        for(int i=0;i<ratio.length;i++){
            ratio[i][0]=i;
            ratio[i][1]=(double)value[i]/weight[i];
        }

        Arrays.sort(ratio,Comparator.comparingDouble(o->o[1]));
        int capacity=W;
        double totalValue=0;

        for(int i=ratio.length-1;i>=0;i--){
            int currIdx=(int)ratio[i][0];
            if(capacity >= weight[currIdx]){
                totalValue+=value[currIdx];
                capacity-=weight[currIdx];
            }else{
                totalValue+=(capacity*ratio[i][1]);
                break;
            }
        }
        return totalValue;
    }

    // ============================================================
    // Q6. Minimum Absolute Difference Pair
    //
    // About:
    // Minimize sum of absolute differences between two arrays.
    //
    // Time Complexity: O(n log n)
    // ============================================================
    public static int minAbsoluteDiffPair(int[] A,int[] B){
        Arrays.sort(A);
        Arrays.sort(B);
        int sum=0;

        for(int i=0;i<A.length;i++){
            int diff=Math.abs(A[i]-B[i]);
            sum+=diff;
        }
        return sum;
    }

    // ============================================================
    // Q7. Maximum Length Chain of Pairs
    //
    // Time Complexity: O(n log n)
    // ============================================================
    public static int maximumLengthChainOfPair(int[][] pairs){
        int ans=1;
        Arrays.sort(pairs,Comparator.comparingDouble(o->o[1]));
        int lastEnd=pairs[0][1];

        for(int i=1;i<pairs.length;i++){
            if(pairs[i][0] > lastEnd){
                ans++;
                lastEnd=pairs[i][1];
            }
        }
        return ans;
    }

    // ============================================================
    // Q8. Minimum Coins Problem
    //
    // About:
    // Find minimum number of coins to make a given value.
    //
    // Time Complexity: O(n)
    // ============================================================
    public static int minCoins(int[] arr,int n){
        int ans=0;

        int i=0;
        while(i<arr.length && n>0){
            if(arr[i] <= n){
                ans++;
                n-=arr[i];
            }else{
                i++;
            }
        }
        return ans;
    }

    // ============================================================
    // Q9. Job Sequencing Problem
    //
    // About:
    // Maximize profit with deadlines using greedy strategy.
    //
    // Time Complexity: O(n log n)
    // ============================================================
    public static class Job{
        int profit;
        int deadline;
        int idx;

        public Job(int p,int d,int i){
            profit=p;
            deadline=d;
            idx=i;
        }
    }

    public static int jobSequenceProblem(int[][] jobSequence){
        ArrayList<Job> jobs=new ArrayList<>();
        for(int i=0;i<jobSequence.length;i++){
            jobs.add(new Job(jobSequence[i][1],jobSequence[i][0],i));
        }
        Collections.sort(jobs,(obj1,obj2)->obj2.profit-obj1.profit);

        ArrayList<Integer> seq=new ArrayList<>();
        int time=0;
        for(int i=0;i<jobs.size();i++){
            Job curr=jobs.get(i);
            if(curr.deadline > time){
                seq.add(curr.idx+1);
                time++;
            }
        }
        System.out.println(seq);
        return time;
    }

    // ============================================================
    // Q10. Chocola Problem
    //
    // About:
    // Minimize cost of breaking chocolate using greedy strategy.
    //
    // Time Complexity: O(n log n)
    // ============================================================
    public static int ChocolaProblem(Integer[] costVer,Integer[] costHor){
        Arrays.sort(costVer,Collections.reverseOrder());
        Arrays.sort(costHor,Collections.reverseOrder());

        int h=0;
        int v=0;
        int hp=1;
        int vp=1;
        int cost=0;

        while(h<costHor.length && v<costVer.length){
            if(costVer[v] <= costHor[h]){
                cost+=(costHor[h]*vp);
                hp++;
                h++;
            }else{
                cost+=(costVer[v]*hp);
                vp++;
                v++;
            }
        }

        while(h<costHor.length){
            cost+=(costHor[h]*vp);
            hp++;
            h++;
        }
        while(v<costVer.length){
            cost+=(costVer[v]*hp);
            vp++;
            v++;
        }

        return cost;
    }
    // ============================================================
// Q11. Capacity To Ship Packages Within D Days
//
// About:
// Given an array where each element represents the weight of a package,
// and an integer 'days', find the minimum ship capacity required to
// ship all packages within the given number of days.
//
// Rules:
// - Packages must be shipped in order
// - Each day, total weight shipped cannot exceed ship capacity
//
// Approach:
// - Use Binary Search on the answer (capacity)
// - Minimum capacity = max weight in array
// - Maximum capacity = sum of all weights
// - For a given capacity, check if shipping is possible within 'days'
//
// Time Complexity: O(n log S)
//   where:
//   n = number of packages
//   S = sum of all package weights
//
// Space Complexity: O(1)
// ============================================================
public static int shipWithDays(int[] weights,int days){
        int allSum=0;
        for(int i=0;i<weights.length;i++){
            allSum+=weights[i];
        }
        int maxValue=0;
        for(int i=0;i<weights.length;i++){
            maxValue=Math.max(maxValue,weights[i]);
        }

        int low=maxValue;
        int high=allSum;
        int ans=-1;

        while(low<=high){
            int mid=low+(high-low)/2;
            if(helper(mid,weights,days)){
                ans=mid;
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return ans;
}

    // ============================================================
    // Helper Method
    //
    // About:
    // Checks whether all packages can be shipped within the given
    // number of days using 'mid' as ship capacity.
    //
    // Time Complexity: O(n)
    // Space Complexity: O(1)
    // ============================================================
    public static boolean helper(int mid,int[] weights,int days){
        int count=1;
        int sum=weights[0];

        for(int i=1;i<weights.length;i++){
            sum+=weights[i];
            if(sum>mid){
                count++;
                sum=weights[i];
            }
        }
        if(count <= days){
            return true;
        }
        return false;
    }

    // ------------------------------------------------------------
    // Main Method (Test Code)
    // ------------------------------------------------------------
    public static void main(String[] args){
        Integer[] costVer={2,1,3,1,4};
        Integer[] costHor={4,1,2};
        System.out.println(ChocolaProblem(costVer,costHor));
    }
}
