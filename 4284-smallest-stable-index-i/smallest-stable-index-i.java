class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int[]prefix = new int[nums.length];
        int[]suffix = new int[nums.length];
        prefix[0] = nums[0];
        suffix[nums.length-1] = nums[nums.length-1];
        for(int i=1;i<nums.length;i++){
            prefix[i] = Math.max(prefix[i-1],nums[i]);
        }
        for(int i=nums.length-2;i>=0;i--){
            suffix[i] = Math.min(suffix[i+1],nums[i]);
        }
        int res = Integer.MAX_VALUE;
        int idx = -1;
        for(int i=0;i<nums.length;i++){
            int instabilityScore = prefix[i]-suffix[i];
            if(instabilityScore<=k && instabilityScore<res){
                idx = i;
                res = instabilityScore;
                break;
            }
        }
        return idx;
    }
}