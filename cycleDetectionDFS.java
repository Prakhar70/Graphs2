import java.util.List;


public class cycleDetectionDFS {
    public boolean isCycle(int V, List<Integer>[] adj) {
    
        boolean[] visited = new boolean[V];
        for(int i=0;i<V;i++){
            if(visited[i]==false){
                if(dfs(i, adj, visited, -1)){
                    return true;
                }
            }
        }
        return false;
    }
    private boolean dfs(int src, List<Integer>[] adj, boolean[] visited, int parent){
        visited[src] = true;
        for(int neighbour : adj[src]){
            if(visited[neighbour] && neighbour != parent){
                return true;
            }
            if(!visited[neighbour]){
                if(dfs(neighbour, adj,visited, src)){
                    return true;
                }
            }
        }
        return false;
    }
}
