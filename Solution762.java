class Solution {
    public int countPrimeSetBits(int left, int right) {
        int ans = 0;
        int mask = 665772; // primes under 20 encoded
        for(int i = left; i <= right; i++){
            ans += (mask >> Integer.bitCount(i)) & 1;
        }
        return ans;
    }
}
