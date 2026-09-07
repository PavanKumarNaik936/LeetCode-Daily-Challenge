class Solution {
    int MOD = 1_000_000_007;
    public int distinctSubseqII(String s) {
        int n = s.length();
        int[]lastSeen = new int[26];
        int[]dp = new int[n+1];
        Arrays.fill(lastSeen,-1);
        dp[0]=1;
        for(int i=1;i<=n;i++){
            dp[i] = (2*dp[i-1])%MOD;
            //remove duplicates
            int ch = s.charAt(i-1)-'a';
            if(lastSeen[ch]!=-1){
                dp[i]-=dp[lastSeen[ch]];
                dp[i]+=MOD;
                dp[i]%=MOD;
            }
            lastSeen[ch] = i-1;
        }
        //remove empty subsequence
        return (dp[n]-1+MOD)%MOD;
    }
 
}