class Solution {
    public int largestInteger(int[] nums, int k) {
        HashMap<Integer,Integer>map = new HashMap<>();
        int max = -1;
        for(int x:nums){
            map.put(x,map.getOrDefault(x,0)+1);
            max = Math.max(max,x);
        }
        if(k==1){
            int ans = -1;
            for(int x:nums){
                if(map.get(x)==1 && x>ans){
                    ans = x;
                }
            }
            return ans;
        }
        if(k==nums.length)
            return max;
        if(map.get(nums[0])==1){
            if(map.get(nums[nums.length-1])==1)
                return Math.max(nums[0],nums[nums.length-1]);
            return nums[0];
        }
        if(map.get(nums[nums.length-1])==1)
            return nums[nums.length-1];
        return -1;
    }
}