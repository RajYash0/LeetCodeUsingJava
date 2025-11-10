import java.util.*;
class Solution {
    public String findLongestWord(String s, List<String> dictionary) {
        String res = "";
        for (String word : dictionary) {
            if (isSubsequence(word, s)) {
                if (word.length() > res.length() || (word.length() == res.length() && word.compareTo(res) < 0)) {
                    res = word;
                }
            }
        }
        return res;
    }
    private boolean isSubsequence(String w, String s) {
        int i = 0, j = 0;
        while (i < w.length() && j < s.length()) {
            if (w.charAt(i) == s.charAt(j)) i++;
            j++;
        }
        return i == w.length();
    }
}