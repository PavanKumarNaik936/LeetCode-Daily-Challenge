class Solution {
    public int longestValidParentheses(String s) {
        int open = 0;
        int close = 0;
        int ans = 0;
        for(char ch:s.toCharArray()){
            if(ch=='('){
                open++;
            }else{
                close++;
            }

            if(close>open){
                open=0;
                close=0;
            }
            if(open==close){
                ans = Math.max(ans,open+close);
            }
        }
        open = 0;
        close = 0;
        for(int i=s.length()-1;i>=0;i--){
            char ch = s.charAt(i);
            if(ch=='('){
                open++;
            }else{
                close++;
            }

            if(open>close){
                open=0;
                close=0;
            }
            if(open==close){
                ans = Math.max(ans,open+close);
            }
        }
        return ans;
    }
}