class Solution {
    public int minOperations(int[] nums) {
        boolean isAsc = false;
        boolean isDsc = false;
        int asc_count = 0;
        int dsc_count = 0;
        int n = nums.length;
        for(int i=1;i<n;i++){
            if(nums[i-1]==(nums[i]+1)%n)
                dsc_count++;
            if((nums[i-1]+1)%n==(nums[i]))
                asc_count++;
        }
        if(asc_count==n-1)
            isAsc = true;
        if(dsc_count==n-1)
            isDsc = true;
        if(isAsc){
            if(nums[0]==0)
                return 0;
            int left = n-nums[0];
            int right = nums[n-1]+3;
            return Math.min(left,right);
        }
        else if(isDsc){
            if(nums[0]==n-1)
                return 1;
            int left = n-nums[n-1]+1;
            int right = (nums[0]+1)%n+1;
            return Math.min(left,right);
        }else{
            return -1;
        }
    }
}