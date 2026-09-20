class Solution {
    public int numDecodings(String s) {
        if (s.charAt(0) == '0') return 0;
        int ans=1, ans2=1;

        int L = s.length();
        int i = L-1;
        while (i>=0)
        {
            int newans = ans;
            int c = Integer.parseInt(""+s.charAt(i));

            if (c==0) {
                if (i==0) return 0; // starts with 0

                i--;
                int c2 = Integer.parseInt(""+s.charAt(i));
                newans = ans;
                ans = 0;

                if (c2!=1 && c2!=2) return 0; // cannot pair '00', '30', '40', ..
            }
            else if (i<s.length()-1)
            {
                int c2 = Integer.parseInt(""+s.charAt(i+1));
                if (c==1 || (c==2 && c2<7))
                {
                    newans = ans + ans2;
                }
            }

            ans2 = ans;
            ans = newans;
            i--;
        }

        return ans;
    }
}