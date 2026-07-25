class Solution {
    public int maximumSum(int[][] mat, int k) {
        // code here
        int n = mat.length;
        int m = mat[0].length;
        int[][]prefix = new int[n+1][m+1];
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                prefix[i][j] = mat[i-1][j-1]+prefix[i-1][j]+prefix[i][j-1]-prefix[i-1][j-1];
            }
        }
        int maxSum = Integer.MIN_VALUE;
        int sum = Integer.MIN_VALUE;
        for(int r=1;r<=n;r++){
            for(int c=1;c<=m;c++){
                int r2 = r+k-1;
                int c2 = c+k-1;
                if(r2<=n && c2<=m){
                    sum = prefix[r2][c2]-prefix[r2][c-1]-prefix[r-1][c2]+prefix[r-1][c-1];
                    maxSum = Math.max(sum,maxSum);
                }
            }
        }
        return maxSum;
    }
}