/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        ListNode prev = head;
        ListNode cur = head.next;

        int idx = 1;

        int firstCritical = -1;
        int lastCritical = -1;
        int minDist = Integer.MAX_VALUE;

        while(cur.next != null){
            ListNode next = cur.next;

            boolean isMax = cur.val > prev.val && cur.val > next.val;
            boolean isMin = cur.val < prev.val && cur.val < next.val;

            if(isMax || isMin){
                if(lastCritical == -1){
                    firstCritical = idx;
                }
                else {
                    minDist = Math.min(minDist, idx - lastCritical);
                }

                lastCritical = idx;
            }

            prev = cur;
            cur = next;
            idx++;
        }

        if(firstCritical == -1 || firstCritical == lastCritical){
            return new int[]{-1, -1};
        }

        int maxDist = lastCritical - firstCritical;

        return new int[]{minDist, maxDist};
    }
}
