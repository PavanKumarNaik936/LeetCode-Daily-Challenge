class Solution {
    class Node{
        int r;
        int c;
        int dist;
        int turns;
        int prevDir;
        Node(int r,int c,int dist,int turns,int prevDir){
            this.r = r;
            this.c = c;
            this.dist = dist;
            this.turns = turns;
            this.prevDir = prevDir;
        }
    }
    public int minCost(int[][] grid, int k) {
        PriorityQueue<Node>pq = new PriorityQueue<>((a,b)->{
            if(a.dist!=b.dist)
                return Integer.compare(a.dist,b.dist);
            return Integer.compare(a.turns,b.turns);
        });
        int n = grid.length;
        int m = grid[0].length;
        int[][][][]dist = new int[n][m][k+1][4];
       for(int[][][]R:dist){
            for(int[][]r:R){
                for(int[]rr:r){
                    Arrays.fill(rr,Integer.MAX_VALUE);
                }
            }
       }
       dist[0][0][0][0] = grid[0][0];
        int[][] dir = {{-1,0},{0,1},{1,0},{0,-1}};
        pq.offer(new Node(0,0,grid[0][0],0,-1));
        while(!pq.isEmpty()){
            Node node = pq.poll();
            if (node.prevDir!=-1 && node.dist != dist[node.r][node.c][node.turns][node.prevDir])
                continue;
            for(int i=0;i<4;i++){
                int nr = node.r+dir[i][0];
                int nc = node.c+dir[i][1];
                if(nr<0 || nr>=n || nc<0 || nc>=m)
                    continue;
                int newTurns = node.turns;
                if(node.prevDir!=-1 && node.prevDir!=i)
                    newTurns++;
                if(newTurns>k)
                    continue;
                if(node.dist+grid[nr][nc]<dist[nr][nc][newTurns][i]){
                    dist[nr][nc][newTurns][i] = node.dist+grid[nr][nc];
                    pq.offer(new Node(nr,nc,dist[nr][nc][newTurns][i],newTurns,i));
                }
                
            }
        }
        int ans = Integer.MAX_VALUE;
        for(int t=0;t<=k;t++){
            for(int d=0;d<4;d++){
                ans = Math.min(ans,dist[n-1][m-1][t][d]);
            }     
        }
        if(ans==Integer.MAX_VALUE)
            return -1;
        return ans;

    }
}