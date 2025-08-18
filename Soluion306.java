class Solution {
    public boolean isAdditiveNumber(String num) {
        int n = num.length();
        for (int i = 1; i <= n / 2; i++) {
            if (num.charAt(0) == '0' && i > 1) break;
            long x1 = Long.parseLong(num.substring(0, i));
            for (int j = 1; Math.max(j, i) <= n - i - j; j++) {
                if (num.charAt(i) == '0' && j > 1) break;
                long x2 = Long.parseLong(num.substring(i, i + j));
                if (isValid(x1, x2, i + j, num)) return true;
            }
        }
        return false;
    }

    private boolean isValid(long x1, long x2, int start, String num) {
        if (start == num.length()) return true;
        x2 = x1 + x2;
        x1 = x2 - x1;
        String sum = String.valueOf(x2);
        return num.startsWith(sum, start) && isValid(x1, x2, start + sum.length(), num);
    }
}
