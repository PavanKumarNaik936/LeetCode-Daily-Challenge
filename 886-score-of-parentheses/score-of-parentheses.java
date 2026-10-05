class Solution {
    public int scoreOfParentheses(String s) {
        int deapth = 0;
        int score = 0;
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch==')'){
                deapth--;
                if(s.charAt(i-1)=='('){
                    score+= 1<<deapth;
                }
            }else{//'('
                deapth++;
            }
        }
        return score;
    }
}