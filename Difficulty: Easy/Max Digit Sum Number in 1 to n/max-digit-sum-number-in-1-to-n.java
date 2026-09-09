class Solution {
    public int findMax(int n) {
        // code here
        int best = n;
        int bestSum = digitSum(n);
        String num = String.valueOf(n);
        for(int i=0;i<num.length();i++){
            int digit = num.charAt(i)-'0';
            if(digit==0)
                continue;
            StringBuilder candidate = new StringBuilder();
            candidate.append(num,0,i);
            candidate.append(digit-1);
            for(int j=i+1;j<num.length();j++){
                candidate.append(9);
            }
            int value = Integer.parseInt(candidate.toString());
            int sum = digitSum(value);
            if(sum>bestSum || sum==bestSum && value>best){
                best = value;
                bestSum = sum;
            }
            
        }
        return best;
    }
    public int digitSum(int n){
        int sum = 0;
        while(n>0){
            sum+=(n%10);
            n/=10;
        }
        return sum;
    }
}
