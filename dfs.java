import java.util.ArrayList;

public class dfs {
    public ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> graph) {
        int V=graph.size();
        boolean[] vis = new boolean[V];
        ArrayList<Integer> ans = new ArrayList<>();
        dfs(0, vis, ans, graph);
        return ans;
        
    }
    private void dfs(int src, boolean[] vis, ArrayList<Integer> ans, ArrayList<ArrayList<Integer>> graph) {
        ans.add(src);
        vis[src]=true;
        for(int neighbour: graph.get(src)){
            if(!vis[neighbour])
                dfs(neighbour,vis,ans, graph);
        }
    }
}
