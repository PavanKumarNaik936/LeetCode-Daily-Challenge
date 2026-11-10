class Solution {
    public int climbStairs(int n, int[] costs) {
        int[]dp = new int[n];
        dp[0] = costs[0]+1;
        if(n>1)
            dp[1] = costs[1]+Math.min(dp[0]+1,4);
        if(n>2)
            dp[2] = costs[2]+Math.min(dp[1]+1,Math.min(dp[0]+4,9));
        for(int i=3;i<n;i++){
            int step1 = dp[i-1]+1;
            int step2 = dp[i-2]+4;
            int step3 = dp[i-3]+9;
            dp[i] = costs[i]+Math.min(step1,Math.min(step2,step3));
        }
        for(int x:dp)System.out.println(x);
        return dp[n-1];
    }
}