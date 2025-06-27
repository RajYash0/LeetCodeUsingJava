public class Leetcode152 {
    public static int maxProduct(int[] nums) {
        int maxProd = nums[0], minProd = nums[0], result = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int temp = maxProd;
            maxProd = Math.max(nums[i], Math.max(nums[i] * maxProd, nums[i] * minProd));
            minProd = Math.min(nums[i], Math.min(nums[i] * temp, nums[i] * minProd));
            result = Math.max(result, maxProd);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, -2, 4};
        int output = maxProduct(nums);
        System.out.println("Output: " + output);
    }
}
