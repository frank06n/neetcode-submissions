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
    // return "prev" pointer = node before boundary (before reverse)
    ListNode reverseList(ListNode curr, ListNode boundary)
    {
        ListNode prev = null;
        while (curr != boundary)
        {
            ListNode t = curr.next;
            curr.next = prev;
            prev = curr;
            curr = t;
        }
        return prev;
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode ptr = dummy;

        while (ptr.next != null)
        {
            ListNode bnd = ptr.next;
            int i=0;
            while (i<k && bnd!=null) { bnd=bnd.next; i++; }
            if (i<k) break; // leave last few <k nodes as it is

            ListNode curr = ptr.next;
            ptr.next = reverseList(curr, bnd);
            curr.next = bnd;
            ptr = curr;
        }
        return dummy.next;
    }
}
