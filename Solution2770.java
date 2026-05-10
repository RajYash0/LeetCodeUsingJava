class Solution {
    public int maximumJumps(int[] nums, int target) {
        
        int n = nums.length;

        int[] dp = new int[n];

        Arrays.fill(dp, -1);

        // base case
        dp[0] = 0;

        for(int i = 0; i < n; i++) {

            // unreachable index
            if(dp[i] == -1) continue;

            for(int j = i + 1; j < n; j++) {

                long diff = 1L * nums[j] - nums[i];

                if(-target <= diff && diff <= target) {

                    dp[j] = Math.max(dp[j], dp[i] + 1);
                }
            }
        }

        return dp[n - 1];
    }
}
