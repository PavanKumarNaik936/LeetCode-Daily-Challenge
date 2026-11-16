class Solution {
    public String digitSum(String s, int k) {
        
        int sum = findSum(s);
        while(s.length()>k){
            StringBuilder sb = new StringBuilder();
            for(int i=0;i<s.length();i=i+k){
                int end = Math.min(i+k,s.length());
                int newSum=findSum(s.substring(i,end));
                sb.append(newSum);
            }
            s = sb.toString();

        }
        return s;

    }
    public int findSum(String s){
        int sum = 0;
        for(int i=0;i<s.length();i++){
            sum+=s.charAt(i)-'0';
        }
        return sum;
    }
    
}