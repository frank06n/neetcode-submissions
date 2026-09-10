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
    public ListNode reverseList(ListNode head) {
        if (head == null) return null;

        ListNode one = null;
        ListNode two = head;

        while (two != null) {
            ListNode three = two.next;
            two.next = one;
            // if (one == head) one.next = null;
            one = two;
            two = three;
        }

        return one;
    }
}
