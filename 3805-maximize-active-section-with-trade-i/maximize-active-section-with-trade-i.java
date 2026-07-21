class Solution {
    public int maxActiveSectionsAfterTrade(String s) {
        int ones = 0;
        int zeros = 0;
        int orgOnes = 0;
        ArrayList<int[]>list = new ArrayList<>();
        if(s.charAt(0)=='1'){
            ones++;
            orgOnes++;
        }else{
            zeros++;
        }
        for(int i=1;i<s.length();i++){
            char curr = s.charAt(i);
            char prev = s.charAt(i-1);
            if(curr != prev){
                if(prev == '1'){
                    list.add(new int[]{1,ones});
                    ones=0;
                }else{
                    list.add(new int[]{0,zeros});
                    zeros=0;
                }
            }
            if(curr == '0'){
                zeros++;
            }else{
                ones++;
                orgOnes++;
            }
        }
        if (s.charAt(s.length()-1) == '1'){
            list.add(new int[]{1, ones});
        }else{
            list.add(new int[]{0, zeros});
        }
        int max = 0;
        int leftZeros =0;
        int rightZeros =0;
        for(int i=1;i<list.size()-1;i++){
            if(list.get(i)[0]==1){
                if(list.get(i-1)[0]==0 && list.get(i+1)[0]==0){
                    leftZeros = list.get(i-1)[1];
                    rightZeros = list.get(i+1)[1];
                    max = Math.max(max,leftZeros+rightZeros);
                }
            }
        }
        return orgOnes+max;
    }
}