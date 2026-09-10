class Solution {
    public String encode(List<String> strs) {
        StringBuilder out = new StringBuilder();
        for (String s : strs) out.append(s.length()).append('#').append(s);
        return out.toString();
    }

    public List<String> decode(String s) {
        List<String> out = new ArrayList<String>();
        int i=0;
        String ix = "";
        while (i<s.length())
        {
            while (s.charAt(i) != '#') ix += s.charAt(i++);

            int len = Integer.parseInt(ix);
            out.add(s.substring(i+1, i+1+len));
            ix = "";
            i += 1+len;
        }
        return out;
    }
}
