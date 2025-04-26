import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//https://www.geeksforgeeks.org/problems/bfs-traversal-of-graph/1
class bfs {
    public ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> graph) {
        int V = graph.size();
        ArrayList<Integer> ans = new ArrayList<>();
        boolean [] visited = new boolean[V];
        Queue<Integer> que = new LinkedList<>();
        que.add(0);
        visited[0]=true;
        while(que.size()!=0){
            int size = que.size();
            while(size-->0){
                int rEle = que.remove();
                ans.add(rEle);
                List<Integer> neighbours = graph.get(rEle);
                for(int neighbour:neighbours){
                    if(!visited[neighbour]){
                        que.add(neighbour);
                        visited[neighbour]=true;
                    }
                }
            }
        }
        return ans;
    }

    public ArrayList<ArrayList<Integer>> bfs2(ArrayList<ArrayList<Integer>> graph) {
        int V = graph.size();
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        boolean [] visited = new boolean[V];
        Queue<Integer> que = new LinkedList<>();
        que.add(0);
        visited[0]=true;
        int lvl =0;
        while(que.size()!=0){
            int size = que.size();
            while(size-->0){
                int rEle = que.remove();
                if(lvl == ans.size()){
                    ArrayList<Integer> dummy = new ArrayList<>();
                    dummy.add(rEle);
                    ans.add(dummy);
                }else{
                    ans.get(lvl).add(rEle);
                }
                List<Integer> neighbours = graph.get(rEle);
                for(int neighbour:neighbours){
                    if(!visited[neighbour]){
                        que.add(neighbour);
                        visited[neighbour]=true;
                    }
                }
            }
            lvl++;
        }
        return ans;
    }
}