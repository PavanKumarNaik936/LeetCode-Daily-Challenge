class Solution {
    int time;
    int[] st;
    int[]deapth;
    int[][]ancestorTable;
    int cols;
    void buildSegmentTree(int i,int l,int r,int[]nums){
        if(l==r){
            st[i] = nums[l];
            return;
        }
        int mid = l+(r-l)/2;
        buildSegmentTree(2*i+1,l,mid,nums);
        buildSegmentTree(2*i+2,mid+1,r,nums);
        st[i] = st[2*i+1]^st[2*i+2];
    }
    void updatePoint(int idx,int val,int i,int l,int r){
        if(l==r){
            st[i] = val;
            return;
        }
        int mid = l+(r-l)/2;
        if(idx<=mid){
            updatePoint(idx,val,2*i+1,l,mid);
        }else{
            updatePoint(idx,val,2*i+2,mid+1,r);
        }
        st[i] = st[2*i+1]^st[2*i+2];
    }
    int querySt(int start,int end,int i,int l,int r){
        if(l>end || r<start)
            return 0;
        if(l>=start && r<=end)
            return st[i];
        int mid = l+(r-l)/2;
        return querySt(start,end,2*i+1,l,mid)^querySt(start,end,2*i+2,mid+1,r);
    }
     void buildAncestorTable(int n) {
        for (int j = 1; j < cols; j++) {
            for (int node = 0; node < n; node++) {
                if (ancestorTable[node][j - 1] != -1) {
                    ancestorTable[node][j] = ancestorTable[ancestorTable[node][j - 1]][j - 1];
                }
            }
        }
    }

    public List<Boolean> palindromePath(int n, int[][] edges, String str, String[] queries) {
        ArrayList<ArrayList<Integer>>adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int[]edge:edges){
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        char[]s = str.toCharArray();
        int[]tin = new int[n];
        int[]tout = new int[n];
        int[]eulerTour = new int[2*n];
        time = 0;
        deapth = new int[n];
        cols = (31 - Integer.numberOfLeadingZeros(n)) + 1;   // same as log2(n) + 1
        ancestorTable = new int[n][cols];
        for (int[] row : ancestorTable) {
            Arrays.fill(row, -1);
        }
        dfs(0,adj,-1,tin,tout,eulerTour,s,0);
        int N = 2*n;
        st = new int[4*N];
        buildSegmentTree(0,0,N-1,eulerTour);
        buildAncestorTable(n);
        List<Boolean>res = new ArrayList<>();
        for(String q:queries){
            String[]parts = q.split(" ");
            String type = parts[0];
            if(type.equals("update")){
                int node = Integer.parseInt(parts[1]);
                char c = parts[2].charAt(0);
                s[node] = c;
                int charVal = (1<<(c-'a'));
                updatePoint(tin[node],charVal,0,0,2*n-1);
                updatePoint(tout[node],charVal,0,0,2*n-1);
            }else{
                int u = Integer.parseInt(parts[1]);
                int v = Integer.parseInt(parts[2]);
                int lcaNode = getLca(u,v);
                int charVal = (1<<(s[lcaNode]-'a'));
                int mask =  querySt(0,tin[u],0,0,2*n-1)^querySt(0,tin[v],0,0,2*n-1)^charVal;
                res.add((mask&(mask-1))==0);

            }
        }
        return res;

    }
    int getLca(int u,int v){
        if(deapth[u]<deapth[v]){
            int t = u;
            u=v;
            v=t;
        }
        int diff = deapth[u]-deapth[v];
        for(int i=0;i<cols;i++){
            if((diff &(1<<i))!=0){
                u = ancestorTable[u][i];
            }
        }
        if(u==v)
            return u;
        for(int i=cols-1;i>=0;i--){
            if(ancestorTable[u][i]!=ancestorTable[v][i]){
                u = ancestorTable[u][i];
                v = ancestorTable[v][i];
            }
        }
        return ancestorTable[u][0];
    }
    void dfs(int i,ArrayList<ArrayList<Integer>>adj,int parent,int[]tin,int[]tout,int[]eulerTour,char[]s,int d){
        tin[i] = time;
        eulerTour[time] = (1<<(s[i]-'a'));
        time++;
        ancestorTable[i][0] = parent;
        deapth[i] = d;
        for(int x:adj.get(i)){
            if(x!=parent){
                dfs(x,adj,i,tin,tout,eulerTour,s,d+1);
            }
        }
        tout[i] = time;
        eulerTour[time] = (1<<(s[i]-'a'));
        time++;
    }
}