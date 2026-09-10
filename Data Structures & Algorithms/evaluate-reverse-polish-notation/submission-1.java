class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> nums = new Stack<>();
        for (String s : tokens) {
            int val = -999, a,b;
            try {
                val = Integer.parseInt(s);
            }
            catch (Exception e) {}
            if (val != -999) {
                nums.push(val);
            }
            else {
                b = nums.pop();
                a = nums.pop();
                if (s.equals("+")) nums.push(a+b);
                if (s.equals("-")) nums.push(a-b);
                if (s.equals("*")) nums.push(a*b);
                if (s.equals("/")) nums.push(a/b);
            }
        }
        return nums.pop();
    }
}
