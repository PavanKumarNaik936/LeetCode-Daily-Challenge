class Solution {
    public boolean canRepresentBST(List<Integer> arr) {
        // code here
        int lb = Integer.MIN_VALUE;
        Deque<Integer>st = new ArrayDeque<>();
        for(Integer x:arr){
            while(!st.isEmpty() && st.peek()<x){
                lb = st.pop();
            }
            if(x<lb)
                return false;
            else st.push(x);
        }
        return true;
    }
}