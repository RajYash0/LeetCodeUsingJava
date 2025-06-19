public class Solution136 {
    public int singleNumber(int[] nums) {
        int res = 0;
        for (int num : nums) res ^= num;
        return res;
    }

    public static void main(String[] args) {
        Solution136 sol = new Solution136();
        int[] nums = {4, 1, 2, 1, 2};
        System.out.println(sol.singleNumber(nums)); // Output: 4
    }
}
