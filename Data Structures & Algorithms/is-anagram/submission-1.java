class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i=0; i<s.length(); i++) {
            char c = s.charAt(i), d = t.charAt(i);
            if (c==d) continue;
            map.put(c, map.getOrDefault(c, 0)+1);
            map.put(d, map.getOrDefault(d, 0)-1);
        }
        for (char k : map.keySet()) 
            if (map.get(k) != 0) 
                return false;
        return true;
    }
}
