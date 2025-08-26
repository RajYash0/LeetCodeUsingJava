class Solution {
    int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
    public int longestIncreasingPath(int[][] matrix) {
        int n = matrix.length, m = matrix[0].length;
        int[][] dp = new int[n][m];
        int max = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                max = Math.max(max, dfs(matrix, i, j, dp));
            }
        }
        return max;
    }
    private int dfs(int[][] mat, int i, int j, int[][] dp){
        if(dp[i][j] != 0) return dp[i][j];
        int max = 1;
        for(int[] d : dirs){
            int x = i+d[0], y = j+d[1];
            if(x>=0 && y>=0 && x<mat.length && y<mat[0].length && mat[x][y]>mat[i][j]){
                max = Math.max(max, 1 + dfs(mat, x, y, dp));
            }
        }
        return dp[i][j] = max;
    }
}
