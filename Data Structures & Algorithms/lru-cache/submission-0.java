class Node
{
    int key;
    int val;
    Node next;
    Node prev;
}


class LRUCache {
    int cap;
    HashMap<Integer, Node> map;
    Node least;
    Node most;
    int used;

    public LRUCache(int capacity) {
        cap = capacity;
        map = new HashMap<>();
        least = null;
        used = 0;
    }

    void pln(Object o) {
        // System.out.println(o);
    }
    
    public int get(int key) {
        Node n = map.get(key);
        if (n == null) {
        pln("---GET " + key + "--- NOT FOUND");
            return -1;
        }

        pln("---GET " + key + "---");
        n = use(key);
        return n.val;
    }
    
    public void put(int key, int value) {
        pln("---PUT " + key + "--- | value = " + value);
        Node n = use(key);
        n.val = value;
    }

    public Node use(int key) {
        Node n = map.get(key);
        if (n == null) 
        {
            pln("put new key " + key);
            if (used == cap)
            {
                pln("reached cap; remove least used " + least==null?-1:least.key);
                map.remove(least.key);
                Node nl = least.next;
                if (nl!=null) nl.prev = null;
                least = nl;
                used --;
            }
            n = new Node();
            map.put(key, n);
            used ++;
            pln("used from cap " + used);
        }
        n.key = key;

        if (used == 1)
        {
            pln("used==1; least=most=" + n.key);
            least = most = n;
            return n;
        }
        if (n == most) {
            pln("already most (latest) used: " + n.key + "; return");
            return n;
        }

        Node prev = n.prev;
        Node next = n.next;

        if (prev!=null) prev.next = next;
        if (next!=null) next.prev = prev;
        
        if (n == least && next!=null) least = next;

        n.next = null;
        n.prev = most;
        most.next = n;
        most = n;

        pln("operation performed; now least = " + least.key + " most = " + most.key);

        return n;
    }
}
