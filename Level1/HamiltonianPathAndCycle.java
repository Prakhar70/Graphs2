package Level1;

import java.util.ArrayList;
import java.util.Scanner;

public class HamiltonianPathAndCycle {
    public static void printHPathandCycle(ArrayList<Integer>[] graph){
        int n = graph.length;
        boolean[] vis = new boolean[n];
        printPath(graph,0,"",vis,0,0);
    }

    public static void printPath(ArrayList<Integer>[] graph, int src, String psf, boolean[] vis, int nodesTravelled, int originalSrc){
        vis[src]=true;
        if(nodesTravelled == graph.length-1){
            
            System.out.println("Hamiltonian path"+psf+src);
            for(int neighbour:graph[src]){
                if(neighbour == originalSrc){
                    System.out.print(" Also a cycle");
                }
            }
            return;
        }
        for(int neighbour:graph[src]){
            if(!vis[neighbour]){
                printPath(graph, neighbour, psf+src+" ", vis, nodesTravelled+1, originalSrc);
            }
        }
        vis[src]=false;
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
        printHPathandCycle(graph);
    }   
}
