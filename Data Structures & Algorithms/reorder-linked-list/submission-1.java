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
    String plist(ListNode head)
{
if (head==null) return "x";
String out="";

    while (head.next!=null)
    {
        out += head.val + "->";
        head = head.next;
    }
    out += head.val;
    return out;
}
    public void reorderList(ListNode head) {
        // int len=0;
        // ListNode t1 = head, t2;
        // while (t1 != null) {
        //     len++; 
        //     t1 = t1.next;
        // }
        
        // len = (len-1)/2;
        // t1 = head;
        // while (len-- > 0) t1 = t1.next;

        ListNode t1 = head, t2 = head;
        while (t2!=null)
        {
            if (t2.next == null || t2.next.next == null) break;

            t1 = t1.next;
            t2 = t2.next==null ? null : t2.next.next;
        }
        // System.out.println(plist(t2));

        t2 = t1.next; // curr
        t1.next = null;

        
        // System.out.println(plist(head));
        // System.out.println(plist(t2));

        t1 = null; // prev
        while (t2 != null)
        {
            ListNode t0 = t2.next;
            t2.next = t1;
            t1 = t2;
            t2 = t0;
        }

        t2 = head;

        

        while (t2 != null)
        {
            ListNode t0 = t2.next;
            ListNode tA = t1 == null ? null : t1.next;
            t2.next = t1;
            if (t1 != null) t1.next = t0;
            
            t2 = t0;
            t1 = tA;
        }
    }
}
