import java.util.*;

class Solution {
    int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length, n = heights[0].length;
        boolean[][] pac = new boolean[m][n];
        boolean[][] atl = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            dfs(heights, pac, i, 0, heights[i][0]);
            dfs(heights, atl, i, n - 1, heights[i][n - 1]);
        }
        for (int j = 0; j < n; j++) {
            dfs(heights, pac, 0, j, heights[0][j]);
            dfs(heights, atl, m - 1, j, heights[m - 1][j]);
        }
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pac[i][j] && atl[i][j]) res.add(Arrays.asList(i, j));
            }
        }
        return res;
    }
    void dfs(int[][] h, boolean[][] vis, int i, int j, int prev) {
        if (i < 0 || j < 0 || i >= h.length || j >= h[0].length || vis[i][j] || h[i][j] < prev) return;
        vis[i][j] = true;
        for (int[] d : dirs) dfs(h, vis, i + d[0], j + d[1], h[i][j]);
    }
}
