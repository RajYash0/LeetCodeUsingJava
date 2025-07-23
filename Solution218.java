import java.util.*;

class Solution {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<int[]> events = new ArrayList<>();
        for (int[] b : buildings) {
            events.add(new int[]{b[0], -b[2]});
            events.add(new int[]{b[1], b[2]});
        }
        events.sort((a, b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]);
        
        List<List<Integer>> res = new ArrayList<>();
        TreeMap<Integer, Integer> heights = new TreeMap<>();
        heights.put(0, 1);
        int prevHeight = 0;
        
        for (int[] e : events) {
            if (e[1] < 0) {
                heights.put(-e[1], heights.getOrDefault(-e[1], 0) + 1);
            } else {
                heights.put(e[1], heights.get(e[1]) - 1);
                if (heights.get(e[1]) == 0) heights.remove(e[1]);
            }
            int currHeight = heights.lastKey();
            if (currHeight != prevHeight) {
                res.add(Arrays.asList(e[0], currHeight));
                prevHeight = currHeight;
            }
        }
        return res;
    }
}
