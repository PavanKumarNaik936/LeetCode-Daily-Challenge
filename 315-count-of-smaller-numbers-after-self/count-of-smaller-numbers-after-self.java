class Solution {
    class FenwickTree{
        int n;
        int[]bit;
        FenwickTree(int n){
            this.n = n;
            bit = new int[n+1];
        }
        void add(int i,int delta){
            while(i<=n){
                bit[i]+=delta;
                i+= i & -i;
            }
        }
        int query(int i){
            int sum = 0;
            while(i>0){
                sum+=bit[i];
                i-= i & -i;
            }
            return sum;
        }
    }
    public List<Integer> countSmaller(int[] nums) {
        ArrayList<Integer>res = new ArrayList<>();
        int[]temp = nums.clone();
        Arrays.sort(temp);
        Map<Integer,Integer>rank = new HashMap<>();
        int r = 1;
        for(int x:temp){
            if(!rank.containsKey(x)){
                rank.put(x,r++);
            }
        }
        int unique = r-1;
        FenwickTree ft = new FenwickTree(unique);
        for(int i=nums.length-1;i>=0;i--){
            int R = rank.get(nums[i]);
            res.add(ft.query(R-1));
            ft.add(R,1);
        }
        int left=0;
        int right = nums.length-1;
        while(left<right){
            int t = res.get(left);
            res.set(left,res.get(right));
            res.set(right,t);
            left++;
            right--;
        }
        return res;
    }
}