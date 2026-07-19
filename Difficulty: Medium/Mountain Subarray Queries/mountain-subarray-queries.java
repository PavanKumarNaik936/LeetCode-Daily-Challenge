class Solution {
    public ArrayList<Boolean> processQueries(int[] arr, int[][] queries) {
        // code here
        int n = arr.length;
        int[]left = new int[n];
        int[]right = new int[n];
        left[n-1] = n-1;
        right[n-1] = n-1;
        ArrayList<Boolean>res = new ArrayList<>();
        for(int i=n-2;i>=0;i--){
            if(arr[i]<=arr[i+1]){
                left[i]=left[i+1];
            }else{
                left[i]=i;
            }
        }
        for(int i=n-2;i>=0;i--){
            if(arr[i]>=arr[i+1])
                right[i]=right[i+1];
            else
                right[i]=i;
        }
        for(int[]q:queries){
            int end = left[q[0]];
            if(right[end]>=q[1])
                res.add(true);
            else
                res.add(false);
        }
        return res;
    }
}