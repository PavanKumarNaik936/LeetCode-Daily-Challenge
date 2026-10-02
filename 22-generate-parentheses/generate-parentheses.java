class Solution {
    public List<String> generateParenthesis(int n) {
        List<String>ans = new ArrayList<>();
        solve("",0,0,ans,n);
        return ans;
    }
    public void solve(String s,int open,int close,List<String>ans,int n){
        if(s.length()==2*n){
            ans.add(s);
            return;
        }
        if(open<n)
            solve(s+"(",open+1,close,ans,n);
        if(close<open)
            solve(s+")",open,close+1,ans,n);
    }
}