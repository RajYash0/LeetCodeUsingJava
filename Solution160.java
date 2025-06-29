class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class Solution160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode a = headA;
        ListNode b = headB;
        while (a != b) {
            a = (a == null) ? headB : a.next;
            b = (b == null) ? headA : b.next;
        }
        return a;
    }

    public static void main(String[] args) {
        // Create intersecting nodes
        ListNode common = new ListNode(8);
        common.next = new ListNode(10);

        // List A: 4 -> 1 -> 8 -> 10
        ListNode headA = new ListNode(4);
        headA.next = new ListNode(1);
        headA.next.next = common;

        // List B: 5 -> 6 -> 1 -> 8 -> 10
        ListNode headB = new ListNode(5);
        headB.next = new ListNode(6);
        headB.next.next = new ListNode(1);
        headB.next.next.next = common;

        Solution sol = new Solution();
        ListNode intersection = sol.getIntersectionNode(headA, headB);
        System.out.println("Intersection at: " + (intersection != null ? intersection.val : "null"));
    }
}
