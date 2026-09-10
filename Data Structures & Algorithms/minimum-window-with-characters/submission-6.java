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
        String out=s+s;

        while (r<s.length())
        {
            // System.out.println(";");
            char c = s.charAt(r);
            int f = fn_f(c);
            if (f == -1) // char not present in t
            {
                // System.out.println("..");
                if (l==r) {l++; r++;}
                else r++;
                continue;
            }
            fn_inc(c);

            // System.out.println("c: "+c+" f: "+f+" f2: "+f2);


            Character c8 = q.peek();
            // System.out.println("** peeked = "+c8+" xf2: "+map2.get(c8));
            while (c8 != null && fn_f2(c8) > fn_f(c8))
            {
                // System.out.println("** skipping "+c8);
                if (s.charAt(l) == c8)
                {
                    fn_dec(c8);
                    c8 = q.peek();
                    // System.out.println("** peeked = "+c8+" xf2: "+map2.get(c8));
                }
                l++;
            }

            // remove extra chars
            while (
                fn_f(s.charAt(l)) == -1
                && l < r
            ) l++;

            r++;
            // if (map2.getOrDefault(c, 0) >= f) // perform check for valid substring
            // {
            //     boolean is_invalid = false;
            //     for (char c3 : t.toCharArray()) {
            //         int _f = map.get(c3);
            //         int _f2 = map2.getOrDefault(c3, 0);
            //         if (_f2 < _f) {
            //             is_invalid = true;
            //             break;
            //         }
            //     }
            //     // System.out.println("VALID "+ (!is_invalid) + "; " + ((!is_invalid) ? s.substring(l,r) : ""));
            //     if (!is_invalid && r-l < out.length()) out = s.substring(l,r);
            // }
            if (net == t.length() && r-l < out.length())
            {
               out = s.substring(l,r);
            }
        }

        if (out.length() == s.length()*2)
            return "";
        return out;
    }
}
