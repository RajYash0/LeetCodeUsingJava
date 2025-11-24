class Solution {
    public int arrayNesting(int[] nums) {
        int n = nums.length;
        boolean[] vis = new boolean[n];
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                int count = 0;
                int cur = i;
                while (!vis[cur]) {
                    vis[cur] = true;
                    cur = nums[cur];
                    count++;
                }
                if (count > res) res = count;
            }
        }
        return res;
    }
}