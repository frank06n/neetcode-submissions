class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c=='(' || c=='{' || c=='[')  {
                st.push(c);
                continue;
            }
            if (st.empty()) return false;
            char d = st.pop();
            boolean matching = d=='(' && c==')' ||
                            d=='{' && c=='}' ||
                            d=='[' && c==']';
            if (!matching) return false;
        }
        return st.empty();
    }
}
