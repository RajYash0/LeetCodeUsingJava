class Solution {
    public int findMinMoves(int[] machines) {
        int n = machines.length;
        long sum = 0;
        for (int x : machines) sum += x;
        if (sum % n != 0) return -1;
        int target = (int)(sum / n);
        int maxMoves = 0;
        long accumulated = 0;
        for (int load : machines) {
            int diff = load - target;
            accumulated += diff;
            int candidate = (int)Math.max(Math.abs(accumulated), diff);
            maxMoves = Math.max(maxMoves, candidate);
        }
        return maxMoves;
    }
}