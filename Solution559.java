class Solution {
    public int maxDepth(Node root) {
        if (root == null) return 0;
        int depth = 1;
        for (Node child : root.children)
            depth = Math.max(depth, 1 + maxDepth(child));
        return depth;
    }
}