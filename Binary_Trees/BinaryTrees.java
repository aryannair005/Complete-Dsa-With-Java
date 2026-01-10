/*
 * Topic: Binary Trees (Data Structures & Algorithms)
 *
 * This file contains basic Binary Tree implementation
 * and commonly used Binary Tree operations.
 *
 * Purpose:
 * - Learn Binary Tree construction
 * - Understand tree traversals
 * - Practice fundamental tree problems
 *
 * Language: Java
 * Author: Aryan Nair
 */

import java.util.Queue;
import java.util.LinkedList;
import java.util.HashMap;

public class BinaryTreesBasics{

    // ============================================================
    // Node Structure for Binary Tree
    // ============================================================
    public static class Node{
        int data;
        Node left;
        Node right;
        
        public Node(int data){
            this.data=data;
            this.left=null;
            this.right=null;
        }
    }

    // ============================================================
    // Binary Tree Implementation
    // ============================================================
    public static class BinaryTree{
        static int idx=-1;

        // ------------------------------------------------------------
        // Q1. Build Binary Tree from Preorder Array
        //
        // About:
        // Builds a binary tree using preorder traversal array
        // where -1 represents a null node.
        //
        // Time Complexity: O(n)
        // ------------------------------------------------------------
        public static Node buildTree(int[] nodes){
            idx++;
            if(nodes[idx] == -1){
                return null;
            }

            Node newNode=new Node(nodes[idx]);
            newNode.left=buildTree(nodes);
            newNode.right=buildTree(nodes);

            return newNode;
        }

        // ------------------------------------------------------------
        // Q2. Preorder Traversal (Root → Left → Right)
        //
        // Time Complexity: O(n)
        // ------------------------------------------------------------
        public static void preOrder(Node root){
            if(root == null){
                System.out.print("-1" + " ");
                return;
            }
            System.out.print(root.data+" ");
            preOrder(root.left);
            preOrder(root.right);
        }

        // ------------------------------------------------------------
        // Q3. Postorder Traversal (Left → Right → Root)
        //
        // Time Complexity: O(n)
        // ------------------------------------------------------------
        public static void postOrder(Node root){
            if(root == null){
                System.out.print("-1" +" ");
                return;
            }
            postOrder(root.left);
            postOrder(root.right);
            System.out.print(root.data+" ");
        }

        // ------------------------------------------------------------
        // Q4. Inorder Traversal (Left → Root → Right)
        //
        // Time Complexity: O(n)
        // ------------------------------------------------------------
        public static void inOrder(Node root){
            if(root == null){
                System.out.print("-1" +" ");
                return;
            }
            inOrder(root.left);
            System.out.print(root.data+" ");
            inOrder(root.right);
        }

        // ------------------------------------------------------------
        // Q5. Level Order Traversal (Breadth First Search)
        //
        // About:
        // Traverses tree level by level using Queue
        //
        // Time Complexity: O(n)
        // Space Complexity: O(n)
        // ------------------------------------------------------------
        public static void levelOrder(Node root){
            if(root == null){
                System.out.println("Root Node is null.");
                return;
            }
            Queue<Node> q=new LinkedList<>();
            q.add(root);
            q.add(null);

            while(q.isEmpty() != true){
                Node currNode=q.remove();
                if(currNode == null){
                    System.out.println();
                    if(q.isEmpty()){
                        break;
                    }else{
                        q.add(null);
                    }
                }else{
                    System.out.print(currNode.data+ " ");
                    if(currNode.left != null){
                        q.add(currNode.left);
                    }
                    if(currNode.right != null){
                        q.add(currNode.right);
                    }
                }
            }
        }

        // ------------------------------------------------------------
        // Q6. Height of Binary Tree
        //
        // About:
        // Finds the maximum depth of the tree
        //
        // Time Complexity: O(n)
        // ------------------------------------------------------------
        public static int height(Node root){
            if(root == null){
                return 0;
            }
            int lh=height(root.left);
            int rh=height(root.right);

            int height=Math.max(lh,rh)+1;
            return height;
        }

        // ------------------------------------------------------------
        // Q7. Count Total Nodes in Binary Tree
        //
        // Time Complexity: O(n)
        // ------------------------------------------------------------
        public static int count(Node root){
            if(root == null){
                return 0;
            }
            int leftCount=count(root.left);
            int rightCount=count(root.right);

            return leftCount+rightCount+1;
        }

        // ------------------------------------------------------------
        // Q8. Sum of All Nodes in Binary Tree
        //
        // Time Complexity: O(n)
        // ------------------------------------------------------------
        public static int sum(Node root){
            if(root == null){
                return 0;
            }
            int leftSum=sum(root.left);
            int rightSum=sum(root.right);

            return leftSum+rightSum+root.data;
        }

        // ------------------------------------------------------------
        // Q9. Diameter of Binary Tree (Naive Approach)
        //
        // About:
        // Diameter = Longest path between any two nodes.
        // Uses height calculation repeatedly.
        //
        // Time Complexity: O(n^2)
        // ------------------------------------------------------------
        public static int diameterOfTree(Node root){
            if(root == null){
                return 0;
            }
            int leftDiam=diameterOfTree(root.left);
            int leftHt=height(root.left);
            int rightDiam=diameterOfTree(root.right);
            int rightHt=height(root.right);

            int selfDiam=leftHt+rightHt+1;
            return Math.max(selfDiam,Math.max(leftDiam,rightDiam));
        }

        // ------------------------------------------------------------
        // Helper Class for Optimized Diameter
        // ------------------------------------------------------------
        static class Info{
            int diam;
            int h;

            public Info(int diam,int h){
                this.diam=diam;
                this.h=h;
            }
        }

        // ------------------------------------------------------------
        // Q10. Diameter of Binary Tree (Optimized)
        //
        // About:
        // Computes diameter and height in a single traversal.
        //
        // Time Complexity: O(n)
        // ------------------------------------------------------------
        public static Info diameter(Node root){
            if(root == null){
                return new Info(0,0);
            }

            Info leftInfo=diameter(root.left);
            Info rightInfo=diameter(root.right);

            int finalDiameter=Math.max(
                Math.max(leftInfo.diam,rightInfo.diam),
                leftInfo.h + rightInfo.h + 1
            );

            int FinalHeight=Math.max(leftInfo.h,rightInfo.h)+1;

            return new Info(finalDiameter,FinalHeight);
        }

        // ------------------------------------------------------------
        // Q11. Check if Two Trees are Identical
        //
        // Time Complexity: O(n)
        // ------------------------------------------------------------
        public static boolean isIdentical(Node node,Node subroot){
            if(node == null && subroot == null){
                return true;
            }else if(node == null || subroot == null || node.data != subroot.data){
                return false;
            }
            if(isIdentical(node.left,subroot.left) != true){
                return false;
            }
            if(isIdentical(node.right,subroot.right) != true){
                return false;
            }
            return true;
        }

        // ------------------------------------------------------------
        // Q12. Check if a Tree is Subtree of Another
        //
        // Time Complexity: O(n * m)
        // ------------------------------------------------------------
        public static boolean isSubtree(Node root,Node subroot){
            if(root == null ){
                return false;
            }

            if(root.data == subroot.data){
                if(isIdentical(root,subroot)){
                    return true;
                }
            }

            return isSubtree(root.left,subroot) || isSubtree(root.right,subroot);
        }

        // ------------------------------------------------------------
        // Helper Class for Top View
        // ------------------------------------------------------------
        public static class Info2{
            Node node;
            int hd;

            public Info2(Node node,int hd){
                this.node=node;
                this.hd=hd;
            }
        }

        // ------------------------------------------------------------
        // Q13. Top View of Binary Tree
        //
        // About:
        // Prints nodes visible from the top using
        // horizontal distance and level order traversal.
        //
        // Time Complexity: O(n)
        // Space Complexity: O(n)
        // ------------------------------------------------------------
        public static void topView(Node root){
            Queue<Info2> q=new LinkedList<>();
            HashMap<Integer,Node> map=new HashMap<>();

            q.add(new Info2(root,0));
            q.add(null);

            int min=0,max=0;

            while(q.isEmpty() != true){
                Info2 curr=q.remove();
                if(curr == null){
                    if(q.isEmpty()){
                        break;
                    }else{
                        q.add(null);
                    }
                }else{
                    if(!map.containsKey(curr.hd)){
                        map.put(curr.hd,curr.node);
                    }
                    if(curr.node.left != null){
                        q.add(new Info2(curr.node.left,curr.hd-1));
                        min=Math.min(curr.hd-1,min);
                    }
                    if(curr.node.right != null){
                        q.add(new Info2(curr.node.right,curr.hd+1));
                        max=Math.max(max,curr.hd+1);
                    }
                }
            }
            for(int i=min;i<=max;i++){
                System.out.print(map.get(i).data+" ");
            }
            System.out.println();
        }
    }   

    // ------------------------------------------------------------
    // Main Method (Test Code)
    // ------------------------------------------------------------
    public static void main(String[] args){
        int[] nodes={1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        BinaryTree tree=new BinaryTree(); 
        Node root=tree.buildTree(nodes);

        tree.topView(root);
    }
}