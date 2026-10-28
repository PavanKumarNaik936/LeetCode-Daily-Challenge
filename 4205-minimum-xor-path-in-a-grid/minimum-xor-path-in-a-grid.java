class Solution {
    public int minCost(int[][] grid) {
        boolean[][][]dp = new boolean[grid.length][grid[0].length][1024];
        find(0,0,grid,dp,0);
        for(int i=0;i<1024;i++){
            if(dp[grid.length-1][grid[0].length-1][i]==true)
                return i;
        }
        return -1;
    }
    void find(int r,int c,int[][]grid,boolean[][][]dp,int xor){
        int currXor = xor^grid[r][c];
        if(dp[r][c][currXor])
            return;
        dp[r][c][currXor] = true;
        if(r==grid.length-1 && c==grid[0].length-1)
            return;
        //down
        if(r+1<grid.length)
            find(r+1,c,grid,dp,currXor);
        if(c+1<grid[0].length)
            find(r,c+1,grid,dp,currXor);
    }
}