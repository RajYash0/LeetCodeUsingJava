import java.util.*;
class Solution {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Queue<TreeNode> q = new ArrayDeque<>();
        q.add(root);
        while (!q.isEmpty()) {
            int sz = q.size();
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < sz; i++) {
                TreeNode t = q.poll();
                max = Math.max(max, t.val);
                if (t.left != null) q.add(t.left);
                if (t.right != null) q.add(t.right);
            }
            res.add(max);
        }
        return res;
    }
}