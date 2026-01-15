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
import java.util.ArrayList;

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
        // ------------------------------------------------------------
        // Q14. Print Nodes at Kth Level of Binary Tree
        //
        // About:
        // Returns all nodes present at level K (root is level 1).
        // Uses recursive traversal with a level counter.
        //
        // Time Complexity: O(n)
        // Space Complexity: O(n)  (recursion + list)
        // ------------------------------------------------------------
        public static ArrayList kthLevel(Node root,int k){
            ArrayList<Integer> list=new ArrayList<>();
            helper(root,k,1,list);
            return list;
        }

        public static void helper(Node root,int k,int currIdx,ArrayList<Integer> list){
            if(root == null){
                return ;
            }
            if(currIdx == k){
                list.add(root.data);
            }
            helper(root.left,k,currIdx+1,list);
            helper(root.right,k,currIdx+1,list);
        }

        // ------------------------------------------------------------
        // Q15. Find Path from Root to a Given Node
        //
        // About:
        // Stores the path from root to a target node in an ArrayList.
        //
        // Time Complexity: O(n)
        // Space Complexity: O(n)
        // ------------------------------------------------------------
        public static boolean getPath(Node root,int n,ArrayList<Node> path){
            if(root == null){
                return false;
            }
            path.add(root);
            if(root.data == n){
                return true;
            }
            boolean isLeftFound=getPath(root.left,n,path);
            boolean isRightFound=getPath(root.right,n,path);

            if(isLeftFound || isRightFound){
                return true;
            }
            path.remove(path.size()-1);
            return false; 
        }

        // ------------------------------------------------------------
        // Q16. Lowest Common Ancestor (Path Method)
        //
        // About:
        // Finds LCA by storing paths from root to both nodes
        // and comparing them.
        //
        // Time Complexity: O(n)
        // Space Complexity: O(n)
        // ------------------------------------------------------------
        public static Node lowestCommonAncestorApproach1(Node root,int n1,int n2){
            ArrayList<Node> path1=new ArrayList<>();
            ArrayList<Node> path2=new ArrayList<>();

            getPath(root,n1,path1);
            getPath(root,n2,path2);

            int i=0,j=0;
            Node lca=null;

            while(i<path1.size() && j<path2.size()){
                if(path1.get(i) == path2.get(j)){
                    lca=path1.get(i);
                }
                i++;
                j++;
            }

            return lca;
        }

        // ------------------------------------------------------------
        // Q17. Lowest Common Ancestor (Optimized Recursive)
        //
        // About:
        // Finds LCA without extra space using recursion.
        //
        // Time Complexity: O(n)
        // Space Complexity: O(h)
        // ------------------------------------------------------------
        public static Node lowestCommonAncestorApproach2(Node root,int n1,int n2){
            if(root == null || root.data ==n1 || root.data == n2){
                return root;
            }
            Node leftLca=lowestCommonAncestorApproach2(root.left,n1,n2);
            Node rightLca=lowestCommonAncestorApproach2(root.right,n1,n2);

            if(leftLca == null){
                return rightLca;
            }
            if(rightLca == null){
                return leftLca;
            }

            return root;
        }

        // ------------------------------------------------------------
        // Q18. Distance of a Node from Root
        //
        // About:
        // Returns the number of edges between root and a target node.
        //
        // Time Complexity: O(n)
        // ------------------------------------------------------------
        public static int getDistance(Node root,int n){
            if(root == null){
                return -1;
            }
            if(root.data == n){
                return 0;
            }

            int leftDistance=getDistance(root.left,n);
            int rightDistance=getDistance(root.right,n);

            if(leftDistance == -1 && rightDistance == -1){
                return -1;
            }else if(leftDistance == -1){
                return rightDistance+1;
            }else{
                return leftDistance+1;
            }
        }

        // ------------------------------------------------------------
        // Q19. Minimum Distance Between Two Nodes
        //
        // About:
        // Uses LCA + distance calculation.
        //
        // Time Complexity: O(n)
        // ------------------------------------------------------------
        public static int minDistance(Node root,int n1,int n2){
            Node lca= lowestCommonAncestorApproach2(root,n1,n2);
            int distance1=getDistance(lca,n1);
            int distance2=getDistance(lca,n2);

            return distance1+distance2;
        }
        
        // ------------------------------------------------------------
        // Q20. Kth Ancestor of a Node
        //
        // About:
        // Prints the Kth ancestor of a given node.
        //
        // Time Complexity: O(n)
        // ------------------------------------------------------------
        public static int ans=-1;
        public static int kthAncestor2(Node root,int n,int k){
            if(root == null){
                return -1;
            }
            if(root.data == n){
                return 0;
            }
            int leftD=kthAncestor2(root.left,n,k);
            int rightD=kthAncestor2(root.right,n,k);

            if(leftD == -1 && rightD == -1){
                return -1;
            }

            int distance=Math.max(leftD,rightD)+1;
            if(distance == k){
                ans=root.data;
            }
            return distance;
        }

        // ------------------------------------------------------------
        // Q21. Convert to Sum Tree
        //
        // About:
        // Replaces each node value with the sum of its left and right subtrees.
        //
        // Time Complexity: O(n)
        // ------------------------------------------------------------
        public static int sumtree(Node root){
            if(root == null){
                return 0;
            }

            int leftChildSum=sumtree(root.left);
            int rightChildSum=sumtree(root.right);

            int oldData=root.data;
            root.data=leftChildSum+rightChildSum;

            return oldData+root.data;
        }


    // ------------------------------------------------------------
    // Main Method (Test Code)
    // ------------------------------------------------------------
    public static void main(String[] args){
        int[] nodes={1,2,4,-1,-1,5,-1,-1,3,6,-1,-1,7,-1,-1};
        BinaryTree tree=new BinaryTree(); 
        Node root=tree.buildTree(nodes);
        // System.out.println(tree.kthAncestor(root,5,2));
        tree.sumtree(root);
        tree.preOrder(root);
    }
}