class Solution {
    public int zigZagArrays(int n, int l, int r) {
        int range = r - l + 1;
        long MOD = 1000000007;
        
        if (n == 1) return range;
        if (n == 2) return (int)((1L * range * (range - 1)) % MOD);

        // dp[0][v] = ways to end at value 'v' having just gone DOWN
        // dp[1][v] = ways to end at value 'v' having just gone UP
        long[][] dp = new long[2][range];

        // Base case: n = 2
        for (int v = 0; v < range; v++) {
            for (int prev = 0; prev < range; prev++) {
                if (v < prev) dp[0][v]++;      // Went DOWN
                else if (v > prev) dp[1][v]++; // Went UP
            }
        }

        // Step-by-step transition up to length N
        for (int i = 3; i <= n; i++) {
            long[][] nextDp = new long[2][range];
            for (int v = 0; v < range; v++) {
                // If we want to end going UP to 'v', the previous step must have been DOWN to 'p' (where p < v)
                for (int p = 0; p < v; p++) {
                    nextDp[1][v] = (nextDp[1][v] + dp[0][p]) % MOD;
                }
                // If we want to end going DOWN to 'v', the previous step must have been UP to 'p' (where p > v)
                for (int p = v + 1; p < range; p++) {
                    nextDp[0][v] = (nextDp[0][v] + dp[1][p]) % MOD;
                }
            }
            dp = nextDp;
        }

        long total = 0;
        for (int v = 0; v < range; v++) {
            total = (total + dp[0][v] + dp[1][v]) % MOD;
        }
        return (int)total;
    }
}
