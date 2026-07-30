class Solution {
    public int maxSubsetXOR(int[] arr) {
        // code here
        int idx = 0;
        int n = arr.length;
        for(int bit=32;bit>=0;bit--){
            int maxIdx = -1;
            for(int i=idx;i<n;i++){
                if(((arr[i]>>bit)&1)==1){
                    maxIdx = i;
                    break;
                }
            }
            if(maxIdx==-1)
                continue;
            int temp = arr[idx];
            arr[idx] = arr[maxIdx];
            arr[maxIdx]=temp;
            for(int i=0;i<n;i++){
                if(i!=idx && ((arr[i]>>bit)&1)==1){
                    arr[i]^=arr[idx];
                }
            }
            idx++;
            
        }
        int maxXor = 0;
            for(int x:arr){
                maxXor ^=x;
            }
            
            return maxXor;
            
    }
}