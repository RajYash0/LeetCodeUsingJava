import java.util.Arrays;

class Solution {
    public int countPartitions(int[] nums) {
        long totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }
        
        if (totalSum % 2 == 0) {
            return nums.length - 1;
        } else {
            return 0;
        }
    }
}
