class Solution {
    public int[] dailyTemperatures(int[] t) {
        int res[] = new int[t.length];
        Stack<Integer> s = new Stack<>();

        int i=t.length-1;
        Stack<Integer> tmp = new Stack<>();

        while (i>=0) {
            if (s.empty()) {
                res[i] = 0;
                while (!tmp.empty()) tmp.pop();
                s.push(t[i]);
                i--;
            }
            else if (t[i] < s.peek()) {
                res[i] = 1+tmp.size();
                while (!tmp.empty()) s.push(tmp.pop());
                s.push(t[i]);
                i--;
            }
            else {
                tmp.push(s.pop());
            }
        }
        return res;
    }
}
