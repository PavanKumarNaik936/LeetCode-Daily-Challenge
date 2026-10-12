class Solution {
    int MOD = 1_000_000_007;
    public int maxSum(List<Integer> nums, int k) {
        int[]count = new int[32];
        for(int i=0;i<nums.size();i++){
            for(int b=0;b<32;b++){
                if(((nums.get(i)&(1<<b))!=0)){
                    count[b]++;
                }
            }
        }
        long sum = 0;
        while(k>0){
            int curr = 0;
            for(int b=0;b<32;b++){
                if(count[b]>0){
                    curr = curr|(1<<b);
                    count[b]--;
                }
            }
            sum = (sum+((long)curr*curr)%MOD)%MOD;
            k--;
        }
        return (int)sum;
    }
}