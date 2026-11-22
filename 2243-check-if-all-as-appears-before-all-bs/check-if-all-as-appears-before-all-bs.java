class Solution {
    public boolean checkString(String s) {
        boolean seenB = false;
        for(char ch:s.toCharArray()){
            if(ch=='a' && seenB)
                return false;
            if(ch=='b')
                seenB = true;
        }
        return true;
    }
}