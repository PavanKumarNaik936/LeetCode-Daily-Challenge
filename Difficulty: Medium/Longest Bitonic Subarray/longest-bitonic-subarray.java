class Solution {
    public int bitonic(int[] arr) {
        // code here
        int max = 1;
        int len = 1;
        int[]inc = new int[arr.length];
        int[]dec = new int[arr.length];
        inc[0]=1;
        dec[arr.length-1]=1;
        //find longest increasing length up to i
        for(int i=1;i<arr.length;i++){
            if(arr[i]>=arr[i-1]){
                len++;
                inc[i]=len;
            }else{
                len = 1;
                inc[i]=1;
            }
        }
        len = 1;
        for(int i=arr.length-2;i>=0;i--){
            if(arr[i]>=arr[i+1]){
                len++;
                dec[i] = len;
            }else{
                len = 1;
                dec[i] = 1;
            }
        }
        max =  1;
        for(int i=0;i<arr.length;i++){
            max = Math.max(max,inc[i]+dec[i]-1);
        }
        return max;
    }
}