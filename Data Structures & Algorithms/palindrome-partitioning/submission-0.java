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

    boolean palin(int i, int j)
    {
        System.out.println("checkpalin: " + s.substring(i,j) + " i="+i+" j="+j);
        for (int k=i; k<i+(j-i)/2; k++)
        {
            if (s.charAt(k) != s.charAt(j-(k-i)-1)) return false;
        }
        System.out.println("..true");
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
