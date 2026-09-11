class Solution {
    public int totalNumbers(int[] digits) {
        int[]vis = new int[1000];
        int cnt = 0;
        for(int i=0;i<digits.length;i++){
            if(digits[i]==0)
                continue;
            for(int j=0;j<digits.length;j++){
                if(i==j)
                    continue;
                for(int k=0;k<digits.length;k++){
                    if(i==j || j==k ||i==k || digits[k]%2!=0)
                        continue;
                    int x = digits[i]*100+digits[j]*10+digits[k];
                    if(vis[x]==0){
                        vis[x]++;
                        cnt++;
                    }
                }
            }
        }
        return cnt;
    }
}