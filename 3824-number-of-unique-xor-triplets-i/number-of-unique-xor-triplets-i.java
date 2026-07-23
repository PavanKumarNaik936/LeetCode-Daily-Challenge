class Solution {
    public int uniqueXorTriplets(int[] nums) {
        int msb = 1;
        int n = nums.length;
        if(n<=2)
            return n;
        int len = 0;
        while(msb <=n){
            msb = msb<<1;
            len++;
        }
        msb = msb>>1;
        return (int)Math.pow(2,len);
    }
}