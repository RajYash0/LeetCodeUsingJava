public class Main81 {
    public static void main(String[] args) {
        Solution81 solution = new Solution81();
        int[] nums = {2, 5, 6, 0, 0, 1, 2};
        int target = 0;
        boolean result = solution.search(nums, target);
        System.out.println(result);
    }
}

class Solution81 {
    public boolean search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) return true;
            if (nums[left] == nums[mid] && nums[right] == nums[mid]) {
                left++;
                right--;
            } else if (nums[left] <= nums[mid]) {
                if (nums[left] <= target && target < nums[mid]) right = mid - 1;
                else left = mid + 1;
            } else {
                if (nums[mid] < target && target <= nums[right]) left = mid + 1;
                else right = mid - 1;
            }
        }
        return false;
    }
}
