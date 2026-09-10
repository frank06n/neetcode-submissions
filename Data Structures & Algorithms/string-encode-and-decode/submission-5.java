class Solution {
    public String encode(List<String> strs) {
        String out = "";
        for (String s : strs) out += s.length() + "#" + s;
        return out;
    }

    public List<String> decode(String s) {
        List<String> out = new ArrayList<String>();
        int i=0;
        String ix = "";
        while (i<s.length())
        {
            while (s.charAt(i) != '#') ix += s.charAt(i++);
            out.add(s.substring(++i, i+=Integer.parseInt(ix))+(ix=""));
        }
        return out;
    }
}
