class Solution {
    String result = "";
    public String lexGreaterPermutation(String s, String target) {
        int[]freq = new int[26];
        for(int i=0;i<s.length();i++){
            freq[s.charAt(i)-'a']++;
        }
        StringBuilder curr = new StringBuilder();
        solve(0,curr,s,freq,false,target);
        return result;
    }
    boolean solve(int i,StringBuilder curr,String s,int[]freq,boolean greater,String target){
        if(i==target.length()){
            if(greater){
                result = curr.toString();
                return true;
            }
            return false;
        }
        for(char ch='a';ch<='z';ch++){
            if(freq[ch-'a']==0) 
                continue;
            if(greater==false && ch<target.charAt(i))
                continue;
            //do
            boolean isGreater = greater || ch>target.charAt(i);
            curr.append(ch);
            freq[ch-'a']--;
            if(solve(i+1,curr,s,freq,isGreater,target))
                return true;
            
            //undo
            freq[ch-'a']++;
            curr.deleteCharAt(curr.length()-1);

        }
        return false;
    }
}