class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int pre[] = new int[n];
        int post[] = new int[n];
        for (int i=0; i<n; i++) {
            int pi = n-i-1;
            if (i==0) {
                pre[i] = post[pi] = 1;
                continue;
            }
            pre[i] = pre[i-1] * nums[i-1];
            post[pi] = post[pi+1] * nums[pi+1];
        }
        for (int i=0; i<n; i++) {
            nums[i] = pre[i] * post[i];
        }
        return nums;
    }
}  
