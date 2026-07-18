class Solution {
    public int findGCD(int[] nums) {
        int min = nums[0], max = nums[0];

        for (int ele : nums) {
            min = Math.min(min, ele);
            max = Math.max(max, ele);
        }

        return gcd(min, max);
    }

    private int gcd(int a, int b) {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }
}
