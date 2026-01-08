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
    }

    // ------------------------------------------------------------
    // Main Method (Test Code)
    // ------------------------------------------------------------
    public static void main(String[] args){
        int[] nodes={1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        BinaryTree tree=new BinaryTree(); 
        Node root=tree.buildTree(nodes);

        System.out.println(tree.sum(root));
    }
}