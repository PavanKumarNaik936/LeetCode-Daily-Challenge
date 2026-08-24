class Solution {
    public int stoneGameVIII(int[] stones) {
        int[]prefixSum = new int[stones.length];
        prefixSum[0]=stones[0];
        for(int i=1;i<stones.length;i++){
            prefixSum[i]=prefixSum[i-1]+stones[i];
        }
        Integer[] dp = new Integer[stones.length];
        return solve(1,prefixSum,dp);
    }
    int solve(int i,int[]prefixSum,Integer[]dp){
        if(i==prefixSum.length-1)
            return prefixSum[i];
        if(dp[i]!=null)
            return dp[i];
        int take = prefixSum[i]-solve(i+1,prefixSum,dp);
        int skip = solve(i+1,prefixSum,dp);
        return dp[i]=Math.max(take,skip);
    }

}