class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution106 {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return helper(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    private TreeNode helper(int[] inorder, int inStart, int inEnd,
                            int[] postorder, int postStart, int postEnd) {
        if (inStart > inEnd || postStart > postEnd) return null;
        TreeNode root = new TreeNode(postorder[postEnd]);
        int rootIndex = 0;
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == root.val) {
                rootIndex = i;
                break;
            }
        }
        int leftSize = rootIndex - inStart;
        root.left = helper(inorder, inStart, rootIndex - 1, postorder, postStart, postStart + leftSize - 1);
        root.right = helper(inorder, rootIndex + 1, inEnd, postorder, postStart + leftSize, postEnd - 1);
        return root;
    }
}
