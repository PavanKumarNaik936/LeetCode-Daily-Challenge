class Solution {
    public long findKthSmallest(int[] coins, int k) {
        long left = Integer.MAX_VALUE;
        for(int ele:coins){
            left = Math.min(left,ele);
        }
        long right = left*k;
        long ans = -1;
        while(left<=right){
            long mid = left+(right-left)/2;
            if(find(mid,coins.length,coins,k)){
                ans =mid;
                right=mid-1;
            }else{
                left = mid+1;
            }
        }
        return ans;
    }
    long lcm(long a,long b){
        return (a*b)/gcd(a,b);
    }
    long gcd(long a,long b){
        if(b==0)
            return a;
        return gcd(b,a%b);
    }
    boolean find(long x,int n,int[]coins,int k){
        long ans = 0;
        for(int mask=1;mask<(1<<n);mask++){
            long Lcm = 1;
            int bits=0;
            for(int i=0;i<n;i++){
                if((mask & (1<<i))!=0){
                    bits++;
                    Lcm = lcm(Lcm,coins[i]);
                    if(Lcm>x)
                        break;
                }
                
            }
            if(Lcm>x)continue;
            long ways = x/Lcm;
            if(bits%2==0)
                ans-=ways;
            else ans+=ways;
        }
        return ans>=k;
    }
}