class Solution {
    static int MOD = 1_000_000_007;
    public int maxAmount(int[] arr, int k) {
        // code here
        
        PriorityQueue<Integer>pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int x:arr){
            pq.offer(x);
        }
        int amt = 0;
        while(k>0 && !pq.isEmpty()){
            int ticket = pq.poll();
            amt = (amt%MOD+ticket%MOD)%MOD;
            if (ticket > 1) {
                pq.offer(ticket - 1);
            }
            k--;
        }
        return amt;
    }
}