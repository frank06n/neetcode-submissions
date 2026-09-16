class Solution {
    List<String> out;
    public List<String> generateParenthesis(int n) {
        out = new ArrayList<>();
        dfs(n, 0, "");
        return out;
    }

    // left = paranthesis left to open
    void dfs(int left, int open, String curr)
    {
        if (left == 0)
        {
            while (open-- > 0) curr += ")";
            out.add(curr);
            return;
        }

        // open par
        dfs(left-1, open+1, curr+"(");

        // close par if open avail
        if (open > 0) dfs(left, open-1, curr+")");
    }
}
