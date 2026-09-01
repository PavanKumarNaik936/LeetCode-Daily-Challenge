class Solution {
    public int minMoves(String[] classroom, int energy) {
        int[][]direction = {{-1,0},{0,1},{1,0},{0,-1}};
        int l = 0;
        int[]src=new int[2];
        Queue<int[]>q = new LinkedList<>();
        int rows = classroom.length;
        int cols = classroom[0].length();
        int[][] litterId = new int[rows][cols];
        
        for (int i = 0; i < rows; i++) {
            Arrays.fill(litterId[i], -1);
        }
        int litterCount = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {

                if (classroom[i].charAt(j) == 'L') {
                    litterId[i][j] = litterCount;
                    litterCount++;
                }
                if(classroom[i].charAt(j)=='S'){
                    // {row,col,enery,moves}
                    src[0]=i;
                    src[1]=j;
                }
            }
        }
        int fullMask = (1 << litterCount) - 1;
        int[][][][]visited = new int[rows][cols][energy+1][fullMask+1];
        q.offer(new int[]{src[0],src[1],energy,0,0});
        visited[src[0]][src[1]][energy][0]=1;
        while(!q.isEmpty()){
            int[]data = q.poll();
            int r = data[0];
            int c = data[1];
            int e = data[2];
            int m = data[3];
            int mask = data[4];
            if(mask==fullMask){
                return m;
            }
            if(e==0)
                continue;
            //process the 4 directions up,right,down,left
            for(int[]dir:direction){
                int nr = r+dir[0];
                int nc = c+dir[1];
                
                if(nr>=0 && nr<classroom.length && nc>=0 && nc<classroom[0].length()){
                    int ne = e-1;
                    int newMask = mask;
                    if(classroom[nr].charAt(nc)=='X')
                    continue;
                    if(classroom[nr].charAt(nc)=='R')
                        ne=energy;
                    if(classroom[nr].charAt(nc)=='L'){
                        newMask = newMask | (1<<litterId[nr][nc]);
                    }
                    if(visited[nr][nc][ne][newMask]==0){
                        q.offer(new int[]{nr,nc,ne,m+1,newMask});
                        visited[nr][nc][ne][newMask]=1;
                    }
                    
                    
                }
                
                
            }
        }
        return -1;

    }
}