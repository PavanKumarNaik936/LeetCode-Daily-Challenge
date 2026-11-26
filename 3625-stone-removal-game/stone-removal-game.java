class Solution {
    public boolean canAliceWin(int n) {
        if(n<10 || (n>=19 && n<=26) || (n>=34 && n<=39) || (n>=45 && n<=48))
            return false;
        return true;
        // 20-26   35-39   46-48
    }
}