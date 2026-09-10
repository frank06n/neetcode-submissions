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
        ListNode ptr = head;
        while (ptr!=null) {len++; ptr=ptr.next;}
        if (len==n) return head.next;
        ptr = head;

        while (len>0) {
            len--;
            if (len==n) {
                ptr.next = ptr.next.next;
                break;
            }
            else
                ptr = ptr.next;
        }

        return head;
    }
}
