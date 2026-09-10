class Solution {
    double time(int ix, int[][] data, int target) {
        return (target - data[ix][0])/(double)data[ix][1];
    }

    public int carFleet(int t, int[] position, int[] speed) {
        int n = position.length;
        int x[][] = new int[n][2];
        for (int i=0; i<n; i++) {
            x[i] = new int[]{position[i], speed[i]};
        }

        Arrays.sort(x, (a,b) -> a[0] - b[0]);
        double front = time(n-1, x, t);
        int fleet = 1;

        for (int i=n-2; i>=0; i--) 
        {
            double y = time(i, x, t);
            if (y>front) {
                front = y;
                fleet++;
            }
        }
        
        return fleet;
    }
}
