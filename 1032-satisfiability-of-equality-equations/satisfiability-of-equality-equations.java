class Solution {
    public boolean equationsPossible(String[] equations) {
        int[]parent = new int[26];
        int[]rank = new int[26];
        for(int i=0;i<26;i++){
            parent[i] = i;
        }
        for(String str:equations){
            int ch1 = str.charAt(0)-'a';
            int ch2 = str.charAt(3)-'a';
            char opr = str.charAt(1);
            int ch1_parent = find(ch1,parent);
            int ch2_parent = find(ch2,parent);
            if(opr=='='){
                union(ch1_parent,ch2_parent,parent,rank);
            }
        }
        for(String str:equations){
            int ch1 = str.charAt(0)-'a';
            int ch2 = str.charAt(3)-'a';
            char opr = str.charAt(1);
            int ch1_parent = find(ch1,parent);
            int ch2_parent = find(ch2,parent);
            if(opr=='=' && ch1_parent!=ch2_parent)
                return false;
            if(opr == '!' && ch1_parent==ch2_parent)
                return false;
        }
        return true;
    }
    int find(int i,int[]parent){
        if(i==parent[i])
            return i;
        return parent[i] = find(parent[i],parent);
    }
    void union(int x,int y,int[]parent,int[]rank){
        int x_parent = find(x,parent);
        int y_parent = find(y,parent);
        if(x_parent==y_parent)
            return;
        if(rank[x_parent]>rank[y_parent]){
            parent[y_parent] = x_parent;
        }else if(rank[y_parent]>rank[x_parent]){
            parent[x_parent] = y_parent;
        }else{
            parent[x_parent] = y_parent;
            rank[x_parent]+=1;
        }
    }
}