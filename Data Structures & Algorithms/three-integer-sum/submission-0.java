class Solution {
    // record Rec(int ix, int val) {}

    public List<List<Integer>> threeSum(int[] nums) {
        // Rec n2[] = new Rec[nums.length];
        // for (int i=0; i<nums.length; i++) n2[i] = new Rec(i, nums[i]);
        // Arrays.sort(n2, (a, b) -> a.val - b.val);
        
        Arrays.sort(nums);

        Set<List<Integer>> out = new HashSet<>();
        for (int i=0; i<nums.length; i++)
        {
            int t=0-nums[i], j=i+1, k=nums.length-1;
            while (j<k) {
                int sum = nums[j]+nums[k];
                if (sum<t) j++;
                else if (sum>t) k--;
                else {out.add(List.of(nums[i],nums[j],nums[k]));j++;k--;}
            }
        }
        return new ArrayList<>(out);
    }
}
