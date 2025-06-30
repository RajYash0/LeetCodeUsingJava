import java.util.*;

public class Solution162 {
    public int findPeakElement(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[mid + 1]) right = mid;
            else left = mid + 1;
        }
        return left;
    }

    public static void main(String[] args) {
        Solution162 sol = new Solution162();
        int[] nums = {1, 2, 3, 1};
        int result = sol.findPeakElement(nums);
        System.out.println("Peak Index: " + result);
    }
}
