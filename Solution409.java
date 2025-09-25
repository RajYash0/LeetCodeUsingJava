class Solution {
    public int longestPalindrome(String s) {
        int[] count = new int[128];
        for (char c : s.toCharArray()) count[c]++;
        int res = 0;
        for (int v : count) res += v / 2 * 2;
        if (res < s.length()) res++;
        return res;
    }
}
