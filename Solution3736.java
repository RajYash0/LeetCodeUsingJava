class Solution {
    public int minMoves(int[] nums) {
        int top = Arrays.stream(nums).max().getAsInt(), moves = 0;
        for (int x : nums) moves += top - x;
        return moves;
    }
}
