class Solution {
    public int longestPath(int[][] mat, int xs, int ys, int xd, int yd) {
        // code here
        if (mat[xs][ys] == 0 || mat[xd][yd] == 0)
            return -1;
        int[][]direction = {{-1,0},{0,1},{1,0},{0,-1}};
        boolean[][]vis = new boolean[mat.length][mat[0].length];
        int res = find(xs,ys,mat,xd,yd,direction,vis);
        return res;
    }
    int find(int r,int c,int[][]mat,int xd,int yd,int[][]direction,boolean[][]vis){
        
        
        if(r==xd && c==yd)
            return 0;
        vis[r][c]=true;
        int ans = -1;
        for(int[]dir:direction){
            int nx = dir[0]+r;
            int ny = dir[1]+c;
            if(nx>=0 && nx<mat.length && ny>=0 && ny<mat[0].length && !vis[nx][ny] && mat[nx][ny]==1){
                int curr = find(nx,ny,mat,xd,yd,direction,vis);
                if(curr!=-1)
                    ans = Math.max(curr+1,ans);
            }
        }
        vis[r][c]=false;
        return ans;
    }
}