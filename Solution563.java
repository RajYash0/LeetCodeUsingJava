class Solution {
    private int totalTilt = 0;

    public int findTilt(TreeNode root) {
        postOrder(root);
        return totalTilt;
    }

    private int postOrder(TreeNode node) {
        if (node == null) return 0;
        int left = postOrder(node.left);
        int right = postOrder(node.right);
        totalTilt += Math.abs(left - right);
        return left + right + node.val;
    }
}
