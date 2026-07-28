class Solution {
    class Node{
        int nextNode;
        int wt;
        Node(int nextNode,int wt){
            this.nextNode = nextNode;
            this.wt = wt;
        }
    }
    public int shortestPath(int V, int src, int dest, int[][] edges) {
        // code here
        ArrayList<ArrayList<Node>>adj = new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        for(int[]edge:edges){
            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];
            adj.get(u).add(new Node(v,wt));
            adj.get(v).add(new Node(u,wt));
        }
        int[]dist = new int[V];
        
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[src]=0;
        PriorityQueue<Node>pq = new PriorityQueue<>((a,b)->Integer.compare(a.wt,b.wt));
        pq.offer(new Node(src,0));
        while(!pq.isEmpty()){
            Node curr = pq.poll();
            int u = curr.nextNode;
            int d = curr.wt;
            if(d>dist[u])
                continue;
            for(Node nei:adj.get(u)){
                int v = nei.nextNode;
                int wt = nei.wt;
                if(dist[u]+wt<dist[v]){
                    dist[v] = dist[u]+wt;
                    pq.offer(new Node(v,dist[v]));
                }
            }
        }
        return dist[dest] == Integer.MAX_VALUE ? -1 : dist[dest];
        
    }
}