class Solution {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        if (timeSeries == null || timeSeries.length == 0) return 0;
        int n = timeSeries.length, total = 0;
        for (int i = 0; i < n - 1; ++i) total += Math.min(duration, timeSeries[i + 1] - timeSeries[i]);
        total += duration;
        return total;
    }
}