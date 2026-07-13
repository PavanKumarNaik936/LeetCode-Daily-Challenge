class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer>res = new ArrayList<>();
        for(int i=1;i<=9;i++){
            dfs(i,i+1,low,high,res);
        }
        Collections.sort(res);
        return res;
    }
    public void dfs(int num,int next,int low,int high,List<Integer>res){
        
        if(num>= low && num<=high)
            res.add(num);
        if(num>high || next>9)
            return;
        dfs(num*10+next,next+1,low,high,res);
        

    }
}