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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dum = new ListNode();
        dum.next = head;
        ListNode z = dum;

        while (z.next != null)
        {
            ListNode b = z.next;
            int i=0;
            while (i<k && b!=null) { b=b.next; i++; }
            if (i<k) break; // leave last few <k nodes as it is

            ListNode prev = null;
            ListNode curr = z.next;
            ListNode t_curr = curr;
            while (curr != b)
            {
                ListNode t = curr.next;
                curr.next = prev;
                prev = curr;
                curr = t;
            }
            z.next = prev;
            t_curr.next = b;
            z = t_curr;
        }
        return dum.next;
    }
}
