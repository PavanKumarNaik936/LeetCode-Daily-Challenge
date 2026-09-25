class Solution {
    int idx;
    String s;
    public List<String> braceExpansionII(String expression) {
        s = expression;
        idx = 0;
        Set<String>res = parse();
        List<String>ans = new ArrayList<>(res);
        Collections.sort(ans);
        return ans;
    }
    public Set<String> parse(){
        Set<String>res = new HashSet<>();
        Set<String>curr = new HashSet<>();
        curr.add("");
        while(idx<s.length() && s.charAt(idx)!='}'){
            char ch = s.charAt(idx);
            if(ch==','){
                res.addAll(curr);
                curr = new HashSet<>();
                curr.add("");
                idx++;
            }else{
                Set<String>next = parsePart();
                Set<String>combined = new HashSet<>();
                for(String a:curr){
                    for(String b:next){
                        combined.add(a+b);
                    }
                }
                curr = combined;
            }
        }
        res.addAll(curr);
        if(idx<s.length() && s.charAt(idx)=='}')
            idx++;
        return res;
    }
    public Set<String> parsePart(){
        Set<String>res = new HashSet<>();
        if(s.charAt(idx)=='{'){
            idx++;
            res = parse();
        }else{
            res.add(String.valueOf(s.charAt(idx)));
            idx++;
        }
        return res;
    }
}