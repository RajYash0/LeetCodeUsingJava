import java.util.HashMap;
import java.util.Map;

class Leetcode87 {
    static class Solution {
        Map<String, Boolean> memo = new HashMap<>();

        public boolean isScramble(String s1, String s2) {
            String key = s1 + "," + s2;
            if (memo.containsKey(key)) return memo.get(key);
            if (s1.equals(s2)) return true;

            int[] count = new int[26];
            for (int i = 0; i < s1.length(); i++) {
                count[s1.charAt(i) - 'a']++;
                count[s2.charAt(i) - 'a']--;
            }
            for (int c : count) {
                if (c != 0) {
                    memo.put(key, false);
                    return false;
                }
            }

            int n = s1.length();
            for (int i = 1; i < n; i++) {
                if (isScramble(s1.substring(0, i), s2.substring(0, i)) &&
                    isScramble(s1.substring(i), s2.substring(i)) ||
                    isScramble(s1.substring(0, i), s2.substring(n - i)) &&
                    isScramble(s1.substring(i), s2.substring(0, n - i))) {
                    memo.put(key, true);
                    return true;
                }
            }

            memo.put(key, false);
            return false;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        String s1 = "great", s2 = "rgeat";
        System.out.println(sol.isScramble(s1, s2)); // Output: true
    }
}
