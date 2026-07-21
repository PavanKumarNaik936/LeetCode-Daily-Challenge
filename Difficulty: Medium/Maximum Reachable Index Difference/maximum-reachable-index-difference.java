class Solution {
    public int maxIndexDifference(String s) {
        // code here
        int[]best = new int[26];
        Arrays.fill(best,-1);
        int ans = -1;
        int reach = -1;
        for(int i=s.length()-1;i>=0;i--){
            int idx = s.charAt(i)-'a';
            int nxtIdx = idx+1;
            if(nxtIdx<26 && best[nxtIdx]!=-1)
                reach = best[idx+1];
            else
                reach = i;
            best[idx] = Math.max(reach,best[idx]);
            if(s.charAt(i)=='a'){
                ans = Math.max(ans,reach-i);
            }
        }
        return ans;
    }
}