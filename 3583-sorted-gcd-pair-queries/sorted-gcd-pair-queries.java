class Solution {
    public int[] gcdValues(int[] nums, long[] queries) {
        int max = nums[0];
        for(int x:nums){
            max = Math.max(max,x);
        }
        int[]freq = new int[max+1];
        //finding freq of each ele
        for(int x:nums){
            freq[x]++;
        }
        // finding num of pairs of elements divisible by x 
        long[]pairsDivisibleBy = new long[max+1];
        for(int i=1;i<=max;i++){
            int c = 0;
            for(int j = i;j<=max;j+=i){
                c+=freq[j];
            }
            pairsDivisibleBy[i] = convert(c);
        }
        // finding num of exact pairs of elements divisible by x 
        long[]exact = new long[max+1];
        exact[max] = pairsDivisibleBy[max];
        for(int i = max-1;i>=1;i--){
            long c = 0;
            for(int j = 2*i;j<=max;j+=i){
                c+=exact[j];
            }
            exact[i]=pairsDivisibleBy[i]-c; 
        }
        //find prefixCount of exact gcd
        long[]prefix = new long[max+1];
        prefix[1] = exact[1];
        for(int i=2;i<=max;i++){
            prefix[i] = prefix[i-1]+exact[i];
        }
        int[]res = new int[queries.length];
        for(int i=0;i<queries.length;i++){
            res[i] = binarySearch(prefix,queries[i]);
        }
        return res;
    }
    public int binarySearch(long[]prefix,long idx){
        int l = 1;
        int r = prefix.length-1;
        while(l<r){
            int m = l+(r-l)/2;
            if(prefix[m]>idx)
                r = m;
            else l = m+1;
        }
        return l;
    }
    public long convert(int n){
        return 1L*n*(n-1)/2;
    }
}