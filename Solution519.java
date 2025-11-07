import java.util.*;

class Solution {
    private int rows, cols, total;
    private Map<Integer, Integer> map = new HashMap<>();
    private Random rand = new Random();

    public Solution(int n_rows, int n_cols) {
        rows = n_rows;
        cols = n_cols;
        total = rows * cols;
    }

    public int[] flip() {
        int r = rand.nextInt(total);
        int x = map.getOrDefault(r, r);
        total--;
        map.put(r, map.getOrDefault(total, total));
        return new int[]{x / cols, x % cols};
    }

    public void reset() {
        map.clear();
        total = rows * cols;
    }
}