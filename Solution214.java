class Solution {
    public String shortestPalindrome(String s) {
        String rev = new StringBuilder(s).reverse().toString();
        String l = s + "#" + rev;
        int[] kmp = new int[l.length()];
        for (int i = 1, j = 0; i < l.length(); i++) {
            while (j > 0 && l.charAt(i) != l.charAt(j)) j = kmp[j - 1];
            if (l.charAt(i) == l.charAt(j)) j++;
            kmp[i] = j;
        }
        return rev.substring(0, s.length() - kmp[l.length() - 1]) + s;
    }
}
