class Solution {
    public int numDistinct(String s, String t) {
        int[][]dp = new int[s.length()+1][t.length()+1];
        for(int[]r:dp)
            Arrays.fill(r,-1);
        return find(0,0,s,t,dp);
    }
    public int find(int i,int j,String s,String t,int[][]dp){
        if(j==t.length())
            return 1;
        if(i==s.length())
            return 0;
        if(dp[i][j]!=-1)
            return dp[i][j];
        int take = 0;
        if(s.charAt(i)==t.charAt(j)){
            take+=find(i+1,j+1,s,t,dp);
            take+=find(i+1,j,s,t,dp);
        }else
            take+=find(i+1,j,s,t,dp);
        return dp[i][j] = take;
    }
}