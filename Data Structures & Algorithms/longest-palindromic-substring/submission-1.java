class Solution {
    String s;
    String ans;
    public String longestPalindrome(String s) {
        this.s = s;
        ans = ""+s.charAt(0);
        
        largePalin2(s, 0);
        for (int k=1; k+1<s.length(); k++)
        {
            largePalin(s, k);
            largePalin2(s, k);
        }

        return ans;
    }

    void largePalin(String s, int i)
    {
        // System.out.printf("check[%d] '%c': ", i, s.charAt(i));
        int k;
        for (k=1; i-k>=0 && i+k<s.length(); k++)
            if (s.charAt(i-k) != s.charAt(i+k))
                break;
        k = k-1;
        // System.out.printf("\t max[%d]: %s\n", k, s.substring(i-k, i+k+1));
        if (1+2*k > ans.length()) ans = s.substring(i-k, i+k+1);
    }

    void largePalin2(String s, int i)
    {
        if (s.length()<2 || i+1>=s.length()) return;
        // System.out.printf("check[%d] '%c%c': ", i, s.charAt(i), s.charAt(i+1));
        int k;
        for (k=0; i-k>=0 && i+1+k<s.length(); k++)
            if (s.charAt(i-k) != s.charAt(i+1+k))
                break;
        k = k-1;
        // System.out.printf("\t max[%d]: %s\n", k, k!=-1 ? s.substring(i-k, i+1+k+1) : "+");
        if (2+2*k > ans.length()) ans = s.substring(i-k, i+1+k+1);
    }
}
