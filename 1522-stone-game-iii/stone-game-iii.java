class Solution {
    public String stoneGameIII(int[] stoneValue) {
        long totalValue = 0;
        long[][]dp = new long[stoneValue.length][2];
        for(long[] r:dp){
            Arrays.fill(r,-1);
        }
        for(int x:stoneValue){
            totalValue+=x;
        }
        long alice = findAlice(0,0,stoneValue,dp);
        long bob = totalValue-alice;
        if(alice>bob){
            return "Alice";
        }else if(alice<bob){
            return "Bob";
        }else
            return "Tie";
    }
    // this method will find max alice value
    public long findAlice(int i,int person,int[]stoneValue,long[][]dp){
        if(i>=stoneValue.length)
            return 0;
        if(dp[i][person]!=-1)
            return dp[i][person];
        long best;
        if(person==0){
            //alice turn 
            best = Long.MIN_VALUE;
            long sum = 0;
            for(int x=1;x<=3 && x+i<=stoneValue.length;x++){
                sum+=stoneValue[i+x-1];
                long alice = sum+findAlice(i+x,1,stoneValue,dp);
                best = Math.max(best,alice);
            }
        }else{
            best = Long.MAX_VALUE;
            for(int x=1;x<=3 && x+i<=stoneValue.length;x++){
                long alice = findAlice(i+x,0,stoneValue,dp);
                best = Math.min(best,alice);
            }
        }
        return dp[i][person] =best;
    }
}