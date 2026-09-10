class MinStack {
    int list[];
    int min[];
    int i;

    public MinStack() {
        list = new int[10];
        min = new int[10];
        i = 0;
    }
    
    public void push(int val) {
        if (i==list.length) {
            int t[] = list;
            list = new int[t.length + 10];
            min = new int[t.length + 10];

            for (i=0; i<t.length; i++) {
                list[i] = t[i];
                min[i] = i==0 ? t[i] : Math.min(min[i-1], t[i]);
            }
        }
        list[i] = val;
        min[i] = i==0 ? val : Math.min(min[i-1], val);
        i++;
    }
    
    public void pop() {
        i--;
    }
    
    public int top() {
        return list[i-1];
    }
    
    public int getMin() {
        return min[i-1];
    }
}
