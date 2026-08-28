class Solution {
    String res = "";
    public String lexPalindromicPermutation(String s, String target) {
        int[]freq = new int[26];
        for(char ch:s.toCharArray()){
            freq[ch-'a']++;
        }
        char oddChar = '$';
        int odd = 0;
        for(int i=0;i<26;i++){
            if(freq[i]%2!=0){
                odd++;
                oddChar = (char)('a'+i);
            }
            freq[i]/=2;
            if(odd>1)
                return "";
        }
        StringBuilder sb = new StringBuilder();
        solve(0,sb,target,freq,false,oddChar);
        return res;
    }
    
    boolean solve(int i,StringBuilder curr,String target,int[]freq,boolean greater,char middle){
        if(i==target.length()/2){
            String left = curr.toString();
            String right = new StringBuilder(curr).reverse().toString();
            // String palindrome = left+String.valueOf(middle)+right;
            String palindrome = (middle != '$') ? left + middle + right : left + right;
            if( palindrome.compareTo(target)>0){
                res = palindrome.toString();
                return true;
            }
            return false;
        }
        for(char ch='a';ch<='z';ch++){
            if(greater==false && ch<target.charAt(i))
                continue;
            if(freq[ch-'a']==0)
                continue;
            //do
            boolean isGreater = greater || ch>target.charAt(i);
            curr.append(ch);
            freq[ch-'a']--;
            if(solve(i+1,curr,target,freq,isGreater,middle))
                return true;
            //undo
            curr.deleteCharAt(curr.length()-1);
            freq[ch-'a']++;
        }
        return false;
    }
}