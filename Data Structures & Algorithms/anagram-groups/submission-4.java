class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap();

        for (String str : strs) {
            int freq[] = new int[26];
            for (char c : str.toCharArray()) {
                freq[c - 'a'] += 1;
            }
            String s = "";
            for (int f : freq) s += f + ",";

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
        for (String k : map.keySet()) {
            out.add(map.get(k));
        }
        return out;
    }
}
