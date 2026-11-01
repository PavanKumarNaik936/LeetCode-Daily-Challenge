class Solution {
    public int minMoves(int[] nums) {
        int sum = 0;
        int min = nums[0];
        for(int x:nums){
            min = Math.min(min,x);
            sum+=x;
        }
        int n = nums.length;
        return sum-n*min;
    }
}