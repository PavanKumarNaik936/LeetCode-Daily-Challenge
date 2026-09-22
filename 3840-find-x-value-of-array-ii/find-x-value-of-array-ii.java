class SegmentTree{
    int n;
    int k;
    Node[]st;
    SegmentTree(int[]nums,int k){
        this.n=nums.length;
        this.k=k;
        st = new Node[4*n];
        for(int i=0;i<4*n;i++){
            st[i] = new Node();
        }
        build(0,0,n-1,nums);
    }
    void build(int i,int l,int r,int[]nums){
        if(l==r){
            leafNode(i,nums[l]);
            return;
        }
        int mid = l+(r-l)/2;
        build(2*i+1,l,mid,nums);
        build(2*i+2,mid+1,r,nums);
        st[i] = mergeNodes(st[2*i+1],st[2*i+2]);
    }
    void leafNode(int i,int val){
        for(int x=0;x<k;x++){
            st[i].count[x] = 0;
        }
        int rem = val%k;
        st[i].prod = rem;
        st[i].count[rem]=1;
    }
    Node mergeNodes(Node left,Node right){
        Node result = new Node();
        result.prod = (left.prod*right.prod)%k;
        for(int x=0;x<k;x++){
            result.count[x] = left.count[x];
        }
        for(int x=0;x<k;x++){
            int newRem = (left.prod*x)%k;
            result.count[newRem] += right.count[x];
        }
        return result;
    }
    void segmentTreeUpdate(int i,int l,int r,int idx,int val){
        if(l==r){
            leafNode(i,val);
            return;
        }
        int mid = l+(r-l)/2;
        if(idx<=mid){
            segmentTreeUpdate(2*i+1,l,mid,idx,val);
        }else{
            segmentTreeUpdate(2*i+2,mid+1,r,idx,val);
        }
        st[i] = mergeNodes(st[2*i+1],st[2*i+2]);
    }
    void update(int idx,int val){
        segmentTreeUpdate(0,0,n-1,idx,val);
    }
    Node query(int start,int end){
        return segmentTreeQuery(start,end,0,0,n-1);
    }
    Node segmentTreeQuery(int start,int end,int i,int l,int r){
        if(l>=start && r<=end)
            return st[i];
        int mid = l+(r-l)/2;
        if(end<=mid){
            return segmentTreeQuery(start,end,2*i+1,l,mid);
        }else if(start>mid){
            return segmentTreeQuery(start,end,2*i+2,mid+1,r);
        }
        Node left = segmentTreeQuery(start,end,2*i+1,l,mid);
        Node right = segmentTreeQuery(start,end,2*i+2,mid+1,r);
        return mergeNodes(left,right);
    }
}
class Node{
    int[]count = new int[5];
    int prod =0;
}
class Solution {
    public int[] resultArray(int[] nums, int k, int[][] queries) {
        int n = nums.length;
        SegmentTree st = new SegmentTree(nums,k);
        int[]res = new int[queries.length];
        for(int i=0;i<queries.length;i++){
            int idx = queries[i][0];
            int val = queries[i][1];
            int start = queries[i][2];
            int x = queries[i][3];
            st.update(idx,val);
            Node node = st.query(start,n-1);
            res[i] = node.count[x];
        }
        return res;
    }
}