class Solution {
    public boolean[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        int id = 0;
        HashMap<Integer,Integer>map = new HashMap<>();
        map.put(0,0);
        for(int i=1;i<n;i++){
            if(nums[i]-nums[i-1]<=maxDiff){
                map.put(i,map.get(i-1));
            }else{
                map.put(i,map.get(i-1)+1);
            }
        }
        boolean[]ans = new boolean[queries.length];
        for(int i=0;i<queries.length;i++){
            if(map.get(queries[i][0])==map.get(queries[i][1]))
                ans[i]=true;
            else ans[i]= false;
        }
        return ans;
    }
}