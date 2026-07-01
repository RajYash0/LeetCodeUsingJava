class Solution {
    int[][] dirs = {{0,1}, {0,-1}, {1,0}, {-1,0}};
    
    public int maximumSafenessFactor(List<List<Integer>> grid) {
        int n = grid.size();
        if (grid.get(0).get(0) == 1 || grid.get(n-1).get(n-1) == 1) return 0;

        int[][] safeness = new int[n][n];
        for(int[] row : safeness) Arrays.fill(row, -1);
        Queue<int[]> q = new LinkedList<>();

        // Step 1: Multi-source BFS to calculate safeness factor for each cell
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(grid.get(i).get(j) == 1) {
                    q.offer(new int[]{i, j});
                    safeness[i][j] = 0;
                }
            }
        }

        while(!q.isEmpty()) {
            int[] curr = q.poll();
            for(int[] d : dirs) {
                int nx = curr[0] + d[0], ny = curr[1] + d[1];
                if(nx >= 0 && nx < n && ny >= 0 && ny < n && safeness[nx][ny] == -1) {
                    safeness[nx][ny] = safeness[curr[0]][curr[1]] + 1;
                    q.offer(new int[]{nx, ny});
                }
            }
        }

        // Step 2: Binary Search for the maximum minimum safeness factor
        int low = 0, high = n * 2, ans = 0;
        while(low <= high) {
            int mid = low + (high - low) / 2;
            if(isValid(safeness, mid, n)) {
                ans = mid; // We found a valid path, try for a safer one!
                low = mid + 1;
            } else {
                high = mid - 1; // Too strict, lower our expectations
            }
        }
        return ans;
    }

    private boolean isValid(int[][] safeness, int minSafe, int n) {
        if(safeness[0][0] < minSafe || safeness[n-1][n-1] < minSafe) return false;
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[n][n];
        
        q.offer(new int[]{0, 0});
        visited[0][0] = true;

        while(!q.isEmpty()) {
            int[] curr = q.poll();
            if(curr[0] == n-1 && curr[1] == n-1) return true;
            
            for(int[] d : dirs) {
                int nx = curr[0] + d[0], ny = curr[1] + d[1];
                if(nx >= 0 && nx < n && ny >= 0 && ny < n && !visited[nx][ny] && safeness[nx][ny] >= minSafe) {
                    visited[nx][ny] = true;
                    q.offer(new int[]{nx, ny});
                }
            }
        }
        return false;
    }
}