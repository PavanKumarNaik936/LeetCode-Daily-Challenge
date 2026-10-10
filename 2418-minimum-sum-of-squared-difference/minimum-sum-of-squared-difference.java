class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        int n = nums1.length;
        long K = k1+k2;
        long d = 0;
        long[]diff = new long[100001];
        for(int i=0;i<n;i++){
            int Dif= Math.abs(nums1[i]-nums2[i]);
            diff[Dif]++;
            d+=Dif;
        }
        if(d<=K)
            return 0;
        long sum = 0;
       for(int i=100000;i>=0;i--){
            if(diff[i]>0){
                long freq = diff[i];
                long c = Math.min(freq,K);
                diff[i]-=c;
                if(i>0){
                    diff[i-1]+=c;
                }
                sum+=(diff[i]*i*i);
                K-=c;
            }
       }
        
       
        return sum;
        
    }
}