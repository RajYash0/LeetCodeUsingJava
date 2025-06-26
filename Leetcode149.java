import java.util.*;

public class Leetcode149 {
    public static void main(String[] args) {
        Solution149 sol = new Solution149();
        int[][] points = { {1,1}, {2,2}, {3,3} };
        System.out.println(sol.maxPoints(points)); // Output: 3
    }
}

class Solution149 {
    public int maxPoints(int[][] points) {
        if (points.length <= 2) return points.length;
        int max = 0;
        for (int i = 0; i < points.length; i++) {
            Map<String, Integer> map = new HashMap<>();
            int duplicate = 1;
            for (int j = i + 1; j < points.length; j++) {
                int dx = points[j][0] - points[i][0];
                int dy = points[j][1] - points[i][1];
                if (dx == 0 && dy == 0) {
                    duplicate++;
                    continue;
                }
                int gcd = gcd(dx, dy);
                dx /= gcd;
                dy /= gcd;
                String key = dx + "/" + dy;
                map.put(key, map.getOrDefault(key, 0) + 1);
            }
            int currMax = 0;
            for (int count : map.values()) {
                currMax = Math.max(currMax, count);
            }
            max = Math.max(max, currMax + duplicate);
        }
        return max;
    }

    private int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}
