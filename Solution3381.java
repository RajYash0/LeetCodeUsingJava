import java.util.Arrays;

class Solution {
    public long maxSubarraySum(int[] nums, int k) {
        long ans = Long.MIN_VALUE;
        long prefix = 0;
        long[] minPrefix = new long[k];
        Arrays.fill(minPrefix, Long.MAX_VALUE / 2);
        minPrefix[k - 1] = 0;

        for (int i = 0; i < nums.length; ++i) {
            prefix += nums[i];
            int r = i % k;
            ans = Math.max(ans, prefix - minPrefix[r]);
            if (prefix < minPrefix[r]) {
                minPrefix[r] = prefix;
            }
        }

        return ans;
    }
}