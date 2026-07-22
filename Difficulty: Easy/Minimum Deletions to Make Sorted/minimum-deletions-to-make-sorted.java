class Solution {
    public int minDeletions(int[] arr) {
        // code here
        ArrayList<Integer>lis = new ArrayList<>();
        for(int x:arr){
            int idx = binarySearch(x,lis);
            if(idx == lis.size())
                lis.add(x);
            else
                lis.set(idx,x);
        }
        return arr.length-lis.size();
    }
    public int binarySearch(int x,ArrayList<Integer>lis){
        int l = 0;
        int r = lis.size()-1;
        while(l<=r){
            int m = l+(r-l)/2;
            if(lis.get(m)>=x)
                r = m-1;
            else l = m+1;
        }
        return l;
    }
}