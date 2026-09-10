class Solution {
    HashMap<Character, Integer> map, map2;
    Queue<Character> q;
    int net;

    int fn_f(char c) {
        return map.getOrDefault(c, -1);
    }
    // For the following functions, required fn_f != -1
    int fn_f2(char c) {
        return map2.getOrDefault(c, 0);
    }
    void fn_inc(char c) {
        int f2 = fn_f2(c) + 1;
        map2.put(c, f2);
        q.offer(c);
        if (f2 <= fn_f(c)) net++;
    }
    void fn_dec(char c) {
        int f2 = fn_f2(c) - 1;
        map2.put(c, f2);
        q.poll();
        if (f2 < fn_f(c)) net--;
    }

    public String minWindow(String s, String t) {
        map = new HashMap<Character, Integer>();
        map2 = new HashMap<Character, Integer>();
        q = new LinkedList<Character>();
        net = 0;

        for (char c : t.toCharArray()) {
            map.put(c, 1 + map.getOrDefault(c, 0));
        }
        
        int l=0, r=0;
        String out=null;

        while (r<s.length())
        {
            char c = s.charAt(r);
            int f = fn_f(c);
            if (f == -1) // char not present in t
            {
                if (l==r) {l++; r++;}
                else r++;
                continue;
            }
            fn_inc(c);



            Character c8 = q.peek();
            while (c8 != null && fn_f2(c8) > fn_f(c8))
            {
                if (s.charAt(l) == c8)
                {
                    fn_dec(c8);
                    c8 = q.peek();
                }
                l++;
            }

            // remove extra chars
            while (
                l < r &&
                fn_f(s.charAt(l)) == -1
            ) l++;

            r++;
            if (net == t.length() && (out == null || r-l < out.length()))
            {
               out = s.substring(l,r);
            }
        }

        return out == null ? "" : out;
    }
}
