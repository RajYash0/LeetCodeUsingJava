class Solution {
    private int[][] rects;
    private int[] prefix;
    private Random rand = new Random();
    public Solution(int[][] rects) {
        this.rects = rects;
        prefix = new int[rects.length];
        for (int i = 0; i < rects.length; i++) {
            int[] r = rects[i];
            int count = (r[2] - r[0] + 1) * (r[3] - r[1] + 1);
            prefix[i] = (i == 0 ? count : prefix[i - 1] + count);
        }
    }
    public int[] pick() {
        int total = prefix[prefix.length - 1];
        int target = rand.nextInt(total) + 1;
        int idx = Arrays.binarySearch(prefix, target);
        if (idx < 0) idx = -idx - 1;
        int[] r = rects[idx];
        int x = r[0] + rand.nextInt(r[2] - r[0] + 1);
        int y = r[1] + rand.nextInt(r[3] - r[1] + 1);
        return new int[] { x, y };
    }
}