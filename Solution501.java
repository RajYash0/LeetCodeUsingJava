class Solution {
    List<Integer> modes = new ArrayList<>();
    Integer prev = null;
    int count = 0, max = 0;
    public int[] findMode(TreeNode root) {
        inorder(root);
        int[] res = new int[modes.size()];
        for (int i = 0; i < modes.size(); i++) res[i] = modes.get(i);
        return res;
    }
    void inorder(TreeNode root) {
        if (root == null) return;
        inorder(root.left);
        if (prev != null && root.val == prev) count++;
        else count = 1;
        if (count > max) {
            max = count;
            modes.clear();
            modes.add(root.val);
        } else if (count == max) modes.add(root.val);
        prev = root.val;
        inorder(root.right);
    }
}