class Solution {
    static final String SEP = "é";
    public String encode(List<String> strs) {
        int n = strs.size();
        String out = "";
        for (int i=0; i<n; i++) {
            out += strs.get(i);
                    // .replaceAll("<", "<<")
                    // .replaceAll("&", "<amp")
            // if (i != n-1) 
            out += SEP;
        }
        return "x"+SEP+out+"x";
    }

    public List<String> decode(String str) {
        String items[] = str.split(SEP);
        List<String> out = new ArrayList(Arrays.asList(items));
        out.remove(out.size()-1);
        out.remove(0);
        return out;
    }
}
