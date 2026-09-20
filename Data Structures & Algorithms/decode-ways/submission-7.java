class Solution {
    public int numDecodings(String s) {
        if (s.charAt(0) == '0') return 0;
        int ans=1, ans2=1;

        int i=s.length()-1;
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
            else if (c==1)
            {
                if (i<s.length()-1) 
                {
                    // int c2 = Integer.parseInt(""+s.charAt(i+1));
                    newans = ans + ans2;
                }
            }
            else if (c==2)
            {
                if (i<s.length()-1) 
                {
                    int c2 = Integer.parseInt(""+s.charAt(i+1));
                    if (c2<7) newans = ans + ans2;
                }
            }

            ans2 = ans;
            ans = newans;
            i--;
        }

        return ans;
    }
}