class Solution {
    public int stoneGameII(int[] piles) {
        // 0->alice turn    1->bobs turn 
        int[][][]dp = new int[piles.length][piles.length+1][2];
        for(int[][]R:dp){
            for(int[]r:R){
                Arrays.fill(r,-1);
            }
        }
        return solve(0,0,1,piles,dp);
    }
    public int solve(int i,int person,int M,int[]piles,int[][][]dp){
        if(i>=piles.length)
            return 0;
        if(dp[i][M][person]!=-1)
            return dp[i][M][person];
        int best;
        if(person==0){
            best = 0;
            int sum = 0;
            for(int x=1; x<=2*M && i+x<=piles.length ; x++){
                int newM = Math.max(x,M);
                sum+=piles[i+x-1];
                int alice = sum+solve(i+x,1,newM,piles,dp);
                best = Math.max(best,alice);
            }
        }else{
            best = Integer.MAX_VALUE;
            for(int x=1;x<=2*M && i+x<=piles.length ;x++){
                int newM = Math.max(x,M);
                int alice = solve(i+x,0,newM,piles,dp);
                best = Math.min(best,alice);
            }
        }
        return dp[i][M][person]=best;
    }
}