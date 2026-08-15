class Solution {
    public int longestSubsequence(int[] nums) {
        int xor = 0;
        int zero = 0;
        for(int x:nums){
            xor ^=x;
            if(x==0)
                zero++;
        }
        if(xor!=0)
            return nums.length;
        if(zero==nums.length)
            return 0;
        return nums.length-1;
    }
}