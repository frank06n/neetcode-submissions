class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length())
            return false;

        int map[] = new int[26];
        for (int i = 0; i < s1.length(); i++) map[s1.charAt(i) - 'a']++;

        int l = 0, r = 0;

        int N = 0;
        while (r < s2.length()) {
            // if (N++ == 100) break;
            char c = s2.charAt(r);
            map[c - 'a']--;
            // if (map[c - 'a'] == 0 && l == r) {
            //     l++; r++;
            //     continue;
            // }
            if (map[c - 'a'] >= 0) {
                System.out.println("okay " + c + " " + l + " " + r);
                // map[c - 'a']--;
                if (r - l + 1 == s1.length())
                    return true;
            } else {
                System.out.print("not okay " + c + " ; remove ->");
                while (map[c - 'a'] < 0 && l <= r) {
                    System.out.print(s2.charAt(l) + " ");
                    map[s2.charAt(l) - 'a']++;
                    l++;
                }
                // if (l == r) {
                //     l++;
                //     r++;
                //     System.out.print(s2.charAt(l - 1) + " ");
                //     System.out.println();
                //     continue;
                // }
                System.out.println();
            }
            r++;
        }

        return false;
    }
}