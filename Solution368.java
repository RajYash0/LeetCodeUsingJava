import java.util.*;

class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int[] dp = new int[n];
        int[] parent = new int[n];
        int max = 0, lastIndex = -1;
        Arrays.fill(dp, 1);
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0 && dp[j] + 1 > dp[i]) {
                    dp[i] = dp[j] + 1;
                    parent[i] = j;
                }
            }
            if (dp[i] > max) {
                max = dp[i];
                lastIndex = i;
            }
        }
        List<Integer> res = new ArrayList<>();
        while (parent[lastIndex] != lastIndex) {
            res.add(nums[lastIndex]);
            lastIndex = parent[lastIndex];
        }
        res.add(nums[lastIndex]);
        Collections.reverse(res);
        return res;
    }
}
