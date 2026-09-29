class Solution {
    public boolean hasValidPath(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        Boolean[][][]dp = new Boolean[n][m][n+m];
        if(grid[0][0]==')')
            return false;
        if((n+m-1)%2!=0)
            return false;
        return dfs(0,0,1,dp,grid);
    }
    boolean dfs(int r,int c,int bal,Boolean[][][]dp,char[][]grid){
        if(bal<0)
            return false;
        if (r >= grid.length || c >= grid[0].length)
            return false;

        if(r==grid.length-1 && c==grid[0].length-1){
            return bal==0;
        }
        
        if(dp[r][c][bal]!=null){
            return dp[r][c][bal];
        }
        //move down
        if(r+1<grid.length){
            int newBal = bal+(grid[r+1][c]=='('?1:-1);
            if(dfs(r+1,c,newBal,dp,grid)){
                return dp[r][c][bal] = true;
            }
        }
        
        //move right
        if(c+1<grid[0].length){
            int newBal = bal+(grid[r][c+1]=='('?1:-1);
            if(dfs(r,c+1,newBal,dp,grid)){
                return dp[r][c][bal] = true;
            }
        }
        
        return dp[r][c][bal]=false;
    }
}