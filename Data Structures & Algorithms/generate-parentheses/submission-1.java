class Solution {
    List<String> out;
    public List<String> generateParenthesis(int n) {
        out = new ArrayList<>();
        dfs(n, 0, new StringBuilder());
        return out;
    }

    // left = paranthesis left to open
    void dfs(int left, int open, StringBuilder curr)
    {
        if (left == 0 && open == 0)
        {
            out.add(curr.toString());
            return;
        }

        if (left > 0)
        {
            // open par
            curr.append("(");
            dfs(left-1, open+1, curr);
            curr.deleteCharAt(curr.length() - 1);
        }
        
        // close par if open avail
        if (open > 0)
        {
            curr.append(")");
            dfs(left, open-1, curr);
            curr.deleteCharAt(curr.length() - 1);
        }
    }
}
