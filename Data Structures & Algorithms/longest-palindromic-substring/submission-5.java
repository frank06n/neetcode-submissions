class Solution {
    String s;
    String ans;
    public String longestPalindrome(String s) {
        if (s.length() == 1) return s;

        this.s = s;
        ans = ""+s.charAt(0);
        
        checkPalin(0, 1);
        for (int k=1; k+1<s.length(); k++) {
            checkPalin(k, 0);
            checkPalin(k, 1);
        }

        return ans;
    }

    void checkPalin(int i, int ex)
    {
        // System.out.printf("check[%d] '%s': ", i, s.substring(i, i+ex+1));
        int k;
        for (k=0; i-k>=0 && i+ex+k<s.length(); k++)
            if (s.charAt(i-k) != s.charAt(i+ex+k))
                break;
        k = k-1;
        // System.out.printf("\t max[%d]: %s\n", k, s.substring(i-k, i+ex+k+1));
        if (1+ex+2*k > ans.length()) ans = s.substring(i-k, i+ex+k+1);
    }
}
