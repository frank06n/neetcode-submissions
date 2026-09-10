class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length, m = matrix[0].length;
        int l=0, r=m*n-1;

        while (l<=r)
        {
            int i = (l+r)/2;
            int v = matrix[i/m][i%m];
            System.out.println(i+" "+v);
            if (target == v) return true;
            else if (target < v) r = i-1;
            else l = i+1;
        }
        return false;
    }
}
