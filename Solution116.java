public class Solution116 {
    public static void main(String[] args) {
        Node root = new Node(1,
                        new Node(2, new Node(4), new Node(5), null),
                        new Node(3, new Node(6), new Node(7), null),
                        null);
        Solution solution = new Solution();
        solution.connect(root);
        printTreeWithNextPointers(root);
    }

    static class Solution {
        public Node connect(Node root) {
            if (root == null) return null;
            Node leftmost = root;

            while (leftmost.left != null) {
                Node head = leftmost;
                while (head != null) {
                    head.left.next = head.right;
                    if (head.next != null) {
                        head.right.next = head.next.left;
                    }
                    head = head.next;
                }
                leftmost = leftmost.left;
            }

            return root;
        }
    }

    static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int val) {
            this.val = val;
        }

        public Node(int val, Node left, Node right, Node next) {
            this.val = val;
            this.left = left;
            this.right = right;
            this.next = next;
        }
    }

    static void printTreeWithNextPointers(Node root) {
        while (root != null) {
            Node curr = root;
            while (curr != null) {
                System.out.print(curr.val + " -> ");
                curr = curr.next;
            }
            System.out.println("null");
            root = root.left;
        }
    }
}
