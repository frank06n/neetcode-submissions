class Solution {
    String s;
    int ans;

    public int countSubstrings(String s)
    {
        this.s = s;
        
        for (int k=0; k<s.length(); k++) {
            checkPalin(k, 0);
            checkPalin(k, 1);
        }

        return ans;
    }

    void checkPalin(int i, int ex)
    {
        for (int k=0; i-k>=0 && i+ex+k<s.length(); k++)
            if (s.charAt(i-k) != s.charAt(i+ex+k))
                break;
            else
                ans++;
    }
}
