class Solution {
    public String maxSumOfSquares(int num, int sum) {
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<num;i++){
            int dig = Math.min(9,sum);
            sb.append(dig);
            sum-=dig;
        }
        if(sum==0)
            return sb.toString();
        return "";
    }
}