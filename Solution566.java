class Solution {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int m = mat.length;
        int n = mat[0].length;
        if (m * n != r * c) return mat;
        int[][] res = new int[r][c];
        int idx = 0;
        for (int[] row : mat) {
            for (int val : row) {
                res[idx / c][idx % c] = val;
                idx++;
            }
        }
        return res;
    }
}
