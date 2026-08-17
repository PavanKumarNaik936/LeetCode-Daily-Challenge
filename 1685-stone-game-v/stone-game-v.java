class Solution {
    public int stoneGameV(int[] stoneValue) {
        int n = stoneValue.length;
        int[]prefixSum = new int[n];
        prefixSum[0]=stoneValue[0];
        int[][]dp = new int[n+1][n+1];
        for(int[]row:dp){
            Arrays.fill(row,-1);
        }
        for(int i=1;i<n;i++){
            prefixSum[i]= prefixSum[i-1]+stoneValue[i];
        }
        return solve(0,n-1,prefixSum,stoneValue,dp);
    }
    public int solve(int l,int r,int[]prefix,int[]stoneValue,int[][]dp){
        if(dp[l][r]!=-1)
            return dp[l][r];
        int score = 0;
        for(int mid=l;mid<=r-1;mid++){

            int leftSum = (l==0)?prefix[mid]:prefix[mid]-prefix[l-1];     // l-->mid
            int rightSum = prefix[r]-prefix[mid];       // mid+1 -->r
            if(leftSum<rightSum){
                score = Math.max(score,leftSum+solve(l,mid,prefix,stoneValue,dp));
            }else if(rightSum<leftSum){
                score = Math.max(score,rightSum+solve(mid+1,r,prefix,stoneValue,dp));
            }else{
                score = Math.max(score,leftSum+solve(l,mid,prefix,stoneValue,dp));
                score = Math.max(score,rightSum+solve(mid+1,r,prefix,stoneValue,dp));
            }
        }
        return dp[l][r]=score;
    }
}