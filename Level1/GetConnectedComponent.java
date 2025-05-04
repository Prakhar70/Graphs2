package Level1;

import java.util.ArrayList;
import java.util.Scanner;

public class GetConnectedComponent {
    public static ArrayList<ArrayList<Integer>> getConnectComp(ArrayList<Integer>[] graph){
        int V = graph.length;
        boolean[] vis = new boolean[V];

        ArrayList<ArrayList<Integer>> mainList = new ArrayList<>();
        for(int i=0;i<V;i++){
            if(!vis[i]){
                ArrayList<Integer> smallList = new ArrayList<>();
                traversal(graph, i, smallList, vis);
                mainList.add(smallList);
            }
        }
        return mainList;
    }
    public static void traversal(ArrayList<Integer>[] graph, int src, ArrayList<Integer> list, boolean[] vis){
        vis[src] = true;
        list.add(src);
        for(int neighbour:graph[src]){
            if(!vis[neighbour]){
                traversal(graph, neighbour, list, vis);
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
        ArrayList<ArrayList<Integer>> ans = getConnectComp(graph);
        for(ArrayList<Integer> list: ans){
            System.out.println(list);
        }
    }   
}
