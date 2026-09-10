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

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1==null) return list2;
        if (list2==null) return list1;

        ListNode A, B;
        if (list1.val < list2.val)
        { A = list1; B = list2; }
        else
        { A = list2; B = list1; }
        ListNode head = A;

        while (A!=null & B!=null)
        {
            System.out.printf("A:%s; B:%s\n", plist(A), plist(B));
            
            if (A.next != null && B.val > A.next.val)
            {
                A = A.next;
                System.out.printf("A>>\n");
                continue;
            }
            else if (B.next != null && A.val > B.next.val)
            {
                B = B.next;
                System.out.printf("B>>\n");
                continue;
            }
            else 
            {
                ListNode tA,tB;
                
                tA = A.next;
                A.next = B;
                System.out.printf("A->B");
       
                if (tA == null) break;

                while (B.next!=null && B.next.val < tA.val)
                {
                    B = B.next;                    
                    System.out.printf("->B'");
                }

                tB = B.next;
                B.next = tA;

                System.out.printf("->An\n");

                if (tB == null) break;

                A=tA; B=tB;
                // if (tA.val < tB.val)
                // {A=tA; B=tB;}
                // else
                // {A=tB; B=tA;}
            }
        }




        return head;
    }
}