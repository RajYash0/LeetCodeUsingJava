class Solution {
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        if (desiredTotal <= 0) return true;
        int sum = (maxChoosableInteger + 1) * maxChoosableInteger / 2;
        if (sum < desiredTotal) return false;
        return dfs(maxChoosableInteger, desiredTotal, 0, new Boolean[1 << maxChoosableInteger]);
    }

    private boolean dfs(int max, int total, int used, Boolean[] dp) {
        if (dp[used] != null) return dp[used];
        for (int i = 1; i <= max; i++) {
            int mask = 1 << (i - 1);
            if ((used & mask) == 0) {
                if (total - i <= 0 || !dfs(max, total - i, used | mask, dp)) 
                    return dp[used] = true;
            }
        }
        return dp[used] = false;
    }
}