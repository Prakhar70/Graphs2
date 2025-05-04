package Level1;

public class CountNumberOfIsland {
    public int numIslands(char[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}};
        int cnt = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(matrix[i][j]=='1'){
                    traversal(i, j , matrix, dir);
                    cnt++;
                }
            }
        }
        return cnt;
    }
    public void traversal(int i, int j, char[][] matrix, int[][] dir){
        matrix[i][j]='0';
        for(int[] d:dir){
            int row = i+d[0];
            int col = j+d[1];
            if(row>=0 && col>=0 && row<matrix.length && col<matrix[0].length && matrix[row][col]=='1'){
                traversal(row, col, matrix, dir);
            }
        }
    }
}
