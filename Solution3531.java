import java.util.*;

class Solution {
    public int countCoveredBuildings(int n, int[][] buildings) {
        int[] minY = new int[n+1];
        int[] maxY = new int[n+1];
        int[] minX = new int[n+1];
        int[] maxX = new int[n+1];
        Arrays.fill(minY, Integer.MAX_VALUE);
        Arrays.fill(minX, Integer.MAX_VALUE);
        Arrays.fill(maxY, Integer.MIN_VALUE);
        Arrays.fill(maxX, Integer.MIN_VALUE);
        for (int[] b : buildings) {
            int x = b[0], y = b[1];
            minY[x] = Math.min(minY[x], y);
            maxY[x] = Math.max(maxY[x], y);
            minX[y] = Math.min(minX[y], x);
            maxX[y] = Math.max(maxX[y], x);
        }
        int cnt = 0;
        for (int[] b : buildings) {
            int x = b[0], y = b[1];
            if (minY[x] < y && y < maxY[x] && minX[y] < x && x < maxX[y]) cnt++;
        }
        return cnt;
    }
}