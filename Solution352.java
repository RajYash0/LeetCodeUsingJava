import java.util.*;

class SummaryRanges {
    private TreeMap<Integer, int[]> map;

    public SummaryRanges() {
        map = new TreeMap<>();
    }

    public void addNum(int val) {
        if (map.containsKey(val)) return;
        Integer l = map.lowerKey(val);
        Integer h = map.higherKey(val);
        if (l != null && h != null && map.get(l)[1] + 1 == val && val + 1 == map.get(h)[0]) {
            map.get(l)[1] = map.get(h)[1];
            map.remove(h);
        } else if (l != null && map.get(l)[1] + 1 >= val) {
            map.get(l)[1] = Math.max(map.get(l)[1], val);
        } else if (h != null && map.get(h)[0] - 1 == val) {
            map.put(val, new int[]{val, map.get(h)[1]});
            map.remove(h);
        } else {
            map.put(val, new int[]{val, val});
        }
    }

    public int[][] getIntervals() {
        Collection<int[]> values = map.values();
        return values.toArray(new int[values.size()][]);
    }
}
