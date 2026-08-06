class Solution {
    public int smallestNumber(int n, int t) {
        while(true){
            if(find(n,t)){
                return n;
            }
            n++;
        }
        
    }
    public boolean find(int n,int t){
        int product = 1;
        while(n>0){
            int dig = n%10;
            product*=dig;
            n/=10;
        }
        return product%t==0;
    }
}