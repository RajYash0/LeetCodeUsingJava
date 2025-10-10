import java.util.*;
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int val) { this.val = val; }
}
class Codec {
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        preorder(root, sb);
        return sb.toString();
    }
    private void preorder(TreeNode r, StringBuilder sb) {
        if (r == null) return;
        if (sb.length() > 0) sb.append(' ');
        sb.append(r.val);
        preorder(r.left, sb);
        preorder(r.right, sb);
    }
    public TreeNode deserialize(String data) {
        if (data == null || data.length() == 0) return null;
        String[] arr = data.split(" ");
        int[] idx = {0};
        return build(arr, idx, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    private TreeNode build(String[] arr, int[] idx, long low, long high) {
        if (idx[0] == arr.length) return null;
        long val = Long.parseLong(arr[idx[0]]);
        if (val <= low || val >= high) return null;
        idx[0]++;
        TreeNode node = new TreeNode((int)val);
        node.left = build(arr, idx, low, val);
        node.right = build(arr, idx, val, high);
        return node;
    }
}
