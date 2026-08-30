class Solution {
    public int minimumDeletions(int[] nums) {
        int minIdx = 0;
        int maxIdx = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]<nums[minIdx]){
                minIdx = i;
            }
            if(nums[i]>nums[maxIdx]){
                maxIdx = i;
            }
        }
        int n = nums.length;
        // case 1: both can be removed from front
        int del = Math.max(minIdx,maxIdx)+1;
        //case 2: both can be removed from back
        del = Math.min(del,n-Math.min(minIdx,maxIdx));
        //case 3: one from front and another from back
        int front = 0;
        int back = 0;
        if(minIdx<=n/2){
            front = minIdx+1;
            back = n-maxIdx;
        }else{
            front = maxIdx+1;
            back = n-minIdx;
        }
        del = Math.min(del,front+back);
        return del;
    }
}