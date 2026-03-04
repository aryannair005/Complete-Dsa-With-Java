import java.util.ArrayList;
import java.util.Stack;
import java.util.PriorityQueue;

/*
 * Topic: Graph (Advanced Algorithms)
 *
 * Problems Covered:
 * 1. Topological Sorting (DFS)
 * 2. Print All Paths Between Two Vertices
 * 3. Dijkstra Shortest Path Algorithm
 *
 * Purpose:
 * - Understand Directed Acyclic Graph ordering
 * - Explore all possible paths in a graph
 * - Find shortest path in weighted graphs
 *
 * Language: Java
 * Author: Aryan Nair
 */

public class Graph3{

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
    // Builds a directed weighted graph using adjacency list.
    //
    // Time Complexity: O(V + E)
    // ------------------------------------------------------------
    public static void createGraph(ArrayList<Edge>[] graph){

        for(int i=0;i<graph.length;i++){
            graph[i]=new ArrayList<>();
        }

        graph[0].add(new Edge(0,1,2));
        graph[0].add(new Edge(0,2,4));

        graph[1].add(new Edge(1,3,7));
        graph[2].add(new Edge(2,4,3));

        graph[3].add(new Edge(3,5,1));
        graph[4].add(new Edge(4,5,5));
    }

    // ------------------------------------------------------------
    // Q2. Topological Sorting using DFS
    //
    // About:
    // Topological sorting is used in Directed Acyclic Graphs (DAG)
    // to order vertices such that for every edge u → v,
    // u appears before v in the ordering.
    //
    // Uses DFS and a stack.
    //
    // Time Complexity: O(V + E)
    // Space Complexity: O(V)
    // ------------------------------------------------------------
    public static void topologicalSorting(ArrayList<Edge>[] graph){

        boolean[] visited=new boolean[graph.length];
        Stack<Integer> st=new Stack<>();

        for(int i=0;i<graph.length;i++){
            if(visited[i] != true){
                topologicalSortingUtil(graph,i,visited,st);
            }
        }

        while(st.isEmpty() != true){
            System.out.print(st.pop() +" ");
        }
    }

    // ------------------------------------------------------------
    // Helper Function for Topological Sorting
    //
    // About:
    // Performs DFS traversal and pushes vertex
    // into stack after exploring all neighbours.
    //
    // Time Complexity: O(V + E)
    // ------------------------------------------------------------
    public static void topologicalSortingUtil(ArrayList<Edge>[] graph,int curr,boolean[] visited,Stack<Integer> st){

        visited[curr]=true;

        for(int i=0;i<graph[curr].size();i++){
            Edge e=graph[curr].get(i);

            if(visited[e.dest] != true){
                topologicalSortingUtil(graph,e.dest,visited,st);
            }
        }

        st.push(curr);
    }

    // ------------------------------------------------------------
    // Q3. Print All Paths from Source to Destination
    //
    // About:
    // Uses DFS to explore every possible path
    // between source and destination vertices.
    //
    // Time Complexity: O(V^V) (Worst Case)
    // ------------------------------------------------------------
    public static void allPaths(ArrayList<Edge>[] graph,int src,int dest,String path){

        if(src == dest){
            path+=dest;
            System.out.println(path);
            return;
        }

        for(int i=0;i<graph[src].size();i++){
            Edge e=graph[src].get(i);
            allPaths(graph,e.dest,dest,path+src+" ");
        }
    }

    // ------------------------------------------------------------
    // Helper Class for Dijkstra Algorithm
    // ------------------------------------------------------------
    static class Path implements Comparable<Path>{

        int vertex;
        int cost;

        public Path(int vertex,int cost){
            this.vertex=vertex;
            this.cost=cost;
        }

        public int compareTo(Path p2){
            return this.cost-p2.cost;
        }
    }

    // ------------------------------------------------------------
    // Q4. Dijkstra Algorithm (Shortest Path)
    //
    // About:
    // Finds the shortest distance from a source
    // vertex to all other vertices in a weighted graph.
    //
    // Uses a Priority Queue (Min Heap).
    //
    // Works only for graphs with non-negative weights.
    //
    // Time Complexity: O(E log V)
    // Space Complexity: O(V)
    // ------------------------------------------------------------
    public static void dijkstra(ArrayList<Edge>[] graph,int src){

        int[] dist=new int[graph.length];
        boolean[] visited=new boolean[graph.length];

        for(int i=0;i<dist.length;i++){
            if(i != src){
                dist[i]=Integer.MAX_VALUE;
            }
        }

        PriorityQueue<Path> pq=new PriorityQueue<>();
        pq.add(new Path(src,0));

        while(pq.isEmpty() != true){

            Path curr=pq.remove();

            if(visited[curr.vertex] != true){

                visited[curr.vertex]=true;

                for(int i=0;i<graph[curr.vertex].size();i++){

                    Edge e=graph[curr.vertex].get(i);

                    int u=e.src;
                    int v=e.dest;

                    if(dist[u]+e.wt < dist[v]){

                        dist[v]=dist[u]+e.wt;
                        pq.add(new Path(v,dist[v]));
                    }
                }
            }
        }

        for(int i=0;i<dist.length;i++){
            System.out.print(dist[i]+" ");
        }
    }

    // ------------------------------------------------------------
    // Main Method (Test Code)
    // ------------------------------------------------------------
    public static void main(String[] args){

        int V=6;
        ArrayList<Edge>[] graph=new ArrayList[V];

        createGraph(graph);

        System.out.print("Topological : ");
        topologicalSorting(graph);

        System.out.println("\nAll Paths 0 → 5");
        allPaths(graph,0,5,"");

        System.out.print("Dijkstra : ");
        dijkstra(graph,0);
    }
}