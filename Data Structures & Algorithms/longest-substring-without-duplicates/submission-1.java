class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) return 0;
        
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int l=0, r=1, maxl=1;

        while (r<=s.length()) {
            char c = s.charAt(r-1);
            if (map.containsKey(c)) {
                int ix = map.get(c);
                while (l <= ix) {
                    map.remove(s.charAt(l));
                    l++;
                }
            }
            else {
                map.put(c, r-1);
                if (r-l > maxl) maxl = r-l;
                r++;
            }
        }
        return maxl;
    }
}
