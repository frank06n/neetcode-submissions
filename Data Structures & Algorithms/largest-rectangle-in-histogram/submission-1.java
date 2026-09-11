class Solution {
    public int largestRectangleArea(int[] hts) {
        Stack<Integer> s = new Stack<Integer>();
        int maxA = 0;
        
        // int[] rbn = new int[hts.length];
        // int[] lbn = new int[hts.length];

        // for (int i=0; i<hts.length; i++)
        // {
        //     while (!s.isEmpty() && hts[i] < hts[s.peek()])
        //     {
        //         rbn[s.pop()] = i-1;
        //     }
        //     s.push(i);
        // }

        // while (!s.isEmpty())
        // {
        //     rbn[s.pop()] = hts.length-1;
        // }
        
        // for (int i=hts.length-1; i>=0; i--)
        // {
        //     while (!s.isEmpty() && hts[i] < hts[s.peek()])
        //     {
        //         lbn[s.pop()] = i+1;
        //     }
        //     s.push(i);
        // }
        // while (!s.isEmpty())
        // {
        //     lbn[s.pop()] = 0;
        // }

        // for (int i=0; i<hts.length; i++)
        // {
        //     int area = (rbn[i]-lbn[i]+1) * hts[i];
        //     maxA = Math.max(maxA, area);
        // }

        for (int i = 0; i <= hts.length; i++) {
            int curr = (i == hts.length) ? 0 : hts[i];

            while (!s.isEmpty() && curr < hts[s.peek()]) {
                int x = s.pop();

                int left = s.isEmpty() ? -1 : s.peek();
                int width = i - left - 1;

                maxA = Math.max(maxA, hts[x] * width);
            }

            s.push(i);
        }

        return maxA;
    }
}
