package Level1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class IsCycle {
    public static boolean isCycle(ArrayList<Integer>[] graph, int src, boolean[] vis){
        Queue<Integer> que = new LinkedList<>();
        que.add(src);
        while(que.size()>0){
            int k = que.size();
            while(k-->0){
                int rNode = que.remove();
                if(vis[rNode]){
                    return true;
                }
                vis[rNode]=true;
                for(int neighbour: graph[rNode]){
                    if(!vis[neighbour]){
                        que.add(neighbour);
                    }
                }

            }
        }
        return false;
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

        boolean[] vis = new boolean[V];
        boolean isCyclePresent = false;
        for(int i=0;i<V;i++){
            if(!vis[i]){
                if(isCycle(graph,i, vis)==true){
                    isCyclePresent = true;
                    break;
                }
            }
        }
        if(isCyclePresent){
            System.out.println("Present");
        }else{
            System.out.println("Not Present");
        }
    }
}
