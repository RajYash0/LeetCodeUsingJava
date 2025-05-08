public class NQueens52 {
    public int totalNQueens(int n) {
        return backtrack(0, n, new boolean[n], new boolean[2 * n], new boolean[2 * n]);
    }

    private int backtrack(int row, int n, boolean[] cols, boolean[] d1, boolean[] d2) {
        if (row == n) return 1;
        int count = 0;
        for (int col = 0; col < n; col++) {
            int id1 = row - col + n, id2 = row + col;
            if (cols[col] || d1[id1] || d2[id2]) continue;
            cols[col] = d1[id1] = d2[id2] = true;
            count += backtrack(row + 1, n, cols, d1, d2);
            cols[col] = d1[id1] = d2[id2] = false;
        }
        return count;
    }

    public static void main(String[] args) {
        NQueens52 solution = new NQueens52();
        int n = 4;
        System.out.println("Total solutions: " + solution.totalNQueens(n));
    }
}
