class Solution {
    public int countCompleteComponents(int n, int[][] edges) {
        boolean[]vis = new boolean[n];
        ArrayList<ArrayList<Integer>>adj = new ArrayList<>();
        for(int i=0;i<n;i++)
            adj.add(new ArrayList<>());
        for(int[]e:edges){
            int u = e[0];
            int v = e[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        int[]Edges= new int[1];
        int complteComponents = 0;
        for(int i=0;i<n;i++){
            if(vis[i])
                continue;
            int[]componentInfo = new int[2];
            //componentInfo[0]= total nodes  // componentInfo[1] = total edges
            dfs(i,adj,vis,componentInfo);
            int requiredEdges = componentInfo[0]*(componentInfo[0]-1)/2;
            if(requiredEdges == componentInfo[1]/2)
                complteComponents++;
        }
        return complteComponents;
    }
    void dfs(int node,ArrayList<ArrayList<Integer>>adj,boolean[]vis,int[]componentInfo){
        vis[node]=true;
        componentInfo[0]++;
        componentInfo[1]+=adj.get(node).size();
        for(int x:adj.get(node)){
            if(!vis[x])
                dfs(x,adj,vis,componentInfo);
        }
    }
}