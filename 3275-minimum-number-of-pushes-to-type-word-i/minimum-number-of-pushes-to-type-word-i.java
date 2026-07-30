class Solution {
    public int minimumPushes(String word) {
        int total = 0;
        int cost = 1;
        int n = word.length();
        while(n>=8){
            total+=(cost*8);
            n = n-8;
            cost++;
        }
        total+=(n*cost);
        return total;
    }

}