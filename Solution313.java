class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        int m = primes.length;
        int[] idx = new int[m];
        int[] ugly = new int[n];
        ugly[0] = 1;
        for (int i = 1; i < n; i++) {
            long next = Long.MAX_VALUE;
            for (int j = 0; j < m; j++) next = Math.min(next, (long) primes[j] * ugly[idx[j]]);
            ugly[i] = (int) next;
            for (int j = 0; j < m; j++) {
                if ((long) primes[j] * ugly[idx[j]] == next) idx[j]++;
            }
        }
        return ugly[n - 1];
    }
}
