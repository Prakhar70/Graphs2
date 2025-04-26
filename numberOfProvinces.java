import java.util.ArrayList;

public class numberOfProvinces {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
        }
        for(int i =0;i<isConnected.length;i++){
            for(int j=0;j<isConnected[0].length;j++){
                if(i!=j && isConnected[i][j]==1){
                    graph.get(i).add(j);
                }
            }
        }
        int count =0;
        boolean vis[]=new boolean[n];
        for(int i=0;i<n;i++){
            if(!vis[i]){
                dfs(i, graph, vis);
                count++;
            }
        }
        return count;

    }

    private void dfs(int i, ArrayList<ArrayList<Integer>> graph, boolean[] vis) {
        vis[i]=true;
        for(int neighbour:graph.get(i)){
            if(!vis[neighbour])
                dfs(neighbour,graph, vis);
        }
    }
}
