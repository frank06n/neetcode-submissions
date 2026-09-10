/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) return null;

        HashMap<Node, Node> mapo2n = new HashMap<Node, Node>();
        Node nhead = new Node(head.val);

        mapo2n.put(head, nhead);

        Node nptr = nhead; 
        Node ptr_ = head.next;

        while (ptr_ != null)
        {
            nptr.next = new Node(ptr_.val);
            nptr = nptr.next;
            mapo2n.put(ptr_, nptr);

            ptr_ = ptr_.next;
        }

        for (Node n : mapo2n.keySet())
        {
            Node newn = mapo2n.get(n);
            Node randptr = n.random == null ? null : mapo2n.get(n.random);
            newn.random = randptr;
        }

        return nhead;
    }
}
