class Solution {
    public String removeOuterParentheses(String s) {
        StringBuilder sb = new StringBuilder();
        int l=0;
        int bal = 0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                bal++;
            }else{
                bal--;
            }

            if(bal==0){
                sb.append(s.substring(l+1,i));
                l = i+1;
            }
        }
        return sb.toString();
    }
}