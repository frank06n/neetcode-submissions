class Solution {
    public int trap(int[] h) {
        int[][] map = new int[h.length][2]; // index: [max, real]
        int max=0, lvl=h[0], v=0;
        for (int i=0; i<h.length; i++) {
            if (h[i] < lvl) lvl = h[i];
            if (h[i] >= max) {
                for (int j=i-1; j>=0 && map[j][0]==max; j--) {
                    v += max - map[j][1]; // volume added
                    map[j][1] = max;//updating, but i dont think will be used
                }
                lvl = h[i]; // reset level (previous sections dealt, ignore)
                max = h[i];
            }
            else if (h[i] > lvl) {
                for (int j=i-1; j>=0 && h[j]<h[i]; j--) {
                    v += h[i] - map[j][1]; // volume added
                    map[j][1] = h[i];
                }
                lvl = h[i];
            }
            map[i] = new int[]{max, h[i]}; // touching baseline, no volume added
        }
        return v;
    }
}
