import java.util.ArrayList;
import java.util.Queue;
import java.util.ArrayDeque;

/*
 * Topic: Graph (Data Structures & Algorithms)
 *
 * This file contains basic graph representation
 * using Adjacency List and common graph traversals.
 *
 * Problems Covered:
 * 1. Graph Creation (Adjacency List)
 * 2. Breadth First Search (BFS)
 * 3. Depth First Search (DFS)
 * 4. Check Path Between Two Vertices
 *
 * Purpose:
 * - Understand graph representation
 * - Learn BFS and DFS traversal
 * - Practice basic graph problems
 *
 * Language: Java
 * Author: Aryan Nair
 */

public class GraphBasics{

    // ============================================================
    // Edge Structure
    // ============================================================
    static class Edge{
        int src;
        int dest;
        int wt;

        public Edge(int src,int dest,int wt){
            this.src=src;
            this.dest=dest;
            this.wt=wt;
        }
    }

    // ------------------------------------------------------------
    // Q1. Create Graph using Adjacency List
    //
    // About:
    // Creates an undirected graph using adjacency list.
    // Each index represents a vertex and stores its edges.
    //
    // Time Complexity: O(V + E)
    // ------------------------------------------------------------
    public static void createGraph(ArrayList<Edge>[] graph){
        for(int i=0;i<graph.length;i++){
            graph[i]=new ArrayList<>();
        }

        // Vertex 0 
        graph[0].add(new Edge(0,1,1));
        graph[0].add(new Edge(0,2,1));

        // Vertex 1
        graph[1].add(new Edge(1,0,1));
        graph[1].add(new Edge(1,3,1));

        // Vertex 2
        graph[2].add(new Edge(2,0,1));
        graph[2].add(new Edge(2,4,1));

        // Vertex 3
        graph[3].add(new Edge(3,1,1));
        graph[3].add(new Edge(3,4,1));
        graph[3].add(new Edge(3,5,1));

        // Vertex 4
        graph[4].add(new Edge(4,2,1));
        graph[4].add(new Edge(4,3,1));
        graph[4].add(new Edge(4,5,1));

        // Vertex 5
        graph[5].add(new Edge(5,3,1));
        graph[5].add(new Edge(5,4,1));
        graph[5].add(new Edge(5,6,1));

        // Vertex 6
        graph[6].add(new Edge(6,5,1)); 
    }

    // ------------------------------------------------------------
    // Q2. Breadth First Search (BFS)
    //
    // About:
    // Traverses the graph level by level using Queue.
    //
    // Time Complexity: O(V + E)
    // Space Complexity: O(V)
    // ------------------------------------------------------------
    public static void bfs(ArrayList<Edge>[] graph){
        Queue<Integer> q=new ArrayDeque<>();
        boolean[] vis=new boolean[graph.length];

        q.add(0);
        vis[0]=true;

        while(q.isEmpty() != true){
            int curr=q.remove();
            System.out.print(curr+" ");

            for(int i=0;i<graph[curr].size();i++){
                Edge e=graph[curr].get(i);
                if(vis[e.dest] != true){
                    q.add(e.dest);
                    vis[e.dest]=true;
                }
            }
        }   
    }

    // ------------------------------------------------------------
    // Q3. Depth First Search (DFS)
    //
    // About:
    // Traverses the graph depth-wise using recursion.
    //
    // Time Complexity: O(V + E)
    // Space Complexity: O(V) (recursion stack)
    // ------------------------------------------------------------
    public static void dfs(ArrayList<Edge>[] graph,int curr,boolean[] vis){
        System.out.print(curr+" ");
        vis[curr]=true;

        for(int i=0;i<graph[curr].size();i++){
            Edge e=graph[curr].get(i);
            if(vis[e.dest] != true){
                dfs(graph,e.dest,vis);
            }
        }
    }

    // ------------------------------------------------------------
    // Q4. Check if Path Exists Between Two Vertices
    //
    // About:
    // Uses DFS to check whether a path exists
    // between source and destination vertices.
    //
    // Time Complexity: O(V + E)
    // Space Complexity: O(V)
    // ------------------------------------------------------------
    public static boolean hasPath(ArrayList<Edge>[] graph,int src,int des,boolean[] vis){
        if(src == des){
            return true;
        }

        vis[src]=true;

        for(int i=0;i<graph[src].size();i++){
            Edge e=graph[src].get(i);
            if(vis[e.dest] != true && hasPath(graph,e.dest,des,vis)){
                return true;
            }
        }
        return false;
    }

    // ------------------------------------------------------------
    // Main Method (Test Code)
    // ------------------------------------------------------------
    public static void main(String[] args){
        int V=7;
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph=new ArrayList[V];

        createGraph(graph);

        System.out.println(hasPath(graph,0,6,new boolean[V]));
    }
}
