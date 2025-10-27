class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int n : nums) sum += n;
        if (Math.abs(target) > sum || (sum + target) % 2 != 0) return 0;
        int s = (sum + target) / 2;
        int[] dp = new int[s + 1];
        dp[0] = 1;
        for (int num : nums) {
            for (int i = s; i >= num; i--) {
                dp[i] += dp[i - num];
            }
        }
        return dp[s];
    }
}