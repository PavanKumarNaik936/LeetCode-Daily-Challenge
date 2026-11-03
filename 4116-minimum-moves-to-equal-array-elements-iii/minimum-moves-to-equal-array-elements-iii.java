class Solution {
    public int minMoves(int[] nums) {
        int max = nums[0];
        int total = 0;
        for(int x:nums){
            max = Math.max(max,x);
            total+=x;
        }
        return nums.length*max-total;
    }
}