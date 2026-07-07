class Solution {
    public int largestArea(int n, int m, int k, int[][] arr) {
        // code here
        int[]BlockedRows = new int[k+2];
        int[]BlockedCols = new int[k+2];
        BlockedRows[BlockedRows.length-1] = n+1;
        BlockedCols[BlockedCols.length-1] = m+1;
        for(int i=0;i<k;i++){
            int r = arr[i][0];
            int c = arr[i][1];
            BlockedRows[i+1]=r;
            BlockedCols[i+1]=c;
        }
        Arrays.sort(BlockedRows);
        Arrays.sort(BlockedCols);
        int maxHeight = 0;
        int maxWidth = 0;
        for(int i=1;i<k+2;i++){
            maxHeight = Math.max(maxHeight,BlockedRows[i]-BlockedRows[i-1]-1);
            maxWidth = Math.max(maxWidth,BlockedCols[i]-BlockedCols[i-1]-1);
        }
        return maxHeight*maxWidth;
    }
}