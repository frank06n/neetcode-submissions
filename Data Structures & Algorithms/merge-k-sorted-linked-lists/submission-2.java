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
    ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(0);
        ListNode node = dummy;

        while (list1 != null || list2 != null)
        {
            if (list1==null) {node.next = list2; break;}
            if (list2==null) {node.next = list1; break;}
            if (list1.val < list2.val) {
                node.next = list1;
                list1 = list1.next;
            }
            else
            {
                node.next = list2;
                list2 = list2.next;
            }
            node = node.next;
        }

        return dummy.next;
    }
    ListNode mergeKListsX(ListNode[] lists, int start, int end)
    {
        int len = end - start + 1;
        if (len == 1) return lists[start];

        int m = (start + end)/2;
        ListNode left = mergeKListsX(lists, start, m);
        ListNode right = mergeKListsX(lists, m+1, end);
        return mergeTwoLists(left, right);
    }
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) return null;
        if (lists.length == 1) return lists[0];
        
        return mergeKListsX(lists, 0, lists.length-1);
    }
}


// class Solution2 {
//     String plist(ListNode head)
//     {
//         if (head==null) return "x";
//         String out="";

//         while (head.next!=null)
//         {
//             out += head.val + "->";
//             head = head.next;
//         }
//         out += head.val;
//         return out;
//     }

//     public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
//         if (list1==null) return list2;
//         if (list2==null) return list1;

//         ListNode A, B;
//         if (list1.val < list2.val)
//         { A = list1; B = list2; }
//         else
//         { A = list2; B = list1; }
//         ListNode head = A;

//         while (A!=null & B!=null)
//         {
//             System.out.printf("A:%s; B:%s\n", plist(A), plist(B));
            
//             if (A.next != null && B.val > A.next.val)
//             {
//                 A = A.next;
//                 System.out.printf("A>>\n");
//                 continue;
//             }
//             else if (B.next != null && A.val > B.next.val)
//             {
//                 B = B.next;
//                 System.out.printf("B>>\n");
//                 continue;
//             }
//             else 
//             {
//                 ListNode tA,tB;
                
//                 tA = A.next;
//                 A.next = B;
//                 System.out.printf("A->B");
       
//                 if (tA == null) break;

//                 while (B.next!=null && B.next.val < tA.val)
//                 {
//                     B = B.next;                    
//                     System.out.printf("->B'");
//                 }

//                 tB = B.next;
//                 B.next = tA;

//                 System.out.printf("->An\n");

//                 if (tB == null) break;

//                 A=tA; B=tB;
//             }
//         }

//         return head;
//     }
// }