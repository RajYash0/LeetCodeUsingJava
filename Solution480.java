import java.util.*;

class Solution {
    public double[] medianSlidingWindow(int[] nums, int k) {
        TreeMap<Integer, Integer> left = new TreeMap<>();
        TreeMap<Integer, Integer> right = new TreeMap<>();
        int leftSize = 0, rightSize = 0;
        double[] ans = new double[nums.length - k + 1];

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (leftSize == 0 || num <= left.lastKey()) {
                left.put(num, left.getOrDefault(num, 0) + 1);
                leftSize++;
            } else {
                right.put(num, right.getOrDefault(num, 0) + 1);
                rightSize++;
            }
            while (leftSize > rightSize + 1) {
                int move = left.lastKey();
                left.put(move, left.get(move) - 1);
                if (left.get(move) == 0) left.remove(move);
                leftSize--;
                right.put(move, right.getOrDefault(move, 0) + 1);
                rightSize++;
            }
            while (rightSize > leftSize) {
                int move = right.firstKey();
                right.put(move, right.get(move) - 1);
                if (right.get(move) == 0) right.remove(move);
                rightSize--;
                left.put(move, left.getOrDefault(move, 0) + 1);
                leftSize++;
            }
            if (i >= k - 1) {
                if (k % 2 == 1) ans[i - k + 1] = (double) left.lastKey();
                else ans[i - k + 1] = ((double) left.lastKey() + right.firstKey()) / 2.0;

                int remove = nums[i - k + 1];
                if (left.containsKey(remove)) {
                    left.put(remove, left.get(remove) - 1);
                    if (left.get(remove) == 0) left.remove(remove);
                    leftSize--;
                } else {
                    right.put(remove, right.get(remove) - 1);
                    if (right.get(remove) == 0) right.remove(remove);
                    rightSize--;
                }
            }
        }
        return ans;
    }
}