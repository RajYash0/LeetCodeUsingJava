class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n1 = s1.length(), n2 = s2.length();
        if (n1 > n2) return false;
        int[] count = new int[26];
        for (int i = 0; i < n1; i++) {
            count[s1.charAt(i) - 'a']++;
            count[s2.charAt(i) - 'a']--;
        }
        if (allZero(count)) return true;
        for (int i = n1; i < n2; i++) {
            count[s2.charAt(i) - 'a']--;
            count[s2.charAt(i - n1) - 'a']++;
            if (allZero(count)) return true;
        }
        return false;
    }

    private boolean allZero(int[] count) {
        for (int x : count) if (x != 0) return false;
        return true;
    }
}
