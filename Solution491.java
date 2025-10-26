class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> findSubsequences(int[] nums) {
        backtrack(nums, 0, new ArrayList<>());
        return res;
    }
    void backtrack(int[] nums, int start, List<Integer> temp) {
        if (temp.size() > 1) res.add(new ArrayList<>(temp));
        Set<Integer> set = new HashSet<>();
        for (int i = start; i < nums.length; i++) {
            if (!temp.isEmpty() && nums[i] < temp.get(temp.size() - 1)) continue;
            if (set.contains(nums[i])) continue;
            set.add(nums[i]);
            temp.add(nums[i]);
            backtrack(nums, i + 1, temp);
            temp.remove(temp.size() - 1);
        }
    }
}