class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length, count = 0, curr = 0;
        for (int i = 2; i < n; i++) {
            if (nums[i] - nums[i - 1] == nums[i - 1] - nums[i - 2]) {
                curr++;
                count += curr;
            } else {
                curr = 0;
            }
        }
        return count;
    }
}
