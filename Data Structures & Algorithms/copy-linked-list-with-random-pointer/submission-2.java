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
        HashMap<Node, Node> mapo2n = new HashMap<Node, Node>();
        Node ptr = head;

        while (ptr != null)
        {
            mapo2n.put(ptr, new Node(ptr.val));
            ptr = ptr.next;
        }

        for (Node n : mapo2n.keySet())
        {
            Node newn = mapo2n.get(n);
            newn.next = mapo2n.get(n.next);
            newn.random = mapo2n.get(n.random);
        }

        return mapo2n.get(head);
    }
}
