class Solution {
    public long sumAndMultiply(int n) {
        if(n==0)return 0;
        long sum = 0;
        StringBuilder sb = new StringBuilder();
        while(n>0){
            int dig = n%10;
            n = n/10;
            if(dig!=0){
                sb.append(dig);
                sum+=dig;
            }
        }
        return Long.parseLong(sb.reverse().toString())*sum;
    }
}