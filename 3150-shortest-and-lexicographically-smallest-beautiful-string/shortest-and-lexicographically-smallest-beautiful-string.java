class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        
        String ans = "";
        for(int i=0;i<s.length();i++){
            int ones = 0;
            for(int j=i;j<s.length();j++){
                if(s.charAt(j)=='1')
                    ones++;
                if(ones==k){
                   String current = s.substring(i, j + 1);
                    if(ans.isEmpty()
                            || current.length() < ans.length()
                            || (current.length() == ans.length() && current.compareTo(ans) < 0)) {

                        ans = current;
                    }
                    break;
                }
            }
            if(s.charAt(i)=='1')
                ones--;
        }
        return ans;
    }
}