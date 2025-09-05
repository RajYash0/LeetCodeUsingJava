class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0) return 1;
        int ans = 10, uniqueDigits = 9;
        for (int available = 9; n > 1 && available > 0; --n, --available) {
            uniqueDigits *= available;
            ans += uniqueDigits;
        }
        return ans;
    }
}
