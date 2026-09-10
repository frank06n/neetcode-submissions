class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<Set<String>, List<String>> map = new HashMap();

        for (String str : strs) {
            Set<String> s = new HashSet();
            Map<Character, Integer> _m = new HashMap();
            for (char c : str.toCharArray()) {
                _m.put(c, _m.getOrDefault(c, 0)+1);
            }
            for (char c : _m.keySet()) s.add("" + c + _m.get(c));


            List<String> list;
            if (map.containsKey(s)) {
                list = map.get(s);
            }
            else {
                list = new ArrayList();
                map.put(s, list);
            }
            list.add(str);
        }

        List<List<String>> out = new ArrayList();
        for (Set k : map.keySet()) {
            out.add(map.get(k));
        }
        System.gc();
        return out;
    }
}
