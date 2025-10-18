class Solution {
    public int islandPerimeter(int[][] grid) {
        int islands = 0;
        int neighbors = 0;
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    islands++;
                    if (i > 0 && grid[i-1][j] == 1) neighbors++;
                    if (j > 0 && grid[i][j-1] == 1) neighbors++;
                }
            }
        }
        return islands * 4 - neighbors * 2;
    }
}