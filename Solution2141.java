class Solution {
    public long maxRunTime(int n, int[] batteries) {
        long sum = 0;
        int max = 0;
        for (int b : batteries) {
            sum += b;
            if (b > max) max = b;
        }

        long left = 0, right = sum / n;
        long ans = 0;

        while (left <= right) {
            long mid = left + (right - left) / 2;
            if (canRun(mid, n, batteries)) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return ans;
    }

    private boolean canRun(long time, int n, int[] batteries) {
        long total = 0;
        for (int b : batteries) {
            total += Math.min(b, time);
            if (total >= time * n) return true;
        }
        return total >= time * n;
    }
}
