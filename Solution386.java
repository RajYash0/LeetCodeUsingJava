import java.util.*;

class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> res = new ArrayList<>();
        dfs(1, n, res);
        return res;
    }

    private void dfs(int curr, int n, List<Integer> res) {
        if (curr > n) return;
        res.add(curr);
        dfs(curr * 10, n, res);
        if (curr % 10 != 9) dfs(curr + 1, n, res);
    }
}
