class Solution {
    public String smallestSubsequence(String s) {
        StringBuilder sb =  new StringBuilder();
        int[]freq = new int[26];
        for(char ch:s.toCharArray()){
            freq[ch-'a']++;
        }
        boolean[]taken = new boolean[26];
        for(char ch:s.toCharArray()){
            freq[ch-'a']--;
            if(taken[ch-'a'])
                continue;
            while(sb.length()>0 && ch<sb.charAt(sb.length()-1) && freq[sb.charAt(sb.length()-1)-'a']>0){
                    char removed = sb.charAt(sb.length()-1);
                    sb.deleteCharAt(sb.length()-1);
                    taken[removed-'a']=false;
            }
            sb.append(ch);
            taken[ch-'a']=true;
            
            
        }
        return sb.toString();
    }
}