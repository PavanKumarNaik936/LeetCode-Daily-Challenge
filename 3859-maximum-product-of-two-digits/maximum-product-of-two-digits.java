class Solution {
    public int maxProduct(int n) {
        int[]map = new int[10];
        while(n>0){
            int dig = n%10;
            n/=10;
            map[dig]++;
        }
        int first = -1;
        int second = -1;
        for(int i=9;i>=0;i--){
            if(map[i]>=1){
                if(first==-1){
                    first = i;
                }else{
                    second = i;
                    break;
                }
                map[i]--;
            }
            if(map[i]>=1){
                if(first==-1){
                    first = i;
                }else{
                    second = i;
                    break;
                }
                map[i]--;
            }

        }
        return first*second;
    }
}