class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        int l = 0;
        int maxLen = 0;
        HashMap<Integer,Integer>map = new HashMap<>();
        for(int r=0;r<nums.length;r++){
            if(!map.containsKey(nums[r])){
                map.put(nums[r],1);
                maxLen = Math.max(maxLen,r-l+1);
            }else{
                map.put(nums[r],map.get(nums[r])+1);
                while(l<=r && map.get(nums[r])>k){
                    map.put(nums[l],map.get(nums[l])-1);
                    l++;
                }
                maxLen = Math.max(maxLen,r-l+1);
            }
        }
        return maxLen;
    }
}