package Level1;

import java.util.ArrayList;
import java.util.Scanner;

public class isGraphConnected {
    public static boolean isGraphConnected(ArrayList<Integer>[] graph){
        int V = graph.length;
        boolean[] vis = new boolean[V];
        boolean traversed = false;
        for(int i=0;i<V;i++){
            if(!vis[i]){
                if(traversed == false){
                    traversal(graph , i, vis);
                    traversed = true;
                }else {
                    return false;
                }                    
            }
        }
        return true;
    }
    public static void traversal(ArrayList<Integer>[] graph, int src, boolean[] vis){
        vis[src]=true;
        for(int neighbour:graph[src]){
            if(!vis[neighbour]){
                traversal(graph, neighbour, vis);
            }
        }
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int V = scn.nextInt(); // number of vertices
        int E = scn.nextInt(); // number of edges

        @SuppressWarnings("unchecked")
        ArrayList<Integer>[] graph = new ArrayList[V];
        
        for(int i = 0; i < V; i++) {
            graph[i] = new ArrayList<>();
        }
        for(int i = 0; i < E; i++) {
            int src = scn.nextInt();
            int dest = scn.nextInt();
            graph[src].add(dest);
            graph[dest].add(src); // undirected
        }
        boolean ans = isGraphConnected(graph);
        if(ans){
            System.out.println("Connected");
        }else{
            System.out.println("Not Connected");
        }
        
    }
}
