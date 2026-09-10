class Solution {
    static final String SEP = "é";
    public String encode(List<String> strs) {
        String out = "x"+SEP;
        for (String s : strs) out += s + SEP;
        return out+"x";
    }

    public List<String> decode(String str) {
        String items[] = str.split(SEP);
        List<String> out = new ArrayList(Arrays.asList(items));
        out.remove(out.size()-1);
        out.remove(0);
        return out;
    }
}
