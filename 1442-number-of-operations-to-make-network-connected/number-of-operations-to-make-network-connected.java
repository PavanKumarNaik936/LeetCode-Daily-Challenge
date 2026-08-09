class Solution {
    public int makeConnected(int n, int[][] connections) {
        if(connections.length<n-1)
            return -1;
        int[]parent = new int[n];
        int[]rank = new int[n];
        for(int i=0;i<n;i++){
            parent[i] = i;
        }
        int components = n;
        for(int[]edge:connections){
            int u = edge[0];
            int v = edge[1];
            if(find(u,parent)!=find(v,parent)){
                union(u,v,parent,rank);
                components--;
            }

        }
        return components-1;

    }
    public void union(int x,int y,int[]parent,int[]rank){
        int x_parent = find(x,parent);
        int y_parent = find(y,parent);
        if(x_parent==y_parent)
            return;
        if(rank[x_parent]>rank[y_parent]){
            parent[y_parent] = x_parent;
        }else if(rank[y_parent]>rank[x_parent]){
            parent[x_parent] = y_parent;
        }else{
            parent[x_parent] = y_parent;
            rank[y_parent]+=1;
        }
    }
    public int find(int i,int[]parent){
        if(i==parent[i])
            return i;
        return parent[i] = find(parent[i],parent);
    }
}