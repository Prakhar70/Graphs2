public class ConnectedComponent {
    public int numIslands(char[][] grid) {

        int n = grid.length;
        int m = grid[0].length;
        int count =0;

        int[][] dir={{0,1},{1,0},{0,-1},{-1,0}};
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]=='1'){
                    dfs(grid, i, j, dir);
                    count++;
                }
            }
        }
        return count;
    }
    private void dfs(char[][] grid, int i, int j, int[][] dir){
        int n = grid.length;
        int m = grid[0].length;
        grid[i][j]='0';
        for(int[] d:dir){
            int i_=i+d[0];
            int j_=j+d[1];
            if(i_>=0 && i_<n && j_>=0 && j_<m && grid[i_][j_]=='1'){
                dfs(grid, i_, j_, dir);
            }
        }
    }
}
