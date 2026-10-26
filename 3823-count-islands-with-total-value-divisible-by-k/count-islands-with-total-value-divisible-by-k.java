class Solution {
    class Pair{
        int row;
        int col;
        Pair(int row,int col){
            this.row = row;
            this.col = col;
        }
    }
    public int countIslands(int[][] grid, int k) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][]vis = new boolean[n][m];
        int c = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]!=0 && !vis[i][j]){
                    long sum = bfs(i,j,grid,vis);
                    if(sum%k==0)
                        c++;
                }
            }
        }
        return c;
    }
    long bfs(int i,int j,int[][]grid,boolean[][]vis){
        vis[i][j]=true;
        Queue<Pair>q = new LinkedList<>();
        int[][] delta = {{-1,0},{0,1},{1,0},{0,-1}};
        long sum = grid[i][j];
        q.offer(new Pair(i,j));
        while(!q.isEmpty()){
            Pair p = q.poll();
            for(int[]d:delta){
                int newR = p.row+d[0];
                int newC = p.col+d[1];
                if(newR<0 || newR>=grid.length || newC<0 || newC>=grid[0].length)
                    continue;
                if(grid[newR][newC]==0 || vis[newR][newC])
                    continue;
                sum+=grid[newR][newC];
                vis[newR][newC]=true;
                q.offer(new Pair(newR,newC));
            }
        }
        return sum;
    }
}