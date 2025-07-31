class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head, fast = head, prev = null, temp;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            temp = slow.next;
            slow.next = prev;
            prev = slow;
            slow = temp;
        }
        if (fast != null) slow = slow.next;
        while (slow != null) {
            if (slow.val != prev.val) return false;
            slow = slow.next;
            prev = prev.next;
        }
        return true;
    }
}
