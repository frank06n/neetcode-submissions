class Solution {
    public int largestRectangleArea(int[] hts) {
        Stack<Integer> s = new Stack<Integer>();
        int[] rbn = new int[hts.length];
        for (int i=0; i<hts.length; i++)
        {
            while (!s.isEmpty() && hts[i] < hts[s.peek()])
            {
                rbn[s.pop()] = i-1;
            }
            s.push(i);
        }

        while (!s.isEmpty())
        {
            rbn[s.pop()] = hts.length-1;
        }
        
        int[] lbn = new int[hts.length];
        for (int i=hts.length-1; i>=0; i--)
        {
            while (!s.isEmpty() && hts[i] < hts[s.peek()])
            {
                lbn[s.pop()] = i+1;
            }
            s.push(i);
        }
        while (!s.isEmpty())
        {
            lbn[s.pop()] = 0;
        }
        // System.out.println(Arrays.toString(lbn));
        // System.out.println(Arrays.toString(rbn));
        int maxA = 0;
        for (int i=0; i<hts.length; i++)
        {
            int area = (rbn[i]-lbn[i]+1) * hts[i];
            maxA = Math.max(maxA, area);
        }

        return maxA;
    }
}
