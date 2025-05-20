public class MinimumWindowSubstring {
    public static String minWindow(String s, String t) {
        if (s.length() < t.length()) return "";
        int[] map = new int[128];
        for (char c : t.toCharArray()) map[c]++;
        int left = 0, right = 0, minLen = Integer.MAX_VALUE, start = 0, count = t.length();
        while (right < s.length()) {
            if (map[s.charAt(right++)]-- > 0) count--;
            while (count == 0) {
                if (right - left < minLen) {
                    minLen = right - left;
                    start = left;
                }
                if (map[s.charAt(left++)]++ == 0) count++;
            }
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
    }

    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        System.out.println(minWindow(s, t)); // BANC
    }
}
