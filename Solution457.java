class Solution{
    private int nextIndex(int[] nums, int cur) {
        int n = nums.length;
        int nxt = (cur + nums[cur]) % n;
        if (nxt < 0) nxt += n;
        return nxt;
    }
    public boolean circularArrayLoop(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) continue;
            int slow = i, fast = i;
            boolean forward = nums[i] > 0;
            while (true) {
                slow = nextIndex(nums, slow);
                if (nums[slow] > 0 != forward || nums[slow] == 0) break;
                fast = nextIndex(nums, fast);
                if (nums[fast] > 0 != forward || nums[fast] == 0) break;
                fast = nextIndex(nums, fast);
                if (nums[fast] > 0 != forward || nums[fast] == 0) break;
                if (slow == fast) {
                    if (slow == nextIndex(nums, slow)) break;
                    return true;
                }
            }
            int j = i;
            while (nums[j] > 0 == forward && nums[j] != 0) {
                int nxt = nextIndex(nums, j);
                nums[j] = 0;
                j = nxt;
            }
        }
        return false;
    }
}