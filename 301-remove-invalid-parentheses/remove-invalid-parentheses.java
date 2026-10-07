class Solution {
    int maxLen= 0;
    public List<String> removeInvalidParentheses(String s) {
        Set<String>set = new HashSet<String>();
        solve(0,new StringBuilder(),0,s,set);
        return new ArrayList<>(set);
    }
    void solve(int i,StringBuilder curr,int cnt,String s,Set<String>set){
        if(cnt<0)
            return;
        if(i==s.length()){
            if(cnt==0){
                if(curr.length()>maxLen){
                    set.clear();
                    set.add(curr.toString());
                    maxLen = curr.length();
                }else if(curr.length()==maxLen){
                    set.add(curr.toString());
                }
            }
            return;
        }
        //always take other than '( && )'
        if(s.charAt(i)!='(' && s.charAt(i)!=')'){
            curr.append(s.charAt(i));
            solve(i+1,curr,cnt,s,set);
            curr.deleteCharAt(curr.length()-1);
            return;
        }
        //take 
        curr.append(s.charAt(i));
        solve(i+1,curr,cnt+(s.charAt(i)=='('?1:-1),s,set);
        curr.deleteCharAt(curr.length()-1);
        solve(i+1,curr,cnt,s,set);
    }
}