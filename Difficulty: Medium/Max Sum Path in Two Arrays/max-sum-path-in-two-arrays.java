class Solution {
    public int maxPathSum(int[] a, int[] b) {
        // code here
        int i=0;
        int j=0;
        int n = a.length;
        int m = b.length;
        int sumA =0;
        int sumB =0;
        int res = 0;
        while(i<n && j<m){
            if(a[i]==b[j]){
                sumA+=a[i];
                sumB+=b[j];
                res+=Math.max(sumA,sumB);
                sumA = 0;
                sumB = 0;
                i++;
                j++;
            }else if(a[i]<b[j]){
                sumA+=a[i];
                i++;
            }else{
                sumB+=b[j];
                j++;
            }
        }
        while(i<n){
            sumA+=a[i];
            i++;
        }
        while(j<m){
            sumB+=b[j];
            j++;
        }
        res+=Math.max(sumA,sumB);
        return res;
    }
}