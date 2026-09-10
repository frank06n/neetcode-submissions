class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<Map<Character, Integer>, List<String>> map = new HashMap();

        for (String str : strs) {
            Map<Character, Integer> _m = new HashMap();
            for (char c : str.toCharArray()) {
                _m.put(c, _m.getOrDefault(c, 0)+1);
            }

            List<String> list;
            if (map.containsKey(_m)) {
                list = map.get(_m);
            }
            else {
                list = new ArrayList();
                map.put(_m, list);
            }
            list.add(str);
        }

        List<List<String>> out = new ArrayList();
        for (Map k : map.keySet()) {
            out.add(map.get(k));
        }
        return out;
    }
}
