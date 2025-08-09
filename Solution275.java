class Solution {
    public int hIndex(int[] citations) {
        int n = citations.length, l = 0, r = n;
        while (l < r) {
            int m = (l + r) / 2;
            if (citations[m] + m >= n) r = m;
            else l = m + 1;
        }
        return n - l;
    }
}
