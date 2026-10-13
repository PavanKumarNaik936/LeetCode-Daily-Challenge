class Solution {
    public long maxAlternatingSum(int[] nums) {
        int n = nums.length;
        int even = n%2==0?n/2:(n/2)+1;
        int odd = n-even;
        // System.out.println(even+" "+odd);
        long[]sq = new long[n];
        for(int i=0;i<n;i++){
            sq[i] = nums[i]*nums[i];
        }
        Arrays.sort(sq);
        long score = 0;
        for(int i=0;i<n;i++){
            if(i<odd){
                score-=sq[i];
            }else{
                score+=sq[i];
            }
        }
        return score;
    }
}