class Solution {
    public Node intersect(Node q1, Node q2) {
        if (q1.isLeaf) return q1.val ? q1 : q2;
        if (q2.isLeaf) return q2.val ? q2 : q1;
        Node tl = intersect(q1.topLeft, q2.topLeft);
        Node tr = intersect(q1.topRight, q2.topRight);
        Node bl = intersect(q1.bottomLeft, q2.bottomLeft);
        Node br = intersect(q1.bottomRight, q2.bottomRight);
        if (tl.isLeaf && tr.isLeaf && bl.isLeaf && br.isLeaf &&
            tl.val == tr.val && tl.val == bl.val && tl.val == br.val) {
            return new Node(tl.val, true, null, null, null, null);
        }
        return new Node(false, false, tl, tr, bl, br);
    }
}