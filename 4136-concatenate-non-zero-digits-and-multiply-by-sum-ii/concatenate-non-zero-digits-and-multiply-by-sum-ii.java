class Solution {
    int MOD = 1_000_000_007;
    public int[] sumAndMultiply(String s, int[][] queries) {
       int n = s.length();
       int[]countOfNonZeroDig = new int[n];
       int[]pow10 = new int[n+1];
       int[]numUptoN = new int[n];
       int[]sumUptoN = new int[n];
       pow10[0] = 1;
       for(int i=1;i<=n;i++){
        pow10[i] = (int) ((10L * pow10[i - 1]) % MOD);
       }
       if(s.charAt(0)!='0'){
            countOfNonZeroDig[0]=1;
            numUptoN[0] = s.charAt(0)-'0';
            sumUptoN[0] = s.charAt(0)-'0';
       }
       for(int i=1;i<n;i++){
            int dig = s.charAt(i)-'0';
            if(dig!=0){
                countOfNonZeroDig[i]=countOfNonZeroDig[i-1]+1;
                numUptoN[i] = (int)(((long) numUptoN[i - 1] * 10 + dig) % MOD);
                sumUptoN[i] = (sumUptoN[i-1]+dig)%MOD;
            }else{
                countOfNonZeroDig[i] = countOfNonZeroDig[i-1];
                numUptoN[i] = numUptoN[i-1];
                sumUptoN[i] = sumUptoN[i-1];
            }    
       }
       int[] ans = new int[queries.length];
       for(int i=0;i<queries.length;i++){
            int l = queries[i][0];
            int r = queries[i][1];
            int k = countOfNonZeroDig[r] - (l == 0 ? 0 : countOfNonZeroDig[l - 1]);
            int prevSum = l==0?0:sumUptoN[l-1];
           int sum = (sumUptoN[r] - prevSum + MOD) % MOD;
            int prevX = l==0?0:numUptoN[l-1];
            
            int x = (int)((numUptoN[r] -(long)prevX * pow10[k] % MOD + MOD) % MOD);
            ans[i] = (int) ((long) sum * x % MOD); 
       }
       return ans;
    }
}