class Solution {
    public boolean sumGame(String num) {
        int bal = 0;
        int n = num.length();
        int leftQ = 0;
        int rightQ = 0;
        for(int i=0;i<num.length();i++){
            if(num.charAt(i)=='?'){
                if(i<n/2)
                    leftQ++;
                else
                    rightQ++;
            }else{
                int dig = num.charAt(i)-'0';
                if(i<n/2)
                    bal+=dig;
                else
                    bal-=dig;
            }
        }
        if(leftQ-rightQ==0)
            return bal!=0;
        return 2*bal != (-9)*(leftQ-rightQ);
    }
}