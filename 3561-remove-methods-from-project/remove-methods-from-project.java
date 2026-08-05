class Solution {
    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        int[]inDegree = new int[n];
        boolean[]suspicious = new boolean[n];
        ArrayList<ArrayList<Integer>>adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int[]invoc:invocations){
            int u = invoc[0];
            int v = invoc[1];
            inDegree[v]++;
            adj.get(u).add(v);
        }
        Queue<Integer>q = new LinkedList<>();
        suspicious[k]=true;
        q.offer(k);
        while(!q.isEmpty()){
            int node = q.poll();
            for(Integer neibr:adj.get(node)){
                inDegree[neibr]--;
                if(!suspicious[neibr]){
                    suspicious[neibr]=true;
                    q.offer(neibr);
                }

            }
        }
        List<Integer>res = new ArrayList<>();
        for(int i=0;i<n;i++){
            if(!suspicious[i]){
                res.add(i);
            }
            if(suspicious[i] && inDegree[i]>0){
                List<Integer>ans = new ArrayList<>();
                for(int j=0;j<n;j++){
                    ans.add(j);
                }
                return ans;
            }
        }
        return res;
    }
}