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
}
