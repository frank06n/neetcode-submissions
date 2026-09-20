class Solution {
    public int numDecodings(String s) {
        if (s.charAt(0) == '0') return 0;
        int b=1, a=1;

        int i = s.length()-1;
        while (i>=0)
        {
            int c = b;
            char ch = s.charAt(i);

            if (ch=='0') {
                if (i==0) return 0; // starts with 0

                i--;
                int cx = s.charAt(i);

                if (cx=='0' || cx>='3') return 0; // cannot pair '00', '30', '40', ..

                c = b;
                b = 0;
            }
            else if (i<s.length()-1)
            {
                int c2 = s.charAt(i+1);
                if (ch=='1' || (ch=='2' && c2<='6'))
                {
                    c = b + a;
                }
            }

            a = b;
            b = c;
            i--;
        }

        return b;
    }
}