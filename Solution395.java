class Solution {
    public int longestSubstring(String s, int k) {
        return helper(s, 0, s.length(), k);
    }
    private int helper(String s, int start, int end, int k) {
        if (end - start < k) return 0;
        int[] freq = new int[26];
        for (int i = start; i < end; i++) freq[s.charAt(i) - 'a']++;
        for (int i = start; i < end; i++) {
            if (freq[s.charAt(i) - 'a'] < k) {
                int j = i + 1;
                while (j < end && freq[s.charAt(j) - 'a'] < k) j++;
                return Math.max(helper(s, start, i, k), helper(s, j, end, k));
            }
        }
        return end - start;
    }
}
