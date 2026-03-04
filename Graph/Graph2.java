import java.util.ArrayList;
import java.util.Queue;
import java.util.ArrayDeque;

/*
 * Topic: Graph (Data Structures & Algorithms)
 *
 * Covers:
 * 1. BFS for Disconnected Graph
 * 2. DFS for Disconnected Graph
 * 3. Cycle Detection in Undirected Graph
 * 4. Bipartite Graph Check
 *
 * Purpose:
 * - Handle graphs with multiple components
 * - Detect cycles in undirected graphs
 * - Identify bipartite graphs
 *
 * Language: Java
 * Author: Aryan Nair
 */

public class Graph2{

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
    // Creates an undirected graph where each vertex
    // stores a list of its neighbours.
    //
    // Time Complexity: O(V + E)
    // ------------------------------------------------------------
    public static void createGraph(ArrayList<Edge>[] graph){
        for(int i=0;i<graph.length;i++){
            graph[i]=new ArrayList<>();
        }

        graph[0].add(new Edge(0,1,1));
        graph[1].add(new Edge(1,0,1));

        graph[1].add(new Edge(1,2,1));
        graph[2].add(new Edge(2,1,1));

        graph[2].add(new Edge(2,3,1));
        graph[3].add(new Edge(3,2,1));
    }

    // ------------------------------------------------------------
    // Q2. Breadth First Search for Disconnected Graph
    //
    // About:
    // Performs BFS traversal even when the graph has
    // multiple disconnected components.
    //
    // Time Complexity: O(V + E)
    // Space Complexity: O(V)
    // ------------------------------------------------------------
    public static void BFS(ArrayList<Edge>[] graph){
        boolean[] vis=new boolean[graph.length];

        for(int i=0;i<graph.length;i++){
            if(vis[i] != true){
                bfsUtil(graph,vis,i);
            }
        }
    }

    // ------------------------------------------------------------
    // Helper Function for BFS
    //
    // About:
    // Performs BFS traversal starting from a given vertex.
    //
    // Time Complexity: O(V + E)
    // ------------------------------------------------------------
    public static void bfsUtil(ArrayList<Edge>[] graph,boolean[] vis,int start){
        Queue<Integer> q=new ArrayDeque<>();
        q.add(start);
        vis[start]=true;

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
    // Q3. Detect Cycle in Undirected Graph
    //
    // About:
    // Uses DFS with parent tracking to detect whether
    // a cycle exists in the graph.
    //
    // Time Complexity: O(V + E)
    // Space Complexity: O(V)
    // ------------------------------------------------------------
    public static boolean detectCycle(ArrayList<Edge>[] graph){
        boolean[] vis=new boolean[graph.length];

        for(int i=0;i<graph.length;i++){
            if(vis[i] != true){
                if(detectCycleUtil(graph,vis,i,-1)){
                    return true;
                }
            }
        }
        return false;
    }

    // ------------------------------------------------------------
    // Helper Function for Cycle Detection
    //
    // About:
    // Recursively checks neighbours while tracking parent
    // to avoid false cycle detection.
    //
    // Time Complexity: O(V + E)
    // ------------------------------------------------------------
    public static boolean detectCycleUtil(ArrayList<Edge>[] graph,boolean[] vis,int curr,int parent){
        vis[curr]=true;

        for(int i=0;i<graph[curr].size();i++){
            Edge e=graph[curr].get(i);

            if(vis[e.dest] != true){
                if(detectCycleUtil(graph,vis,e.dest,curr)){
                    return true;
                }
            }
            else if(parent != e.dest){
                return true;
            }
        }
        return false;
    }

    // ------------------------------------------------------------
    // Q4. Check if Graph is Bipartite
    //
    // About:
    // A graph is bipartite if its vertices can be divided
    // into two sets such that no two adjacent vertices
    // belong to the same set.
    //
    // Uses BFS and coloring technique.
    //
    // Time Complexity: O(V + E)
    // Space Complexity: O(V)
    // ------------------------------------------------------------
    public static boolean bipartite(ArrayList<Edge>[] graph) {

        int[] color = new int[graph.length];

        for (int i = 0; i < color.length; i++) {
            color[i] = -1;
        }

        Queue<Integer> q = new ArrayDeque<>();

        for(int i=0;i<graph.length;i++){

            if(color[i]==-1){

                q.add(i);
                color[i]=0;

                while(!q.isEmpty()){

                    int curr=q.remove();

                    for(int j=0;j<graph[curr].size();j++){

                        Edge e=graph[curr].get(j);

                        if(color[e.dest]==-1){
                            color[e.dest]=1-color[curr];
                            q.add(e.dest);
                        }

                        else if(color[e.dest]==color[curr]){
                            return false;
                        }
                    }
                }
            }
        }

        return true;
    }

    // ------------------------------------------------------------
    // Main Method (Test Code)
    // ------------------------------------------------------------
    public static void main(String[] args){

        int V=4;
        ArrayList<Edge>[] graph=new ArrayList[V];

        createGraph(graph);

        System.out.println("Cycle : "+detectCycle(graph));
        System.out.println("Bipartite : "+bipartite(graph));
    }
}