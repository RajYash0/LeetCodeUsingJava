class Solution
 {
    public int strongPasswordChecker(String s) {
        int n = s.length();
        boolean lower = false, upper = false, digit = false;
        for (char c : s.toCharArray()) {
            if (Character.isLowerCase(c)) lower = true;
            else if (Character.isUpperCase(c)) upper = true;
            else if (Character.isDigit(c)) digit = true;
        }
        int missing = (lower ? 0 : 1) + (upper ? 0 : 1) + (digit ? 0 : 1);
        if (n < 6) return Math.max(6 - n, missing);
        int replace = 0;
        int one = 0, two = 0;
        for (int i = 2; i < n;) {
            if (s.charAt(i) == s.charAt(i - 1) && s.charAt(i) == s.charAt(i - 2)) {
                int len = 2;
                while (i < n && s.charAt(i) == s.charAt(i - 1)) {
                    len++;
                    i++;
                }
                replace += len / 3;
                if (len % 3 == 0) one++;
                else if (len % 3 == 1) two++;
            } else i++;
        }
        if (n <= 20) return Math.max(replace, missing);
        int delete = n - 20;
        replace -= Math.min(delete, one);
        replace -= Math.min(Math.max(delete - one, 0), two * 2) / 2;
        replace -= Math.max(delete - one - 2 * two, 0) / 3;
        return delete + Math.max(replace, missing);
    }
}
