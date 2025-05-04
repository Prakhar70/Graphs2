import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class cycleDetectionBFS {
    public boolean isCycle(int V, List<Integer>[] adj) {
        
        boolean[] visited = new boolean[V];
        for(int i=0;i<V;i++){
            if(visited[i]==false){
                if(bfs(i, visited, adj)){
                    return true;
                }
            }
        }
        return false;
    }
    private boolean bfs(int src, boolean[] visited, List<Integer>[] adj){
        Queue<Pair> que = new LinkedList<>();
        que.add(new Pair(src,-1));
        visited[src] = true;
        while(que.size()>0){
            int size= que.size();// you can comment
            while(size-->0){/// you can comment
                Pair rPair = que.remove();
                int parent = rPair.b;
                int node = rPair.a;
                
                for(int neighbour:adj[node]){
                    if(visited[neighbour] && neighbour != parent){
                        return true;
                    }
                    if(!visited[neighbour]){
                        visited[neighbour]=true;
                        que.add(new Pair(neighbour, node));
                    }
                }
            }
        }/// you can comment
        return false;
    }
}
