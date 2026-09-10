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
    public boolean hasCycle(ListNode head) {
        ListNode sh = head;
        while (head != null && head.next != null)
        {
            head = head.next.next;
            sh = sh.next;
            if (sh == head) return true;
        }
        return false;
    }
}
