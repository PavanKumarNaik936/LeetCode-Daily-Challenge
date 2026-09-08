class Solution {
    public ArrayList<ArrayList<Integer>> searchWord(char[][] mat, String word) {
        // code here
        ArrayList<ArrayList<Integer>>res = new ArrayList<>();
        int n = mat.length;
        int m = mat[0].length;
        int[][]dir = {{-1,-1},{-1,0},{-1,1},{0,1},{1,1},{1,0},{1,-1},{0,-1}};
        for(int r=0;r<n;r++){
            for(int c=0;c<m;c++){
                if(mat[r][c]!=word.charAt(0))
                    continue;
                for(int[]d:dir){
                    boolean found = true;
                    for(int k=0;k<word.length();k++){
                        int nr = r+k*d[0];
                        int nc = c+k*d[1];
                        if(nr<0 || nr>=n || nc>=m || nc<0 || word.charAt(k)!=mat[nr][nc]){
                            found = false;
                            break;
                        }
                    }
                    if(found){
                        ArrayList<Integer>pos = new ArrayList<>();
                        pos.add(r);
                        pos.add(c);
                        res.add(pos);
                        break;
                    }
                 }
            }
        }
        return res;
    }
};