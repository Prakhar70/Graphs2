public class floodFill {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int indexColor = image[sr][sc];
        if(indexColor == newColor){
            return image;
        }
        int[][] dir = {{0,1},{1,0},{0,-1},{-1,0}};
        dfs(indexColor, dir, image, sr, sc, newColor);
        return image;
    }
    private void dfs(int indexColor, int[][] dir, int [][] image, int sr, int sc, int newColor){
        image[sr][sc]=newColor;
        for(int[] d:dir){
            int i = sr+d[0];
            int j = sc+d[1];
            if(i>=0 && i<image.length && j>=0 && j<image[0].length && image[i][j]==indexColor){
                dfs(indexColor, dir, image, i, j, newColor);
            }
        }   
    }
}
