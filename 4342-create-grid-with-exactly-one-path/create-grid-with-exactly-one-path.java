class Solution {
    public String[] createGrid(int m, int n) {
        String[]grid = new String[m];
        for(int i=0;i<m;i++){
           StringBuilder sb = new StringBuilder(n);
            if(i==0){
                for(int j=0;j<n;j++){
                    sb.append(".");
                } 
            }else{
                for(int j=0;j<n;j++){
                    if(j==n-1)
                        sb.append(".");
                    else
                        sb.append("#");
                }
            }
            grid[i] = sb.toString();
        }
        return grid;
    }
}