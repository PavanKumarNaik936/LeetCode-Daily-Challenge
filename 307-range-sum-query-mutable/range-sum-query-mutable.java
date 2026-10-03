class NumArray {
    int n;
    int[]bit;
    int[]nums;
    public NumArray(int[] nums) {
        this.n = nums.length;
        this.bit = new int[n+1];
        this.nums = nums.clone();
        for(int i=1;i<=n;i++){
            add(i,nums[i-1]);
        }
    }
    public void add(int idx,int delta){
        while(idx<=n){
            bit[idx]+=delta;
            idx += idx & -idx;
        }
    }
    public void update(int idx, int val) {
        int delta = val-nums[idx];
        nums[idx] = val;
        add(idx+1,delta);
    }
    public int query(int i){
        int sum = 0;
        while(i>0){
            sum+=bit[i];
            i-=(i & (-i));
        }
        return sum;
    }
    
    public int sumRange(int left, int right) {
        return query(right+1)-query(left);
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */