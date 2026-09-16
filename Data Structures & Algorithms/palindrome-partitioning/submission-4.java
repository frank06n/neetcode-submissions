class Solution {
    List<List<String>> out;
    List<String> curr;
    String s;
    public List<List<String>> partition(String s) {
        out = new ArrayList<>();
        curr = new ArrayList<>();
        this.s = s;
        dfs(0);
        return out;
    }

    boolean palin(int a, int b)
    {
        int len = b-a;
        for (int i=0; i<len/2; i++)
        {
            if (s.charAt(a+i) != s.charAt(a+len-i-1)) return false;
        }
        return true;
    }

    void dfs(int i)
    {
        if (i==s.length()) 
        {
            out.add(new ArrayList<>(curr));
            return;
        }

        for (int j=i+1; j<=s.length(); j++)
        {
            if (!palin(i, j)) continue;
            curr.add(s.substring(i,j));
            dfs(j);
            curr.remove(curr.size() - 1);
        }
    }


}
