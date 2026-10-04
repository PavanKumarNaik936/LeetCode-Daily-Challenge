class Solution {
    public boolean checkValidString(String s) {
        int open = 0;
        int close = 0;
        int n = s.length();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='(' || s.charAt(i)=='*'){
                open++;
            }else{
                open--;
            }
            if(s.charAt(n-i-1)==')' || s.charAt(n-i-1)=='*'){
                close++;
            }else{
                close--;
            }
            if(open<0 ||  close<0)
                return false;
        }
        return true;
    }
}