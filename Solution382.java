import java.util.*;

class Solution {
    ListNode head;
    Random rand;

    public Solution(ListNode head) {
        this.head = head;
        this.rand = new Random();
    }

    public int getRandom() {
        int res = 0, i = 1;
        ListNode curr = head;
        while (curr != null) {
            if (rand.nextInt(i) == 0) res = curr.val;
            i++;
            curr = curr.next;
        }
        return res;
    }
}
