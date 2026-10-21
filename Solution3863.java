class Solution {
    public int minOperations(String s) {
        int n = s.length();
        boolean flag = true;

        for(int i=0;i<n;i++) {
            if(i > 0 && s.charAt(i) < s.charAt(i-1)) {
                flag = false;
                break;
            }
        }

        if(flag) {
            return 0;
        }
        if(n == 2) {
            return -1;
        }

        char minChar = 'z';
        char maxChar = 'a';

        for(char ch : s.toCharArray()) {
            minChar = (char)Math.min(minChar,ch);
            maxChar = (char)Math.max(maxChar,ch);
        }

        if(minChar == s.charAt(0) || maxChar == s.charAt(n-1)) {
            return 1;
        }
        for(int i=1;i<n-1;i++) {
            if(s.charAt(i) == minChar || s.charAt(i) == maxChar) {
                return 2;
            }
        }
        return 3;
    }
}
