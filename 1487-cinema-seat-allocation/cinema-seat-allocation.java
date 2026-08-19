class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        HashMap<Integer,ArrayList<Integer>>map = new HashMap<>();
        for(int[]seat:reservedSeats){
            int r=seat[0];
            int c=seat[1];
            if(!map.containsKey(r)){
                map.put(r,new ArrayList<>());
            }
            map.get(r).add(c);
        }
        int size = map.size();
        int ans = (n-size)*2;
        for(Integer r:map.keySet()){
            ArrayList<Integer>cols = map.get(r);
            boolean left=true;
            boolean right=true;
            boolean middle=true;
            for(Integer c:cols){
                if(c==2||c==3||c==4||c==5)
                    left=false;
                if(c==4 ||c==5||c==6||c==7)
                    middle=false;
                if(c==6||c==7||c==8||c==9)
                    right=false;
            }
            if(left && right){
                ans+=2;
            }else if((left||right)){
                ans+=1;
            }else if(middle)
                ans+=1;
        }
        return ans;
    }
}