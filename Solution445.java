class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    static ListNode deserialize(String data) {
        if (data == null || data.length() == 0) return null;
        data = data.replaceAll("\\[|\\]|\\s", "");
        if (data.isEmpty()) return null;
        String[] parts = data.split(",");
        ListNode dummy = new ListNode(0), curr = dummy;
        for (String s : parts) {
            curr.next = new ListNode(Integer.parseInt(s));
            curr = curr.next;
        }
        return dummy.next;
    }
}

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        java.util.Deque<Integer> s1 = new java.util.ArrayDeque<>();
        java.util.Deque<Integer> s2 = new java.util.ArrayDeque<>();
        while (l1 != null) { s1.push(l1.val); l1 = l1.next; }
        while (l2 != null) { s2.push(l2.val); l2 = l2.next; }
        int carry = 0;
        ListNode head = null;
        while (!s1.isEmpty() || !s2.isEmpty() || carry != 0) {
            int a = s1.isEmpty() ? 0 : s1.pop();
            int b = s2.isEmpty() ? 0 : s2.pop();
            int sum = a + b + carry;
            carry = sum / 10;
            ListNode node = new ListNode(sum % 10);
            node.next = head;
            head = node;
        }
        return head;
    }
}
