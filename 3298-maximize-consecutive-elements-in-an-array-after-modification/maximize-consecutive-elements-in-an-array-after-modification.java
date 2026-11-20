class Solution {
    public int maxSelectedElements(int[] nums) {
        Arrays.sort(nums);
        int ans = 0;
        int[]dp = new int[nums[nums.length-1]+2];
        for(int x:nums){
            int unchanged = dp[x-1]+1;
            int increased = dp[x]+1;
            dp[x] = Math.max(dp[x],unchanged);
            dp[x+1] = Math.max(dp[x+1],increased);
            ans = Math.max(ans,Math.max(dp[x],dp[x+1]));
        }
        return ans;
    }
}