import java.util.*;

class Solution {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        int rows = matrix.length, cols = matrix[0].length, res = Integer.MIN_VALUE;
        for (int left = 0; left < cols; left++) {
            int[] rowSum = new int[rows];
            for (int right = left; right < cols; right++) {
                for (int r = 0; r < rows; r++) rowSum[r] += matrix[r][right];
                TreeSet<Integer> set = new TreeSet<>();
                set.add(0);
                int prefixSum = 0;
                for (int sum : rowSum) {
                    prefixSum += sum;
                    Integer target = set.ceiling(prefixSum - k);
                    if (target != null) res = Math.max(res, prefixSum - target);
                    set.add(prefixSum);
                }
            }
        }
        return res;
    }
}
