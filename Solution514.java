import java.util.*;
class Solution {
    int n;
    String ring;
    String key;
    List<Integer>[] pos;
    int[][] memo;
    public int findRotateSteps(String ring, String key) {
        this.ring = ring;
        this.key = key;
        n = ring.length();
        pos = new List[26];
        for (int i = 0; i < 26; i++) pos[i] = new ArrayList<>();
        for (int i = 0; i < n; i++) pos[ring.charAt(i)-'a'].add(i);
        int m = key.length();
        memo = new int[m][n];
        for (int i = 0; i < m; i++) Arrays.fill(memo[i], -1);
        return dfs(0,0);
    }
    int dfs(int i, int j) {
        if (i == key.length()) return 0;
        if (memo[i][j] != -1) return memo[i][j];
        int target = key.charAt(i)-'a';
        int best = Integer.MAX_VALUE;
        for (int p : pos[target]) {
            int diff = Math.abs(p - j);
            int step = Math.min(diff, n - diff) + 1;
            best = Math.min(best, step + dfs(i+1, p));
        }
        memo[i][j] = best;
        return best;
    }
}