import java.util.*;

class Solution {
    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        int[] idx = new int[n];
        for (int i = 0; i < n; i++) idx[i] = i;
        int[] tmp = new int[n];
        int[] count = new int[n];
        sort(nums, idx, tmp, 0, n - 1, count);
        List<Integer> res = new ArrayList<>(n);
        for (int c : count) res.add(c);
        return res;
    }

    private void sort(int[] nums, int[] idx, int[] tmp, int l, int r, int[] count) {
        if (l >= r) return;
        int m = (l + r) >>> 1;
        sort(nums, idx, tmp, l, m, count);
        sort(nums, idx, tmp, m + 1, r, count);
        merge(nums, idx, tmp, l, m, r, count);
    }

    private void merge(int[] nums, int[] idx, int[] tmp, int l, int m, int r, int[] count) {
        int i = l, j = m + 1, k = l;
        while (i <= m && j <= r) {
            if (nums[idx[i]] <= nums[idx[j]]) {
                count[idx[i]] += j - (m + 1);
                tmp[k++] = idx[i++];
            } else {
                tmp[k++] = idx[j++];
            }
        }
        while (i <= m) {
            count[idx[i]] += j - (m + 1);
            tmp[k++] = idx[i++];
        }
        while (j <= r) tmp[k++] = idx[j++];
        for (int p = l; p <= r; p++) idx[p] = tmp[p];
    }
}
