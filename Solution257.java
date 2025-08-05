class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList<>();
        dfs(root, "", paths);
        return paths;
    }

    private void dfs(TreeNode node, String path, List<String> paths) {
        if (node == null) return;
        if (node.left == null && node.right == null) {
            paths.add(path + node.val);
            return;
        }
        dfs(node.left, path + node.val + "->", paths);
        dfs(node.right, path + node.val + "->", paths);
    }
}
