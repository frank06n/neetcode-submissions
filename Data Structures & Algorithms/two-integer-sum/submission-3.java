class Solution {
    // public int[] twoSum(int[] nums, int target) {
    //     int n = nums.length;
    //     int look[] = new int[n];
    //     int i=0, j=n-1;
    //     int out[] = new int[]{-1,-1};

    //     for (int k=0; k<n; k++) look[k] = nums[k];
    //     Arrays.sort(look);
        
    //     while (true) {
    //         int sum = look[i] + look[j];
    //         if (sum > target) j--;
    //         else if (sum < target) i++;
    //         else break;
    //     }
        
    //     for (int k=0; k<nums.length; k++) {
    //         if (i != -1 && look[i] == nums[k]) i = -1;
    //         else if (j != -1 && look[j] == nums[k]) j = -1;
    //         else continue;

    //         if (out[0] == -1) out[0] = k;
    //         else { out[1] = k; break; }
    //     }
    //     return out;
    // }
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap();
        for (int i=0; i<nums.length; i++) {
            int c = map.getOrDefault(nums[i], -1);
            if (c != -1) return new int[] {c, i};
            map.put(target-nums[i], i);
        }
        throw new RuntimeException("shouldn't occur");
    }
}
