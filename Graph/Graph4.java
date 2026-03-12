import java.util.ArrayList;
import java.util.PriorityQueue;

/*
 * Topic: Graph (Shortest Path & Minimum Spanning Tree)
 *
 * Problems Covered:
 * 1. Bellman Ford Algorithm
 * 2. Bellman Ford using Edge List
 * 3. Prim's Algorithm (Minimum Spanning Tree)
 *
 * Purpose:
 * - Handle graphs with negative edge weights
 * - Understand edge relaxation technique
 * - Build Minimum Spanning Tree using greedy approach
 *
 * Language: Java
 * Author: Aryan Nair
 */

public class Graph4{

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
    // Builds an undirected weighted graph.
    //
    // Time Complexity: O(V + E)
    // ------------------------------------------------------------
    public static void createGraph(ArrayList<Edge>[] graph){
        for(int i=0;i<graph.length;i++){
            graph[i]=new ArrayList<>();
        }

        // Vertex 0
        graph[0].add(new Edge(0,1,10));
        graph[0].add(new Edge(0,2,15));
        graph[0].add(new Edge(0,3,30));

        // Vertex 1
        graph[1].add(new Edge(1,0,10));
        graph[1].add(new Edge(1,3,40));

        // Vertex 2
        graph[2].add(new Edge(2,0,15));
        graph[2].add(new Edge(2,3,50));

        // Vertex 3
        graph[3].add(new Edge(3,0,30));
        graph[3].add(new Edge(3,1,40));
        graph[3].add(new Edge(3,2,50));
    }

    // ------------------------------------------------------------
    // Q2. Create Graph using Edge List
    //
    // About:
    // Stores graph as list of edges instead of adjacency list.
    // Useful for Bellman-Ford algorithm.
    //
    // Time Complexity: O(E)
    // ------------------------------------------------------------
    public static void createGraphUsingEdges(ArrayList<Edge> graph){

        graph.add(new Edge(0,1,2));
        graph.add(new Edge(0,2,4));

        graph.add(new Edge(1,2,-4));

        graph.add(new Edge(2,3,2));

        graph.add(new Edge(3,4,4));

        graph.add(new Edge(4,1,-1));
    }

    // ------------------------------------------------------------
    // Q3. Bellman Ford Algorithm
    //
    // About:
    // Finds shortest path from a source vertex
    // in graphs that may contain negative weights.
    //
    // Uses edge relaxation technique.
    //
    // Time Complexity: O(V * E)
    // Space Complexity: O(V)
    // ------------------------------------------------------------
    public static void bellmanFord(ArrayList<Edge>[] graph,int src){

        int[] dist=new int[graph.length];

        for(int i=0;i<dist.length;i++){
            if(i != src){
                dist[i]=Integer.MAX_VALUE;
            }
        }

        for(int k=0;k<graph.length-1;k++){

            for(int i=0;i<graph.length;i++){

                for(int j=0;j<graph[i].size();j++){

                    Edge e=graph[i].get(j);

                    int u=e.src;
                    int v=e.dest;
                    int wt=e.wt;

                    if(dist[u] != Integer.MAX_VALUE && dist[u] + wt < dist[v]){
                        dist[v]=dist[u]+wt;
                    }
                }
            }
        }

        for(int i=0;i<dist.length;i++){
            System.out.print(dist[i] +" ");
        }
    }

    // ------------------------------------------------------------
    // Q4. Bellman Ford using Edge List
    //
    // About:
    // Uses edge list representation instead of adjacency list.
    //
    // Time Complexity: O(V * E)
    // ------------------------------------------------------------
    public static void bellmanFordUsingEdges(ArrayList<Edge> graph,int src,int V){

        int[] dist=new int[V];

        for(int i=0;i<dist.length;i++){
            if(i != src){
                dist[i]=Integer.MAX_VALUE;
            }
        }

        for(int k=0;k<V-1;k++){

            for(int j=0;j<graph.size();j++){

                Edge e=graph.get(j);

                int u=e.src;
                int v=e.dest;
                int wt=e.wt;

                if(dist[u] != Integer.MAX_VALUE && dist[u] + wt < dist[v]){
                    dist[v]=dist[u]+wt;
                }
            }
        }

        for(int i=0;i<dist.length;i++){
            System.out.print(dist[i] +" ");
        }
    }

    // ------------------------------------------------------------
    // Helper Class for Prim's Algorithm
    // ------------------------------------------------------------
    static class Pair implements Comparable<Pair>{

        int vertex;
        int cost;

        public Pair(int vertex,int cost){
            this.vertex=vertex;
            this.cost=cost;
        }

        @Override
        public int compareTo(Pair p2){
            return this.cost-p2.cost;
        }
    }

    // ------------------------------------------------------------
    // Q5. Prim's Algorithm (Minimum Spanning Tree)
    //
    // About:
    // Finds Minimum Spanning Tree of a weighted graph.
    // Uses greedy approach with Priority Queue.
    //
    // Time Complexity: O(E log V)
    // Space Complexity: O(V)
    // ------------------------------------------------------------
    public static int primsAlgorithm(ArrayList<Edge>[] graph){
        boolean[] visited=new boolean[graph.length];
        PriorityQueue<Pair> pq=new PriorityQueue<>();
        int totalCost=0;

        pq.add(new Pair(0,0));

        while(pq.isEmpty() != true){
            Pair curr=pq.remove();

            if(visited[curr.vertex] != true){
                visited[curr.vertex] = true;
                totalCost+=curr.cost;

                for(int i=0;i<graph[curr.vertex].size();i++){
                    Edge e=graph[curr.vertex].get(i);
                    pq.add(new Pair(e.dest,e.wt));
                }
            }
        }

        return totalCost;
    }

    // ------------------------------------------------------------
    // Main Method (Test Code)
    // ------------------------------------------------------------
    public static void main(String[] args){

        int V=4;

        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph=new ArrayList[V];

        createGraph(graph);

        System.out.println(primsAlgorithm(graph));
    }
}