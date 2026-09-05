class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n = nums.length;
        int[]prefix = new int[n];
        prefix[0] = nums[0];
        int[]suffix = new int[n];
        suffix[n-1] = nums[n-1];
        for(int i=1;i<n;i++){
            prefix[i] = Math.max(prefix[i-1],nums[i]);
        }
        for(int i=n-2;i>=0;i--){
            suffix[i] =Math.min(suffix[i+1],nums[i]); 
        }
        int res = k+1;
        int idx = -1;
        for(int i=0;i<n;i++){
            int score = prefix[i]-suffix[i];
            if(score<=k && score<res){
                idx = i;
                res = score;
                break;
            }
        }
        return idx;
    }
}