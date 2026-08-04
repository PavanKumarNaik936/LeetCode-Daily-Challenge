class Solution {
    public static int countPairs(int arr[], int k) {
        // code here
        Arrays.sort(arr);
        int l = 0;
        int c = 0;
        for(int r=0;r<arr.length;r++){
            while(arr[r]-arr[l]>=k){
                l++;
            }
            c+=(r-l);
        }
        return c;
    }
}
