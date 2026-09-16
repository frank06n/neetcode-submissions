class Solution {
    final char MAP[][] =  {
        {'a', 'b', 'c'},
        {'d', 'e', 'f'},
        {'g', 'h', 'i'},
        {'j', 'k', 'l'},
        {'m', 'n', 'o'},
        {'p', 'q', 'r', 's'},
        {'t', 'u', 'v'},
        {'w', 'x', 'y', 'z'},
    };
    List<String> out;
    StringBuilder sb;
    String digits;
    public List<String> letterCombinations(String digits) {
        out = new ArrayList<>();
        if (digits.length() == 0) return out;

        sb = new StringBuilder();
        this.digits = digits;

        run(0);
        return out;
    }

    void run(int i)
    {
        if (i==digits.length())
        {
            out.add(sb.toString());
            return;
        }

        int n = digits.charAt(i)-'2';
        for (char c : MAP[n])
        {
            sb.append(c);
            run(i+1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
