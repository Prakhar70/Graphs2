package Level1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Bfs {
    public static class Pair{
        int node;
        String psf;
        Pair(int node, String psf){
            this.node = node;
            this.psf = psf;
        }
    }
    public static void printBFSPath(ArrayList<Integer>[] graph, int src){
        Queue<Pair> que = new LinkedList<>();

        int n = graph.length;
        boolean[] vis=new boolean[n];

        que.add(new Pair(src, src+""));

        while(que.size()>0){
            int k = que.size();
            while(k-->0){
                Pair rNode = que.remove();
                if(vis[rNode.node]){
                    continue;
                }
                vis[rNode.node]=true;
                System.out.print(rNode.psf+" , ");
                for(int neighbour:graph[rNode.node]){
                    if(!vis[neighbour]){
                        que.add(new Pair(neighbour, rNode.psf+"-"+neighbour));
                    }
                }
            }
            System.out.println();
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
        printBFSPath(graph,0);
    }
}
