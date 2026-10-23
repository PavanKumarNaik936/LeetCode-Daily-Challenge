class Solution {
    public int sortPermutation(int[] nums) {
        int ans = -1;
        for(int i=0;i<nums.length;i++){
            if(i!=nums[i]){
                ans = (ans & nums[i]);
            }
        }
        if(ans==-1)
            return 0;
        return ans;
    }
}