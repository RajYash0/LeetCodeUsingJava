class Solution {
    public int minimumPushes(String word) {
        int q = word.length() >> 3;
        int r = word.length() & 7;
        return ((q << 2) + r) * (q + 1);
    }
}
