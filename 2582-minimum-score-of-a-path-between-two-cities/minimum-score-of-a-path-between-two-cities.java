class Solution {
    class Pair{
        int node;
        int dist;
        Pair(int node,int dist){
            this.node = node;
            this.dist = dist;
        }
    }
    public int minScore(int n, int[][] roads) {
        List<List<Pair>>adj = new ArrayList<>();
        for(int i=0;i<=n;i++){
            adj.add(new ArrayList<Pair>());
        }
        for(int[]road:roads){
            int u = road[0];
            int v = road[1];
            int d = road[2];
            adj.get(u).add(new Pair(v,d));
            adj.get(v).add(new Pair(u,d));
        }
        int[]res = new int[1];
        res[0]=Integer.MAX_VALUE;
        boolean[]vis = new boolean[n+1];
        find(1,adj,res,vis);
        return res[0];
    }
    void find(int node,List<List<Pair>>adj,int[]res,boolean[]vis){
        vis[node]=true;
        for(Pair p :adj.get(node)){
            res[0]=Math.min(res[0],p.dist);
            if(!vis[p.node]){
                find(p.node,adj,res,vis);
            }
        }
    }
}