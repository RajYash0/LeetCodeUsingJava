class Solution {
    public int findNthDigit(int n) {
        long len = 1, count = 9, start = 1;
        while (n > len * count) {
            n -= len * count;
            len++;
            count *= 10;
            start *= 10;
        }
        start += (n - 1) / len;
        String s = Long.toString(start);
        return s.charAt((n - 1) % (int)len) - '0';
    }
}
