class Solution {
    public int missingMultiple(int[] nums, int k) {
        HashSet<Integer>set = new HashSet<>();
        for(int x:nums){
            set.add(x);
        }
        int K=k;
        while(set.contains(k)){
            k+=K;
        }
        return k;
    }
}