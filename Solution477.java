class Solution {
    public int totalHammingDistance(int[] nums) {
        int res = 0, n = nums.length;
        for (int bit = 0; bit < 32; bit++) {
            int c = 0;
            for (int num : nums) {
                c += (num >> bit) & 1;
            }
            res += c * (n - c);
        }
        return res;
    }
}