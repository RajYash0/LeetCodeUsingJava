class Solution {
    int[] prefix;
    int total;
    java.util.Random rand = new java.util.Random();
    public Solution(int[] w) {
        prefix = new int[w.length];
        prefix[0] = w[0];
        for (int i = 1; i < w.length; i++) prefix[i] = prefix[i - 1] + w[i];
        total = prefix[w.length - 1];
    }
    public int pickIndex() {
        int target = rand.nextInt(total) + 1;
        int l = 0, r = prefix.length - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (prefix[mid] < target) l = mid + 1;
            else r = mid;
        }
        return l;
    }
}