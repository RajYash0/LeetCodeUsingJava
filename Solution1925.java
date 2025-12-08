class Solution {
    public int countTriples(int n) {
        int ans = 0;
        boolean[] square = new boolean[n * n + 1];
        for (int i = 1; i <= n; i++) square[i * i] = true;
        for (int a = 1; a <= n; a++) {
            for (int b = 1; b <= n; b++) {
                int c2 = a * a + b * b;
                if (c2 <= n * n && square[c2]) ans++;
            }
        }
        return ans;
    }
}
