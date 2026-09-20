class Solution {
    public int reverseDegree(String s) {
        int sum = 0;
        for(int i=0;i<s.length();i++){
            int pos =26-(s.charAt(i)-'a');
            // System.out.println(pos);
            sum+=(pos*(i+1));
        }
        return sum;
    }
}