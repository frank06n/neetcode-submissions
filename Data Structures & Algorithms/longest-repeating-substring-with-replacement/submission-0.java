class Solution {
    public int characterReplacement(String s, int k) {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();

        int l=0, r=0;
        int maxF = 1;
        while (r<s.length()) {
            char c = s.charAt(r);
            int f = 1 + map.getOrDefault(c, 0);
            map.put(c, f);
            int L = r-l+1;
            maxF = Math.max(maxF, f);
            if (L - maxF > k) { // while window is INVALID
                char c2 = s.charAt(l);
                // System.out.println("INVALID when " + c + " added from " + r + " ; remove " + c2 + " at " + l + " :: max- "+maxF+" L-"+L);
                map.put(c2, map.get(c2) - 1);
                l++;
            }
            else {
                // System.out.println("valid when " + c + " added from " + r + " ; add next :: max- "+maxF+" L-"+L);
                }
                r++;
        }

        return Math.min(maxF+k, s.length());
    }
}
