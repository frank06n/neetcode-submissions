class Solution {
    public int maxArea(int[] h) {
        int i=0, j=h.length-1;
        int max = 0;
        while (i<j) {
            int min = Math.min(h[i], h[j]);
            int area = (j-i)*min;
            if (area > max) max = area;
            if (min==h[i]) i++;
            else j--;
        }
        System.gc();
        return max;
    }
}
