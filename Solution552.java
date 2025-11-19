class Solution {
    public int checkRecord(int n) {
        final int MOD = 1_000_000_007;
        long[][][] dp = new long[n+1][2][3];
        dp[0][0][0] = 1;
        for (int i = 0; i < n; i++) {
            for (int a = 0; a <= 1; a++) {
                for (int l = 0; l <= 2; l++) {
                    long cur = dp[i][a][l];
                    if (cur == 0) continue;
                    dp[i+1][a][0] = (dp[i+1][a][0] + cur) % MOD;
                    if (l < 2) dp[i+1][a][l+1] = (dp[i+1][a][l+1] + cur) % MOD;
                    if (a == 0) dp[i+1][1][0] = (dp[i+1][1][0] + cur) % MOD;
                }
            }
        }
        long ans = 0;
        for (int a = 0; a <= 1; a++) for (int l = 0; l <= 2; l++) ans = (ans + dp[n][a][l]) % MOD;
        return (int) ans;
    }
}
