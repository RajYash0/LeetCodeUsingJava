class Solution {
    public Node construct(int[][] grid) {
        return build(grid, 0, 0, grid.length);
    }
    private Node build(int[][] g, int r, int c, int len) {
        if (len == 1) return new Node(g[r][c] == 1, true);
        int half = len / 2;
        Node tl = build(g, r, c, half);
        Node tr = build(g, r, c + half, half);
        Node bl = build(g, r + half, c, half);
        Node br = build(g, r + half, c + half, half);
        if (tl.isLeaf && tr.isLeaf && bl.isLeaf && br.isLeaf && tl.val == tr.val && tr.val == bl.val && bl.val == br.val) 
            return new Node(tl.val, true);
        return new Node(true, false, tl, tr, bl, br);
    }
}