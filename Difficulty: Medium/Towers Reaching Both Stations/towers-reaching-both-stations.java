class Solution {
    public int countCoordinates(int[][] mat) {
        // code here
        int n = mat.length;
        int m = mat[0].length;
        int[][]direction = {{-1,0},{0,1},{1,0},{0,-1}};
        boolean[][]pv = new boolean[n][m];
        boolean[][]qv = new boolean[n][m];
        Queue<int[]>p = new ArrayDeque<>();
        Queue<int[]>q = new ArrayDeque<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(i==0 || j==0){
                    p.offer(new int[]{i,j});
                    pv[i][j]=true;
                }
                if(i==n-1 || j==m-1){
                    q.offer(new int[]{i,j});
                    qv[i][j]=true;
                }
            }
        }
        while(!p.isEmpty()){
            int[]pos = p.poll();
            for(int[]dir:direction){
                int nx = pos[0]+dir[0];
                int ny = pos[1]+dir[1];
                if(nx>=0 && nx<n && ny>=0 && ny<m && !(pv[nx][ny]) && mat[pos[0]][pos[1]]<=mat[nx][ny]){
                    p.offer(new int[]{nx,ny});
                    pv[nx][ny]=true;
                }
            }
        }
         while(!q.isEmpty()){
            int[]pos = q.poll();
            for(int[]dir:direction){
                int nx = pos[0]+dir[0];
                int ny = pos[1]+dir[1];
                if(nx>=0 && nx<n && ny>=0 && ny<m && !(qv[nx][ny]) && mat[pos[0]][pos[1]]<=mat[nx][ny]){
                    q.offer(new int[]{nx,ny});
                    qv[nx][ny]=true;
                }
            }
        }
        int c = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(pv[i][j] && qv[i][j])
                    c++;
            }
        }
        return c;
    }
}