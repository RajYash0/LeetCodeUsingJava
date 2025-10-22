class Solution {
    public boolean makesquare(int[] matchsticks) {
        int sum = 0;
        for (int m : matchsticks) sum += m;
        if (sum % 4 != 0) return false;
        Arrays.sort(matchsticks);
        return backtrack(matchsticks, matchsticks.length - 1, new int[4], sum / 4);
    }

    boolean backtrack(int[] nums, int i, int[] sides, int target) {
        if (i < 0) return sides[0] == target && sides[1] == target && sides[2] == target && sides[3] == target;
        int val = nums[i];
        for (int j = 0; j < 4; j++) {
            if (sides[j] + val > target) continue;
            sides[j] += val;
            if (backtrack(nums, i - 1, sides, target)) return true;
            sides[j] -= val;
        }
        return false;
    }
}