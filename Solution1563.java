class Solution {

    int[][] dp;
    int[] prefix;

    public int stoneGameV(int[] stoneValue) {
        int n = stoneValue.length;

        dp = new int[n][n];
        prefix = new int[n + 1];

        // Prefix sum
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + stoneValue[i];
        }

        return solve(0, n - 1);
    }

    private int solve(int l, int r) {

        // Only one stone
        if (l == r) {
            return 0;
        }

        if (dp[l][r] != 0) {
            return dp[l][r];
        }

        int ans = 0;

        // Try every possible split
        for (int k = l; k < r; k++) {

            int leftSum = prefix[k + 1] - prefix[l];
            int rightSum = prefix[r + 1] - prefix[k + 1];

            if (leftSum < rightSum) {

                // Right side is discarded
                ans = Math.max(ans,
                        leftSum + solve(l, k));

            } else if (leftSum > rightSum) {

                // Left side is discarded
                ans = Math.max(ans,
                        rightSum + solve(k + 1, r));

            } else {

                // Equal -> Alice chooses the better side
                ans = Math.max(ans,
                        Math.max(
                                leftSum + solve(l, k),
                                rightSum + solve(k + 1, r)
                        ));
            }
        }

        return dp[l][r] = ans;
    }
}
