class Solution {
    public int maxDiffSubArrays(int[] arr) {
        // code here
        int n = arr.length;
        int[]leftMin = new int[n];
        int[]leftMax = new int[n];
        int[]rightMin = new int[n];
        int[]rightMax = new int[n];
        int currMin = arr[0];
        int bestMin = arr[0];
        leftMin[0] = arr[0];
        int currMax = arr[0];
        int bestMax = arr[0];
        leftMax[0] = arr[0];
        rightMin[n-1] = arr[n-1];
        rightMax[n-1] = arr[n-1];
        // finding minSum subarray and maxsum subarray from left
        for(int i=1;i<n;i++){
            currMin = Math.min(arr[i],currMin+arr[i]);
            bestMin = Math.min(bestMin,currMin);
            leftMin[i] = bestMin;
            currMax = Math.max(arr[i],currMax+arr[i]);
            bestMax = Math.max(bestMax,currMax);
            leftMax[i] = bestMax;
        }
        // finding minSum subarray and maxsum subarray from right
        currMin = arr[n-1];
        currMax = arr[n-1];
        bestMax = arr[n-1];
        bestMin = arr[n-1];
        for(int i=n-2;i>=0;i--){
            currMin = Math.min(arr[i],currMin+arr[i]);
            bestMin = Math.min(bestMin,currMin);
            rightMin[i] = bestMin;
            currMax = Math.max(arr[i],currMax+arr[i]);
            bestMax = Math.max(bestMax,currMax);
            rightMax[i] = bestMax;
        }
        
        // finding max Absolute diff of 2 subarrays
        int ans = 0;
        int currDiff = 0;
        for(int i=0;i<n-1;i++){
            
            currDiff = Math.max(leftMax[i]-rightMin[i+1],rightMax[i+1]-leftMin[i]);
            ans = Math.max(ans,currDiff);
        }
        return ans;
        
        
    }
}