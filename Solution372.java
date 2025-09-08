class Solution {
    private static final int MOD = 1337;
    
    public int superPow(int a, int[] b) {
        return pow(a % MOD, b, b.length - 1);
    }
    
    private int pow(int a, int[] b, int idx) {
        if (idx < 0) return 1;
        int part1 = modPow(a, b[idx]);
        int part2 = modPow(pow(a, b, idx - 1), 10);
        return (part1 * part2) % MOD;
    }
    
    private int modPow(int a, int k) {
        int res = 1;
        for (int i = 0; i < k; i++) res = (res * a) % MOD;
        return res;
    }
}
