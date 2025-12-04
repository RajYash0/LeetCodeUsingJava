class Solution {
    public int countCollisions(String directions) {
        int n = directions.length();
        int l = 0;
        int r = n - 1;

        while (l < n && directions.charAt(l) == 'L') {
            l++;
        }

        while (r >= 0 && directions.charAt(r) == 'R') {
            r--;
        }

        int ans = 0;
        for (int i = l; i <= r; i++) {
            if (directions.charAt(i) != 'S') {
                ans++;
            }
        }

        return ans;
    }
}
