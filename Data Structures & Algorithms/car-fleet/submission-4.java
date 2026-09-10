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

        Arrays.sort(x, (a,b) -> Integer.compare(b[0], a[0]));
        double front = time(0, x, t);
        int fleet = 1;

        for (int i=1; i<n; i++) 
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
