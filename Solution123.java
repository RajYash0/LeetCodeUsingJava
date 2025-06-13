class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[3][n];

        for (int k = 1; k <= 2; k++) {
            int maxDiff = -prices[0];
            for (int i = 1; i < n; i++) {
                dp[k][i] = Math.max(dp[k][i - 1], prices[i] + maxDiff);
                maxDiff = Math.max(maxDiff, dp[k - 1][i] - prices[i]);
            }
        }

        return dp[2][n - 1];
    }
}
