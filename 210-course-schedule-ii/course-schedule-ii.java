class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[]inDegree = new int[numCourses];
        int[]order = new int[numCourses];
        int idx = 0;
        ArrayList<ArrayList<Integer>>adj = new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }
        for(int[]pre:prerequisites){
            int a = pre[0];
            int b = pre[1];
            adj.get(b).add(a);
            inDegree[a]+=1;
        }
        Deque<Integer>q = new ArrayDeque<Integer>();
        for(int i=0;i<numCourses;i++){
            if(inDegree[i]==0){
                q.offer(i);
            }
        }
        int c = 0;
        while(!q.isEmpty()){
            int node = q.poll();
            order[idx++] = node;
            c++;
            for(int x:adj.get(node)){
                inDegree[x]--;
                if(inDegree[x]==0)
                    q.offer(x);
            }
        }
        if(c!=numCourses){
            return new int[]{};
        }
        return order;
    }
}