class Solution {
    int base;
    int MOD = 1_000_000_007;
    public int smallestUniqueSubarray(int[] nums) {
        int max = nums[0];
        for(int x:nums){
            max = Math.max(max,x);
        }
        base = max+1;
        int l = 1;
        int r = nums.length;
        int ans = r;
        while(l<=r){
            int m = l+(r-l)/2;
            if(check(m,nums)){
                ans = m;
                r = m-1;
            }else{
                l = m+1;
            }
        }
        return ans;
    }
    long findPower(long base,int p){
        if(p==0)
            return 1;
        long half = findPower(base,p/2);
        long result = (half*half)%MOD;
        if(p%2!=0){
            result = (result*base)%MOD;
            return result;
        }
        return result;
    }
    boolean check(int size,int[]nums){
        HashMap<Integer,Integer>map = new HashMap<>();
        int l = 0;
        int r = 0;
        int hash=0;
        long p = findPower(base , size - 1); // O(log(size))
        while(r<nums.length){
            hash = (int)(((long)hash*base+nums[r])%MOD);
            if(r-l+1==size){
                map.put(hash,map.getOrDefault(hash,0)+1);
                hash = (int)(hash-(nums[l]*p)%MOD+MOD)%MOD;
                l++;
                r++;
            }else{
                r++;
            }
        }

        for(Integer key:map.keySet()){
            if(map.get(key)==1)
                return true;
        }
        return false;
    }
}