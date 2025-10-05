class Solution {
    public int[] findRightInterval(int[][] intervals) {
        int n = intervals.length;
        int[][] starts = new int[n][2];
        for (int i = 0; i < n; i++) {
            starts[i][0] = intervals[i][0];
            starts[i][1] = i;
        }
        Arrays.sort(starts, (a, b) -> a[0] - b[0]);
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            int l = 0, r = n - 1, ans = -1;
            while (l <= r) {
                int m = (l + r) / 2;
                if (starts[m][0] >= intervals[i][1]) {
                    ans = starts[m][1];
                    r = m - 1;
                } else {
                    l = m + 1;
                }
            }
            res[i] = ans;
        }
        return res;
    }
}