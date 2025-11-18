class Solution {
    public boolean checkRecord(String s) {
        int a = 0, l = 0;
        for (char c : s.toCharArray()) {
            if (c == 'A') a++;
            if (c == 'L') l++;
            else l = 0;
            if (a > 1 || l > 2) return false;
        }
        return true;
    }
}
