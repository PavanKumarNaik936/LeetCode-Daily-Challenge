class Solution {
    public int minInsertions(String s) {
       int leftCount = 0;
       int idx = 0;
       int insertions = 0;
       while(idx<s.length()){
            char ch = s.charAt(idx);
            if(ch=='('){
                leftCount++;
                idx++;
            }else{
                //)
                if(leftCount>0){
                    leftCount--;
                }else{
                    insertions++;
                }
                if(idx<s.length()-1 && s.charAt(idx+1)==')'){
                    idx+=2;
                }else{
                    insertions++;
                    idx++;
                }
            }
       }
       insertions+=(leftCount*2);
       return insertions;
        
    }
}