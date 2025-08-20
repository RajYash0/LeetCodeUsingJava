class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] val = new int[n + 2];
        val[0] = 1;
        val[n + 1] = 1;
        for (int i = 1; i <= n; i++) val[i] = nums[i - 1];
        int[][] dp = new int[n + 2][n + 2];
        for (int len = 2; len <= n + 1; len++) {
            for (int left = 0; left + len <= n + 1; left++) {
                int right = left + len;
                for (int k = left + 1; k < right; k++) {
                    dp[left][right] = Math.max(dp[left][right],
                        dp[left][k] + dp[k][right] + val[left] * val[k] * val[right]);
                }
            }
        }
        return dp[0][n + 1];
    }
}
