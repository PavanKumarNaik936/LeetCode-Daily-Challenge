class Solution {
    public int firstMatchingIndex(String s) {
        int i=0;
        int n = s.length();
        while(i<=n/2){
            if(s.charAt(i)==s.charAt(n-i-1)){
                return i;
            }
            i++;
        }
        return -1;
    }
}