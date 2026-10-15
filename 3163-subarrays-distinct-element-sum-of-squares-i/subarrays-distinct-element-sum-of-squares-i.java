class Solution {
    public int sumCounts(List<Integer> nums) {
        int sum = 0;
        int n = nums.size();
        HashSet<Integer>set = new HashSet<>();
        for(int i=0;i<n;i++){
            
            for(int j=i;j<n;j++){
                set.add(nums.get(j));
                int unique = set.size();
                sum+=(unique*unique);
            }
            
            set.clear();
        }
        return sum;
    }
}