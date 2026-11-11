class Solution {
    public long minimumCost(int cost1, int cost2, int costBoth, int need1, int need2) {
        if(need1==0 && need2==0)
            return 0;
        long n = (long)Math.min(need1,need2);
        long c = (long)Math.min(cost1+cost2,costBoth);
        long ans = n*c;
        if(need1>n){
            if(costBoth<cost1)
                ans+=((need1-n)*(long)costBoth);
            else ans+=((need1-n)*(long)cost1);
        }else if(need2>n){
            if(costBoth<cost2)
                ans+=((need2-n)*(long)costBoth);
            else ans+=((need2-n)*(long)cost2);
        }
        return ans;
    }
}