import java.util.*;

class Solution {

    int getRhombusSum(int[][] grid, int i, int j, int k) {
        int x = i - k, y = j;
        int sum = 0;

        for (int p = 0; p < k; p++) {
            sum += grid[x][y];
            x++;
            y++;
        }

        for (int p = 0; p < k; p++) {
            sum += grid[x][y];
            x++;
            y--;
        }

        for (int p = 0; p < k; p++) {
            sum += grid[x][y];
            x--;
            y--;
        }

        for (int p = 0; p < k; p++) {
            sum += grid[x][y];
            x--;
            y++;
        }

        return sum;
    }

    void computeRhombus(int[][] grid, int i, int j, Set<Integer> st) {
        int n = grid.length;
        int m = grid[0].length;

        for (int k = 1; i-k >= 0 && i+k < n && j-k >= 0 && j+k < m; k++) {
            st.add(getRhombusSum(grid, i, j, k));
        }
    }

    public int[] getBiggestThree(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        Set<Integer> st = new HashSet<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                st.add(grid[i][j]);
                computeRhombus(grid, i, j, st);
            }
        }

        List<Integer> res = new ArrayList<>(st);

        Collections.sort(res, Collections.reverseOrder());

        int size = Math.min(3, res.size());
        int[] ans = new int[size];

        for (int i = 0; i < size; i++) {
            ans[i] = res.get(i);
        }

        return ans;
    }
}
