class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] vis = new boolean[n];
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                dfs(isConnected, vis, i);
                cnt++;
            }
        }
        return cnt;
    }
    void dfs(int[][] g, boolean[] vis, int i) {
        vis[i] = true;
        for (int j = 0; j < g.length; j++) {
            if (g[i][j] == 1 && !vis[j]) dfs(g, vis, j);
        }
    }
}
