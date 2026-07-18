class Solution {
    public int findGCD(int[] nums) {
        int max = nums[0];
        int min = nums[0];
        for(int x:nums){
            max = Math.max(max,x);
            min = Math.min(min,x);
        }
        while(max!=0){
            int t = min%max;
            min = max;
            max = t;
        }
        return min;
    }
    public int gcd(int a,int b){
        if(b==0)
            return a;
        return gcd(b,a%b);
    }
}