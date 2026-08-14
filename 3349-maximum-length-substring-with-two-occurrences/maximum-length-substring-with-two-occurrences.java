class Solution {
    public int maximumLengthSubstring(String s) {
        int[]map = new int[26];
        int l = 0;
        int maxLen = 0;
        for(int r=0;r<s.length();r++){
            map[s.charAt(r)-'a']++;
            while(map[s.charAt(r)-'a']>2){
                map[s.charAt(l)-'a']--;
                l++;
            }
            maxLen = Math.max(r-l+1,maxLen);
        }
        return maxLen;
    }
}