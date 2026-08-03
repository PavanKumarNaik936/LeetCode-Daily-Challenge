class Solution {
    public int maxSumWithK(int[] arr, int k) {
        // code here
           int n = arr.length;
        if(n<k) return -1;
        int l = 0;
        int r = 0;
        int s = 0;
        int last = 0;
        int maxi = Integer.MIN_VALUE;
        while(r<n){
            s+=arr[r];
            int ans = 0;
            if((r-l+1)==k){
                maxi = Math.max(maxi,s);
                                
            }
        else if((r-l+1)>k){
            last+=arr[l];
            l++;
            if(last<0){
                s = s-last;
                last = 0;
            }
            maxi = Math.max(maxi,s);
        }
        r++;   
        }
    return maxi;
    }
}