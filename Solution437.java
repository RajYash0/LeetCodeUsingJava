class Solution {
    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) return 0;
        return dfs(root, targetSum) + pathSum(root.left, targetSum) + pathSum(root.right, targetSum);
    }
    private int dfs(TreeNode node, long target) {
        if (node == null) return 0;
        return (node.val == target ? 1 : 0) + dfs(node.left, target - node.val) + dfs(node.right, target - node.val);
    }
}