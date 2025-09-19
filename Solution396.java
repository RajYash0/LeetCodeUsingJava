class Solution {
    public int maxRotateFunction(int[] nums) {
        int n = nums.length;
        long sum = 0, f = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            f += (long) i * nums[i];
        }
        long res = f;
        for (int i = n - 1; i > 0; i--) {
            f += sum - (long) n * nums[i];
            res = Math.max(res, f);
        }
        return (int) res;
    }
}
