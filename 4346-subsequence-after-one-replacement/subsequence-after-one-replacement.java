class Solution {
    public boolean canMakeSubsequence(String s, String t) {
        int n = s.length();
        int m = t.length();
        int[]pref = new int[n];
        int[]sufx = new int[n];
        //build prefix array
        int j = 0;
        for(int i=0;i<n;i++){
            while(j<m && t.charAt(j)!=s.charAt(i)){
                j++;
            }
            if(j==m)
                pref[i]=m;
            else{
                pref[i]=j;
                j++;
            }
        }
        //build suffix array
        j = m-1;
        for(int i=n-1;i>=0;i--){
            while(j>=0 && t.charAt(j)!=s.charAt(i))
                j--;
            if(j<0)
                sufx[i]=-1;
            else{
                sufx[i]=j;
                j--;
            }
        }
        //already a subsequence
        for(int i=0;i<n;i++){
            int left = (i==0)?-1:pref[i-1];
            int right = (i==n-1)?m:sufx[i+1];
            if(left+1<right)
                return true;
        }
        return false;
    }
}