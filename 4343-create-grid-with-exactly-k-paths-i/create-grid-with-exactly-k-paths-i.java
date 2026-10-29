class Solution {
    public String[] createGrid(int m, int n, int k) {
        if(m==1 || n==1 ){
            if(k!=1){
                return new String[]{};
            }
            String[]res = new String[m];
            for(int i=0;i<m;i++){
                res[i] = ".".repeat(n);
            }
            return res;
        }
        char[][]grid = new char[m][n];
        for(char[]r:grid){
            Arrays.fill(r,'#');
        }
        //make the first col and last row always reach 
        for(int i=0;i<m;i++){
            grid[i][0]='.';
        }
        for(int j=0;j<n;j++){
            grid[m-1][j]='.';
        }
        if(k==1){
            String[]res = new String[m];
            for(int i=0;i<m;i++){
                res[i] = new String(grid[i]);
            }
            return res;
        }
        if(k==2){
            grid[m-2][1]='.';
            String[]res = new String[m];
            for(int i=0;i<m;i++){
                res[i] = new String(grid[i]);
            }
            return res;
        }
        if(k==3){
            if(m==2 && n==2){
                return new String[]{};
            }
            grid[m-2][1]='.';
            if(n>=3){
                grid[m-2][2]='.';
            }else if(m>2){
                grid[m-3][1]='.';
            }
            String[]res = new String[m];
            for(int i=0;i<m;i++){
                res[i] = new String(grid[i]);
            }
            return res;
        }
        if(k==4){
    
            grid[m-2][1]='.';
            if(n>=3 && m>=3){
                grid[m-2][2] = '.';
                grid[m-3][1] = '.';
                grid[m-1][0] = '#';
            }else if(m>=4){
                grid[m-3][1]='.';
                grid[m-4][1]='.';
            }else if(n>=4){
                grid[0][2]='.';
                grid[0][3]='.';
            }else if(m==2 || n==2){
                return new String[]{};
            }

        }
        String[]res = new String[m];
        for(int i=0;i<m;i++){
            res[i] = new String(grid[i]);
        }
        return res;
        
    }
}