class Solution {
    int MOD = 1_000_000_007;
    public int uniquePaths(int[][] grid) {
        int[][][]dp = new int[grid.length][grid[0].length][2];
        for(int[][]R:dp){
            for(int[]r:R){
                Arrays.fill(r,-1);
            }
        }
        return find(0,0,grid,-1,dp);
    }
    public int find(int r,int c,int[][]grid,int dir,int[][][]dp){
        if(r>=grid.length || c>=grid[0].length)
            return 0;
        if(r==grid.length-1 && c==grid[0].length-1){
            return 1;
        }
        
        if(dir!=-1 && dp[r][c][dir]!=-1)
            return dp[r][c][dir];
        //mirror
        int paths = 0;
        if(grid[r][c]==1){
            if(dir==0){
                paths = find(r,c+1,grid,1,dp)%MOD;
            }else if(dir==1){
                paths = find(r+1,c,grid,0,dp)%MOD;
            }
        }else{
            //nomral cell
            paths = (find(r,c+1,grid,1,dp)%MOD+find(r+1,c,grid,0,dp)%MOD)%MOD;
        }
        if(dir!=-1)
            dp[r][c][dir] = paths;
        return paths;
       
    }
}