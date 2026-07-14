class Solution {
    int MOD = 1_000_000_007;
    public int find(int[] arr) {
        // code here
        long l = 1;
        long r = Integer.MAX_VALUE;
        while(l<=r){
            long m = l+(r-l)/2;
            if(check(m,arr)){
                r=m-1;
            }else{
                l = m+1;
            }
        }
        return (int)l;
    }
    boolean check(long x, int[] arr) {
    for (int a : arr) {
        if (x > (Long.MAX_VALUE - a) / 2) {
            x = Long.MAX_VALUE;
        } else {
            x = 2 * x - a;
        }

        if (x < 0)
            return false;
    }
    return true;
}
}
