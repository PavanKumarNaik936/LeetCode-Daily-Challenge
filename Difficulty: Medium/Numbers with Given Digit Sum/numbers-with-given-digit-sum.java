class Solution {
    public int countWays(int n, int sum) {
        // code here
        int[][]dp = new int[10][100];
        for(int[]r:dp){
            Arrays.fill(r,-1);
        }
        int ans = 0;
        for(int i=1;i<=9;i++){
            if(sum>=i){
                ans+=count(n-1,sum-i,dp);
            }else
                break;
        }
        if(ans==0)return -1;
        return ans;
    }
    public int count(int n,int sum,int[][]dp){
        if(n==0){
            if(sum==0)
                return 1;
            return 0;
        }
        
        if(dp[n][sum]!=-1)
            return dp[n][sum];
        int ans = 0;
        for(int i=0;i<=9;i++){
            if(sum>=i){
                ans+=count(n-1,sum-i,dp);
            }else
                break;
        }
        return dp[n][sum]=ans;
    }
};