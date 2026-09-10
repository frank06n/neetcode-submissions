class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0)+1);
        }
        for (char c : t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0)-1);
        }
        for (char k : map.keySet()) 
            if (map.get(k) != 0) 
                return false;
        return true;
    }
}
