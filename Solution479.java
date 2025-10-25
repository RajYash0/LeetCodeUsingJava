class Solution {
    public int largestPalindrome(int n) {
        if (n == 1) return 9;
        long upper = (long)Math.pow(10, n) - 1;
        for (long left = upper; left > upper / 10; left--) {
            long p = Long.parseLong(left + new StringBuilder().append(left).reverse().toString());
            for (long i = upper; i * i >= p; i--) {
                if (p % i == 0) return (int)(p % 1337);
            }
        }
        return 0;
    }
}