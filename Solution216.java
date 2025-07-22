import java.util.*;

class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(1, k, n, new ArrayList<>(), res);
        return res;
    }

    private void backtrack(int start, int k, int n, List<Integer> temp, List<List<Integer>> res) {
        if (k == 0 && n == 0) {
            res.add(new ArrayList<>(temp));
            return;
        }
        if (k == 0 || n < 0) return;
        for (int i = start; i <= 9; i++) {
            temp.add(i);
            backtrack(i + 1, k - 1, n - i, temp, res);
            temp.remove(temp.size() - 1);
        }
    }
}
