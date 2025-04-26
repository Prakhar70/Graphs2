
import java.util.LinkedList;
import java.util.Queue;

public class rottenOranges {
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] dir = {{1,0},{0,1},{-1,0},{0,-1}};
        Queue<Pair> que = new LinkedList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==2){
                    que.add(new Pair(i,j));
                }
            }
        }
        int time=-1;
        while(que.size()>0){
            int size = que.size();
            time++;
            while(size-->0){
                
                Pair rPair = que.remove();
                for(int[] d:dir){
                    int row = rPair.a+d[0];
                    int col = rPair.b+d[1];
                    if(row>=0 && row<n && col>=0 && col<m && grid[row][col]==1){
                        grid[row][col]=2;
                        que.add(new Pair(row, col));
                    }
                }
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1){
                    return -1;
                }
            }
        }
        return time;
    }
}
