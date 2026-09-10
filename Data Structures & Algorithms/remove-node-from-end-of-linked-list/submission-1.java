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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int len=0;
        ListNode dum = head;
        while (dum!=null) {len++; dum=dum.next;}
        dum = head;

        if  (len==n) return head.next;

        while (len>0) {
            len--;
            if (len==n) {
                dum.next = dum.next.next;
                break;
            }
            else
                dum = dum.next;
        }

        return head;
    }
}
