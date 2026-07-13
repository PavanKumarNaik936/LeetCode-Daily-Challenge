class Solution {
    int MOD = 1_000_000_007;
    int minOperations(int[] b) {
        // code here
        int n = b.length;
        int ans = 1;
        boolean[]vis = new boolean[n+1];
        for(int i=1;i<=n;i++){
            if(!vis[i]){
                int len = 0;
                int curr = i;
                while(!vis[curr]){
                    vis[curr]=true;
                    len++;
                    curr = b[curr-1];
                }
                ans=Lcm(ans,len)%MOD;
            }
        }
        return ans;
    }
    int Lcm(int a,int b){
        return (a*b)/GCD(a,b);
    }
    int GCD(int a,int b){
        if(b==0)
            return a;
        return GCD(b,a%b);
    }
    
};