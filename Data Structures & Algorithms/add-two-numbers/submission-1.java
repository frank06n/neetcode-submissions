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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode();
        ListNode ptr = dummy;
        int carry = 0;
        while (l1!=null || l2!=null)
        {
            int x = l1==null ? 0 : l1.val;
            int y = l2==null ? 0 : l2.val;
            int sum = x+y+carry;
            carry = sum/10;
            ptr.next = new ListNode(sum%10);
            ptr = ptr.next;
            l1 = l1==null?null:l1.next;
            l2 = l2==null?null:l2.next;
        }
        if (carry>0) ptr.next = new ListNode(carry);

        return dummy.next;
    }
}
