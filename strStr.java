class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String haystack = "hello";
        String needle = "ll";
        int index = solution.strStr(haystack, needle);
        System.out.println(index);
    }
}

class Solution {
    public int strStr(String haystack, String needle) {
        int h = haystack.length();
        int n = needle.length();
        for (int i = 0; i <= h - n; i++) {
            if (haystack.substring(i, i + n).equals(needle)) {
                return i;
            }
        }
        return -1;
    }
}
