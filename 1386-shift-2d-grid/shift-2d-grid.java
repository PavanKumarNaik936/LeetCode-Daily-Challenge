class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int n = grid.length;
        int m = grid[0].length;
        int temp = -1;
        while(k>0){
            temp = grid[n-1][m-1];
            for(int i=n-1;i>=0;i--){
                for(int j=m-1;j>=0;j--){
                    if(j==0){
                        if(i==0){
                            grid[i][j]=temp;
                        }else{
                            grid[i][j] = grid[i-1][m-1];
                        }
                    }else{
                        grid[i][j]=grid[i][j-1];
                    }
                }
            }
            k--;
        }
        List<List<Integer>>res = new ArrayList<>();
        for(int[]row:grid){
            List<Integer>list = new ArrayList<>();
            for(int ele:row){
                list.add(ele);
            }
            res.add(list);
        }
        return res;
    }
}