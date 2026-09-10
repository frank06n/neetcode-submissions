class Pair {
    int k;
    String v;
    Pair(int k, String v) {
        this.k = k;
        this.v = v;
    }
}

class TimeMap {
    Map<String, List<Pair>> map;
    public TimeMap() {
        map = new HashMap<String, List<Pair>>();
    }
    
    public void set(String key, String value, int t) {
        List<Pair> list = map.get(key);
        if (list == null) list = new ArrayList<Pair>();
        list.add(new Pair(t, value));
        map.put(key, list);
    }
    
    public String get(String key, int t) {
        // display();
        List<Pair> list = map.get(key);
        if (list == null) return "";

        int l=0, r=list.size()-1;
        String best = "";
        while (l<=r)
        {
            int m = (l+r)/2;
            int mk = list.get(m).k;
            if (mk > t)
            {
                r = m-1;
            }
            else if (mk < t)
            {
                best = list.get(m).v;
                l = m+1;
            }
            else // if found
            {
                return list.get(m).v;
            }
        }
        return best;
    }

    void display() {
        if (map == null || map.isEmpty()) {
            System.out.println("TimeMap is empty.");
            return;
        }

        for (Map.Entry<String, List<Pair>> entry : map.entrySet()) {
            String key = entry.getKey();
            List<Pair> list = entry.getValue();

            System.out.print(key + ": [");
            for (int i = 0; i < list.size(); i++) {
                Pair pair = list.get(i);
                System.out.print("(" + pair.k + ", \"" + pair.v + "\")");
                if (i < list.size() - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println("]");
        }
    }
}
