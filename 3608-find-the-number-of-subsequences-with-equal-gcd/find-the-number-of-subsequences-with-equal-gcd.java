class Solution {
    int MOD = 1_000_000_007;
    public int subsequencePairCount(int[] nums) {
        int[][][]dp = new int[nums.length][201][201];
        for(int[][]R:dp){
            for(int[]r:R){
                Arrays.fill(r,-1);
            }
        }
        return solve(nums,dp,0,0,0);
    }
    public int solve(int[]nums,int[][][]dp,int i,int seq1,int seq2){
        if(i==nums.length){
            if(seq1==seq2  && seq1!=0)
                return 1;
            return 0;
        }
        if(dp[i][seq1][seq2]!=-1)
            return dp[i][seq1][seq2];
        int ans = 0;
        ans=(ans+solve(nums,dp,i+1,seq1,seq2));//skip current element
        ans = (ans+solve(nums,dp,i+1,gcd(seq1,nums[i]),seq2))%MOD; //take in seq1
        ans = (ans+solve(nums,dp,i+1,seq1,gcd(seq2,nums[i])))%MOD;//take in seq2
        return dp[i][seq1][seq2]=ans;
    }
    public int gcd(int a,int b){
        if(b==0)
            return a;
        return gcd(b,a%b);
    }
}