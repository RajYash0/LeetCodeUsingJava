class Solution41 {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            while (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
                int temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
            }
        }

        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) return i + 1;
        }

        return n + 1;
    }

    public static void main(String[] args) {
        Solution41 sol = new Solution41();
        int[] nums = {3, 4, -1, 1};
        System.out.println(sol.firstMissingPositive(nums)); // Output: 2
    }
}
