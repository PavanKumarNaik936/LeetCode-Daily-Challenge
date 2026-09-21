class Solution {
    public long[] resultArray(int[] nums, int k) {
        long[]res = new long[k];
        long[]prev=new long[k];
        for(int i=0;i<nums.length;i++){
            long[]curr = new long[k];
            int currEleRem = nums[i]%k;
            curr[currEleRem] +=1;
            for(int oldRem=0;oldRem<k;oldRem++){
                int newRem = (int)((long)oldRem*nums[i]%k)%k;
                curr[newRem] += prev[oldRem];
            } 
            prev = curr;
            for(int j=0;j<k;j++){
                res[j]+=prev[j];
            }
        }
        return res;
    }
}