/*
 * Topic: Binary Search Tree (Data Structures & Algorithms)
 *
 * This file contains implementation of a Binary Search Tree (BST)
 * along with commonly asked BST operations.
 *
 * Purpose:
 * - Learn BST insertion, deletion, and search
 * - Practice BST-based interview questions
 * - Revision for DSA
 *
 * Language: Java
 * Author: Aryan Nair
 */

import java.util.*;

public class BST{

    // ============================================================
    // Node Structure for BST
    // ============================================================
    static class Node{
        int data;
        Node left;
        Node right;

        public Node(int data){
            this.data=data;
            this.left=null;
            this.right=null;
        }
    }

    // ------------------------------------------------------------
    // Q1. Insert a Node in BST
    //
    // About:
    // Inserts a value into the BST following BST rules.
    //
    // Time Complexity: O(h)  (h = height of tree)
    // ------------------------------------------------------------
    public static Node insert(Node root,int value){
        if(root == null){
            root=new Node(value);
            return root;
        }

        if(root.data > value){
            root.left=insert(root.left,value);
        }
        if(root.data < value){
            root.right=insert(root.right,value);
        }
        return root;
    }

    // ------------------------------------------------------------
    // Q2. Search in BST
    //
    // About:
    // Searches for a key in the BST.
    //
    // Time Complexity: O(h)
    // ------------------------------------------------------------
    public static boolean search(Node root,int key){
        if(root == null){
            return false;
        }
        if(root.data == key){
            return true;
        }
        if(root.data > key){
            return search(root.left,key);
        }else{
           return search(root.right,key);
        }
    }

    // ------------------------------------------------------------
    // Q3. Delete a Node from BST
    //
    // About:
    // Deletes a node handling:
    // 1. Leaf node
    // 2. One child
    // 3. Two children (using inorder successor)
    //
    // Time Complexity: O(h)
    // ------------------------------------------------------------
    public static Node delete(Node root,int val){
        if(root == null){
            return null;
        }
        if(root.data < val){
            root.right=delete(root.right,val);

        }else if(root.data > val){
            root.left=delete(root.left,val);
        }else {
            //Voila

            //Case 1: leaf node
            if(root.left == null && root.right == null){
                return null;
            }
            
            //Case 2: single child
            if(root.right == null){
                return root.left;
            }
            if(root.left == null){
                return root.right;
            }
            
            //Case 3: both children
            Node IS=findInorderSuccessor(root.right);
            root.data=IS.data;
            root.right=delete(root.right,IS.data);
        }
        return root;
    }

    // ------------------------------------------------------------
    // Helper: Find Inorder Successor
    //
    // Time Complexity: O(h)
    // ------------------------------------------------------------
    public static Node findInorderSuccessor(Node root){
        while(root.left != null){
            root=root.left;
        }
        return root;
    }

    // ------------------------------------------------------------
    // Q4. Print BST Nodes in a Given Range [k1, k2]
    //
    // About:
    // Prints all nodes whose values lie in the given range.
    //
    // Time Complexity: O(n)
    // ------------------------------------------------------------
    public static void printInRange(Node root,int k1,int k2){
        if(root == null){
            return;
        }
        if(root.data >= k1 && root.data <=k2){
            printInRange(root.left,k1,k2);
            System.out.print(root.data +" ");
            printInRange(root.right,k1,k2);
        }else if(root.data < k1){
            printInRange(root.right,k1,k2);
        }else{
            printInRange(root.left,k1,k2);
        }
    }

    // ------------------------------------------------------------
    // Q5. Root-to-Leaf Paths in BST
    //
    // About:
    // Returns all paths from root to leaf nodes.
    //
    // Time Complexity: O(n)
    // ------------------------------------------------------------
    public static ArrayList<ArrayList<Integer>> getPath(Node root){
        ArrayList<ArrayList<Integer>> result=new ArrayList<>();
        helper(root,result,new ArrayList<>());
        return result;
    }

    public static void helper(Node root,ArrayList<ArrayList<Integer>> result,ArrayList<Integer> list){
        if(root == null){
            return;
        }
        list.add(root.data);
        if(root.left == null && root.right == null){
            result.add(new ArrayList<>(list));
        }
        helper(root.left,result,list);
        helper(root.right,result,list);
        list.remove(list.size() -1);
    }

    // ------------------------------------------------------------
    // Q6. Validate BST
    //
    // About:
    // Checks whether a binary tree is a valid BST.
    //
    // Time Complexity: O(n)
    // ------------------------------------------------------------
    public static boolean isValidBST(Node root,Node min,Node max){
        if(root == null){
            return true;
        }
        if(min != null && root.data <= min.data){
            return false;
        }
        if(max != null && root.data >= max.data){
            return false;
        }

        return isValidBST(root.left,min,root) && isValidBST(root.right,root,max);
    }

    // ------------------------------------------------------------
    // Q7. Mirror a BST
    //
    // About:
    // Converts the BST into its mirror image.
    //
    // Time Complexity: O(n)
    // ------------------------------------------------------------
    public static Node mirrorBST(Node root){
        if(root == null){
            return null;
        }
        Node leftMirror=mirrorBST(root.left);
        Node rightMirror=mirrorBST(root.right);

        root.left=rightMirror;
        root.right=leftMirror;

        return root;
    }

    // ------------------------------------------------------------
    // Q8. Inorder Traversal of BST
    //
    // Time Complexity: O(n)
    // ------------------------------------------------------------
    public static void inOrder(Node root){
        if(root == null){
            return;
        }
        inOrder(root.left);
        System.out.print(root.data+" ");
        inOrder(root.right);
    }

    // ------------------------------------------------------------
    // Main Method (Test Code)
    // ------------------------------------------------------------
    public static void main(String[] args){
        int[] values={7,5,10,4,6,2,9,11};
        Node root=null;
        for(int i=0;i<values.length;i++){
            root=insert(root,values[i]);
        }

        inOrder(root);
        System.out.println();
        mirrorBST(root);
        inOrder(root);
    }
}
